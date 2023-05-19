package cn.qkl.webserver;

import cn.qkl.common.framework.config.UniqueNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决swagger升级2.6x之后和springboot不兼容情况
@EnableWebMvc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(nameGenerator = UniqueNameGenerator.class, basePackages = {"cn.qkl.webserver.*"})
public class AppApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext run = SpringApplication.run(AppApplication.class, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
