package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ContentMapper;
import cn.qkl.webserver.vo.detail.ContentDynamicMonitorVO;
import cn.qkl.webserver.vo.detail.ContentHistoryVO;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import cn.qkl.webserver.vo.detail.ContentRiskReviseVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentExportVO;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
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
public interface ContentDao extends ContentMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<DynamicContentVO> getDynamicContentList(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    String getAddress(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<DynamicContentExportVO> dynamicContentListExport(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    ContentInfoVO getContentDetail(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ContentHistoryVO> getContentTxHistoryList(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    ContentRiskReviseVO getCotentRiskRevise(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<ContentDynamicMonitorVO> getDynamicMonitor(SelectStatementProvider selectStatementProvider);
}
