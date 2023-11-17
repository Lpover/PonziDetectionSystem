package cn.qkl.webserver.controller;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.contentdetection.ContentTagsDTO;
import cn.qkl.webserver.dto.contentdetection.PlatformDistributionDTO;
import cn.qkl.webserver.dto.contentdetection.ContentDetectionListQueryDTO;
import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.webserver.service.ContentDetectionService;
import cn.qkl.webserver.vo.contentDetection.ContentDetectionInfoVO;
import cn.qkl.webserver.vo.contentDetection.ContentTagsVO;
import cn.qkl.webserver.vo.contentDetection.PlatformDistributionVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title:
 * @Author lu
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "内容监测页面 本地数据相关接口", tags = {"内容监测页面 本地数据相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("contentdetection")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class ContentDetectionController {

    @Autowired
    ContentDetectionService contentDetectionService;

    @ApiOperation("内容监测 本地数据页 获取分页列表信息")
    @GetMapping("contentdetection/info")
    public BaseResult<PageVO<ContentDetectionInfoVO>> getContentDetectionInfo(@Validated ContentDetectionListQueryDTO dto) {
        return BaseResult.ok(contentDetectionService.getContentDetectionList(dto));
    }//获得报表信息
    @ApiOperation("数字内容平台分布视图")
    @GetMapping("contentdetection/platformdistribution")
    public BaseResult<List<PlatformDistributionVO>> platformDistribution(@Validated PlatformDistributionDTO dto) {
        return BaseResult.ok(contentDetectionService.getPlatformDistribution(dto));
    }
    @ApiOperation("数字内容标签分布视图")
    @GetMapping("contentdetection/contenttags")
    public BaseResult<List<ContentTagsVO>> contentTags(@Validated ContentTagsDTO dto) {
        return BaseResult.ok(contentDetectionService.getContentTags(dto));
    }

}
