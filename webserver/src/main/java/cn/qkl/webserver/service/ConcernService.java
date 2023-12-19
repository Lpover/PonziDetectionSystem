package cn.qkl.webserver.service;

import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Concern;
import cn.qkl.webserver.dao.ConcernDao;
import cn.qkl.webserver.dto.concern.AddConcernDTO;
import cn.qkl.webserver.dto.concern.ConcernListDTO;
import cn.qkl.webserver.vo.concern.AddConcernVO;
import cn.qkl.webserver.vo.concern.ConcernListVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        Concern concern = new Concern();


        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            // 将字符串时间戳转换为Date对象
            Date date = new SimpleDateFormat("yyyyMMdd_HHmmss").parse(timeStamp);
            concern.setCreateTime(date);
            concern.setUpdateTime(date);
        } catch (ParseException e) {
            // 处理解析异常
            e.printStackTrace();
        }

        concern.setTitle(dto.getTitle());
        concern.setUrl(dto.getUrl());
        concern.setId(IdUtil.getSnowflakeNextId());
        // 调用 ConcernDao 中的方法将数据插入数据库
        concernDao.insert(concern);
    }

}
