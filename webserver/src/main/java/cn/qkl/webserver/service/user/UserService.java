package cn.qkl.webserver.service.user;

import cn.hutool.json.JSONUtil;
import cn.qkl.common.framework.auth.TokenBean;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.exception.BusinessException;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.dao.UserDao;

import cn.hutool.crypto.digest.DigestUtil;

import cn.qkl.webserver.dto.user.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.function.Function;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 邮箱登录
     *
     * @param dto
     * @return
     */
    public String emailLogin(LoginDTO dto) {
        //判断账号密码是否正确
        User user = userDao.selectOne(c -> c
                .where(Tables.user.userNum, isEqualTo(dto.getUserNum()))
                .and(Tables.user.userPwd, isEqualTo(dto.getUserPwd()))
        ).orElseThrow(() -> new BusinessException(BusinessStatus.EMAIL_OR_PASSWORD_IS_WRONG));

        //生成token
        TokenBean tokenBean = new TokenBean(user.getUserId()).withRoleType(RoleEnum.RoleTypeEnum.USER.getRoleType()).withUuid();
        return TokenHandler.generateToken(tokenBean);
    }


    /**
     * 获取个人信息
     *
     * @return
     */
    public User getUserInfo() {
        //判断账号密码是否正确
        User user = userDao.selectOne(c -> c
                .where(Tables.user.userId, isEqualTo((int) TokenHandler.getUserId()))
        ).orElseThrow(() -> new BusinessException(BusinessStatus.User_Not_EXISTS));

        return user;
    }
}
