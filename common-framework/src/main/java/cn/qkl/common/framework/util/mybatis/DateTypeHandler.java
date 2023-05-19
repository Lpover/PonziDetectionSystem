package cn.qkl.common.framework.util.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.Date;

@Slf4j
public class DateTypeHandler implements TypeHandler<Date> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
//        ps.setLong(i, parameter.getTime());
        ps.setTimestamp(i, new Timestamp(parameter.getTime()));
    }

    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
//        return new Date(rs.getLong(columnName));
        return rs.getTimestamp(columnName) == null ? null : new Date(rs.getTimestamp(columnName).getTime());
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
//        return new Date(rs.getLong(columnIndex));
        return rs.getTimestamp(columnIndex) == null ? null : new Date(rs.getTimestamp(columnIndex).getTime());
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
//        return new Date(cs.getLong(columnIndex));
        return cs.getTimestamp(columnIndex) == null ? null : new Date(cs.getTimestamp(columnIndex).getTime());
    }
}
