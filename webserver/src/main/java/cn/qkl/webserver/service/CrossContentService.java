package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.repository.model.Account;
import cn.qkl.common.repository.model.Chain;
import cn.qkl.common.repository.model.ContentCross;
import cn.qkl.webserver.dao.AccountDao;
import cn.qkl.webserver.dao.ChainDao;
import cn.qkl.webserver.dao.ContentCrossDao;
import cn.qkl.webserver.dto.cross.CrossContentListQueryDTO;
import cn.qkl.webserver.vo.cross.CrossContentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * @title:
 * @Author wang xin
 * @Date: 2022/7/23 21:32
 * @wiki
 */
@Service
@Slf4j
@RefreshScope
public class CrossContentService {

    @Autowired
    private ContentCrossDao contentCrossDao;

    @Autowired
    private ChainDao chainDao;

    @Autowired
    private AccountDao accountDao;

    public void insertContentCross(Integer num) {
        List<ContentCross> contentCrossList = new ArrayList<>();
        Random random = new Random();
        //获取所有链主键id
        List<Long> chainIdlist = chainDao.select(c -> c).stream().map(Chain::getId).collect(Collectors.toList());
        List<Long> accountIdlist = accountDao.select(c -> c).stream().map(Account::getId).collect(Collectors.toList());
        //当前服务器时间
        Date end = new Date();
        for (int i = 0; i < num; i++) {
            ContentCross contentCross = new ContentCross();
            contentCross.setId(IdUtil.getSnowflakeNextId());
            contentCross.setName("随机名称" + random.nextInt());
            contentCross.setMetaurl("https://pic2.zhimg.com/v2-8c2ee9a783c45bb49b5af6b828ab1191_r.jpg");
            //随机插入一个链主键id，保证为chainlist中的值
            contentCross.setChainId(chainIdlist.get(random.nextInt(chainIdlist.size())));
            contentCross.setAddress("0x" + random.nextInt(1000000000));
            contentCross.setHash("0x" + random.nextInt(1000000000));
            contentCross.setTokenId("" + random.nextInt(10000));
            contentCross.setAccountId(accountIdlist.get(random.nextInt(accountIdlist.size())));
            contentCross.setStartTime(DateUtil.offsetHour(end, -5));
            contentCross.setDstChainId(chainIdlist.get(random.nextInt(chainIdlist.size())));
            contentCross.setDstAddress("0x" + random.nextInt(1000000000));
            contentCross.setDstHash("0x" + random.nextInt(1000000000));
            contentCross.setDstTokenId("" + random.nextInt(10000));
            contentCross.setDstAccountId(accountIdlist.get(random.nextInt(accountIdlist.size())));
            contentCross.setEndTime(DateUtil.offsetHour(end, -2));
            contentCross.setBridge(random.nextInt(2) + 1);
            contentCross.setDynamicType(random.nextInt(2));
            contentCross.setRiskLevel(random.nextInt(4));
//            contentCross.setCreateTime(end);
            contentCross.setCreateTime(DateUtil.offsetDay(end, -1));
            contentCross.setUpdateTime(end);
            contentCrossList.add(contentCross);
        }
        contentCrossDao.insertMultiple(contentCrossList);
    }

    public PageVO<CrossContentVO> getCrossContentList(CrossContentListQueryDTO dto) {
//        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentCrossDao.getCrossContentList(select(Tables.contentCross.id, Tables.contentCross.name, Tables.contentCross.metaurl, constant("lc.chain_name"), Tables.contentCross.address, Tables.contentCross.hash, Tables.contentCross.tokenId, constant("la.account_address"), Tables.contentCross.startTime, constant("rc.chain_name as dstChainName"), Tables.contentCross.dstAddress, Tables.contentCross.dstHash, Tables.contentCross.dstTokenId, constant("ra.account_address as dstAccountAddress"), Tables.contentCross.endTime, Tables.contentCross.bridge, Tables.contentCross.dynamicType, Tables.contentCross.riskLevel, Tables.contentCross.createTime)
//                .from(Tables.contentCross)
//                .leftJoin(Tables.account, "la").on(Tables.contentCross.accountId, equalTo(constant("la.id")))
//                .leftJoin(Tables.chain, "lc").on(Tables.contentCross.chainId, equalTo(constant("lc.id")))
//                .leftJoin(new AccountDynamicSqlSupport.Account(), "ra").on(Tables.contentCross.dstAccountId, equalTo(constant("ra.id")))
//                .leftJoin(new ChainDynamicSqlSupport.Chain(), "rc").on(Tables.contentCross.dstChainId, equalTo(constant("rc.id")))
//                .where(Tables.contentCross.riskLevel, isInWhenPresent(dto.getRiskLevelList()))
//                //不包括无风险
//                .and(Tables.contentCross.riskLevel, isNotEqualTo(ContentRiskLevelEnum.NO_RISK.getCode()))
//                .and(Tables.contentCross.chainId, isInWhenPresent(dto.getChainIdList()))
//                .and(Tables.contentCross.dstChainId, isInWhenPresent(dto.getDstChainIdList()))
//                .and(Tables.contentCross.bridge, isInWhenPresent(dto.getBridgeTypeList()))
//                .and(Tables.contentCross.createTime, isGreaterThanOrEqualToWhenPresent(dto.getStartTime()))
//                .and(Tables.contentCross.createTime, isLessThanOrEqualToWhenPresent(dto.getEndTime()))
//                .orderBy(Tables.contentCross.createTime.descending())
//                .build()
//                .render(RenderingStrategies.MYBATIS3)));
        return PageVO.getPageData(dto.getPageId(), dto.getPageSize(), () -> contentCrossDao.getCrossContentList(dto));
    }
}
