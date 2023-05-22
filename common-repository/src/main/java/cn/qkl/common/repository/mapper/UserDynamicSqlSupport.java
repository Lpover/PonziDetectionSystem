package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final User user = new User();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = user.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userNum = user.userNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userPwd = user.userPwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userName = user.userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userImgUrl = user.userImgUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userSex = user.userSex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> userRegdate = user.userRegdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userIntro = user.userIntro;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> randomnum = user.randomnum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> state = user.state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = user.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> userNum = column("user_num", JDBCType.VARCHAR);

        public final SqlColumn<String> userPwd = column("user_pwd", JDBCType.VARCHAR);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> userImgUrl = column("user_img_url", JDBCType.VARCHAR);

        public final SqlColumn<String> userSex = column("user_sex", JDBCType.VARCHAR);

        public final SqlColumn<Date> userRegdate = column("user_regdate", JDBCType.TIMESTAMP);

        public final SqlColumn<String> userIntro = column("user_intro", JDBCType.VARCHAR);

        public final SqlColumn<String> randomnum = column("randomNum", JDBCType.VARCHAR);

        public final SqlColumn<Integer> state = column("`state`", JDBCType.INTEGER);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}