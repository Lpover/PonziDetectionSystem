package cn.qkl.webserver.service.user;

import cn.qkl.common.repository.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "webserver-provider",path = "/api")
public interface OutUserService {
    @RequestMapping("/user/info")
    User getUserInfo();
}
