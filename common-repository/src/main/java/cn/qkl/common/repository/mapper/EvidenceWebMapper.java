package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.EvidenceWebDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.EvidenceWeb;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface EvidenceWebMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, riskType, introduction, personnel, url, platformId, frequency, startTime, endTime, institution, department, webOssPath, certOssPath, packOssPath, evidencePhase, evidenceType, hash, createTime, updateTime, deleteStatus, packageHash, chainId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<EvidenceWeb> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<EvidenceWeb> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EvidenceWebResult")
    Optional<EvidenceWeb> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EvidenceWebResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_type", property="riskType", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="personnel", property="personnel", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="platform_id", property="platformId", jdbcType=JdbcType.BIGINT),
        @Result(column="frequency", property="frequency", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="institution", property="institution", jdbcType=JdbcType.VARCHAR),
        @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_oss_path", property="webOssPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="cert_oss_path", property="certOssPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="pack_oss_path", property="packOssPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="evidence_phase", property="evidencePhase", jdbcType=JdbcType.INTEGER),
        @Result(column="evidence_type", property="evidenceType", jdbcType=JdbcType.INTEGER),
        @Result(column="hash", property="hash", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_status", property="deleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="package_hash", property="packageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="chain_id", property="chainId", jdbcType=JdbcType.BIGINT)
    })
    List<EvidenceWeb> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(EvidenceWeb record) {
        return MyBatis3Utils.insert(this::insert, record, evidenceWeb, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(riskType).toProperty("riskType")
            .map(introduction).toProperty("introduction")
            .map(personnel).toProperty("personnel")
            .map(url).toProperty("url")
            .map(platformId).toProperty("platformId")
            .map(frequency).toProperty("frequency")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(institution).toProperty("institution")
            .map(department).toProperty("department")
            .map(webOssPath).toProperty("webOssPath")
            .map(certOssPath).toProperty("certOssPath")
            .map(packOssPath).toProperty("packOssPath")
            .map(evidencePhase).toProperty("evidencePhase")
            .map(evidenceType).toProperty("evidenceType")
            .map(hash).toProperty("hash")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(deleteStatus).toProperty("deleteStatus")
            .map(packageHash).toProperty("packageHash")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<EvidenceWeb> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, evidenceWeb, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(riskType).toProperty("riskType")
            .map(introduction).toProperty("introduction")
            .map(personnel).toProperty("personnel")
            .map(url).toProperty("url")
            .map(platformId).toProperty("platformId")
            .map(frequency).toProperty("frequency")
            .map(startTime).toProperty("startTime")
            .map(endTime).toProperty("endTime")
            .map(institution).toProperty("institution")
            .map(department).toProperty("department")
            .map(webOssPath).toProperty("webOssPath")
            .map(certOssPath).toProperty("certOssPath")
            .map(packOssPath).toProperty("packOssPath")
            .map(evidencePhase).toProperty("evidencePhase")
            .map(evidenceType).toProperty("evidenceType")
            .map(hash).toProperty("hash")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(deleteStatus).toProperty("deleteStatus")
            .map(packageHash).toProperty("packageHash")
            .map(chainId).toProperty("chainId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(EvidenceWeb record) {
        return MyBatis3Utils.insert(this::insert, record, evidenceWeb, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(riskType).toPropertyWhenPresent("riskType", record::getRiskType)
            .map(introduction).toPropertyWhenPresent("introduction", record::getIntroduction)
            .map(personnel).toPropertyWhenPresent("personnel", record::getPersonnel)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(platformId).toPropertyWhenPresent("platformId", record::getPlatformId)
            .map(frequency).toPropertyWhenPresent("frequency", record::getFrequency)
            .map(startTime).toPropertyWhenPresent("startTime", record::getStartTime)
            .map(endTime).toPropertyWhenPresent("endTime", record::getEndTime)
            .map(institution).toPropertyWhenPresent("institution", record::getInstitution)
            .map(department).toPropertyWhenPresent("department", record::getDepartment)
            .map(webOssPath).toPropertyWhenPresent("webOssPath", record::getWebOssPath)
            .map(certOssPath).toPropertyWhenPresent("certOssPath", record::getCertOssPath)
            .map(packOssPath).toPropertyWhenPresent("packOssPath", record::getPackOssPath)
            .map(evidencePhase).toPropertyWhenPresent("evidencePhase", record::getEvidencePhase)
            .map(evidenceType).toPropertyWhenPresent("evidenceType", record::getEvidenceType)
            .map(hash).toPropertyWhenPresent("hash", record::getHash)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(deleteStatus).toPropertyWhenPresent("deleteStatus", record::getDeleteStatus)
            .map(packageHash).toPropertyWhenPresent("packageHash", record::getPackageHash)
            .map(chainId).toPropertyWhenPresent("chainId", record::getChainId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<EvidenceWeb> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<EvidenceWeb> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<EvidenceWeb> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<EvidenceWeb> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, evidenceWeb, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(EvidenceWeb record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(riskType).equalTo(record::getRiskType)
                .set(introduction).equalTo(record::getIntroduction)
                .set(personnel).equalTo(record::getPersonnel)
                .set(url).equalTo(record::getUrl)
                .set(platformId).equalTo(record::getPlatformId)
                .set(frequency).equalTo(record::getFrequency)
                .set(startTime).equalTo(record::getStartTime)
                .set(endTime).equalTo(record::getEndTime)
                .set(institution).equalTo(record::getInstitution)
                .set(department).equalTo(record::getDepartment)
                .set(webOssPath).equalTo(record::getWebOssPath)
                .set(certOssPath).equalTo(record::getCertOssPath)
                .set(packOssPath).equalTo(record::getPackOssPath)
                .set(evidencePhase).equalTo(record::getEvidencePhase)
                .set(evidenceType).equalTo(record::getEvidenceType)
                .set(hash).equalTo(record::getHash)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(deleteStatus).equalTo(record::getDeleteStatus)
                .set(packageHash).equalTo(record::getPackageHash)
                .set(chainId).equalTo(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(EvidenceWeb record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(riskType).equalToWhenPresent(record::getRiskType)
                .set(introduction).equalToWhenPresent(record::getIntroduction)
                .set(personnel).equalToWhenPresent(record::getPersonnel)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(platformId).equalToWhenPresent(record::getPlatformId)
                .set(frequency).equalToWhenPresent(record::getFrequency)
                .set(startTime).equalToWhenPresent(record::getStartTime)
                .set(endTime).equalToWhenPresent(record::getEndTime)
                .set(institution).equalToWhenPresent(record::getInstitution)
                .set(department).equalToWhenPresent(record::getDepartment)
                .set(webOssPath).equalToWhenPresent(record::getWebOssPath)
                .set(certOssPath).equalToWhenPresent(record::getCertOssPath)
                .set(packOssPath).equalToWhenPresent(record::getPackOssPath)
                .set(evidencePhase).equalToWhenPresent(record::getEvidencePhase)
                .set(evidenceType).equalToWhenPresent(record::getEvidenceType)
                .set(hash).equalToWhenPresent(record::getHash)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(deleteStatus).equalToWhenPresent(record::getDeleteStatus)
                .set(packageHash).equalToWhenPresent(record::getPackageHash)
                .set(chainId).equalToWhenPresent(record::getChainId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(EvidenceWeb record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(riskType).equalTo(record::getRiskType)
            .set(introduction).equalTo(record::getIntroduction)
            .set(personnel).equalTo(record::getPersonnel)
            .set(url).equalTo(record::getUrl)
            .set(platformId).equalTo(record::getPlatformId)
            .set(frequency).equalTo(record::getFrequency)
            .set(startTime).equalTo(record::getStartTime)
            .set(endTime).equalTo(record::getEndTime)
            .set(institution).equalTo(record::getInstitution)
            .set(department).equalTo(record::getDepartment)
            .set(webOssPath).equalTo(record::getWebOssPath)
            .set(certOssPath).equalTo(record::getCertOssPath)
            .set(packOssPath).equalTo(record::getPackOssPath)
            .set(evidencePhase).equalTo(record::getEvidencePhase)
            .set(evidenceType).equalTo(record::getEvidenceType)
            .set(hash).equalTo(record::getHash)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(deleteStatus).equalTo(record::getDeleteStatus)
            .set(packageHash).equalTo(record::getPackageHash)
            .set(chainId).equalTo(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(EvidenceWeb record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(riskType).equalToWhenPresent(record::getRiskType)
            .set(introduction).equalToWhenPresent(record::getIntroduction)
            .set(personnel).equalToWhenPresent(record::getPersonnel)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(platformId).equalToWhenPresent(record::getPlatformId)
            .set(frequency).equalToWhenPresent(record::getFrequency)
            .set(startTime).equalToWhenPresent(record::getStartTime)
            .set(endTime).equalToWhenPresent(record::getEndTime)
            .set(institution).equalToWhenPresent(record::getInstitution)
            .set(department).equalToWhenPresent(record::getDepartment)
            .set(webOssPath).equalToWhenPresent(record::getWebOssPath)
            .set(certOssPath).equalToWhenPresent(record::getCertOssPath)
            .set(packOssPath).equalToWhenPresent(record::getPackOssPath)
            .set(evidencePhase).equalToWhenPresent(record::getEvidencePhase)
            .set(evidenceType).equalToWhenPresent(record::getEvidenceType)
            .set(hash).equalToWhenPresent(record::getHash)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(deleteStatus).equalToWhenPresent(record::getDeleteStatus)
            .set(packageHash).equalToWhenPresent(record::getPackageHash)
            .set(chainId).equalToWhenPresent(record::getChainId)
            .where(id, isEqualTo(record::getId))
        );
    }
}