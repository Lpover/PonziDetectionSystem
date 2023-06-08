package cn.qkl.webserver.dao;

import cn.qkl.webserver.vo.cockpit.integrated.ChoiceVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CockpitMultipleChoiceDao {
    @Select("select id,name from platform where monitor = #{monitor} order by content_num desc limit 5")
    @Results(id = "platformsChoiceResult",value={
            @Result(column = "id", property = "choiceId", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column = "name", property = "text", jdbcType = JdbcType.VARCHAR)
    })
    List<ChoiceVO> findPlatforms(Integer monitor);

    @Select("select id,name from social_platform order by social_platform_index_24h desc limit 5")
    @Results(id = "socialPlatformsChoiceResult",value={
            @Result(column = "id", property = "choiceId", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column = "name", property = "text", jdbcType = JdbcType.VARCHAR)
    })
    List<ChoiceVO> findSocialPlatforms();
}
