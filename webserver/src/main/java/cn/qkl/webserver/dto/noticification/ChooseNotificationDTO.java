package cn.qkl.webserver.dto.noticification;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 17:23
 **/

@Data
public class ChooseNotificationDTO {
    @ApiModelProperty("通知项保持开启的列表")
    @NotNull
    List<Long> choiceOpenList;

    @ApiModelProperty("通知项保持关闭的列表")
    @NotNull
    List<Long> choiceCloseList;
}
