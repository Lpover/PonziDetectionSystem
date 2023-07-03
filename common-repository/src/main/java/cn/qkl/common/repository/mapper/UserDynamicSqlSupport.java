package cn.qkl.common.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final User user = new User();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = user.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> phone = user.phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> pwd = user.pwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> role = user.role;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> state = user.state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = user.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = user.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> pwd = column("pwd", JDBCType.VARCHAR);

        public final SqlColumn<Integer> role = column("`role`", JDBCType.INTEGER);

        public final SqlColumn<Integer> state = column("`state`", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}