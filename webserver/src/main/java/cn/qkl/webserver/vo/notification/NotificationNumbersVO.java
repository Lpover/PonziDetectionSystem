package cn.qkl.webserver.vo.notification;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 16:30
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationNumbersVO {
        @ApiModelProperty("数据")
        List<Integer> data;
        @ApiModelProperty("通知项名字")
        List<String> names;
}
