package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.RiskNumViewDao;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.vo.board.RiskNumViewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @param
 * @return
 */
@Slf4j
@Service
public class RiskNumViewService {
    @Resource
    RiskNumViewDao riskNumViewDao;

    public RiskNumViewVO getRiskNumView(TimePlatformSelecteDTO dto) {
        Date date = new Date();
        Date end = DateUtil.beginOfDay(date);
//        Date end = DateUtil.endOfDay(date);
        Date start = DateUtil.offsetDay(end, -7);   //默认近7天
        if (dto.getTimeSpan() == 0) {   // 近7天
            start = DateUtil.offsetDay(end, -7);
        } else if (dto.getTimeSpan() == 1) {    // 近30天
            start = DateUtil.offsetDay(end, -30);
        }
        Date finalStart = start;
        // 对时间和平台筛选
        List<PlatformDailyStatistics> platformDailyStatisticsList= riskNumViewDao.select(c -> c
                .where(Tables.platformDailyStatistics.platformId, isEqualTo(dto.getPlatformid()))
                .and(Tables.platformDailyStatistics.createTime, isGreaterThan(finalStart))
                .and(Tables.platformDailyStatistics.createTime, isLessThan(end))
        );
        RiskNumViewVO vo = new RiskNumViewVO();
        // 根据创建时间进行排序，封装到vo中
        vo.setHighNum(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getHighRiskNum)
                .collect(Collectors.toList()));
        vo.setMidNum(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getMiddleRiskNum)
                .collect(Collectors.toList()));
        vo.setLowNum(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getLowRiskNum)
                .collect(Collectors.toList()));
        vo.setTimeList(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getCreateTime)
                .collect(Collectors.toList()));
        return vo;
    }

    // 随机插入风险数量数据
    public void insertRiskNum(PlatformDailyStatistics platformDailyStatistics) {
        Random random = new Random();
        Integer high = random.nextInt(1000);
        Integer mid = random.nextInt(1000);
        Integer low = random.nextInt(1000);
        platformDailyStatistics.setHighRiskNum(high);
        platformDailyStatistics.setMiddleRiskNum(mid);
        platformDailyStatistics.setLowRiskNum(low);
        platformDailyStatistics.setContentRiskSum(high + mid + low);
    }
}
