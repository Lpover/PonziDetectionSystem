package cn.qkl.webserver.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author sunxiaen
 * @Date 2023/6/12 16:49
 **/
@Service
@Slf4j
@Primary
public class TsgzAsyncImpl implements TsgzAsyncService {
    @Override
    //使用@Async，并将前面的注册的bean，填写到Async的value中
    //源码AsyncExecutionAspectSupport
    @Async
    public void doAsync() {
        log.info("== async start==");
        log.info("TSGZ 线程 使用 {} 执行代码逻辑",Thread.currentThread().getName());
        log.info("== async end==");
    }
}
