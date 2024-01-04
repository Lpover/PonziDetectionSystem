package cn.qkl.webserver.backgroundTask;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.template.TemplateException;
import cn.qkl.common.framework.initAndBackground.BackgroundTask;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.UploadToChainUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.EvidenceWeb;
import cn.qkl.webserver.common.enums.ChainEnum;
import cn.qkl.webserver.dao.EvidenceWebDao;
import cn.qkl.webserver.service.EvidenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/11/3 15:00
 * @wiki
 */
@Slf4j
@Component
public class EvidenceRegularBackgroundTask implements BackgroundTask {

    @Autowired
    private EvidenceWebDao evidenceWebDao;

    @Autowired
    private EvidenceService evidenceService;

    @Autowired
    private OssUtil ossUtil;

    @Autowired
    private UploadToChainUtil uploadToChainUtil;

    /**
     * 间隔1天
     */
    @Override
    public long getPeriod() {
        return 1 * 60 * 1000;
    }   // 每一分钟检查一次

    @Override
    public long getDelay() {
        return 0;
    }

    @Override
    public String getName() {
        return EvidenceRegularBackgroundTask.class.getName();
    }

    @Override
    public void run() {

        Date curTime = new Date();
        List<EvidenceWeb> evidenceWebList = evidenceWebDao.select(c->c
                .where(Tables.evidenceWeb.nextEvidenceTime, isLessThanOrEqualToWhenPresent(curTime))
                .and(Tables.evidenceWeb.frequency, isNotEqualTo(0)));
        for (EvidenceWeb evidenceWeb : evidenceWebList) {
            // 更改nexttime
            Integer freq = evidenceWeb.getFrequency();
            Date nextTime = evidenceWeb.getNextEvidenceTime();
            Date endTime = evidenceWeb.getEndTime();

            // 达到结束时间
            if ((endTime.before(curTime))) {
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.frequency).equalTo(0).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
            }
            if (freq == 1) {
                evidenceWebDao.update(c -> c.set(Tables.evidenceWeb.frequency).equalTo(0).where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId())));
            } else if (freq == 5) {
                nextTime = DateUtil.offsetDay(nextTime, 1);
            } else if (freq == 6) {
                nextTime = DateUtil.offsetDay(nextTime, 7);
            } else if (freq == 7) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(nextTime);
                // 将月份加 1
                calendar.add(Calendar.MONTH, 1);
                // 获取当前日
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                // 设置下个月的当前日
                calendar.set(Calendar.DAY_OF_MONTH, currentDay);
                // 将 Calendar 转换回 Date
                nextTime = calendar.getTime();
            }

            final Date finalNextTime = nextTime;
            evidenceWebDao.update(c -> c
                    .set(Tables.evidenceWeb.nextEvidenceTime).equalTo(finalNextTime)
                    .set(Tables.evidenceWeb.updateTime).equalTo(new Date())
                    .where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId()))
            );

            CountDownLatch latch = new CountDownLatch(2);

            // 网页截图，上链
            evidenceService.webCapture(evidenceWeb.getUrl(), evidenceWeb.getName(), evidenceWeb.getId());
            String webOss = evidenceWebDao.selectOne(c -> c
                    .where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId()))).get().getWebOssPath();
            InputStream webStream = null;
            try {
                webStream = ossUtil.downloadFileByURL(webOss);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 计算hash并上链
            // todo 上链服务
            String digest = null;
            try {
                digest = uploadToChainUtil.calculateHash(webStream, "MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            try {
//                uploadToChainUtil.uploadToChain(digest);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
            String finalDigest = digest;
            evidenceWebDao.update(c -> c
                    .set(Tables.evidenceWeb.packageHash).equalTo(finalDigest)
                    .set(Tables.evidenceWeb.hash).equalTo("hashtesttesttest")       //uploadToChainUtil.getTxHash()
                    .set(Tables.evidenceWeb.chainTime).equalTo(new Date())              //uploadToChainUtil.getTxTime()
                    .set(Tables.evidenceWeb.updateTime).equalTo(new Date())
                    .set(Tables.evidenceWeb.chainId).equalTo(ChainEnum.XINZHENG.getCode())
                    .where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId()))
            );
            latch.countDown();

            // 生成证书并上传oss
            try {
                String ossPath = evidenceService.generateEvidenceCert(evidenceWeb.getId());
                evidenceWebDao.update(c ->
                        c.set(Tables.evidenceWeb.certOssPath).equalTo(ossPath)
                                .set(Tables.evidenceWeb.updateTime).equalTo(new Date())
                                .set(Tables.evidenceWeb.evidencePhase).equalTo(2)
                                .where(Tables.evidenceWeb.id, isEqualTo(evidenceWeb.getId()))
                );
            } catch (TemplateException | ParserConfigurationException | IOException |
                     FontFormatException | freemarker.template.TemplateException | org.xml.sax.SAXException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }

            // 等待计数值变为零
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 生成证据包并上传oss
            try {
                evidenceService.generateEvidencePack(evidenceWeb.getId());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
