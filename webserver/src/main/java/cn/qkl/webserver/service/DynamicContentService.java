package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.exception.BusinessException;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.EasyExcelUtil;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.framework.util.SchedulerUtil;
import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.DynamicMonitor;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.common.enums.*;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dao.DynamicMonitorDao;
import cn.qkl.webserver.dto.dynamic.*;
import cn.qkl.webserver.service.out.OutDnftService;
import cn.qkl.webserver.vo.dynamic.DnftCheckResultVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentExportVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class DynamicContentService {

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private DynamicMonitorDao dynamicMonitorDao;

    @Autowired
    private OutDnftService outDnftService;

    public PageVO<DynamicContentVO> getDynamicContentList(DynamicContentListQueryDTO dto) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(Tables.content.id, Tables.content.name, Tables.content.address, Tables.content.dynamicTypeArtificial, Tables.content.dynamicType, Tables.content.metaUrl, Tables.algorithm.version.as("dynamicAlgorithm"), Tables.content.dynamicRecognition, Tables.content.riskLevel, Tables.content.contentTag, Tables.content.updateTime)
                .from(Tables.content)
                .leftJoin(Tables.algorithm).on(Tables.content.dynamicAlgorithmId, equalTo(Tables.algorithm.id))
                .where(Tables.content.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
                //不包括无风险
                .and(Tables.content.riskLevel, isNotEqualTo(ContentRiskLevelEnum.NO_RISK.getCode()))
                .and(Tables.content.dynamicAlgorithmId, isInWhenPresent(dto.getDynamicAlgorithmIdList()))
                //必须是动态识别算法
                .and(Tables.content.riskLevel, isNotEqualTo(AlgorithmTypeEnum.DYNAMIC_ALGORITHM.getCode()))
                .and(Tables.content.platformId, isInWhenPresent(dto.getPlatformIdList()))
                //必须是动态数字内容
                .and(Tables.content.dynamicType, isEqualTo(DynamicTypeEnum.DYNAMIC.getCode()),
                        and(Tables.content.dynamicTypeArtificial, isEqualTo(DynamicTypeArtificialEnum.WRITE_DYNAMIC.getCode()),
                                or(Tables.content.dynamicTypeArtificial,isEqualTo(DynamicTypeArtificialEnum.READ_DYNAMIC.getCode())),
                                or(Tables.content.dynamicTypeArtificial,isEqualTo(DynamicTypeArtificialEnum.TBD.getCode())))
                )
                .and(Tables.content.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                .and(Tables.content.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()));

        if (dto.getContentRiskTypeList() != null && dto.getContentRiskTypeList().size() == 1) {
            //有风险,contentTag!=0
            if (dto.getContentRiskTypeList().get(0) == 1) {
                builder.and(Tables.content.contentTag, isNotEqualTo(ContentRiskCategoryEnum.NO_RISK.getCode() + ""));
            } else {
                builder.and(Tables.content.contentTag, isEqualTo(ContentRiskCategoryEnum.NO_RISK.getCode() + ""));
            }
        }

        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentDao.getDynamicContentList(
                builder
                        .orderBy(Tables.content.updateTime)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)), DynamicContentVO::transform);
    }

    @Deprecated
    public void manualReviseDynamicType(ManualReviseDynamicTypeDTO dto) {
        contentDao.update(c -> c
                .set(Tables.content.dynamicType).equalTo(DynamicTypeEnum.NOT_DYNAMIC.getCode())
                .where(Tables.content.id, isIn(dto.getContentIdList()))
        );
    }

    public void manualMarkDynamicTypeArtificial(ManualMarkDynamicTypeArtificialDTO dto) {

        // 添加一条检测记录
        Date date = new Date();
        List<DynamicMonitor> list = new ArrayList<>();
        List<Long> errContentIds = new ArrayList<>();
        for (Long contentId: dto.getContentIdList()) {
            int row = contentDao.update(c -> c
                    .set(Tables.content.dynamicTypeArtificial).equalTo(dto.getDynamicTypeArtificial())
                    .set(Tables.content.reviseTime).equalTo(new Date())
                    .set(Tables.content.revised).equalTo(DynamicRevisedEnum.YES.getCode())
                    .where(Tables.content.id, isEqualTo(contentId))
            );
            if (row <= 0) {
                errContentIds.add(contentId);
                continue;
            }
            list.add(FunctionUtil.apply(new DynamicMonitor(), it -> {
                it.setContentId(contentId);
                it.setContentTag(dto.getDynamicTypeArtificial().toString());
                it.setId(SnowflakeIdUtil.generateId());
                it.setCharacter(CharacterEnum.HUMAN.getCode());
                it.setRiskLevel(ContentRiskLevelEnum.NO_RISK.getCode());
                it.setCreateTime(date);
                it.setUpdateTime(date);
                it.setStatus(DynamicRecognitionEnum.OK.getCode());
            }));
        }
        if (list.size() > 0) {
            dynamicMonitorDao.insertMultiple(list);
        }
        if (errContentIds.size() > 0){
            throw new RuntimeException("存在有不明的contentId,对于这些contentId我们没有处理，而如果你传入了有效的contentId已经处理；或者是你在同一秒内重复执行多次");
        }

    }

    public void triggerDynamicTypeModel(DynamicTypeModelDTO dto) {
        int size = dto.getContentIdsList().size();
        // 需要设置计数器保证先后关系
//        CountDownLatch latch = new CountDownLatch(size);

        for (Long id: dto.getContentIdsList()) {
            SchedulerUtil.commonScheduler.schedule("dnft", () -> {
                DynamicMonitor dynamicMonitor = null;
                Date date = new Date();
                dynamicMonitor = FunctionUtil.apply(new DynamicMonitor(), it -> {
                    it.setContentId(id);
                    it.setId(SnowflakeIdUtil.generateId());
                    it.setCharacter(CharacterEnum.MACHINE.getCode());
                    it.setRiskLevel(ContentRiskLevelEnum.NO_RISK.getCode());
                    it.setCreateTime(date);
                    it.setUpdateTime(date);
                });
                //远程调用dnft api
                try {
                    contentDao.update(c -> c
                            .set(Tables.content.dynamicRecognition).equalTo(DynamicRecognitionEnum.ING.getCode())
                            .where(Tables.content.id, isEqualTo(id))
                    );
                    String address = contentDao.getAddress(select(Tables.content.address).from(Tables.content).where(Tables.content.id, isEqualTo(id)).build().render(RenderingStrategies.MYBATIS3));
                    //address 可能会空 这里直接不搞了
                    if (address == null) return;
                    DnftCheckResultVO vo = outDnftService.getCheckResult(address); //res表示是否成功启动
                    if (vo.getResult()==null || !DynamicTypeEnum.contains(vo.getResult())) {
                        throw new BusinessException(BusinessStatus.MODEL_ERROR);
                    }
                    log.info("Dnft Predicted Result:"+vo.getResult().toString());
                    contentDao.update(c -> c
                            //更新识别状态
                            .set(Tables.content.dynamicRecognition).equalTo(DynamicRecognitionEnum.OK.getCode())
                            //存结果
                            .set(Tables.content.dynamicType).equalTo(vo.getResult())
                            .where(Tables.content.id, isEqualTo(id))
                    );
                    // 添加一条检测记录
                    dynamicMonitor.setContentTag(vo.getResult().toString());
                    dynamicMonitor.setStatus(DynamicRecognitionEnum.OK.getCode());
                    dynamicMonitorDao.insert(dynamicMonitor);
                }catch (Exception e) {
                    if(e instanceof BusinessException) {
                        contentDao.update(c -> c
                                .set(Tables.content.dynamicRecognition).equalTo(DynamicRecognitionEnum.MODEL_ERROR.getCode())
                                .where(Tables.content.id, isEqualTo(id))
                        );
                        // 添加一条MODEL ERROR检测记录
                        dynamicMonitor.setStatus(DynamicRecognitionEnum.MODEL_ERROR.getCode());
                        dynamicMonitorDao.insert(dynamicMonitor);
                    } else {
                        contentDao.update(c -> c
                                .set(Tables.content.dynamicRecognition).equalTo(DynamicRecognitionEnum.NETWORK_ERROR.getCode())
                                .where(Tables.content.id, isEqualTo(id))
                        );
                        // 添加一条NETWORK ERROR检测记录
                        dynamicMonitor.setStatus(DynamicRecognitionEnum.NETWORK_ERROR.getCode());
                        dynamicMonitorDao.insert(dynamicMonitor);
                    }
                    log.error(e.getMessage());
                }finally {
//                    latch.countDown();
                }
            });

        }
//        try {
//            latch.await();
//            log.info("latch ok free");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void dynamicContentListExport(DynamicContentExportDTO dto, HttpServletResponse response) {
        //当前服务器时间
        Date end = new Date();
        //一天的开始，结果：2023-05-24 00:00:00
        end = DateUtil.beginOfDay(end);
        //全部
        DateTime start = null;
        if (dto.getTime() == 1) {
            //近七天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTime() == 2) {
            //近一个月
            start = DateUtil.offsetMonth(end, -1);
        } else if (dto.getTime() == 3) {
            //近半年
            start = DateUtil.offsetMonth(end, -6);
        }

        List<DynamicContentExportVO> dynamicContentExportVOList = contentDao.dynamicContentListExport(
                select(Tables.content.name, Tables.content.address, Tables.content.metaUrl, Tables.content.riskLevel, Tables.content.updateTime)
                        .from(Tables.content)
                        .where(Tables.content.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
                        //不包括无风险
                        .and(Tables.content.riskLevel, isNotEqualTo(ContentRiskLevelEnum.NO_RISK.getCode()))
                        .and(Tables.content.platformId, isInWhenPresent(dto.getPlatformIdList()))
                        //必须是动态数字内容
                        .and(Tables.content.dynamicType, isEqualTo(DynamicTypeEnum.DYNAMIC.getCode()))
                        .and(Tables.content.createTime, isGreaterThanOrEqualToWhenPresent(start))
                        .and(Tables.content.createTime, isLessThanOrEqualToWhenPresent(end))
                        .orderBy(Tables.content.updateTime)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        //数字转描述
        dynamicContentExportVOList.forEach(x -> x.setRiskLevel(ContentRiskLevelEnum.valueOf(Integer.parseInt(x.getRiskLevel())).getDescription()));
        EasyExcelUtil.exportExcel(dynamicContentExportVOList, DynamicContentExportVO.class, dto.getFileName(), response);
    }


}
