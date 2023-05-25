package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.EasyExcelUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.common.enums.AlgorithmTypeEnum;
import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import cn.qkl.webserver.common.enums.ContentRiskLevelEnum;
import cn.qkl.webserver.common.enums.DynamicTypeEnum;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dto.dynamic.DynamicContentExportDTO;
import cn.qkl.webserver.dto.dynamic.DynamicContentListQueryDTO;
import cn.qkl.webserver.dto.dynamic.ManualReviseDynamicTypeDTO;
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
import java.util.Date;
import java.util.List;

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

    public PageVO<DynamicContentVO> getDynamicContentList(DynamicContentListQueryDTO dto) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder builder = select(Tables.content.id, Tables.content.name, Tables.content.address, Tables.content.metaUrl, Tables.algorithm.version.as("dynamicAlgorithm"), Tables.content.dynamicRecognition, Tables.content.riskLevel, Tables.content.contentTag, Tables.content.updateTime)
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
                .and(Tables.content.dynamicType, isEqualTo(DynamicTypeEnum.DYNAMIC.getCode()))
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

    public void manualReviseDynamicType(ManualReviseDynamicTypeDTO dto) {
        contentDao.update(c -> c
                .set(Tables.content.dynamicType).equalTo(DynamicTypeEnum.NOT_DYNAMIC.getCode())
                .where(Tables.content.id, isIn(dto.getContentIdList()))
        );
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
