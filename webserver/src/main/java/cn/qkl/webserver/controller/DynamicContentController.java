package cn.qkl.webserver.controller;


import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.dto.dynamic.DynamicContentExportDTO;
import cn.qkl.webserver.dto.dynamic.DynamicContentListQueryDTO;
import cn.qkl.webserver.dto.dynamic.ManualReviseDynamicTypeDTO;
import cn.qkl.webserver.dto.dynamic.ReCheckDynamicTypeDTO;
import cn.qkl.webserver.service.DynamicContentService;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:31
 * @wiki
 */
@RestController
@Slf4j
@Validated
@Api(value = "动态内容相关接口", tags = {"动态内容相关接口"})
@ApiSupport(author = "wx")
@RequestMapping("dynamic")
@RefreshScope
@Role
public class DynamicContentController {

    @Autowired
    private DynamicContentService dynamicContentService;

    @ApiOperation("动态风险数字内容列表")
    @GetMapping("content/list")
    public BaseResult<PageVO<DynamicContentVO>> getDynamicContentList(@Validated DynamicContentListQueryDTO dto) {
        return BaseResult.ok(dynamicContentService.getDynamicContentList(dto));
    }

    @ApiOperation("动态风险数字内容批量纠错")
    @PutMapping("content/type/manual")
    public BaseResult<Void> manualReviseDynamicType(@Validated @RequestBody ManualReviseDynamicTypeDTO dto) {
        dynamicContentService.manualReviseDynamicType(dto);
        return BaseResult.ok();
    }

    @ApiOperation("动态风险数字内容重新识别")
    @PutMapping("content/type/reCheck")
    public BaseResult<Void> reCheckDynamicType(@Validated @RequestBody ReCheckDynamicTypeDTO dto) {
        return BaseResult.ok();
    }

    @ApiOperation("动态风险数字内容批量导出")
    @PostMapping("content/export")
    public void dynamicContentListExport(@RequestBody @Validated DynamicContentExportDTO dto, HttpServletResponse response) {
        dynamicContentService.dynamicContentListExport(dto, response);
    }

}
