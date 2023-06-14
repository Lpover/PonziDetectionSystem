package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.PlatformMapper;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.Content;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.common.enums.CarrierTypeEnum;
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

    public Long getHotestPlatform2(PlatformSelectionDTO dto) {

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
    public VolumeTrendsVO getVolumeTrends(PlatformAndTimeSelectionDTO dto){

        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform(dto);
        //dayLimit指的是显示的天数，默认7天
        int dayLimit;
        if(dto.getSelectTime()==2)dayLimit=30;
        else {
            dayLimit = 7;
        }

        List<PlatformDailyStatistics> volumeTrendsList = platformViewDao.select(c->c
                            .where(Tables.platformDailyStatistics.platformId, isEqualTo(HotestPlatform))
                            .orderBy(Tables.platformDailyStatistics.createTime.descending())
                            .limit(dayLimit)
        );
        VolumeTrendsVO vo=new VolumeTrendsVO();

        vo.setContentRiskSum(volumeTrendsList.stream()
                .map(PlatformDailyStatistics::getContentRiskSum)
                .collect(Collectors.toList())
        );

        vo.setCreateTime(volumeTrendsList.stream()
                .map(PlatformDailyStatistics::getCreateTime)
                .collect(Collectors.toList())
        );
        return vo;
    }

    //返回平台（NFT、WEB3）的风险指数
    public IndexTrendsVO getIndexTrends(PlatformAndTimeSelectionDTO dto){

        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform(dto);
        //dayLimit指的是显示的天数,默认7天
        int dayLimit;
        if(dto.getSelectTime()==2)dayLimit=30;
        else {
            dayLimit = 7;
        }

        List<PlatformDailyStatistics> indexTrendsList = platformViewDao.select(c->c
                .where(Tables.platformDailyStatistics.platformId, isEqualTo(HotestPlatform))
                .orderBy(Tables.platformDailyStatistics.createTime.descending())
                .limit(dayLimit)
        );
        IndexTrendsVO vo=new IndexTrendsVO();

        vo.setRiskIndex(indexTrendsList.stream()
                .map(PlatformDailyStatistics::getRiskIndex)
                .collect(Collectors.toList())
        );

        vo.setCreateTime(indexTrendsList.stream()
                .map(PlatformDailyStatistics::getCreateTime)
                .collect(Collectors.toList())
        );
        return vo;
    }

//    返回十个平台风险账户
    public List<PlatformRiskAccountVO> getPlatformRiskAccount(PlatformSelectionDTO dto){
        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform2(dto);
        List<PlatformRiskAccountVO> platformRiskAccountList = platformViewDao.getPlatformRiskAccount(
                select(Tables.account.id,Tables.account.accountAlias,Tables.account.image,Tables.account.releaseNum)
                        .from(Tables.account)
                        .where(Tables.account.platformId,isEqualTo(HotestPlatform))
                        .orderBy(Tables.account.releaseNum.descending())
                        .limit(10)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return platformRiskAccountList;
    }

    //返回十个平台风险内容
    public List<PlatformRiskContentVO> getPlatformRiskContent(PlatformSelectionDTO dto){
        //默认最热门NFT平台
        long HotestPlatform=getHotestPlatform2(dto);
        List<PlatformRiskContentVO> platformRiskContentList = platformViewDao.getPlatformRiskContent(
                select(Tables.content.id,Tables.content.name,Tables.content.metaUrl,Tables.content.currencyPrice)
                        .from(Tables.content)
                        .where(Tables.content.platformId,isEqualTo(HotestPlatform))
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
            Integer rand_realeaseNum = random.nextInt(101);
            Integer rand_riskLevel = random.nextInt(3);

            account.setAccountAddress(generateRandomAccountAddress());
            account.setChainId(1L);
            account.setAccountAlias(generateRandomString());
            account.setImage("https://image.kmf.com/da-image/65/a8/65a869ba6f14f304cd06444b29745738.gif");
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
        //随机生成6位英文字符串名字
        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final int STRING_LENGTH = 6;
        private static String generateRandomString() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(STRING_LENGTH);
            for (int i = 0; i < STRING_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            return sb.toString();
        }

    }

    //插入每个平台的内容数据
    public static class ContentGenerator{
        private Faker faker;
        public void insertContent (Content content){

            Random random = new Random();
            Integer rand_tokenid = random.nextInt(1001);
            Integer rand_riskLevel = random.nextInt(4);
            Integer rand_contenttype = random.nextInt(3);
            Integer rand_thingtype = random.nextInt(3);
            Integer rand_risktype = random.nextInt(2);
            Integer rand_hot_num_12h =random.nextInt(101);
            Integer rand_hot_num_24h =random.nextInt(101);

            double rand_current_price_ranking = random.nextDouble() * 500;//法定货币的价格，上限500
            BigDecimal decimal_current_price_ranking = BigDecimal.valueOf(rand_current_price_ranking).setScale(2, BigDecimal.ROUND_HALF_UP);
            String string_current_price_ranking=decimal_current_price_ranking.setScale(2).toString();

            content.setName(generateRandomString());
            content.setAddress(generateRandomAccountAddress());
            content.setTokenid(rand_tokenid);
            content.setMetaUrl("https://pic2.zhimg.com/v2-8c2ee9a783c45bb49b5af6b828ab1191_r.jpg");
            content.setCryptoPrice("1 ETH");
            content.setCurrencyPrice(string_current_price_ranking);
            content.setCreator("0xa8c62111e4652b07110a0fc81816303c42632f64");
            content.setStandard("1");
            content.setChainId(1L);
            content.setDescription("1");
            content.setDynamicType(1);
            content.setDynamicAlgorithmId(1L);
            content.setDynamicRecognition(0);
            content.setRevised(0);
            content.setRiskLevel(rand_riskLevel);
            content.setContentType(rand_contenttype);
            content.setContentTag("1,2");
            content.setOwner("0x95222290dd7278aa3ddd389cc1e1d165cc4bafe5");
            content.setThingType(rand_thingtype);
            content.setRiskType(rand_risktype);
            content.setHotNum12h(rand_hot_num_12h);
            content.setHotNum24h(rand_hot_num_24h);
            content.setCurrencyPriceRanking(decimal_current_price_ranking);

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
        //随机生成8位英文字符串名字
        private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final int STRING_LENGTH = 8;
        private static String generateRandomString() {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(STRING_LENGTH);
            for (int i = 0; i < STRING_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            return sb.toString();
        }

    }

}
