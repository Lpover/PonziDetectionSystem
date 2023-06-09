package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.func.Func;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.SocialPlatformHourStatistics;
import cn.qkl.webserver.common.enums.PlatformMonitorEnum;
import cn.qkl.webserver.common.enums.TimeSeriesChoiceEnum;
import cn.qkl.webserver.dao.CockpitIntegratedDao;
import cn.qkl.webserver.dao.CockpitMultipleChoiceDao;
import cn.qkl.webserver.dto.board.CockpitIntegratedQueryDTO;
import cn.qkl.webserver.vo.cockpit.integrated.*;;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
/**
 * @Author sunxiaen
 * @Date 2023/6/5 17:42
 **/

@Service
public class CockpitIntegratedService {

    @Resource
    CockpitMultipleChoiceDao cockpitMultipleChoiceDao;

    @Resource
    CockpitIntegratedDao cockpitIntegratedDao;

    SocialIndexViewVO getSocialIndexView(Long socialPlatformId) {
        return FunctionUtil.apply(SocialIndexViewVO.transformFromSocialPlatform(
                cockpitIntegratedDao.getSocialIndex(
                        select(
                                Tables.socialPlatform.name,
                                Tables.socialPlatform.socialPlatformIndex24h,
                                Tables.socialPlatform.socialPlatformIndex12h
                        ).from(Tables.socialPlatform)
                                .where(Tables.socialPlatform.id,isEqualTo(socialPlatformId))
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                )), it -> {
//                        it.setViewChoice(viewChoice);
                        it.setViewId(0);
                        it.setViewName("链上内容社交舆情指数视图");
                    }
                );
    }

    PlatformIndexViewVO getPlatformIndexView(List<Long> platformIds) {
        return FunctionUtil.apply(PlatformIndexViewVO.transformFromPlatforms(
                cockpitIntegratedDao.getPlatformIndex(
                        select(
                                Tables.platform.name,
                                Tables.platform.riskIndexChina,
                                Tables.platform.riskIndexOversea
                        ).from(Tables.platform)
                                .where(Tables.platform.id, isInWhenPresent(platformIds))
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                )), it -> {
                        it.setViewId(1);
                        it.setViewName("链上内容多平台风险指数视图");
                    }
                );

    }

    VocabCloudViewVO getVocabCloudView() {
        Date date = new Date();
        Date base = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetHour(base, -12); //默认近12h

        return FunctionUtil.apply(VocabCloudViewVO.transformFromVocabCloud(
                    cockpitIntegratedDao.getVocabCloud(
                        select(
                                Tables.vocabCloud.vocab,
                                Tables.vocabCloud.num
                        ).from(Tables.vocabCloud)
                            .where(Tables.socialPlatformHourStatistics.createTime,isGreaterThanWhenPresent(start))
                            .and(Tables.socialPlatformHourStatistics.createTime,isLessThanOrEqualToWhenPresent(base))
                            .orderBy(Tables.vocabCloud.num.descending())
                            .limit(20)
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
                    )
                ),it -> {
                        it.setViewId(2);
                        it.setViewName("热门话题词云视图");
                    }
                );
    }

    HotContentViewVO getHotContentView(Long platformId, Long timeId) {
        Optional<QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder> builder = Optional.empty();
        if (timeId == TimeSeriesChoiceEnum.J12H.getCode()) {
            builder = Optional.ofNullable(select(
                    Tables.content.name,
                    Tables.content.metaUrl,
                    Tables.content.cryptoPrice,
                    Tables.content.hotNum12h.as("hotNum")
            ).from(Tables.content)
                    .where(Tables.content.platformId, isEqualTo(platformId)));
        } else if (timeId == TimeSeriesChoiceEnum.J24H.getCode()) {
            builder = Optional.ofNullable(select(
                    Tables.content.name,
                    Tables.content.metaUrl,
                    Tables.content.cryptoPrice,
                    Tables.content.hotNum24h.as("hotNum")
            ).from(Tables.content)
                    .where(Tables.content.platformId, isEqualTo(platformId)));
        }

        Optional<QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder> finalBuilder = builder;
        return FunctionUtil.apply(new HotContentViewVO(), it -> {
            it.setViewId(3);
            it.setViewName("热门NFT视图");
//            it.setViewChoice(viewChoice);
            finalBuilder.ifPresent(queryExpressionWhereBuilder -> it.setViewData(cockpitIntegratedDao.getHotContentView(queryExpressionWhereBuilder.orderBy(SimpleSortSpecification.of("hotNum").descending()).limit(10).build().render(RenderingStrategies.MYBATIS3))));
        });

    }

    HotEventViewVO getHotEventView(Long platformId, Long timeId) {
        Optional<QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder> builder = Optional.empty();
        if (timeId == TimeSeriesChoiceEnum.J12H.getCode()) {
            builder = Optional.ofNullable(select(
                    Tables.event.title,
                    Tables.event.imageUrl,
                    Tables.event.abstractText,
                    Tables.event.hotNum12h.as("hotNum")
            ).from(Tables.event)
                    .where(Tables.event.platformId, isEqualTo(platformId)));
        } else if (timeId == TimeSeriesChoiceEnum.J24H.getCode()) {
            builder = Optional.ofNullable(select(
                    Tables.event.title,
                    Tables.event.imageUrl,
                    Tables.event.abstractText,
                    Tables.event.hotNum24h.as("hotNum")
            ).from(Tables.event)
                    .where(Tables.event.platformId, isEqualTo(platformId)));
        }
        Optional<QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder> finalBuilder = builder;
        return FunctionUtil.apply(new HotEventViewVO(), it -> {
            it.setViewId(4);
            it.setViewName("热门Event视图");
//            it.setViewChoice(viewChoice);
            finalBuilder.ifPresent(queryExpressionWhereBuilder -> it.setViewData(cockpitIntegratedDao.getHotEventView(queryExpressionWhereBuilder.orderBy(SimpleSortSpecification.of("hotNum").descending()).limit(10).build().render(RenderingStrategies.MYBATIS3))));
        });
    }

    TextAnalysisViewVO getTextAnalysisView(Long socialPlatformId, Long timeId) {

        Date date = new Date();
        Date base = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetHour(base, -12); //默认近12h
        if (timeId == TimeSeriesChoiceEnum.J12H.getCode()) {   // 近12h
            start = DateUtil.offsetHour(base, -12);
        } else if (timeId == TimeSeriesChoiceEnum.J24H.getCode()) {    // 近24h
            start = DateUtil.offsetHour(base, -24);
        }

        //from mysql
        List<SocialPlatformHourStatistics> socialPlatformHourStatisticsList =  cockpitIntegratedDao.getTextEmotionAndSensitive(
                select( Tables.socialPlatformHourStatistics.posEmotionNum,
                        Tables.socialPlatformHourStatistics.negEmotionNum,
                        Tables.socialPlatformHourStatistics.sensitiveNum,
                        Tables.socialPlatformHourStatistics.nonSensitiveNum,
                        Tables.socialPlatformHourStatistics.createTime)
                        .from(Tables.socialPlatformHourStatistics)
                        .where(Tables.socialPlatformHourStatistics.id, isEqualTo(socialPlatformId))
                        .and(Tables.socialPlatformHourStatistics.createTime,isGreaterThanWhenPresent(start))
                        .and(Tables.socialPlatformHourStatistics.createTime,isLessThanOrEqualToWhenPresent(base))
                        .orderBy(Tables.socialPlatformHourStatistics.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        Integer countPos = 0;
        Integer countNeg = 0;
        List<BigDecimal> sensitiveSeries = new ArrayList<>();
        List<BigDecimal> nonSensitiveSeries = new ArrayList<>();
        List<String> timeSeries = new ArrayList<>();
        for (SocialPlatformHourStatistics s: socialPlatformHourStatisticsList) {
                countPos += s.getPosEmotionNum();
                countNeg += s.getNegEmotionNum();
                sensitiveSeries.add(BigDecimal.valueOf(s.getSensitiveNum()));
                nonSensitiveSeries.add(BigDecimal.valueOf(s.getNonSensitiveNum()));
                timeSeries.add(String.valueOf(DateUtil.hour(s.getCreateTime(),true)));
        }

        return FunctionUtil.apply(TextAnalysisViewVO.transform(countPos,countNeg,sensitiveSeries,nonSensitiveSeries,timeSeries), it ->{
            it.setViewId(5);
            it.setViewName("社交平台文本情绪、敏感分析视图");
        });
    }

    public CockpitIntegratedResponseVO getCockpitIntegratedResponseAll() {
        CockpitIntegratedMultipleChoiceVO multipleChoice = getCockpitIntegratedMultipleChoice();
        Long socialPlatformId = multipleChoice.getSocialPlatforms().get(0).getChoiceId();
        Long timeId = multipleChoice.getTimeSeries().get(0).getChoiceId();
        Long platformId = multipleChoice.getPlatforms().get(0).getChoiceId();
        List<Long> platformIdList = multipleChoice.getPlatforms().stream().map(ChoiceVO::getChoiceId).collect(Collectors.toList());
        return FunctionUtil.apply(new CockpitIntegratedResponseVO(), it -> {
            it.setSocialIndexView(getSocialIndexView(socialPlatformId));
            it.setPlatformIndexView(getPlatformIndexView(platformIdList));
            it.setVocabCloudView(getVocabCloudView());
            it.setHotContentView(getHotContentView(platformId,timeId));
            it.setHotEventView(getHotEventView(platformId,timeId));
            it.setTextAnalysisViewVO(getTextAnalysisView(socialPlatformId,timeId)); //default & fixed
        });
    }

    public CockpitIntegratedResponseVO getCockpitIntegratedResponseDynamic(CockpitIntegratedQueryDTO dto) {

        OptionalLong socialPlatformId = OptionalLong.of(dto.getSocialPlatformChoice());
        OptionalLong timeId = OptionalLong.of(dto.getTimeSeriesChoice());
        OptionalLong platformId = OptionalLong.of(dto.getPlatformChoice());

        return FunctionUtil.apply(new CockpitIntegratedResponseVO(), it -> {
            it.setSocialIndexView(getSocialIndexView(socialPlatformId.getAsLong()));
            it.setHotContentView(getHotContentView(platformId.getAsLong(),timeId.getAsLong()));
            it.setHotEventView(getHotEventView(platformId.getAsLong(),timeId.getAsLong()));
        });
    }

    public CockpitIntegratedMultipleChoiceVO getCockpitIntegratedMultipleChoice() {
        CockpitIntegratedMultipleChoiceVO cockpitIntegratedMultipleChoiceVO = new CockpitIntegratedMultipleChoiceVO();
        // 时间
        List<ChoiceVO> timeSeries = new ArrayList<>();
        ChoiceVO choiceVO1 = new ChoiceVO(TimeSeriesChoiceEnum.J12H.getCode(),TimeSeriesChoiceEnum.J12H.getDescription());
        ChoiceVO choiceVO2 = new ChoiceVO(TimeSeriesChoiceEnum.J24H.getCode(),TimeSeriesChoiceEnum.J24H.getDescription());
        timeSeries.add(choiceVO1);
        timeSeries.add(choiceVO2);
        cockpitIntegratedMultipleChoiceVO.setTimeSeries(timeSeries);
        // 平台
        cockpitIntegratedMultipleChoiceVO.setPlatforms(cockpitMultipleChoiceDao.findPlatforms(PlatformMonitorEnum.MONITOR.getCode()));
        // 社交平台
        cockpitIntegratedMultipleChoiceVO.setSocialPlatforms(cockpitMultipleChoiceDao.findSocialPlatforms());
        return cockpitIntegratedMultipleChoiceVO;
    }
}
