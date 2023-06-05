package cn.qkl.webserver.common;

import cn.qkl.common.framework.auth.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
        //定义排除swagger访问的路径配置
        String[] swaggerExcludes = new String[]{"/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**", "/doc.html/**"};
        registry.addInterceptor(tokenInterceptor).order(-1)
                .addPathPatterns("/**")
                .excludePathPatterns(swaggerExcludes);
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix(frameworkProperties.getApiPrefix(), c -> c.isAnnotationPresent(Role.class));
//    }
}