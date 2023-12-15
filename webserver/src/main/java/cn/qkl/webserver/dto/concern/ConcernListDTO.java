package cn.qkl.webserver.dto.concern;

import cn.qkl.common.framework.request.PageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ConcernListDTO extends PageDTO {
//    @ApiModelProperty("目前登录账号的ID，对应user表中的id")
//    private Long userId;

}
