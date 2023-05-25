package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentMapper;
import cn.qkl.webserver.vo.contentDetection.ContentDetectionInfoVO;
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
public interface ContentDetectionDao extends ContentMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ContentDetectionInfoVO> getContentDetectionList(SelectStatementProvider selectStatementProvider);

}
