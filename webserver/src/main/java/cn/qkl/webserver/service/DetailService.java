package cn.qkl.webserver.service;

import cn.qkl.common.repository.Tables;
import cn.qkl.webserver.dao.ContentDao;
import cn.qkl.webserver.dto.detail.ContentInfoDTO;
import cn.qkl.webserver.vo.detail.ContentInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author zouzh
 * @Date: 2023/5/22 10:38
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class DetailService {
    @Autowired
    private ContentDao contentDao;

    public ContentInfoVO getContentInfo(ContentInfoDTO dto) {
        return contentDao.getContentDetail(
                select(Tables.content.name, Tables.content.address, Tables.content.tokenid,
                        Tables.content.cryptoPrice, Tables.content.currencyPrice, Tables.content.creator, Tables.platform.named,
                        Tables.content.standard, Tables.chain.chainName, Tables.content.listingTime, Tables.content.description,Tables.content.metaUrl)
                .from(Tables.content)
                .leftJoin(Tables.platform).on(Tables.content.platformId, equalTo(Tables.platform.id))
                .leftJoin(Tables.chain).on(Tables.content.chainId, equalTo(Tables.chain.id))
                .where(Tables.content.id, isEqualTo(dto.getContentID()))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }

}
