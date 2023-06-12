package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.RiskTxViewDao;
import cn.qkl.webserver.dto.board.TimePlatformSelecteDTO;
import cn.qkl.webserver.vo.board.RiskTxViewVO;
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
public class RiskTxViewService {
    @Resource
    RiskTxViewDao riskTxViewDao;

    public RiskTxViewVO getRiskTxView(TimePlatformSelecteDTO dto) {
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
        // 对时间和平台筛选，并根据时间排序
        List<PlatformDailyStatistics> platformDailyStatisticsList= riskTxViewDao.select(c -> c
                        .where(Tables.platformDailyStatistics.platformId, isEqualTo(dto.getPlatformid()))
                .and(Tables.platformDailyStatistics.createTime, isGreaterThanOrEqualTo(finalStart))
                .and(Tables.platformDailyStatistics.createTime, isLessThanOrEqualTo(end))
        );
        RiskTxViewVO vo = new RiskTxViewVO();
        // 根据创建时间进行排序，封装到vo中
        vo.setHighTx(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getHighRiskTx)
                .collect(Collectors.toList()));
        vo.setMidTx(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getMiddleRiskTx)
                .collect(Collectors.toList()));
        vo.setLowTx(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getLowRiskTx)
                .collect(Collectors.toList()));
        vo.setTimeList(platformDailyStatisticsList.stream()
                .sorted(Comparator.comparing(PlatformDailyStatistics::getCreateTime))
                .map(PlatformDailyStatistics::getCreateTime)
                .collect(Collectors.toList()));
        return vo;
    }

    // 随机插入风险交易数据
    public void insertRiskTx(PlatformDailyStatistics platformDailyStatistics) {
        Random random = new Random();
        platformDailyStatistics.setHighRiskTx(random.nextInt(1000));
        platformDailyStatistics.setMiddleRiskTx(random.nextInt(1000));
        platformDailyStatistics.setLowRiskTx(random.nextInt(1000));
    }

}
