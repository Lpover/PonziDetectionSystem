package cn.qkl.webserver.vo.detail;

import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ContentRiskReviseVO {
    @ApiModelProperty("风险评级：0低风险 1中风险 2高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容类型：0图片 1视频 2音频")
    private Integer contentType;
    @ApiModelProperty("内容标签，用逗号隔开每个标签")
    private String contentTag;
    @ApiModelProperty("内容标签列表")
    private List<String> contentTagList;
    @ApiModelProperty("自动识别模型算法")
    private String algorithmName;
    @ApiModelProperty("算法准确率")
    private BigDecimal recognitionRate;
    @ApiModelProperty("识别结果：0静态 1读动态 2写动态")
    private String dynamicType;
    @ApiModelProperty("跨链算法模型")
    private String crossModelName;
    @ApiModelProperty("是否跨链 0否 1是")
    private Integer crossRes;
    @ApiModelProperty("人工识别结果 -1待定 0静态 1读动态 2写动态 ")
    private Integer reviseRes;
    @ApiModelProperty("人工识别结果的时间戳")
    private Date reviseDate;

    public static ContentRiskReviseVO transform(ContentRiskReviseVO vo) {
        String[] split = vo.getContentTag().split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(ContentRiskCategoryEnum.valueOf(Integer.parseInt(s)).getDescription());
        }
        vo.setContentTagList(list);
        return vo;
    }
}
