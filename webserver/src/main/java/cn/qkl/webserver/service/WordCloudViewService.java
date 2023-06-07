package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.WordCloudViewDao;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.vo.board.WordCloudViewVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        Date end = DateUtil.beginOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTimeSpan() == 0) {   // 近7天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTimeSpan() == 1) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;

        return wordCloudViewDao.getWordNum(select(Tables.contentRiskDailyStatistics.categoryId, Tables.contentRiskDailyStatistics.num)
                .from(Tables.contentRiskDailyStatistics)
                .where(Tables.contentRiskDailyStatistics.platformId, isEqualTo(dto.getPlatformid()))
                .and(Tables.contentRiskDailyStatistics.createTime, isGreaterThan(finalStart))
                .and(Tables.contentRiskDailyStatistics.createTime, isLessThan(end))
                .orderBy(Tables.contentRiskDailyStatistics.createTime)
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );

    }

//    public void insertWordNum()

}
