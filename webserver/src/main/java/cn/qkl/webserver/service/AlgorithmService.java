package cn.qkl.webserver.service;

import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.webserver.dao.AlgorithmDao;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isIn;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class AlgorithmService {

    @Autowired
    private AlgorithmDao algorithmDao;

    /**
     * 获取算法配置列表
     * @param dto
     * @return
     */
    public List<AlgorithmVO> getAlgorithmList(AlgorithmListQueryDTO dto) {
        List<Algorithm> algorithmList = algorithmDao.select(c -> c
                .where(Tables.algorithm.type, isIn(dto.getType())));
        return algorithmList.stream().map(AlgorithmVO::transform).collect(Collectors.toList());
    }


}
