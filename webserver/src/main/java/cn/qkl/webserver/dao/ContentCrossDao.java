package cn.qkl.webserver.dao;

import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.AccountDynamicSqlSupport;
import cn.qkl.common.repository.mapper.ChainDynamicSqlSupport;
import cn.qkl.common.repository.mapper.ContentCrossMapper;
import cn.qkl.webserver.common.enums.ContentRiskLevelEnum;
import cn.qkl.webserver.dto.cross.CrossContentListQueryDTO;
import cn.qkl.webserver.vo.cross.CrossContentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author Wang Xin
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface ContentCrossDao extends ContentCrossMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<CrossContentVO> getCrossContentList(SelectStatementProvider selectStatementProvider);

    default List<CrossContentVO> getCrossContentList(CrossContentListQueryDTO dto) {
        SelectStatementProvider render = SqlBuilder.select(Tables.contentCross.id, Tables.contentCross.name, Tables.contentCross.metaurl, constant("lc.chain_name"), Tables.contentCross.address, Tables.contentCross.hash, Tables.contentCross.tokenId, constant("la.account_address"), Tables.contentCross.startTime, constant("rc.chain_name as dstChainName"), Tables.contentCross.dstAddress, Tables.contentCross.dstHash, Tables.contentCross.dstTokenId, constant("ra.account_address as dstAccountAddress"), Tables.contentCross.endTime, Tables.contentCross.bridge, Tables.contentCross.dynamicType, Tables.contentCross.riskLevel, Tables.contentCross.createTime)
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
                .render(RenderingStrategies.MYBATIS3);

        return this.getCrossContentList(
                render
        );
    }


    /**
     * 重写getCrossContentList方法的count语句
     * @param dto
     * @return
     */
    default Long getCrossContentListCount(CrossContentListQueryDTO dto) {

        return this.count(c -> c
                .where(Tables.contentCross.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
                //不包括无风险
                .and(Tables.contentCross.riskLevel, isNotEqualTo(ContentRiskLevelEnum.NO_RISK.getCode()))
                .and(Tables.contentCross.chainId, isInWhenPresent(dto.getChainIdList()))
                .and(Tables.contentCross.dstChainId, isInWhenPresent(dto.getDstChainIdList()))
                .and(Tables.contentCross.bridge, isInWhenPresent(dto.getBridgeTypeList()))
                .and(Tables.contentCross.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
                .and(Tables.contentCross.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
        );
    }
}
