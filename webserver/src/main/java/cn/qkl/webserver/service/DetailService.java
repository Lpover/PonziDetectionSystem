package cn.qkl.webserver.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.UploadToChainUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Content;
import cn.qkl.common.repository.model.ContentCross;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.common.enums.ChainEnum;
import cn.qkl.webserver.common.enums.EvidenceTypeEnum;
import cn.qkl.webserver.dao.ContentCrossDao;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.dto.detail.*;
import cn.qkl.webserver.vo.detail.*;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author zouzh
 * @Date: 2023/5/22 10:38
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class DetailService {
    @Autowired
    private ContentDao contentDao;

    @Autowired
    private OssUtil ossUtil;

    @Autowired
    private EvidenceWebDao evidenceWebDao;

    @Autowired
    private ContentRiskDao contentRiskDao;

    @Autowired
    private EvidenceService evidenceService;

    @Autowired
    private UploadToChainUtil uploadToChainUtil;

    @Autowired
    private ContentCrossDao contentCrossDao;

    public ContentInfoVO getContentInfo(ContentInfoDTO dto) {
        return contentDao.getContentDetail(
                select(Tables.content.name, Tables.content.address, Tables.content.tokenid,
                        Tables.content.cryptoPrice, Tables.content.currencyPrice, Tables.content.creator, Tables.platform.name.as("platformName"),
                        Tables.content.standard, Tables.chain.chainName, Tables.content.listingTime, Tables.content.description,Tables.content.metaUrl)
                .from(Tables.content)
                .leftJoin(Tables.platform).on(Tables.content.platformId, equalTo(Tables.platform.id))
                .leftJoin(Tables.chain).on(Tables.content.chainId, equalTo(Tables.chain.id))
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }

    public PageVO<ContentHistoryVO> getContentTxHistory(ContentHistoryDTO dto) {

        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentDao.getContentTxHistoryList(
                select(Tables.contentTxHistory.id, Tables.contentTxHistory.event, Tables.contentTxHistory.from, Tables.contentTxHistory.to,
                        Tables.contentTxHistory.ownerLogo, Tables.contentTxHistory.createTime)
                        .from(Tables.contentTxHistory)
                        .where(Tables.contentTxHistory.contentId, isEqualTo(dto.getContentID()))
                        .orderBy(Tables.contentTxHistory.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        ));
    }

    public ContentRiskReviseVO getReviseRiskInfo(ContentRiskReviseInfoDTO dto) {
//        ContentRiskReviseVO contentRiskReviseVO;
        Integer crossRes = 0;
        List<ContentCross> selectRes = contentCrossDao.select(c -> c.where(Tables.contentCross.contentId, isEqualTo(dto.getContentID())));
        if (!selectRes.isEmpty()) {
            crossRes = 1;
        }
        ContentRiskReviseVO contentRiskReviseVO = ContentRiskReviseVO.transform(contentDao.getCotentRiskRevise(
                select(Tables.content.riskLevel, Tables.content.contentType, Tables.content.contentTag,
                        Tables.algorithm.name.as("algorithmName"), Tables.algorithm.recognitionRate, Tables.content.dynamicType)
                        .from(Tables.content)
                        .leftJoin(Tables.algorithm).on(Tables.content.dynamicAlgorithmId, equalTo(Tables.algorithm.id))
                        .where(Tables.content.id, isEqualTo(dto.getContentID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)));
        contentRiskReviseVO.setCrossRes(crossRes);
        // 跨链算法确定后，修改此字段为Tables.contentCross.crossAlgorithm
        contentRiskReviseVO.setCrossModelName("跨链监测模型V1");
        return contentRiskReviseVO;
    }

    // 人工修正动态识别结果和风险等级
    public void manualReviseRisk(ContentRiskReviseDTO dto) {
        contentDao.update(c -> c
                .set(Tables.content.dynamicType).equalTo(dto.getDynamicType())
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
        );
        contentDao.update(c -> c
                .set(Tables.content.riskLevel).equalTo(dto.getRiskLevel())
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
        );
        contentDao.update(c -> c
                .set(Tables.content.revised).equalTo(1)
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
        );
    }

    public PageVO<ContentDynamicMonitorVO> getDynamicMonitor(ContentDynamicMonitorDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentDao.getDynamicMonitor(
                select(Tables.dynamicMonitor.id, Tables.dynamicMonitor.riskLevel, Tables.dynamicMonitor.contentTag, Tables.dynamicMonitor.createTime)
                        .from(Tables.dynamicMonitor)
                        .where(Tables.dynamicMonitor.contentId, isEqualTo(dto.getContentID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)), ContentDynamicMonitorVO::transform);
    }

    public ContentReinforceVO reinforceDetail(ContentReinforceDTO dto) throws IOException, NoSuchAlgorithmException {
        Long contentId = dto.getId();
        Content item = contentDao.selectOne(c -> c.where(Tables.content.id, isEqualTo(dto.getId()))).get();
//        log.info("item name:================", item.getName().toString());
        // 更新取证状态
        contentDao.update(c->c.set(Tables.content.evidenceStatus).equalTo(1).where(Tables.content.id, isEqualTo(dto.getId())));
        EvidenceWeb evidenceWeb = new EvidenceWeb();
        evidenceWeb.setContentId(contentId);
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
//        evidenceWeb.setChainId(item.getChainId());    item中的chainid是内容所在链，evidence的chainid是固证的链
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
        evidenceWeb.setChainId(ChainEnum.XINZHENG.getCode());                             // 信证链是5

        evidenceWebDao.insert(evidenceWeb);

        // 需要设置计数器保证先后关系
        CountDownLatch latch = new CountDownLatch(1);

        // 生成证书并上传oss
//        SchedulerUtil.commonScheduler.schedule("generateCert", () -> {
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
//        });

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

        ContentReinforceVO vo = new ContentReinforceVO();
        EvidenceWeb finalEvidenceWeb = evidenceWebDao.selectOne(c -> c.where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId()))).get();
        vo.setId(item.getId());
        Content finalContent = contentDao.selectOne(c->c.where(Tables.content.id, isEqualTo(item.getId()))).get();
        vo.setStatus(finalContent.getEvidenceStatus());
        vo.setCertOss(finalEvidenceWeb.getCertOssPath());
        vo.setPackOss(finalEvidenceWeb.getPackOssPath());
        vo.setChainTime(finalEvidenceWeb.getChainTime());
        vo.setChainHash(finalEvidenceWeb.getHash());

        return vo;

    }

    public ContentReinforceVO reinforceStatus(ContentReinforceDTO dto) {
        ContentReinforceVO vo = new ContentReinforceVO();
//        EvidenceWeb evidenceWeb = evidenceWebDao.selectOne(c -> c.where(Tables.evidenceWeb.contentId, isEqualTo(dto.getId()))).get();
        Content content = contentDao.selectOne(c -> c.where(Tables.content.id, isEqualTo(dto.getId()))).get();
        int status = content.getEvidenceStatus()==null?0:content.getEvidenceStatus();
        vo.setStatus(status);
        vo.setId(dto.getId());
        if (status != 0) {
            EvidenceWeb evidenceWeb = evidenceWebDao.selectOne(c -> c.where(Tables.evidenceWeb.contentId, isEqualTo(dto.getId()))).get();
            vo.setCertOss(evidenceWeb.getCertOssPath());
            vo.setPackOss(evidenceWeb.getPackOssPath());
            vo.setChainHash(evidenceWeb.getHash());
            vo.setChainTime(evidenceWeb.getChainTime());
        }

//        vo.setStatus(contentDao.selectOne(c -> c.where(Tables.content.id, isEqualTo(dto.getId()))).get().getEvidenceStatus());
        return vo;
    }
}
