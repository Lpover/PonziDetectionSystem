package cn.qkl.webserver.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.Algorithm;
import cn.qkl.webserver.common.enums.AlgorithmStateEnum;
import cn.qkl.webserver.dao.AlgorithmDao;
import cn.qkl.webserver.dto.algorithm.AlgorithmAddDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmListQueryDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmModifyDTO;
import cn.qkl.webserver.dto.algorithm.AlgorithmStateModifyDTO;
import cn.qkl.webserver.vo.algorithm.AlgorithmVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isInWhenPresent;


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
     *
     * @param dto
     * @return
     */
    public List<AlgorithmVO> getAlgorithmList(AlgorithmListQueryDTO dto) {
        List<Algorithm> algorithmList = algorithmDao.select(c -> c
                .where(Tables.algorithm.type, isInWhenPresent(dto.getType())));
        return algorithmList.stream().map(AlgorithmVO::transform).collect(Collectors.toList());
    }

    @Transactional
    public void modifyAlgorithmState(AlgorithmStateModifyDTO dto) {
        //将使用中改为停用
        algorithmDao.update(c -> c
                .set(Tables.algorithm.state).equalTo(AlgorithmStateEnum.NO_USING.getCode())
                .where(Tables.algorithm.type, isEqualTo(dto.getType()))
                .and(Tables.algorithm.state, isEqualTo(AlgorithmStateEnum.USING.getCode()))
        );
        //修改为新使用
        algorithmDao.update(c -> c
                .set(Tables.algorithm.state).equalTo(AlgorithmStateEnum.USING.getCode())
                .where(Tables.algorithm.id, isEqualTo(dto.getId()))
        );
    }

    public void addAlgorithm(AlgorithmAddDTO dto) {
        Algorithm algorithm = new Algorithm();
        BeanUtil.copyProperties(dto, algorithm);
        algorithm.setId(IdUtil.getSnowflakeNextId());
        algorithm.setRecognitionRate(new BigDecimal(97.00));
        algorithm.setCreateTime(new Date());
        algorithm.setUpdateTime(new Date());
        //如果设置为启用
        if (dto.getType() == AlgorithmStateEnum.USING.getCode()) {
            algorithm.setState(AlgorithmStateEnum.USING.getCode());
            //将使用中改为停用
            algorithmDao.update(c -> c
                    .set(Tables.algorithm.state).equalTo(AlgorithmStateEnum.NO_USING.getCode())
                    .where(Tables.algorithm.type, isEqualTo(dto.getType()))
                    .and(Tables.algorithm.state, isEqualTo(AlgorithmStateEnum.USING.getCode()))
            );
        } else {
            algorithm.setState(AlgorithmStateEnum.NO_USING.getCode());
        }
        algorithmDao.insert(algorithm);
    }


    public void modifyAlgorithm(AlgorithmModifyDTO dto) {
        algorithmDao.update(c -> c
                .set(Tables.algorithm.name).equalToWhenPresent(dto.getName())
                .set(Tables.algorithm.describe).equalToWhenPresent(dto.getDescribe())
                .set(Tables.algorithm.fileUrl).equalToWhenPresent(dto.getFileUrl())
                .where(Tables.algorithm.id, isEqualTo(dto.getId()))
        );
    }

}
