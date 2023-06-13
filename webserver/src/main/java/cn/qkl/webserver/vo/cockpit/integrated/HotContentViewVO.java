package cn.qkl.webserver.vo.cockpit.integrated;


import static cn.qkl.common.framework.util.FunctionUtil.*;

import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.model.Content;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author sunxiaen
 * @Date 2023/6/6 11:20
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotContentViewVO extends ViewVO {

    @ApiModelProperty("视图内容")
    private List<ContentInfo> viewData;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ContentInfo {
        @ApiModelProperty("内容名称")
        private String name;

        @ApiModelProperty("内容图片")
        private String imageUrl;

        @ApiModelProperty("内容采取加密货币计价的价格（带单位）")
        private String cryptoPrice;

        @ApiModelProperty("内容热度")
        private Integer hotNum;
    }

//    public static HotContentViewVO transformFromContent(List<ContentInfo> contentInfoList) {
//        return apply(new HotContentViewVO(),it -> {
//
//
//        });

//        contentInfoList.stream().map((input)->{
//            return apply(new ContentInfo(),contentInfo -> {
//                        contentInfo.setName(input.getName());
//                        contentInfo.setCryptoPrice(input.getCryptoPrice());
//                        contentInfo.setHotNum(input.getHotNum());
//                    }
//            );
//        }).collect(Collectors.toList());
//    }
}