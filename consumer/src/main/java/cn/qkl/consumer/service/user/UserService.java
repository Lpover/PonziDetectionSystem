package cn.qkl.consumer.service.user;

import cn.qkl.common.repository.model.User;
import cn.qkl.consumer.dao.UserDao;
import cn.qkl.consumer.dto.user.LoginDTO;
import cn.qkl.consumer.service.OutUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


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
    @Autowired
    private UserDao userDao;

    @Resource
    OutUserService outUserService;

    /**
     * 邮箱登录
     *
     * @param dto
     * @return
     */
    public String emailLogin(LoginDTO dto) {
//        //判断账号密码是否正确
//        User user = userDao.selectOne(c -> c
//                .where(Tables.user.userNum, isEqualTo(dto.getUserNum()))
//                .and(Tables.user.userPwd, isEqualTo(dto.getUserPwd()))
//        ).orElseThrow(() -> new BusinessException(BusinessStatus.EMAIL_OR_PASSWORD_IS_WRONG));
//
//        //生成token
//        TokenBean tokenBean = new TokenBean(user.getUserId()).withRoleType(RoleEnum.RoleTypeEnum.USER.getRoleType()).withUuid();
//        return TokenHandler.generateToken(tokenBean);
        return null ;
    }
//
    public void test() {
//        System.out.println(""+webServerAge+webServerAlias);
    }
//
    public User getRemoteUserInfo() {
//        User user =  outUserService.getUserInfo();
//        System.out.println(user);
//        return user;
        return null;
    }
    /**
     * 获取个人信息
     *
     * @return
     */
    public User getUserInfo() {
        //判断账号密码是否正确
//        User user = userDao.selectOne(c -> c
//                .where(Tables.user.userId, isEqualTo((int) TokenHandler.getUserId()))
//        ).orElseThrow(() -> new BusinessException(BusinessStatus.User_Not_EXISTS));
//        User user = new User();
//        user.setUserNum(environment.getProperty("server.port"));

//        return user;
        return null;
    }
}
