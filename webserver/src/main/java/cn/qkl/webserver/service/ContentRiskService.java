package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.common.enums.ContentRiskLevelEnum;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dto.contenrisk.ContentRiskInfoDTO;
import cn.qkl.webserver.vo.contentRisk.ContentRiskInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.mybatis.dynamic.sql.Constant;
import org.mybatis.dynamic.sql.SqlCriterion;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
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
        //时间
        Date end = new Date();
        end = DateUtil.endOfDay(end);
        //昨天
        DateTime start=null;
        if(dto.getTimeSet()!=null){
            if(dto.getTimeSet()==1){
                start = DateUtil.offsetDay(end, -1);
            }
            else if(dto.getTimeSet()==2){
                start = DateUtil.offsetDay(end, -7);
            } else {
                start = null;
            }
        }
        Date finalEnd = end;
        Date finalstart = start;
        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),
                () -> contentRiskDao.getContentRiskInfo(
                        select(Tables.content.id,Tables.content.name,Tables.content.metaUrl,Tables.content.address,Tables.content.dynamicType,
                                Tables.content.owner,Tables.content.mintTime, Tables.content.description,Tables.chain.chainName,
                                Tables.platform.name.as("platformname"),Tables.platform.platformType)
                                .from(Tables.content)
                                .leftJoin(Tables.platform).on(Tables.content.platformId,equalTo(Tables.platform.id))
                                .leftJoin(Tables.chain).on(Tables.content.chainId,equalTo(Tables.chain.id))
                                .where(Tables.platform.platformType, isEqualToWhenPresent((dto.getPlatformType())))
                                .and(Tables.content.riskLevel, isEqualToWhenPresent(dto.getRiskLevelList()))
                                .and(Tables.content.mintTime,isGreaterThanOrEqualToWhenPresent(finalstart))
                                .and(Tables.content.mintTime,isLessThanOrEqualToWhenPresent(finalEnd))
                                .and(Tables.content.thingType, isInWhenPresent(dto.getThingType()))
                                .and(Tables.content.riskType, isInWhenPresent(dto.getRiskType()))
                                .orderBy(Tables.content.mintTime.descending())
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                ));


    }
}
