package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.PlatformDailyStatisticsDao;
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
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import com.github.javafaker.Faker;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;


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
    @Autowired
    private PlatformDailyStatisticsDao platformDailyStatisticsDao;

    //获取最热门NFT平台的PlatformId
    public Long getHotestPlatform(PlatformAndTimeSelectionDTO dto) {

        if(dto.getSelectPlatformId() == -999){

            Optional<PlatformDailyStatistics> optionalPlatformDailyStatistics = platformDailyStatisticsDao.selectOne(c-> c
                    .orderBy(Tables.platformDailyStatistics.hotness24h.descending())
                    .limit(1)
            );
            PlatformDailyStatistics platformDailyStatistics=optionalPlatformDailyStatistics.get();
            long pid = platformDailyStatistics.getPlatformId();
            return pid;
        }
        else return dto.getSelectPlatformId();

    }


        //返回平台（NFT、WEB3）的风险内容数量
    public List<VolumeTrendsVO> getVolumeTrends(PlatformAndTimeSelectionDTO dto){

        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform(dto);
        //dayLimit指的是显示的天数
        int dayLimit=7;
        if(dto.getSelectTime()==2)dayLimit=30;
        List<VolumeTrendsVO> volumeTrendsList = platformViewDao.getVolumeTrends(
                    select(Tables.platformDailyStatistics.contentRiskSum, Tables.platformDailyStatistics.createTime)
                            .from(Tables.platformDailyStatistics)
                            .where(Tables.platformDailyStatistics.platformId, isEqualTo(HotestPlatform))
                            .orderBy(Tables.platformDailyStatistics.createTime.descending())
                            .limit(dayLimit)
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
        );
        return volumeTrendsList;
    }

    //返回平台（NFT、WEB3）的风险指数
    public List<IndexTrendsVO> getIndexTrends(PlatformAndTimeSelectionDTO dto){

        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform(dto);
        //dayLimit指的是显示的天数
        int dayLimit=7;
        if(dto.getSelectTime()==2)dayLimit=30;
        List<IndexTrendsVO> indexTrendsList = platformViewDao.getIndexTrends(
                select(Tables.platformDailyStatistics.riskIndex, Tables.platformDailyStatistics.createTime)
                        .from(Tables.platformDailyStatistics)
                        .where(Tables.platformDailyStatistics.platformId, isEqualTo(HotestPlatform))
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

        //平台选择：0-NFT平台,1-WEB3平台,默认选择NFT平台
        int platformType;
        if(dto.getSelectType()==1){
            platformType = 1;
        } else {
            platformType = 0;
        }

        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),
                ()->platformViewDao.getHotnessRankingView(
                        select(Tables.platformDailyStatistics.id,Tables.platformDailyStatistics.platformId,Tables.platform.name,
                                Tables.platform.logo,Tables.platform.hotness.as("hotness"), Tables.platform.riskLevel,
                                Tables.platformDailyStatistics.hotness24h, Tables.platformDailyStatistics.hotnessChange24h,
                                Tables.platformDailyStatistics.hotnessChange7d, Tables.platformDailyStatistics.hotnessChange30d
                                )
                                .from(Tables.platformDailyStatistics)
                                .leftJoin(Tables.platform).on(Tables.platformDailyStatistics.platformId, equalTo(Tables.platform.id))
                                .where(Tables.platform.monitor,isEqualTo(1))
                                .and(Tables.platform.platformType,isEqualTo(platformType))
                                .and(Tables.platformDailyStatistics.createTime,isGreaterThanOrEqualToWhenPresent(start))
                                .and(Tables.platformDailyStatistics.createTime,isLessThanOrEqualToWhenPresent(end))
                                .orderBy(Tables.platformDailyStatistics.hotness24h.descending())
//                                .limit(platformNum)
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                )
        );
    }

    //热门平台每日数据更新
    public void insertPlatformView(PlatformDailyStatistics platformDailyStatistics){
        Random random = new Random();

        Integer totalSum=platformDailyStatistics.getContentRiskSum();
        Integer rand_risk_index = random.nextInt(100);

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        double rand_24_hotness_c = random.nextDouble() * 2 - 1;//一天之内的变化-1~1
        BigDecimal decimal_rand_24_hotness_c = BigDecimal.valueOf(rand_24_hotness_c).setScale(2, BigDecimal.ROUND_HALF_UP);

        double rand_7_hotness_c = random.nextDouble() * 14 - 7;//7天之内的变化-7~7
        BigDecimal decimal_rand_7_hotness_c = BigDecimal.valueOf(rand_7_hotness_c).setScale(2, BigDecimal.ROUND_HALF_UP);


        double rand_30_hotness_c = random.nextDouble() * 60 - 30;//一天之内的变化-30~30
        BigDecimal decimal_rand_30_hotness_c = BigDecimal.valueOf(rand_30_hotness_c).setScale(2, BigDecimal.ROUND_HALF_UP);

        //随机热度生成
        long rand_hotness_24h = ThreadLocalRandom.current().nextLong(20000001);

        platformDailyStatistics.setContentSum(totalSum);
        platformDailyStatistics.setRiskIndex(rand_risk_index);
        platformDailyStatistics.setHotnessChange24h(decimal_rand_24_hotness_c);
        platformDailyStatistics.setHotnessChange7d(decimal_rand_7_hotness_c);
        platformDailyStatistics.setHotnessChange30d(decimal_rand_30_hotness_c);
        platformDailyStatistics.setHotness24h(rand_hotness_24h);

    }

    //插入每个平台的账号数据
    public static class AccountGenerator{
        private Faker faker;
        public void insertAccount (Account account){

            Random random = new Random();
            Integer rand_realeaseNum = random.nextInt(100);
            Integer rand_riskLevel = random.nextInt(2);

            account.setAccountAddress(generateRandomAccountAddress());
            account.setChainId(1L);
            account.setAccountAlias(generateRandomAccountAlias());
            account.setImage("image/65/a8/65a869ba6f14f304cd06444b29745738.gif");
            account.setCryptoBalance("1 ETH");
            account.setCurrencyBalance("500");
            account.setExchangeRate("500");
            account.setReleaseNum(rand_realeaseNum);
            account.setRiskLevel(rand_riskLevel);

        }
        private static String generateRandomAccountAddress() {
            // 生成随机的以太坊账号地址
            Random random = new Random();
            String address = "0x";
            for (int i = 0; i < 40; i++) {
                int digit = random.nextInt(16);
                address += Integer.toHexString(digit);
            }
            return address;
        }
        private String generateRandomAccountAlias() {
            // 生成随机的英文单词作为账号别名
            return faker.lorem().word();
        }

    }

}
