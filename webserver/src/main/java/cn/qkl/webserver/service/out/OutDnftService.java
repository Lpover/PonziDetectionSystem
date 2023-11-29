package cn.qkl.webserver.service.out;

import cn.qkl.webserver.vo.dynamic.DnftCheckResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * @Author sunxiaen
 * @Date 2023/11/20 14:36
 **/
@FeignClient(name = "dnft-provider",url = "${feign.client.path.dnft-provider.server}")
public interface OutDnftService {
    @GetMapping("${feign.client.path.dnft-provider.path}")
    DnftCheckResultVO getCheckResult(@RequestParam("contract_address") @NotNull String address);
}
