package cn.qkl.webserver.common;

import cn.qkl.common.framework.auth.Role;
import cn.qkl.common.framework.auth.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    CommonFrameworkProperties frameworkProperties;

    @Autowired
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).order(-1)
                .addPathPatterns(frameworkProperties.getApiPrefix() + "/**");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(frameworkProperties.getApiPrefix(), c -> c.isAnnotationPresent(Role.class));
    }
}