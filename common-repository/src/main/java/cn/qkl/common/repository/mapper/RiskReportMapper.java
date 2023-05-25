package cn.qkl.common.repository.mapper;

import static cn.qkl.common.repository.mapper.RiskReportDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.qkl.common.repository.model.RiskReport;
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
public interface RiskReportMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, riskContentNum, evolutionNum, highAccountNum, midAccountNum, lowAccountNum, nftName, nftNum, web3Name, web3Num, highContentNum, midContentNum, lowContentNum, dynNum, monitorNum, highRiskPlat, midRiskPlat, lowRiskPlat, highRiskPlatPer, midRiskPlatPer, lowRiskPlatPer, highNamePlat, highNumPlat, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RiskReport> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RiskReport> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RiskReportResult")
    Optional<RiskReport> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RiskReportResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="risk_content_num", property="riskContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="evolution_num", property="evolutionNum", jdbcType=JdbcType.INTEGER),
        @Result(column="high_account_num", property="highAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="mid_account_num", property="midAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="low_account_num", property="lowAccountNum", jdbcType=JdbcType.INTEGER),
        @Result(column="nft_name", property="nftName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nft_num", property="nftNum", jdbcType=JdbcType.INTEGER),
        @Result(column="web3_name", property="web3Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="web3_num", property="web3Num", jdbcType=JdbcType.INTEGER),
        @Result(column="high_content_num", property="highContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="mid_content_num", property="midContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="low_content_num", property="lowContentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="dyn_num", property="dynNum", jdbcType=JdbcType.INTEGER),
        @Result(column="monitor_num", property="monitorNum", jdbcType=JdbcType.INTEGER),
        @Result(column="high_risk_plat", property="highRiskPlat", jdbcType=JdbcType.VARCHAR),
        @Result(column="mid_risk_plat", property="midRiskPlat", jdbcType=JdbcType.VARCHAR),
        @Result(column="low_risk_plat", property="lowRiskPlat", jdbcType=JdbcType.VARCHAR),
        @Result(column="high_risk_plat_per", property="highRiskPlatPer", jdbcType=JdbcType.DECIMAL),
        @Result(column="mid_risk_plat_per", property="midRiskPlatPer", jdbcType=JdbcType.DECIMAL),
        @Result(column="low_risk_plat_per", property="lowRiskPlatPer", jdbcType=JdbcType.DECIMAL),
        @Result(column="high_name_plat", property="highNamePlat", jdbcType=JdbcType.VARCHAR),
        @Result(column="high_num_plat", property="highNumPlat", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RiskReport> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RiskReport record) {
        return MyBatis3Utils.insert(this::insert, record, riskReport, c ->
            c.map(id).toProperty("id")
            .map(riskContentNum).toProperty("riskContentNum")
            .map(evolutionNum).toProperty("evolutionNum")
            .map(highAccountNum).toProperty("highAccountNum")
            .map(midAccountNum).toProperty("midAccountNum")
            .map(lowAccountNum).toProperty("lowAccountNum")
            .map(nftName).toProperty("nftName")
            .map(nftNum).toProperty("nftNum")
            .map(web3Name).toProperty("web3Name")
            .map(web3Num).toProperty("web3Num")
            .map(highContentNum).toProperty("highContentNum")
            .map(midContentNum).toProperty("midContentNum")
            .map(lowContentNum).toProperty("lowContentNum")
            .map(dynNum).toProperty("dynNum")
            .map(monitorNum).toProperty("monitorNum")
            .map(highRiskPlat).toProperty("highRiskPlat")
            .map(midRiskPlat).toProperty("midRiskPlat")
            .map(lowRiskPlat).toProperty("lowRiskPlat")
            .map(highRiskPlatPer).toProperty("highRiskPlatPer")
            .map(midRiskPlatPer).toProperty("midRiskPlatPer")
            .map(lowRiskPlatPer).toProperty("lowRiskPlatPer")
            .map(highNamePlat).toProperty("highNamePlat")
            .map(highNumPlat).toProperty("highNumPlat")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RiskReport> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, riskReport, c ->
            c.map(id).toProperty("id")
            .map(riskContentNum).toProperty("riskContentNum")
            .map(evolutionNum).toProperty("evolutionNum")
            .map(highAccountNum).toProperty("highAccountNum")
            .map(midAccountNum).toProperty("midAccountNum")
            .map(lowAccountNum).toProperty("lowAccountNum")
            .map(nftName).toProperty("nftName")
            .map(nftNum).toProperty("nftNum")
            .map(web3Name).toProperty("web3Name")
            .map(web3Num).toProperty("web3Num")
            .map(highContentNum).toProperty("highContentNum")
            .map(midContentNum).toProperty("midContentNum")
            .map(lowContentNum).toProperty("lowContentNum")
            .map(dynNum).toProperty("dynNum")
            .map(monitorNum).toProperty("monitorNum")
            .map(highRiskPlat).toProperty("highRiskPlat")
            .map(midRiskPlat).toProperty("midRiskPlat")
            .map(lowRiskPlat).toProperty("lowRiskPlat")
            .map(highRiskPlatPer).toProperty("highRiskPlatPer")
            .map(midRiskPlatPer).toProperty("midRiskPlatPer")
            .map(lowRiskPlatPer).toProperty("lowRiskPlatPer")
            .map(highNamePlat).toProperty("highNamePlat")
            .map(highNumPlat).toProperty("highNumPlat")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RiskReport record) {
        return MyBatis3Utils.insert(this::insert, record, riskReport, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(riskContentNum).toPropertyWhenPresent("riskContentNum", record::getRiskContentNum)
            .map(evolutionNum).toPropertyWhenPresent("evolutionNum", record::getEvolutionNum)
            .map(highAccountNum).toPropertyWhenPresent("highAccountNum", record::getHighAccountNum)
            .map(midAccountNum).toPropertyWhenPresent("midAccountNum", record::getMidAccountNum)
            .map(lowAccountNum).toPropertyWhenPresent("lowAccountNum", record::getLowAccountNum)
            .map(nftName).toPropertyWhenPresent("nftName", record::getNftName)
            .map(nftNum).toPropertyWhenPresent("nftNum", record::getNftNum)
            .map(web3Name).toPropertyWhenPresent("web3Name", record::getWeb3Name)
            .map(web3Num).toPropertyWhenPresent("web3Num", record::getWeb3Num)
            .map(highContentNum).toPropertyWhenPresent("highContentNum", record::getHighContentNum)
            .map(midContentNum).toPropertyWhenPresent("midContentNum", record::getMidContentNum)
            .map(lowContentNum).toPropertyWhenPresent("lowContentNum", record::getLowContentNum)
            .map(dynNum).toPropertyWhenPresent("dynNum", record::getDynNum)
            .map(monitorNum).toPropertyWhenPresent("monitorNum", record::getMonitorNum)
            .map(highRiskPlat).toPropertyWhenPresent("highRiskPlat", record::getHighRiskPlat)
            .map(midRiskPlat).toPropertyWhenPresent("midRiskPlat", record::getMidRiskPlat)
            .map(lowRiskPlat).toPropertyWhenPresent("lowRiskPlat", record::getLowRiskPlat)
            .map(highRiskPlatPer).toPropertyWhenPresent("highRiskPlatPer", record::getHighRiskPlatPer)
            .map(midRiskPlatPer).toPropertyWhenPresent("midRiskPlatPer", record::getMidRiskPlatPer)
            .map(lowRiskPlatPer).toPropertyWhenPresent("lowRiskPlatPer", record::getLowRiskPlatPer)
            .map(highNamePlat).toPropertyWhenPresent("highNamePlat", record::getHighNamePlat)
            .map(highNumPlat).toPropertyWhenPresent("highNumPlat", record::getHighNumPlat)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RiskReport> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RiskReport> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RiskReport> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RiskReport> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, riskReport, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RiskReport record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(riskContentNum).equalTo(record::getRiskContentNum)
                .set(evolutionNum).equalTo(record::getEvolutionNum)
                .set(highAccountNum).equalTo(record::getHighAccountNum)
                .set(midAccountNum).equalTo(record::getMidAccountNum)
                .set(lowAccountNum).equalTo(record::getLowAccountNum)
                .set(nftName).equalTo(record::getNftName)
                .set(nftNum).equalTo(record::getNftNum)
                .set(web3Name).equalTo(record::getWeb3Name)
                .set(web3Num).equalTo(record::getWeb3Num)
                .set(highContentNum).equalTo(record::getHighContentNum)
                .set(midContentNum).equalTo(record::getMidContentNum)
                .set(lowContentNum).equalTo(record::getLowContentNum)
                .set(dynNum).equalTo(record::getDynNum)
                .set(monitorNum).equalTo(record::getMonitorNum)
                .set(highRiskPlat).equalTo(record::getHighRiskPlat)
                .set(midRiskPlat).equalTo(record::getMidRiskPlat)
                .set(lowRiskPlat).equalTo(record::getLowRiskPlat)
                .set(highRiskPlatPer).equalTo(record::getHighRiskPlatPer)
                .set(midRiskPlatPer).equalTo(record::getMidRiskPlatPer)
                .set(lowRiskPlatPer).equalTo(record::getLowRiskPlatPer)
                .set(highNamePlat).equalTo(record::getHighNamePlat)
                .set(highNumPlat).equalTo(record::getHighNumPlat)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RiskReport record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(riskContentNum).equalToWhenPresent(record::getRiskContentNum)
                .set(evolutionNum).equalToWhenPresent(record::getEvolutionNum)
                .set(highAccountNum).equalToWhenPresent(record::getHighAccountNum)
                .set(midAccountNum).equalToWhenPresent(record::getMidAccountNum)
                .set(lowAccountNum).equalToWhenPresent(record::getLowAccountNum)
                .set(nftName).equalToWhenPresent(record::getNftName)
                .set(nftNum).equalToWhenPresent(record::getNftNum)
                .set(web3Name).equalToWhenPresent(record::getWeb3Name)
                .set(web3Num).equalToWhenPresent(record::getWeb3Num)
                .set(highContentNum).equalToWhenPresent(record::getHighContentNum)
                .set(midContentNum).equalToWhenPresent(record::getMidContentNum)
                .set(lowContentNum).equalToWhenPresent(record::getLowContentNum)
                .set(dynNum).equalToWhenPresent(record::getDynNum)
                .set(monitorNum).equalToWhenPresent(record::getMonitorNum)
                .set(highRiskPlat).equalToWhenPresent(record::getHighRiskPlat)
                .set(midRiskPlat).equalToWhenPresent(record::getMidRiskPlat)
                .set(lowRiskPlat).equalToWhenPresent(record::getLowRiskPlat)
                .set(highRiskPlatPer).equalToWhenPresent(record::getHighRiskPlatPer)
                .set(midRiskPlatPer).equalToWhenPresent(record::getMidRiskPlatPer)
                .set(lowRiskPlatPer).equalToWhenPresent(record::getLowRiskPlatPer)
                .set(highNamePlat).equalToWhenPresent(record::getHighNamePlat)
                .set(highNumPlat).equalToWhenPresent(record::getHighNumPlat)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RiskReport record) {
        return update(c ->
            c.set(riskContentNum).equalTo(record::getRiskContentNum)
            .set(evolutionNum).equalTo(record::getEvolutionNum)
            .set(highAccountNum).equalTo(record::getHighAccountNum)
            .set(midAccountNum).equalTo(record::getMidAccountNum)
            .set(lowAccountNum).equalTo(record::getLowAccountNum)
            .set(nftName).equalTo(record::getNftName)
            .set(nftNum).equalTo(record::getNftNum)
            .set(web3Name).equalTo(record::getWeb3Name)
            .set(web3Num).equalTo(record::getWeb3Num)
            .set(highContentNum).equalTo(record::getHighContentNum)
            .set(midContentNum).equalTo(record::getMidContentNum)
            .set(lowContentNum).equalTo(record::getLowContentNum)
            .set(dynNum).equalTo(record::getDynNum)
            .set(monitorNum).equalTo(record::getMonitorNum)
            .set(highRiskPlat).equalTo(record::getHighRiskPlat)
            .set(midRiskPlat).equalTo(record::getMidRiskPlat)
            .set(lowRiskPlat).equalTo(record::getLowRiskPlat)
            .set(highRiskPlatPer).equalTo(record::getHighRiskPlatPer)
            .set(midRiskPlatPer).equalTo(record::getMidRiskPlatPer)
            .set(lowRiskPlatPer).equalTo(record::getLowRiskPlatPer)
            .set(highNamePlat).equalTo(record::getHighNamePlat)
            .set(highNumPlat).equalTo(record::getHighNumPlat)
            .set(createTime).equalTo(record::getCreateTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RiskReport record) {
        return update(c ->
            c.set(riskContentNum).equalToWhenPresent(record::getRiskContentNum)
            .set(evolutionNum).equalToWhenPresent(record::getEvolutionNum)
            .set(highAccountNum).equalToWhenPresent(record::getHighAccountNum)
            .set(midAccountNum).equalToWhenPresent(record::getMidAccountNum)
            .set(lowAccountNum).equalToWhenPresent(record::getLowAccountNum)
            .set(nftName).equalToWhenPresent(record::getNftName)
            .set(nftNum).equalToWhenPresent(record::getNftNum)
            .set(web3Name).equalToWhenPresent(record::getWeb3Name)
            .set(web3Num).equalToWhenPresent(record::getWeb3Num)
            .set(highContentNum).equalToWhenPresent(record::getHighContentNum)
            .set(midContentNum).equalToWhenPresent(record::getMidContentNum)
            .set(lowContentNum).equalToWhenPresent(record::getLowContentNum)
            .set(dynNum).equalToWhenPresent(record::getDynNum)
            .set(monitorNum).equalToWhenPresent(record::getMonitorNum)
            .set(highRiskPlat).equalToWhenPresent(record::getHighRiskPlat)
            .set(midRiskPlat).equalToWhenPresent(record::getMidRiskPlat)
            .set(lowRiskPlat).equalToWhenPresent(record::getLowRiskPlat)
            .set(highRiskPlatPer).equalToWhenPresent(record::getHighRiskPlatPer)
            .set(midRiskPlatPer).equalToWhenPresent(record::getMidRiskPlatPer)
            .set(lowRiskPlatPer).equalToWhenPresent(record::getLowRiskPlatPer)
            .set(highNamePlat).equalToWhenPresent(record::getHighNamePlat)
            .set(highNumPlat).equalToWhenPresent(record::getHighNumPlat)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}