package cn.qkl.webserver.service;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.auth.TokenBean;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.exception.BusinessException;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.common.BusinessStatus;
import cn.qkl.webserver.common.ServerConfig;
import cn.qkl.webserver.common.auth.RoleEnum;
import cn.qkl.webserver.common.enums.UserRoleEnum;
import cn.qkl.webserver.dao.UserDao;
import cn.qkl.webserver.dto.user.AddUserDTO;
import cn.qkl.webserver.dto.user.LoginDTO;
import cn.qkl.webserver.dto.user.ModifyPwdDTO;
import cn.qkl.webserver.vo.user.UserInfoVO;
import cn.qkl.webserver.vo.user.UserListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class UserService {


    @Value("${webserver.alias:none}")
    public String webServerAlias;

    @Value("${webserver.age:10}")
    public int webServerAge;

    @Resource
    Environment environment;

    @Resource
    ServerConfig serverConfig;

    @Autowired
    private  UserDao userDao;

    /**
     * 邮箱登录
     *
     * @param dto
     * @return
     */
    public String emailLogin(LoginDTO dto) {
        //判断账号密码是否正确
        User user = userDao.selectOne(c -> c
                .where(Tables.user.phone, isEqualTo(dto.getPhone()))
                .and(Tables.user.pwd, isEqualTo(dto.getPwd()))
        ).orElseThrow(() -> new BusinessException(BusinessStatus.EMAIL_OR_PASSWORD_IS_WRONG));

        //生成token
        TokenBean tokenBean = new TokenBean(user.getId()).withRoleType(RoleEnum.RoleTypeEnum.valueOf(UserRoleEnum.valueOf(user.getRole())).getRoleType()).withUuid();
        return TokenHandler.generateToken(tokenBean);
    }

    public void test() {
        System.out.println("" + webServerAge + webServerAlias);
    }

    /**
     * 获取个人信息
     *
     * @return
     */
    public UserInfoVO getUserInfo() {
        //判断账号密码是否正确
        User user = userDao.selectOne(c -> c
                .where(Tables.user.id, isEqualTo(TokenHandler.getUserId()))
        ).orElseThrow(() -> new BusinessException(BusinessStatus.User_Not_EXISTS));
        return UserInfoVO.transform(user);
    }

    public List<UserListVO> getUserList() {
        List<User> users = userDao.select(c -> c);
        return users.stream().map(UserListVO::transform).collect(Collectors.toList());
    }

    public void addUser(AddUserDTO dto) {
        User user = new User();
        user.setId(IdUtil.getSnowflakeNextId());
        user.setPhone(dto.getPhone());
        user.setPwd(dto.getPwd());
        userDao.insert(user);
    }

    public void modifyPwd(ModifyPwdDTO dto) {
        userDao.update(c -> c
                .set(Tables.user.pwd).equalTo(dto.getPwd())
                .where(Tables.user.id, isEqualTo(dto.getId()))
        );
    }
}
