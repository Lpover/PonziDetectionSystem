package cn.qkl.webserver.vo.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvidenceCertParamsVO{
    private Long id;
    private String name;
    private String personnel;
    private String url;
    private String platformName;
    private Long evidenceType;
    private Date timestamp;
    private String hash;
    private String packageHash;
    private String chainName;
}
