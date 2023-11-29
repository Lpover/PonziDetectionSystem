package cn.qkl.webserver;

import cn.qkl.common.framework.config.UniqueNameGenerator;
import cn.qkl.webserver.service.out.OutDnftService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


//解决swagger升级2.6x之后和springboot不兼容情况
//@EnableWebMvc //会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置！从而导致所有的Date返回都变成时间戳。
@SpringBootApplication(scanBasePackages = {"cn.qkl"})
@EnableFeignClients(clients = {OutDnftService.class})
@EnableScheduling
@MapperScan(nameGenerator = UniqueNameGenerator.class, basePackages = {"cn.qkl.webserver.*"})
public class AppApplication {

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext run = SpringApplication.run(AppApplication.class, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
