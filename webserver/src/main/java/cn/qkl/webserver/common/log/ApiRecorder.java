package cn.qkl.webserver.common.log;

import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.model.LoginLog;
import cn.qkl.common.repository.model.OperationLog;
import cn.qkl.webserver.dao.LoginLogDao;
import cn.qkl.webserver.dao.OperationLogDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 10:50
 **/

@Component
@Slf4j
public class ApiRecorder {

    @Autowired
    OperationLogDao operationLogDao;

    @Autowired
    LoginLogDao loginLogDao;

    public void doLoginLog(Long userId, String ip, String apiName, String apiRouter, String responseJson) {
        LoginLog loginLog = new LoginLog();
        loginLog.setId(SnowflakeIdUtil.generateId());
        loginLog.setUserId(userId);
        loginLog.setIp(ip);
        loginLog.setApiName(apiName);
        loginLog.setApiRouter(apiRouter);
        loginLog.setTime(new Date());
        loginLog.setDetail(responseJson);
        loginLogDao.insert(loginLog);
    }

    public void doOperationLog(Long userId, String ip, String apiName, String apiRouter) {
        OperationLog operationLog = new OperationLog();
        operationLog.setId(SnowflakeIdUtil.generateId());
        operationLog.setUserId(userId);
        operationLog.setIp(ip);
        operationLog.setApiName(apiName);
        operationLog.setApiRouter(apiRouter);
        operationLog.setTime(new Date());
        operationLogDao.insert(operationLog);
    }

    public void doNoLog() {
        // Unreachable
        log.error("Unreachable");
        throw new RuntimeException("Unreachable ApiLog");
    }
}
