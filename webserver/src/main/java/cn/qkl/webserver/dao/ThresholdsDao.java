package cn.qkl.webserver.dao;

import cn.qkl.common.repository.mapper.ThresholdsMapper;
import cn.qkl.webserver.vo.notification.CurrentStatusVO;
import cn.qkl.webserver.vo.notification.TextPreviewVO;
import cn.qkl.webserver.vo.platformview.PlatformRiskContentVO;
import cn.qkl.webserver.vo.threshold.IndexReportVO;
import cn.qkl.webserver.vo.platformview.PlatformRiskContentVO;
import cn.qkl.webserver.vo.threshold.IndexReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 17:37
 **/
@Mapper
public interface ThresholdsDao extends ThresholdsMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<IndexReportVO> getIndexReport(SelectStatementProvider selectStatementProvider);
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<IndexReportVO> getIndexReport(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<TextPreviewVO> getTextPreview(SelectStatementProvider selectStatementProvider);

}
