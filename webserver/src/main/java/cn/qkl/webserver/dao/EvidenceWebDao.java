package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.EvidenceWebMapper;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.vo.evidence.EvidenceCertParamsVO;
import cn.qkl.webserver.vo.evidence.EvidenceRecordItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface EvidenceWebDao extends EvidenceWebMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    EvidenceCertParamsVO getEvidenceCertParams(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    String getEvidenceCert(SelectStatementProvider selectStatementProvider);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int markDeleteEvidence(UpdateStatementProvider updateStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<EvidenceRecordItemVO> getRecordList(SelectStatementProvider selectStatementProvider);
}
