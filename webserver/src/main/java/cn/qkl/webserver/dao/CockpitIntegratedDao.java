package cn.qkl.webserver.dao;

import cn.qkl.common.repository.model.Platform;
import cn.qkl.common.repository.model.SocialPlatform;
import cn.qkl.common.repository.model.SocialPlatformHourStatistics;
import cn.qkl.common.repository.model.VocabCloud;
import cn.qkl.webserver.vo.cockpit.integrated.HotContentViewVO;
import cn.qkl.webserver.vo.cockpit.integrated.HotEventViewVO;
import cn.qkl.webserver.vo.cockpit.integrated.LegendNumberVO;
import cn.qkl.webserver.vo.cockpit.integrated.TextAnalysisViewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface CockpitIntegratedDao {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    SocialPlatform getSocialIndex(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<Platform> getPlatformIndex(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<VocabCloud> getVocabCloud(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<HotContentViewVO.ContentInfo> getHotContentView(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<HotEventViewVO.EventInfo> getHotEventView(SelectStatementProvider selectStatementProvider);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<SocialPlatformHourStatistics> getTextEmotionAndSensitive(SelectStatementProvider selectStatementProvider);

}
