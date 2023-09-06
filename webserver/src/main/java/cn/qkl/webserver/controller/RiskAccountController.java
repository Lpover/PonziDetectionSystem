package cn.qkl.webserver.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.UrlResource;
import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.response.BaseResult;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dto.riskaccount.*;
import cn.qkl.webserver.service.RiskAccountService;
import cn.qkl.webserver.vo.riskAccount.*;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
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
@Api(value = "风险账户相关接口", tags = {"风险账户相关接口"})
@ApiSupport(author = "lpc")
@RequestMapping("riskaccount")
@RefreshScope
@Role(roles = {RoleEnum.UserBaseRole.class, RoleEnum.AdminBaseRole.class})
public class RiskAccountController {

    //    @LoadBalanced
    @Autowired
    RiskAccountService riskAccountService;//风险账户



    @ApiOperation("获取分页列表信息")
    @GetMapping("riskaccount/info")
    public BaseResult<PageVO<AccountInfoVO>> getAccountInfo(@Validated AccountInfoListQueryDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountInfoList(dto));
    }//获得报表信息
    @ApiOperation("高中低风险账户信息")
    @GetMapping("riskaccount/accountnum")
    public BaseResult<AccountNumVO> accountNum(@Validated AccountNumDTO dto) {
        return BaseResult.ok(riskAccountService.getAccountNum(dto));
    }

    @ApiOperation("智能查找目标地址-地址表")
    @GetMapping("smartaddressfind")
    public BaseResult<List<SmartAddressFindVO>>  smartAddressFind(@Validated SmartAddressFindDTO dto) {
        return BaseResult.ok(riskAccountService.getSmartAddress(dto));
    }

    @ApiOperation("智能查找目标地址-交易表")
    @GetMapping("smarttranscationfind")
    public BaseResult<List<SmartTranscationFindVO>>  smartTransactionFind(@Validated SmartAddressFindDTO dto) {
        return BaseResult.ok(riskAccountService.getSmartTransaction(dto));
    }

    @ApiOperation("网状分析添加备注")
    @PostMapping("addnote")
    public BaseResult<Void> addNote(@RequestBody @Validated AddNoteDTO dto) {
        riskAccountService.changeAddNote(dto);
        return BaseResult.ok();
    }

    @ApiOperation("交易导出按钮")
    @GetMapping("transactionexport")
    public BaseResult<String> transactionExport(@Validated TransactionExportDTO dto) {
        return BaseResult.ok(riskAccountService.doTransactionExport(dto));
    }

    @ApiOperation("导出任务显示")
    @GetMapping("exporttask")
    public BaseResult<List<ExportTaskVO>> exportTask(@Validated ExportTaskDTO dto) {
        return BaseResult.ok(riskAccountService.getExportTask(dto));
    }

    @ApiOperation("地址全部交易详情")
    @GetMapping("transactiondetail")
    public BaseResult<List<TransactionDetailVO>> transactionDetail(@Validated TransactionDetailDTO dto) {
        return BaseResult.ok(riskAccountService.getTransactionDetail(dto));
    }

    @ApiOperation("地址全部交易备注修改")
    @PostMapping("detailnote")
    public BaseResult<Void> detailNote(@RequestBody @Validated DetailNoteDTO dto) {
        riskAccountService.changeDetailNote(dto);
        return BaseResult.ok();
    }

    @ApiOperation("下载附件url-1号接口")
    @GetMapping("downloadCsv-1")
    public ResponseEntity<byte[]> downloadCsv(@Validated DownloadDTO dto) throws IOException {
        // 获取文件的URL
        String csvFileUrl = dto.getUrl(); // 请确保 URL 格式正确

        // 如果 URL 中包含多余的前缀，可以尝试去除它们
        csvFileUrl = csvFileUrl.replace("file:/", ""); // 去除 "file:/" 前缀
        // 创建 UrlResource 对象
        UrlResource resource = new UrlResource(new File(csvFileUrl));

        // 读取文件内容为字节数组（Java 8）
        byte[] fileContent;
        try (InputStream inputStream = resource.getStream()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            fileContent = outputStream.toByteArray();
        }

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", resource.getName());

        // 返回字节数组，并设置响应头
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileContent);
    }

    @ApiOperation("下载附件url-2号接口")
    @PostMapping("downloadCsv-2")
    public BaseResult<Void> downloadCsv(@RequestBody @Validated DownloadDTO dto, HttpServletResponse response) throws IOException {
        URL url = new URL(dto.getUrl());
        String filePath = url.getPath();
        String fileName = FilenameUtils.getName(filePath);
        FileInputStream fis=new FileInputStream(filePath);
        response.addHeader("Content-Disposition", "attachment;filename="+fileName+";"+"filename*=utf-8''"+fileName);
        FileUtil.copy((Path) fis, (Path) response.getOutputStream());
        return BaseResult.ok();
    }

}
