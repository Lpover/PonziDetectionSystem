package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.common.enums.DynamicTypeEnum;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dto.detail.*;
import cn.qkl.webserver.vo.detail.ContentDynamicMonitorVO;
import cn.qkl.webserver.vo.detail.ContentHistoryVO;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import cn.qkl.webserver.vo.detail.ContentRiskReviseVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

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

    public ContentInfoVO getContentInfo(ContentInfoDTO dto) {
        return contentDao.getContentDetail(
                select(Tables.content.name, Tables.content.address, Tables.content.tokenid,
                        Tables.content.cryptoPrice, Tables.content.currencyPrice, Tables.content.creator, Tables.platform.name,
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
        return contentDao.getCotentRiskRevise(
                select(Tables.content.riskLevel, Tables.content.contentType, Tables.content.contentTag,
                        Tables.algorithm.version, Tables.algorithm.recognitionRate, Tables.content.dynamicType)
                        .from(Tables.content)
                        .leftJoin(Tables.algorithm).on(Tables.content.dynamicAlgorithmId, equalTo(Tables.algorithm.id))
                        .where(Tables.content.id, isEqualTo(dto.getContentID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
    }

    public void manualReviseRisk(ContentRiskReviseDTO dto) {
        contentDao.update(c -> c
                .set(Tables.content.dynamicType).equalTo(dto.getResultRevise())
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
        );
    }

    public PageVO<ContentDynamicMonitorVO> getDynamicMonitor(ContentDynamicMonitorDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentDao.getDynamicMonitor(
                select(Tables.dynamicMonitor.id, Tables.dynamicMonitor.riskLevel, Tables.dynamicMonitor.contentTag, Tables.dynamicMonitor.createTime)
                        .from(Tables.dynamicMonitor)
                        .where(Tables.dynamicMonitor.contentId, isEqualTo(dto.getContentID()))
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        ));
    }
}
