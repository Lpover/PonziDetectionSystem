package cn.qkl.webserver.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.request.PageDTO;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.mapper.PlatformDynamicSqlSupport;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.common.enums.*;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.dto.dynamic.DynamicContentListQueryDTO;
import cn.qkl.webserver.dto.platform.AddPlatformDTO;
import cn.qkl.webserver.dto.platform.ModifyPlatformDTO;
import cn.qkl.webserver.dto.platform.ModifySuperviseDTO;
import cn.qkl.webserver.dto.platform.PopularPlatformQueryDTO;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import cn.qkl.webserver.vo.platform.PlatformContentVO;
import cn.qkl.webserver.vo.platform.PlatformListVO;
import cn.qkl.webserver.vo.platform.PlatformNameListVO;
import cn.qkl.webserver.vo.platform.PlatformSuperviseListVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.SimpleSortSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author li yang
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class PlatformService {
    @Autowired
    private PlatformDao platformDao;

    /**
     * 获取平台列表
     * @param dto
     * @return
     */
    public List<PlatformContentVO> getPopularPlatform(PopularPlatformQueryDTO dto) {
        //当前服务器时间
        Date end = new Date();
        //全部
        end=DateUtil.beginOfDay(end);
        DateTime start = DateUtil.offsetDay(end, -7);
        List<PlatformContentVO> platforms = platformDao.getPlatformContent(
                select(Tables.platform.id, Tables.platform.platformType ,Tables.platform.name,sum(Tables.riskContentStatistics.contentSum).as("sumContentNumber"))
                        .from(Tables.platform)
                        .leftJoin(Tables.riskContentStatistics).on(Tables.platform.id, equalTo(Tables.riskContentStatistics.platformId))
                        .where(Tables.platform.platformType, isEqualTo(dto.getType()))
                        .and(Tables.platform.updateTime, isGreaterThanOrEqualToWhenPresent(start))
                        .and(Tables.platform.updateTime, isLessThanOrEqualToWhenPresent(end))
                        .groupBy(Tables.platform.id)
                        .orderBy(SimpleSortSpecification.of("sumContentNumber").descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3)
        );
        return platforms;
    }
    public PageVO<PlatformSuperviseListVO> getSuperviseList(PageDTO dto){
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),()->platformDao.select(c -> c
        ),PlatformSuperviseListVO::transform);
    }
    public List<PlatformNameListVO> getNameList(){
        List<Platform> platforms = platformDao.select(c -> c);
        return platforms.stream().map(PlatformNameListVO::transform).collect(Collectors.toList());
    }
    public PageVO<PlatformListVO> getPlatformList(PageDTO dto){
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(),()->platformDao.select(c -> c
        ),PlatformListVO::transform);
    }
    public void addPlatform(AddPlatformDTO dto){
        Platform platform=new Platform();
        platform.setId(SnowflakeIdUtil.generateId());
        platform.setName(dto.getName());
        platform.setUrl(dto.getUrl());
        platform.setCrawlerFile(dto.getCrawlerUrl());
        platformDao.insert(platform);
    }
    public void modifySupervise(ModifySuperviseDTO dto){
        platformDao.update(c -> c
                .set(Tables.platform.monitor).equalTo(dto.getMonitor())
                .where(Tables.platform.id, isEqualTo(dto.getId()))
        );
    }
    public void modifyPlatform(ModifyPlatformDTO dto){
        platformDao.update(c -> c
                .set(Tables.platform.name).equalTo(dto.getName())
                .set(Tables.platform.url).equalTo(dto.getUrl())
                .set(Tables.platform.crawlerFile).equalTo(dto.getCrawlerUrl())
                .where(Tables.platform.id,isEqualTo(dto.getId()))
        );
    }
}
