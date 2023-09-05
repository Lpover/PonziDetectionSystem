package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.SchedulerUtil;
import cn.qkl.common.framework.util.SqlUtil;
import cn.qkl.common.framework.util.UploadToChainUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Content;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.common.enums.ChainEnum;
import cn.qkl.webserver.common.enums.EvidenceTypeEnum;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.dto.contenrisk.ContentBatchEvidenceDTO;
import cn.qkl.webserver.dto.contenrisk.ContentRiskInfoDTO;
import cn.qkl.webserver.vo.contentRisk.ContentRiskInfoVO;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @title:
 * @Author lpc
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class ContentRiskService {

    @Autowired
    private ContentRiskDao contentRiskDao;

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private EvidenceService evidenceService;

    @Autowired
    private EvidenceWebDao evidenceWebDao;

    @Autowired
    OssUtil ossUtil;

    @Autowired
    UploadToChainUtil uploadToChainUtil;

    //获取分页列表信息
    public PageVO<ContentRiskInfoVO> getContentRiskInfo(ContentRiskInfoDTO dto) {

        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder builder = select(Tables.content.id, Tables.content.name, Tables.content.metaUrl, Tables.content.address, Tables.content.dynamicType,
                Tables.content.owner, Tables.content.mintTime, Tables.content.description, Tables.chain.chainName, Tables.content.riskLevel,
                Tables.platform.name.as("platformname"), Tables.platform.platformType, Tables.content.evidenceStatus)
                .from(Tables.content)
                .leftJoin(Tables.platform).on(Tables.content.platformId, equalTo(Tables.platform.id))
                .leftJoin(Tables.chain).on(Tables.content.chainId, equalTo(Tables.chain.id))
                .where(Tables.platform.platformType, isEqualToWhenPresent((dto.getPlatformType())))
                .and(Tables.content.riskLevel, isEqualToWhenPresent(dto.getRiskLevelList()))
                .and(Tables.content.contentTag, isLikeWhenPresent(SqlUtil.allLike(dto.getContentRisk())))
                .and(Tables.content.thingType, isInWhenPresent(dto.getThingType()))
                .and(Tables.content.riskType, isInWhenPresent(dto.getRiskType()));
        //时间
        Date end = new Date();
//        end = DateUtil.beginOfDay(end);
        if (dto.getTimeSet() != null) {
            if (dto.getTimeSet() == 1) {
                builder
                        .and(Tables.content.mintTime, isGreaterThanOrEqualToWhenPresent(DateUtil.offsetDay(end, -1)))
                        .and(Tables.content.mintTime, isLessThanOrEqualTo(end));
            } else if (dto.getTimeSet() == 2) {
                builder.and(Tables.content.mintTime, isGreaterThanOrEqualToWhenPresent(DateUtil.offsetDay(end, -7)))
                        .and(Tables.content.mintTime, isLessThanOrEqualTo(end));
            }
        }
        String keyWord = dto.getKeyWord();
        if (keyWord != null) {
            if (keyWord.startsWith("0x") || keyWord.startsWith("0X")) {
                builder.and(Tables.content.address, isLike(SqlUtil.rightLike(keyWord)), or(Tables.content.owner, isLike(SqlUtil.rightLike(keyWord))));
            } else {
                builder.and(Tables.content.name, isLike(SqlUtil.allLike(keyWord)), or(Tables.content.description, isLike(SqlUtil.allLike(keyWord))));
            }
        }

        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),
                () -> contentRiskDao.getContentRiskInfo(
                        builder
                                .orderBy(Tables.content.mintTime.descending())
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                ));
    }

    public void batchReinforce(ContentBatchEvidenceDTO dto) throws IOException, NoSuchAlgorithmException {


        List<Long> contentIdList = dto.getContentIdList();
        List<Content> contentList = new ArrayList<>();
        for (Long contentId : contentIdList) {
            Optional<Content> content = contentDao.selectOne(c -> c.where(Tables.content.id, isEqualTo(contentId)));
            contentList.add(content.get());
        }

        for (Content item: contentList) {
            // 更新content表中的取证状态
            contentDao.update(c->c.set(Tables.content.evidenceStatus).equalTo(1).where(Tables.content.id, isEqualTo(item.getId())));
            EvidenceWeb evidenceWeb = new EvidenceWeb();
            evidenceWeb.setContentId(item.getId());
            // content -> json 上传oss
            String json = JSONUtil.toJsonStr(item.toString());
//        log.info("file json:", json);
            byte[] jsonBytes = json.getBytes();
            String jsonName = "content_" + item.getId().toString() + ".json";
            MultipartFile multipartFile = new MockMultipartFile(jsonName, jsonName, "application/json", jsonBytes);
            String webOss = ossUtil.uploadMultipartFile(multipartFile, jsonName);
            evidenceWeb.setWebOssPath(webOss);
            evidenceWeb.setUrl(webOss);
            evidenceWeb.setId(IdUtil.getSnowflakeNextId());
            evidenceWeb.setName(item.getName());
            evidenceWeb.setPlatformId(item.getPlatformId());
            evidenceWeb.setPlatformId(item.getPlatformId());
            evidenceWeb.setDeleteStatus(0);
            evidenceWeb.setUpdateTime(new Date());
            evidenceWeb.setCreateTime(new Date());
            evidenceWeb.setFrequency(0);
            evidenceWeb.setContentId(item.getId());
//            evidenceWeb.setChainId(item.getChainId());
            evidenceWeb.setPersonnel("from_detail");
            evidenceWeb.setEvidenceType(EvidenceTypeEnum.MANUAL.getCode());

            // 得到风险类型字符串
            List<Long> riskIdList = Arrays.stream(item.getContentTag().split(",")).map(Long::parseLong).collect(Collectors.toList());
            String riskStr = "";
            for (Long riskId: riskIdList) {
                String category = contentRiskDao.selectOne(c -> c.where(Tables.contentRisk.id, isEqualTo(riskId))).getCategory();
                riskStr = riskStr + category + ",";
            }
            riskStr = riskStr.substring(0, riskStr.length() - 1);

            evidenceWeb.setRiskType(riskStr);

            // 计算hash并上链
            String digest = uploadToChainUtil.calculateHash(multipartFile.getInputStream(), "MD5");
            uploadToChainUtil.uploadToChain(digest);
            evidenceWeb.setPackageHash(digest);                     // 文件hash
            evidenceWeb.setHash(uploadToChainUtil.getTxHash());     // 上链hash
            evidenceWeb.setChainTime(uploadToChainUtil.getTxTime());    // 上链时间
            evidenceWeb.setChainId(ChainEnum.XINZHENG.getCode());

            evidenceWebDao.insert(evidenceWeb);

            // 需要设置计数器保证先后关系
            CountDownLatch latch = new CountDownLatch(1);

            // 生成证书并上传oss
            SchedulerUtil.commonScheduler.schedule("generateCert", () -> {
                try {
                    String ossPath = evidenceService.generateEvidenceCert(evidenceWeb.getId());
                    evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.certOssPath).equalTo(ossPath).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                    evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.updateTime).equalTo(new Date()).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                    evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.evidencePhase).equalTo(2).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
                } catch (ParserConfigurationException | IOException |
                         FontFormatException | TemplateException | SAXException e) {
                    throw new RuntimeException(e);
                } finally {
                    latch.countDown();
                }
            });

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 生成证据包并上传oss
//        SchedulerUtil.commonScheduler.schedule("generateEvidencePack", () -> {
//            try {
            evidenceService.generateEvidencePack(evidenceWeb.getId());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
            // 切换成 已固证 状态
            contentDao.update(c->c.set(Tables.content.evidenceStatus).equalTo(2).where(Tables.content.id, isEqualTo(item.getId())));
        }
    }


}
