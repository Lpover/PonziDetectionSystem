package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.ConcernDao;
import cn.qkl.webserver.dto.concern.AddConcernDTO;
import cn.qkl.webserver.dto.concern.ConcernListDTO;
import cn.qkl.webserver.vo.concern.AddConcernVO;
import cn.qkl.webserver.vo.concern.ConcernListVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLessThanOrEqualToWhenPresent;

@Service
public class ConcernService {
    @Autowired
    private ConcernDao concernDao;

    public PageVO<ConcernListVO> getConcernList(ConcernListDTO dto){
        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),
                ()->concernDao.getConcernList(
                        select(Tables.concern.id,Tables.concern.createTime,Tables.concern.url,
                                Tables.concern.title
                        )
                                .from(Tables.concern)
//                                .where(Tables.concern.userId,isEqualTo(dto.getUserId()))
                                .orderBy(Tables.concern.createTime.descending())
                                .build()
                                .render(RenderingStrategies.MYBATIS3)
                )
        );

    }

    public void addConcern(AddConcernDTO dto) {
        // 调用 ConcernDao 中的方法将数据插入数据库
        concernDao.insertConcern(dto);
    }

}
