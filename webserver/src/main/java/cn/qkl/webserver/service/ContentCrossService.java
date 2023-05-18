package cn.qkl.webserver.service;

import cn.qkl.webserver.dao.ContentCrossDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class ContentCrossService {

    @Autowired
    private ContentCrossDao contentCrossDao;

//    public PageVO<CrossContentVO> getCrossContentList(CrossContentListQueryDTO dto) {
//        return PageVO.getPageData(dto.getPageId(),dto.getPageSize(),()->contentCrossDao.getCrossContentList(
//                select(Tables.contentCross.id,Tables.contentCross.name,Tables.contentCross.metaurl,Tables.chain.chainName,Tables.contentCross.address,Tables.contentCross.hash,Tables.contentCross.tokenId,)
//        ));
//    }
//
//    /**
//     * 获取算法配置列表
//     * @param dto
//     * @return
//     */
//    public List<AlgorithmVO> getAlgorithmList(AlgorithmListQueryDTO dto) {
//        List<Algorithm> algorithmList = algorithmDao.select(c -> c
//                .where(Tables.algorithm.type, isIn(dto.getType())));
//        return algorithmList.stream().map(AlgorithmVO::transform).collect(Collectors.toList());
//    }


}
