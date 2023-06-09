package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dao.PlatformViewDao;
import cn.qkl.webserver.dto.platformview.HotnessRankingViewDTO;
import cn.qkl.webserver.dto.platformview.PlatformAndTimeSelectionDTO;
import cn.qkl.webserver.dto.platformview.PlatformSelectionDTO;
import cn.qkl.webserver.vo.contentDetection.ContentDetectionInfoVO;
import cn.qkl.webserver.vo.platformview.*;
import com.alibaba.druid.support.ibatis.SqlMapClientImplWrapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * @title:
 * @Author li yang
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class PlatformViewService {
    @Autowired
    private PlatformViewDao platformViewDao;
    @Autowired
    private PlatformDao platformDao;

    //返回平台（NFT、WEB3）的风险内容数量
    public List<VolumeTrendsVO> getVolumeTrends(PlatformAndTimeSelectionDTO dto){
        //dayLimit指的是显示的天数
        int dayLimit=7;
        if(dto.getSelectTime()==2)dayLimit=30;
        List<VolumeTrendsVO> volumeTrendsList = platformViewDao.getVolumeTrends(
                    select(Tables.platformDailyStatistics.contentRiskSum, Tables.platformDailyStatistics.createTime)
                            .from(Tables.platformDailyStatistics)
                            .where(Tables.platformDailyStatistics.platformId, isEqualTo(dto.getSelectPlatformId()))
                            .orderBy(Tables.platformDailyStatistics.createTime.descending())
                            .limit(dayLimit)
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
        );
        return volumeTrendsList;
    }

    //返回平台（NFT、WEB3）的风险指数
    public List<IndexTrendsVO> getIndexTrends(PlatformAndTimeSelectionDTO dto){
        //dayLimit指的是显示的天数
        int dayLimit=7;
        if(dto.getSelectTime()==2)dayLimit=30;
        List<IndexTrendsVO> indexTrendsList = platformViewDao.getIndexTrends(
                select(Tables.platformDailyStatistics.riskIndex, Tables.platformDailyStatistics.createTime)
                        .from(Tables.platformDailyStatistics)
                        .where(Tables.platformDailyStatistics.platformId, isEqualTo(dto.getSelectPlatformId()))
                        .orderBy(Tables.platformDailyStatistics.createTime.descending())
                        .limit(dayLimit)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return indexTrendsList;
    }

//    返回十个平台风险账户
    public List<PlatformRiskAccountVO> getPlatformRiskAccount(PlatformSelectionDTO dto){
        List<PlatformRiskAccountVO> platformRiskAccountList = platformViewDao.getPlatformRiskAccount(
                select(Tables.account.id,Tables.account.accountAlias,Tables.account.image,Tables.account.releaseNum)
                        .from(Tables.account)
                        .where(Tables.account.platformId,isEqualTo(dto.getSelectPlatformId()))
                        .orderBy(Tables.account.releaseNum.descending())
                        .limit(10)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return platformRiskAccountList;
    }

    //返回十个平台风险内容
    public List<PlatformRiskContentVO> getPlatformRiskContent(PlatformSelectionDTO dto){
        List<PlatformRiskContentVO> platformRiskContentList = platformViewDao.getPlatformRiskContent(
                select(Tables.content.id,Tables.content.name,Tables.content.metaUrl,Tables.content.currencyPrice)
                        .from(Tables.content)
                        .where(Tables.content.platformId,isEqualTo(dto.getSelectPlatformId()))
                        .orderBy(Tables.content.currencyPriceRanking.descending())
                        .limit(10)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return platformRiskContentList;
    }

    //主流平台（NFT、WEB3）热度排行视图
    public PageVO<HotnessRankingViewVO> getHotnessRankingView(HotnessRankingViewDTO dto){
        //时间：今天的数据
        Date date = new Date();
        Date end = DateUtil.endOfDay(date);
        Date start = DateUtil.offsetDay(end, -1);

        //平台选择 平台类别： 0 nft  1 web3
        int platformType;
        if(dto.getSelectType()==1)platformType=1;
        else {
            platformType = 0;
        }

        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),
                ()->platformViewDao.getHotnessRankingView(
                        select(Tables.platformDailyStatistics.id,Tables.platformDailyStatistics.platformId,Tables.platform.name,
                                Tables.platform.logo,Tables.platform.hotness, Tables.platform.riskLevel,
                                Tables.platformDailyStatistics.hotness24h, Tables.platformDailyStatistics.hotnessChange24h,
                                Tables.platformDailyStatistics.hotnessChange7d, Tables.platformDailyStatistics.hotnessChange30d
                                )
                                .from(Tables.platformDailyStatistics)
                                .leftJoin(Tables.platform).on(Tables.platformDailyStatistics.platformId, equalTo(Tables.platform.id))
//                                .where(Tables.platform.monitor,isEqualTo(1))
                                .where(Tables.platformDailyStatistics.createTime,isGreaterThanOrEqualToWhenPresent(start))
                                .and(Tables.platformDailyStatistics.createTime,isLessThanOrEqualToWhenPresent(end))
                                .and(Tables.platform.platformType,isEqualTo(platformType))
                                .orderBy(Tables.platformDailyStatistics.hotness24h)
//                                .limit(platformNum)
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                )
        );
    }


}
