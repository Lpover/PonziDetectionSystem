package cn.qkl.common.framework.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author sunxiaen
 * @Date 2023/6/12 16:05
 **/
//开启异步
@EnableAsync
//配置类
@Configuration
public class AsyncConfig implements AsyncConfigurer {
    @Autowired
    private AsyncProperties asyncProperties;

    @Override
    @Bean("qklTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncProperties.getCorePoolSize());
        executor.setMaxPoolSize(asyncProperties.getMaxPoolSize());
        executor.setQueueCapacity(asyncProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(asyncProperties.getKeppAliveSeconds());
        executor.setThreadNamePrefix(asyncProperties.getPrefixName());
        //设置线程池关闭的时候 等待所有的任务完成后再继续销毁其他的bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }
}

