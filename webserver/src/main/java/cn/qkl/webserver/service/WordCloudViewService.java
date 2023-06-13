package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentRiskDailyStatistics;
import cn.qkl.webserver.dao.WordCloudViewDao;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.vo.board.WordCloudViewVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @param
 * @return
 */
@Slf4j
@Service
public class WordCloudViewService {
    @Resource
    WordCloudViewDao wordCloudViewDao;

    public List<WordCloudViewVO> getWordCloudView(TimePlatformSelecteDTO dto) {
        Date date = new Date();
//        Date end = DateUtil.beginOfDay(date);
        Date end = DateUtil.endOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTimeSpan() == 1) {   // 近7天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTimeSpan() == 2) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;

        List<WordCloudViewVO> list = wordCloudViewDao.getWordNum(select(Tables.contentRisk.category.as("word"), Tables.contentRiskDailyStatistics.num)
                .from(Tables.contentRiskDailyStatistics)
                .leftJoin(Tables.contentRisk).on(Tables.contentRisk.id, equalTo(Tables.contentRiskDailyStatistics.categoryId))
                .where(Tables.contentRiskDailyStatistics.platformId, isEqualTo(dto.getPlatformid()))
                .and(Tables.contentRiskDailyStatistics.createTime, isGreaterThanOrEqualToWhenPresent(finalStart))
                .and(Tables.contentRiskDailyStatistics.createTime, isLessThanOrEqualToWhenPresent(end))
                .orderBy(SimpleSortSpecification.of("content_risk_daily_statistics.create_time"))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );

        // 对相同的word进行累加
        Map<String, Integer> countMap = list.stream()
                .collect(Collectors.groupingBy(
                        WordCloudViewVO::getWord,
                        Collectors.summingInt(WordCloudViewVO::getNum)
                ));
        List<WordCloudViewVO> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            WordCloudViewVO wordCloudViewVO = new WordCloudViewVO();
            wordCloudViewVO.setWord(entry.getKey());
            wordCloudViewVO.setNum(entry.getValue());
            res.add(wordCloudViewVO);
        }
        return res;

    }

    public void insertWordNum(ContentRiskDailyStatistics contentRiskDailyStatistics, Long categoryID, Long platformID) {
        Random random = new Random();
        Date end = new Date();
        contentRiskDailyStatistics.setId(IdUtil.getSnowflakeNextId());
        contentRiskDailyStatistics.setNum(random.nextInt(1000));
        contentRiskDailyStatistics.setPlatformId(platformID);
        contentRiskDailyStatistics.setCategoryId(categoryID);
        contentRiskDailyStatistics.setCreateTime(end);
        contentRiskDailyStatistics.setUpdateTime(end);
    }

}
