package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentCross;
import cn.qkl.common.repository.model.ContentCrossDailyStatistics;
import cn.qkl.webserver.dao.ContentCrossDailyStatisticsDao;
import cn.qkl.webserver.dao.ContentCrossDao;
import cn.qkl.webserver.dto.cross.CrossContentRiskViewDTO;
import cn.qkl.webserver.vo.cross.CrossContentRiskViewVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class CrossContentDailyStatisticsService {

    @Autowired
    private ContentCrossDao contentCrossDao;

    @Autowired
    private ContentCrossDailyStatisticsDao contentCrossDailyStatisticsDao;

    /**
     * contentCross表过去24小时数据处理
     */
    public void insertContentCrossDailyStatistics() {
        //服务器当前时间
        Date date = new Date();
        //昨天凌晨00：00：00
        Date end = DateUtil.beginOfDay(date);
        //前天凌晨00：00：00
        Date start = DateUtil.offsetDay(end, -1);
        List<ContentCross> contentCrossList = contentCrossDao.select(c -> c
                .where(Tables.contentCross.createTime, isGreaterThan(start))
                .and(Tables.contentCross.createTime, isLessThan(end))
        );
        Map<Long, Set<Long>> chainToAccountNumMap = new HashMap<>();
        Map<Long, Integer> chainToTxNunMap = new HashMap<>();
        List<ContentCrossDailyStatistics> list = new ArrayList<>();
        for (ContentCross contentCross : contentCrossList) {
            //账号集合
            Set<Long> accountSet;
            //源链 chainId与account映射
            accountSet = chainToAccountNumMap.getOrDefault(contentCross.getChainId(), new HashSet<>());
            accountSet.add(contentCross.getAccountId());
            chainToAccountNumMap.put(contentCross.getChainId(), accountSet);
            //目标链 chainId与account映射
            accountSet = chainToAccountNumMap.getOrDefault(contentCross.getDstChainId(), new HashSet<>());
            accountSet.add(contentCross.getDstAccountId());
            chainToAccountNumMap.put(contentCross.getDstChainId(), accountSet);
            //源链交易数量+1
            chainToTxNunMap.put(contentCross.getChainId(), chainToTxNunMap.getOrDefault(contentCross.getChainId(), 0) + 1);
            //目标链交易数量+1
            chainToTxNunMap.put(contentCross.getDstChainId(), chainToTxNunMap.getOrDefault(contentCross.getDstChainId(), 0) + 1);
        }
        for (Map.Entry<Long, Set<Long>> entry : chainToAccountNumMap.entrySet()) {
            ContentCrossDailyStatistics statistics = new ContentCrossDailyStatistics();
            statistics.setId(IdUtil.getSnowflakeNextId());
            statistics.setChainId(entry.getKey());
            statistics.setRiskAccountNum(entry.getValue().size());
            statistics.setTxNum(chainToTxNunMap.get(entry.getKey()));
            statistics.setCreateTime(date);
            statistics.setUpdateTime(date);
            list.add(statistics);
        }
        if (list.size() > 0) {
            contentCrossDailyStatisticsDao.insertMultiple(list);
        }
    }

    public List<CrossContentRiskViewVO> getCrossContentRiskView(CrossContentRiskViewDTO dto) {
        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.JoinSpecificationFinisher dsl = select(Tables.contentCrossDailyStatistics.chainId, Tables.chain.chainName, sum(Tables.contentCrossDailyStatistics.riskAccountNum).as("riskAccountNum"), sum(Tables.contentCrossDailyStatistics.txNum).as("txNum"))
                .from(Tables.contentCrossDailyStatistics)
                .leftJoin(Tables.chain).on(Tables.contentCrossDailyStatistics.chainId, equalTo(Tables.chain.id));
        if (dto.getTime() == 1) {
            dsl.where(Tables.contentCrossDailyStatistics.createTime, isGreaterThanOrEqualTo(DateUtil.offsetDay(new Date(), -7)))
                    .and(Tables.contentCrossDailyStatistics.createTime, isLessThanOrEqualTo(new Date()));
        } else {
            dsl.where(Tables.contentCrossDailyStatistics.createTime, isGreaterThanOrEqualTo(DateUtil.offsetDay(new Date(), -30)))
                    .and(Tables.contentCrossDailyStatistics.createTime, isLessThanOrEqualTo(new Date()));
        }
        return contentCrossDailyStatisticsDao.getCrossContentRiskView(
                dsl
                        .groupBy(Tables.contentCrossDailyStatistics.chainId)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
    }

}
