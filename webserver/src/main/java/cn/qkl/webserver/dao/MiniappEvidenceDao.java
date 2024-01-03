package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.MiniappEvidenceMapper;
import cn.qkl.webserver.vo.miniapp.EvidenceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface MiniappEvidenceDao extends MiniappEvidenceMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<EvidenceVO> selectEvidenceList(SelectStatementProvider selectProvider);
}
