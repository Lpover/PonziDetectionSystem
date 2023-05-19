package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.AccountDynamicSqlSupport;
import cn.qkl.common.repository.mapper.ChainDynamicSqlSupport;
import cn.qkl.webserver.common.enums.ContentRiskLevelEnum;
import cn.qkl.webserver.dao.ContentCrossDao;
import cn.qkl.webserver.dto.cross.CrossContentListQueryDTO;
import cn.qkl.webserver.vo.cross.CrossContentVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

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
public class CrossContentService {

    @Autowired
    private ContentCrossDao contentCrossDao;

    public PageVO<CrossContentVO> getCrossContentList(CrossContentListQueryDTO dto) {
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), contentCrossDao.getCrossContentList(
                select(Tables.contentCross.id, Tables.contentCross.name, Tables.contentCross.metaurl, constant("lc.chain_name"), Tables.contentCross.address, Tables.contentCross.hash, Tables.contentCross.tokenId,
                        constant("la.account_address"), Tables.contentCross.startTime, constant("rc.chain_name as dstChainName"), Tables.contentCross.dstAddress, Tables.contentCross.dstHash, Tables.contentCross.dstTokenId,
                        constant("ra.account_address as dstAccountAddress"), Tables.contentCross.endTime, Tables.contentCross.bridge, Tables.contentCross.dynamicType, Tables.contentCross.riskLevel, Tables.contentCross.createTime)
                        .from(Tables.contentCross)
                        .leftJoin(Tables.account, "la").on(Tables.contentCross.accountId, equalTo(constant("la.id")))
                        .leftJoin(Tables.chain, "lc").on(Tables.contentCross.chainId, equalTo(constant("lc.id")))
                        .leftJoin(new AccountDynamicSqlSupport.Account(), "ra").on(Tables.contentCross.dstAccountId, equalTo(constant("ra.id")))
                        .leftJoin(new ChainDynamicSqlSupport.Chain(), "rc").on(Tables.contentCross.dstChainId, equalTo(constant("rc.id")))
                        .where(Tables.contentCross.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
                        //不包括无风险
                        .and(Tables.contentCross.riskLevel, isNotEqualTo(ContentRiskLevelEnum.NO_RISK.getCode()))
                        .and(Tables.contentCross.chainId, isInWhenPresent(dto.getChainIdList()))
                        .and(Tables.contentCross.dstChainId, isInWhenPresent(dto.getDstChainIdList()))
                        .and(Tables.contentCross.bridge, isInWhenPresent(dto.getBridgeTypeList()))
                        .and(Tables.contentCross.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                        .and(Tables.contentCross.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                        .orderBy(Tables.contentCross.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        ));
    }


}
