package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentCross;
import cn.qkl.common.repository.model.ContentCrossDailyStatistics;
import cn.qkl.webserver.dao.ContentCrossDailyStatisticsDao;
import cn.qkl.webserver.dao.ContentCrossDao;
import cn.qkl.webserver.dto.board.CrossContentRiskViewDTO;
import cn.qkl.webserver.dto.board.CrossContentTxDTO;
import cn.qkl.webserver.vo.board.CrossContentRiskViewVO;
import cn.qkl.webserver.vo.board.CrossContentTxViewVO;
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
        Map<String, Set<Long>> chainToAccountNumMap = new HashMap<>();
        Map<String, Integer> chainToTxNunMap = new HashMap<>();
        List<ContentCrossDailyStatistics> list = new ArrayList<>();
        for (ContentCross contentCross : contentCrossList) {
            //账号集合
            Set<Long> accountSet;
            //源链 chainId与account映射
            String chainKey = contentCross.getChainId() + "-" + contentCross.getBridge();
            accountSet = chainToAccountNumMap.getOrDefault(chainKey, new HashSet<>());
            accountSet.add(contentCross.getAccountId());
            chainToAccountNumMap.put(chainKey, accountSet);
            //目标链 chainId与account映射
            String dstChainKey = contentCross.getDstChainId() + "-" + contentCross.getBridge();
            accountSet = chainToAccountNumMap.getOrDefault(dstChainKey, new HashSet<>());
            accountSet.add(contentCross.getDstAccountId());
            chainToAccountNumMap.put(dstChainKey, accountSet);
            //源链交易数量+1
            chainToTxNunMap.put(chainKey, chainToTxNunMap.getOrDefault(chainKey, 0) + 1);
            //目标链交易数量+1
            chainToTxNunMap.put(dstChainKey, chainToTxNunMap.getOrDefault(dstChainKey, 0) + 1);
        }
        for (Map.Entry<String, Set<Long>> entry : chainToAccountNumMap.entrySet()) {
            ContentCrossDailyStatistics statistics = new ContentCrossDailyStatistics();
            String key = entry.getKey();
            statistics.setId(IdUtil.getSnowflakeNextId());
            String[] split = key.split("-");
            statistics.setChainId(Long.valueOf(split[0]));
            statistics.setBridge(Integer.valueOf(split[1]));
            statistics.setRiskAccountNum(entry.getValue().size());
            statistics.setTxNum(chainToTxNunMap.get(key));
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

    public CrossContentTxViewVO getCrossContentTxView(CrossContentTxDTO dto) {
        List<ContentCrossDailyStatistics> list = contentCrossDailyStatisticsDao.select(c -> c
                .where(Tables.contentCrossDailyStatistics.chainId, isEqualTo(dto.getChainId()))
                .and(Tables.contentCrossDailyStatistics.bridge, isEqualTo(dto.getBridge()))
        );
        return CrossContentTxViewVO.transform(list);
    }

}
