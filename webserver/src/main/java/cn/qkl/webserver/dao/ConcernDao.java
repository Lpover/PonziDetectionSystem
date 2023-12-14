package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ChainMapper;
import cn.qkl.common.repository.mapper.ConcernMapper;
import cn.qkl.webserver.dto.concern.AddConcernDTO;
import cn.qkl.webserver.vo.concern.ConcernListVO;
import cn.qkl.webserver.vo.platformview.HotnessRankingViewVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface ConcernDao extends ConcernMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ConcernListVO> getConcernList(SelectStatementProvider selectStatementProvider);

    @Insert("INSERT INTO your_concern_table (title, url, create_time) VALUES (#{title}, #{url}, #{createTime})")
    void insertConcern(AddConcernDTO dto);

}
