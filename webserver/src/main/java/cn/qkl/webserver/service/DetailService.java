package cn.qkl.webserver.service;

import cn.qkl.webserver.common.ServerConfig;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dao.UserDao;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title:
 * @Author zouzh
 * @Date: 2023/5/18 15:18
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class DetailService {
    @Value("${webserver.alias:none}")
    public String webServerAlias;

    @Value("${webserver.age:10}")
    public int webServerAge;

    @Resource
    Environment environment;

    @Resource
    ServerConfig serverConfig;

    @Autowired
    private ContentDao contentDao;

    public ContentInfoVO getContentInfo() {

        return new ContentInfoVO();
    }

}
