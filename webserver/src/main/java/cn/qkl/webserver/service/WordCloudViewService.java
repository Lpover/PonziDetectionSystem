package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentRiskDailyStatistics;
import cn.qkl.webserver.dao.WordCloudViewDao;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.vo.board.WordCloudViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public WordCloudViewVO getWordCloudView(TimePlatformSelecteDTO dto) {
        Date date = new Date();
        Date end = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTimeSpan() == 0) {   // 近7天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTimeSpan() == 1) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;
        // 对时间和平台筛选
        List<ContentRiskDailyStatistics> contentRiskDailyStatisticsList= wordCloudViewDao.select(c -> c
                .where(Tables.contentRiskDailyStatistics.platformId, isEqualTo(dto.getPlatformid()))
                .and(Tables.contentRiskDailyStatistics.createTime, isGreaterThan(finalStart))
                .and(Tables.contentRiskDailyStatistics.createTime, isLessThan(end))
        );

        List<Integer> listNum = contentRiskDailyStatisticsList.stream()
                .sorted(Comparator.comparing(ContentRiskDailyStatistics::getCreateTime))
                .map(ContentRiskDailyStatistics::getNum).collect(Collectors.toList());
        List<Long> listWordID = contentRiskDailyStatisticsList.stream()
                .sorted(Comparator.comparing(ContentRiskDailyStatistics::getCreateTime))
                .map(ContentRiskDailyStatistics::getCategoryId).collect(Collectors.toList());

        HashMap<Long, Integer> hashMap = IntStream.range(0, listNum.size())
                .boxed()
                .collect(Collectors.toMap(
                        listWordID::get,
                        listNum::get,
                        (oldValue, newValue) -> newValue,
                        HashMap::new)
                );

        WordCloudViewVO vo = new WordCloudViewVO();
//        vo.setWordDict(hashMap);
        return vo;
    }

}
