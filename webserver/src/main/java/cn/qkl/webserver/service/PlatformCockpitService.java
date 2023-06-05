package cn.qkl.webserver.service;

import cn.qkl.webserver.dao.PlatformDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @title:
 * @Author li yang
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class PlatformCockpitService {
    @Autowired
    private PlatformDao platformDao;

}
