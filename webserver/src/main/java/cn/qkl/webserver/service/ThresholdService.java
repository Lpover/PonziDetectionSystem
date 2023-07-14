package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.AccountCheckHistoryDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dao.ThresholdsDao;
import cn.qkl.webserver.dto.riskaccount.AccountInfoListQueryDTO;
import cn.qkl.webserver.dto.riskaccount.AccountNumDTO;
import cn.qkl.webserver.dto.threhold.IndexChangeDTO;
import cn.qkl.webserver.dto.threhold.IndexReportDTO;
import cn.qkl.webserver.vo.platformview.PlatformRiskContentVO;
import cn.qkl.webserver.vo.riskAccount.AccountInfoVO;
import cn.qkl.webserver.vo.riskAccount.AccountNumVO;
import cn.qkl.webserver.vo.threshold.IndexReportVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @title:
 * @Author lpc
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class ThresholdService {

    @Autowired
    private ThresholdsDao thresholdsDao;

    //获取多维度指数
    public List<IndexReportVO> getIndexReport(IndexReportDTO dto){
        List<IndexReportVO> IndexReport= thresholdsDao.getIndexReport(select(
                        Tables.thresholds.id,Tables.thresholds.nowIndex,Tables.thresholds.setIndex)
                        .from(Tables.thresholds)
                        .limit(5)
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
                );
        return IndexReport;
    }

    public void indexChange(IndexChangeDTO dto){
        int cvalue=dto.getChangeValue();
        Long cid=dto.getSelectID();
        thresholdsDao.update(
                    c->c.set(Tables.thresholds.setIndex).equalTo(cvalue)
                            .where(Tables.thresholds.id, isEqualTo(cid))
                );
    }
}
