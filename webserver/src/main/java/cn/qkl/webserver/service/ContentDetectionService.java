package cn.qkl.webserver.service;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.ContentRisk;
import cn.qkl.common.repository.model.Platform;
import cn.qkl.webserver.dao.ContentDetectionDao;
import cn.qkl.webserver.dao.ContentRiskDao;
import cn.qkl.webserver.dao.PlatformDao;
import cn.qkl.webserver.dto.contentdetection.ContentDetectionListQueryDTO;
import cn.qkl.webserver.dto.contentdetection.ContentTagsDTO;
import cn.qkl.webserver.dto.contentdetection.PlatformDistributionDTO;
import cn.qkl.webserver.vo.contentDetection.ContentDetectionInfoVO;
import cn.qkl.webserver.vo.contentDetection.ContentTagsVO;
import cn.qkl.webserver.vo.contentDetection.PlatformDistributionVO;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.Select;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
public class ContentDetectionService {

    @Autowired
    private ContentDetectionDao contentDetectionDao;
    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private ContentRiskDao contentRiskDao;

    //获取分页列表信息
    public PageVO<ContentDetectionInfoVO> getContentDetectionList(ContentDetectionListQueryDTO dto) {
        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),
                ()->contentDetectionDao.getContentDetectionList(
                        select(Tables.content.name,Tables.platform.logo,Tables.platform.name.as("platformName"),Tables.platform.url,
                                Tables.content.owner,Tables.platform.platformType,Tables.content.contentTag,
                                Tables.content.riskLevel,Tables.content.updateTime)
                                .from(Tables.content)
                                .leftJoin(Tables.platform).on(Tables.content.platformId,equalTo(Tables.platform.id))
                                .orderBy(Tables.content.updateTime)
                                .build()
                                .render(RenderingStrategies.MYBATIS3)

                ));
    }

    //数字内容平台分布视图
    public List<PlatformDistributionVO> getPlatformDistribution(PlatformDistributionDTO dto) {
        List<Platform> platformDistributionList = platformDao.select(c -> c
                .orderBy(Tables.platform.riskContentNum
                ));
        return platformDistributionList.stream().map(PlatformDistributionVO::transform).collect(Collectors.toList());
    }

    //数字内容标签分布视图
    public List<ContentTagsVO> getContentTags(ContentTagsDTO dto) {
        List<ContentRisk> contentTagsList = contentRiskDao.select(c -> c
                .orderBy(Tables.contentRisk.num
                ));
        return contentTagsList.stream().map(ContentTagsVO::transform).collect(Collectors.toList());
    }

}
