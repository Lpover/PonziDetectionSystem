package cn.qkl.webserver.vo.miniapp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author sunxiaen
 * @Date 2024/1/2 14:11
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvidenceVO {
    @ApiModelProperty("证据主键id")
    private String id;
    @ApiModelProperty("视频证据文件的名称")
    private String name;
    @ApiModelProperty("视频证据文件的创建时间")
    private Date time;
    @ApiModelProperty("视频证据文件的取证人")
    private String userName;
    @ApiModelProperty("oss上的视频URL")
    private String url;
    @ApiModelProperty("过期时间")
    @JsonIgnore
    private Date expiredTime;
    @ApiModelProperty("字符串，表示距离过期时间 minutes:seconds,如果已经过期了则为字符串-1")
    private String expiredIn;
    @ApiModelProperty("视频的时长，以秒为单位")
    private Long videoTime;
    @ApiModelProperty("视频的大小--字节(bytes)")
    private Long videoSize;

    public void calExpiredIn() {
        Date dateFrom = new Date();
        Date dateTo = this.getExpiredTime();
        // 计算两个日期时间点之间的时间差
        long timeDifferenceMillis = dateTo.getTime() - dateFrom.getTime();
        if (timeDifferenceMillis > 0) {
            // 转换为分钟和秒钟
            long seconds = timeDifferenceMillis / 1000;
            long minutes = seconds / 60;
            seconds %= 60;
            this.setExpiredIn(minutes+":"+seconds);
        } else {
            this.setExpiredIn("-1");
        }
    }
}
