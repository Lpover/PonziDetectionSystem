package cn.qkl.webserver.vo.dynamic;

import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DynamicContentVO {
    @ApiModelProperty("数字内容主键id")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("合约地址")
    private String address;
    @ApiModelProperty("缩略图")
    private String metaUrl;
    @ApiModelProperty("识别算法版本")
    private Integer dynamicAlgorithm;
    @ApiModelProperty("是否正在动态风险识别中：0不是 1是 2网络错误 3模型错误")
    private Integer dynamicRecognition;
    @ApiModelProperty("人工标识是不是动态内容 -1待定 0静态 1读动态  2 写动态")
    private Integer dynamicTypeArtificial;
    @ApiModelProperty("机器标识是不是动态内容 0静态 1动态 2动态")
    private Integer dynamicType;
    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容标签")
    private String contentTag;
    @ApiModelProperty("更新时间")
    private Date updateTime;

    public static DynamicContentVO transform(DynamicContentVO vo) {
        String[] split = vo.getContentTag().split(",");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(ContentRiskCategoryEnum.valueOf(Integer.parseInt(s)).getDescription());
            builder.append(",");
        }
        //删除最后一个逗号
        builder.delete(builder.length() - 1, builder.length());
        vo.setContentTag(builder.toString());
        return vo;
    }
}
