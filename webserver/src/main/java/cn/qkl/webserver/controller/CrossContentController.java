package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.dto.cross.CrossContentListQueryDTO;
import cn.qkl.webserver.service.CrossContentService;
import cn.qkl.webserver.vo.cross.CrossContentVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "跨链内容相关接口", tags = {"跨链内容相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("cross")
@RefreshScope
@Role
public class CrossContentController {

    @Autowired
    private CrossContentService crossContentService;

    @ApiOperation("跨链风险数字内容列表")
    @GetMapping("content/list")
    public BaseResult<PageVO<CrossContentVO>> getCrossContentList(@Validated CrossContentListQueryDTO dto) {
        return BaseResult.ok(crossContentService.getCrossContentList(dto));
    }

}
