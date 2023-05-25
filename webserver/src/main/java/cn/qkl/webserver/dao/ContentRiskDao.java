package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentRiskMapper;
import cn.qkl.webserver.vo.contentRisk.ContentRiskInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @title:
 * @Author Wang Xin
 * @Date: 2022/7/23 17:37
 * @wiki
 */
@Mapper
public interface ContentRiskDao extends ContentRiskMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ContentRiskInfoVO> getContentRiskInfo(SelectStatementProvider selectStatementProvider);

}
