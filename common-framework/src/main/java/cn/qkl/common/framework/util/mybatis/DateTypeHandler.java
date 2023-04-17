package cn.qkl.common.framework.util.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Slf4j
public class DateTypeHandler implements TypeHandler<Date> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getTime());
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        return new Date(rs.getLong(columnName));
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        return new Date(rs.getLong(columnIndex));
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new Date(cs.getLong(columnIndex));
    }
}
