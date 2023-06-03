package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.SqlUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dto.contenrisk.ContentRiskInfoDTO;
import cn.qkl.webserver.vo.contentRisk.ContentRiskInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    //获取分页列表信息
    public PageVO<ContentRiskInfoVO> getContentRiskInfo(ContentRiskInfoDTO dto) {

        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder builder = select(Tables.content.id, Tables.content.name, Tables.content.metaUrl, Tables.content.address, Tables.content.dynamicType,
                Tables.content.owner, Tables.content.mintTime, Tables.content.description, Tables.chain.chainName, Tables.content.riskLevel,
                Tables.platform.name.as("platformname"), Tables.platform.platformType)
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
}
