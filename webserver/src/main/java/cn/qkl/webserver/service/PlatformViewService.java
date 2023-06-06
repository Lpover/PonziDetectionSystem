package cn.qkl.webserver.service;

import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.PlatformDailyStatistics;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dao.PlatformViewDao;
import cn.qkl.webserver.dto.platformview.PlatformAndTimeSelectionDTO;
import cn.qkl.webserver.vo.contentDetection.ContentTagsVO;
import cn.qkl.webserver.vo.platformview.VolumeDailyVO;
import cn.qkl.webserver.vo.platformview.VolumeTrendsVO;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.Limit;
import net.sf.jsqlparser.statement.select.Select;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

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

    //返回平台（NFT、WEB3）的风险内容数量
    public List<VolumeTrendsVO> getVolumeTrends(PlatformAndTimeSelectionDTO dto){
        //dayLimit指的是显示的天数
        int dayLimit=7;
        if(dto.getSelectTime()==2)dayLimit=30;
        List<VolumeTrendsVO> volumeTrendsList = platformViewDao.getVolumeTrends(
                    select(Tables.platformDailyStatistics.contentRiskSum, Tables.platformDailyStatistics.createTime)
                            .from(Tables.platformDailyStatistics)
                            .where(Tables.platformDailyStatistics.platformId, isEqualTo(dto.getSelectPlatformId()))
                            .orderBy(Tables.platformDailyStatistics.createTime.descending())
                            .limit(dayLimit)
                            .build()
                            .render(RenderingStrategies.MYBATIS3)
        );
        return volumeTrendsList;
    }

}
