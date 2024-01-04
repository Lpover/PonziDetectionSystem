package cn.qkl.webserver.service;

import cn.hutool.core.date.DateUtil;
import cn.qkl.common.framework.auth.TokenHandler;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.framework.util.OssUtil;
import cn.qkl.common.framework.util.SnowflakeIdUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.MiniappEvidence;
import cn.qkl.webserver.common.enums.MiniappEvidenceEnum;
import cn.qkl.webserver.dao.MiniappEvidenceDao;
import cn.qkl.webserver.dto.miniapp.EvidenceDTO;
import cn.qkl.webserver.dto.miniapp.VideoUploadDTO;
import cn.qkl.webserver.vo.miniapp.EvidenceVO;
import cn.qkl.webserver.vo.miniapp.VideoVO;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 14:09
 **/

@Service
public class MiniappService {

    @Resource
    OssUtil ossUtil;

    @Resource
    MiniappEvidenceDao miniappEvidenceDao;

    public VideoVO videoUpload(VideoUploadDTO dto) throws IOException {
        String ossUrl = ossUtil.uploadMultipartFile(dto.getFile(),dto.getName());
        MiniappEvidence evidence = new MiniappEvidence();
        evidence.setId(SnowflakeIdUtil.generateId());
        evidence.setName(dto.getName());
        evidence.setUrl(ossUrl);
        evidence.setPreserved(MiniappEvidenceEnum.NonPreserved.getCode());
        Date date = new Date();
        evidence.setTime(date);
        evidence.setExpiredTime(DateUtil.offsetMinute(date,120));
        evidence.setUserid(TokenHandler.getUserId());
        miniappEvidenceDao.insert(evidence);
        return FunctionUtil.apply(new VideoVO(), it -> {
            it.setUrl(ossUrl);
        });
    }

    public List<EvidenceVO> getEvidenceList(EvidenceDTO dto) throws IOException {
        if (dto.getPreserved() == MiniappEvidenceEnum.NonPreserved.getCode()) {
            List<EvidenceVO> voList = miniappEvidenceDao.selectEvidenceList(select(Tables.user.name.as("userName"),
                    Tables.miniappEvidence.name,Tables.miniappEvidence.id,
                    Tables.miniappEvidence.time,Tables.miniappEvidence.expiredTime).from(Tables.miniappEvidence)
                    .leftJoin(Tables.user).on(Tables.user.id, equalTo(Tables.miniappEvidence.userid))
                    .where(Tables.miniappEvidence.preserved, isEqualTo(MiniappEvidenceEnum.NonPreserved.getCode()))
                    .orderBy(Tables.miniappEvidence.expiredTime).build().render(RenderingStrategies.MYBATIS3));
            for (EvidenceVO vo : voList) {
                vo.calExpiredIn();
            }
            return voList;
        } else if (dto.getPreserved() == MiniappEvidenceEnum.Preserved.getCode()) {
            return null;
        }
        return null;
    }
}
