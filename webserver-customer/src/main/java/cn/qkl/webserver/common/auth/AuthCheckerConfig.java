package cn.qkl.webserver.common.auth;

import cn.qkl.common.framework.auth.AuthChecker;
import cn.qkl.common.framework.auth.TokenBean;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.auth.RoleType;
import cn.qkl.common.framework.exception.BusinessException;
import cn.qkl.common.framework.exception.UnauthorizedException;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Component
public class AuthCheckerConfig implements AuthChecker {

    @Autowired
    private UserDao userDao;

    @Override
    public Object getUser(TokenBean tokenBean) {
        if (RoleEnum.RoleTypeEnum.USER.getRoleType().equals(tokenBean.getRoleType())) {

            User user = userDao.selectOne(c -> c
                    .where(Tables.user.userId, isEqualTo((int) tokenBean.getRoleId()))
            ).orElseThrow(() -> new BusinessException(BusinessStatus.User_Not_EXISTS));
            if (user == null) {
                throw new UnauthorizedException(BusinessStatus.ACCOUNT_EXCEPTION.getCode());
            }
            return user;
        } else if (RoleEnum.RoleTypeEnum.ADMIN.getRoleType().equals(tokenBean.getRoleType())) {
            User user = userDao.selectOne(c -> c
                    .where(Tables.user.userId, isEqualTo((int) tokenBean.getRoleId()))
            ).orElseThrow(() -> new BusinessException(BusinessStatus.User_Not_EXISTS));
            if (user == null) {
                throw new UnauthorizedException(BusinessStatus.ACCOUNT_EXCEPTION.getCode());
            }
            return user;
        } else {
            throw new UnauthorizedException(BusinessStatus.UNAUTHORIZED.getCode());
        }
    }

    @Override
    public Class<? extends RoleType> getRole(Object roleModel, TokenBean tokenBean) {
        // 表示从数据库中获取的用户角色(当前登录用户的实际角色)
        if (RoleEnum.RoleTypeEnum.USER.getRoleType().equals(tokenBean.getRoleType())) {
            return RoleEnum.UserRole.class;
        } else if (RoleEnum.RoleTypeEnum.ADMIN.getRoleType().equals(tokenBean.getRoleType())) {
            return RoleEnum.AdminRole.class;
        } else {
            throw new UnauthorizedException(BusinessStatus.UNAUTHORIZED.getCode());
        }
    }

    @Override
    public void customCheck(Object roleModel, TokenBean tokenBean) {

    }
}
