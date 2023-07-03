package cn.qkl.webserver.vo.notification;

import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.model.Thresholds;
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
public class NotificationItemVO {
        @ApiModelProperty("数据")
        Long id;
        @ApiModelProperty("通知项名字")
        String name;
        @ApiModelProperty("目前状态 1开 0关")
        Byte on;

        public static NotificationItemVO transformFromThreshold(Thresholds threshold) {
                return FunctionUtil.apply(new NotificationItemVO(), it -> {
                   it.setId(threshold.getId());
                   it.setName(threshold.getName());
                   it.setOn(threshold.getOn());
                });
        }
}
