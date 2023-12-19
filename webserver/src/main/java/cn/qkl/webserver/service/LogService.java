package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.LoginLogDao;
import cn.qkl.webserver.dao.OperationLogDao;
import cn.qkl.webserver.dto.log.LoginLogDTO;
import cn.qkl.webserver.dto.log.OperationLogDTO;
import cn.qkl.webserver.vo.log.LoginLogVO;
import cn.qkl.webserver.vo.log.OperationLogVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2023/12/19 16:13
 **/

@Service
public class LogService {
    @Autowired
    LoginLogDao loginLogDao;

    @Autowired
    OperationLogDao operationLogDao;

    public PageVO<LoginLogVO> getLoginLog(LoginLogDTO dto) {
        return new PageVO<>(dto.getPageId(),dto.getPageSize(),() -> loginLogDao.getLoginLogVO(select(Tables.loginLog.id,Tables.user.name.as("userName"),Tables.loginLog.apiName,Tables.loginLog.apiRouter,Tables.loginLog.ip,Tables.loginLog.detail,Tables.loginLog.time).from(Tables.loginLog).leftJoin(Tables.user).on(Tables.user.id, equalTo(Tables.loginLog.userId))
                .where(Tables.user.name, isLikeCaseInsensitiveWhenPresent("%"+dto.getUserName()+"%"))
                .and(Tables.loginLog.time, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                .and(Tables.loginLog.time, isGreaterThanOrEqualToWhenPresent(dto.getStartTime())).build().render(RenderingStrategies.MYBATIS3)));

    }

    public PageVO<OperationLogVO> getOperationLog(OperationLogDTO dto) {
        return new PageVO<>(dto.getPageId(),dto.getPageSize(),() -> operationLogDao.getOperationLogVO(select(Tables.operationLog.id,Tables.user.name.as("userName"),Tables.operationLog.apiName,Tables.operationLog.apiRouter,Tables.operationLog.ip,Tables.operationLog.time).from(Tables.operationLog).leftJoin(Tables.user).on(Tables.user.id, equalTo(Tables.operationLog.userId))
                .where(Tables.user.name, isLikeCaseInsensitiveWhenPresent("%"+dto.getUserName()+"%"))
                .and(Tables.operationLog.time, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
                .and(Tables.operationLog.time, isGreaterThanOrEqualToWhenPresent(dto.getStartTime())).build().render(RenderingStrategies.MYBATIS3)));
    }
}
