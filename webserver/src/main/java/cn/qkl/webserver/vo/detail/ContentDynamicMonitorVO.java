package cn.qkl.webserver.vo.detail;

import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ContentDynamicMonitorVO {
    @ApiModelProperty("单条记录的id")
    private Long id;
    @ApiModelProperty("数字内容风险评级：0低 1中 2高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容标签，逗号隔开每个标签")
    private String contentTag;
    @ApiModelProperty("内容标签列表")
    private List<String> contentTagList;
    @ApiModelProperty("监测到的变更时间")
    private String createTime;
    @ApiModelProperty("监测的角色，0-模型，1-人工")
    private Integer character;

//    public static ContentDynamicMonitorVO transform(ContentDynamicMonitorVO vo) {
//        String[] split = vo.getContentTag().split(",");
//        ArrayList<String> list = new ArrayList<>();
//        for (String s : split) {
//            list.add(ContentRiskCategoryEnum.valueOf(Integer.parseInt(s)).getDescription());
//        }
//        vo.setContentTagList(list);
//        return vo;
//    }
    public static ContentDynamicMonitorVO transform(ContentDynamicMonitorVO vo) {
        String[] split = vo.getContentTag().split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            int enumValue = Integer.parseInt(s);
            String description;
            switch (enumValue) {
                case 0:
                    description = "静态";
                    break;
                case 1:
                    description = "动态";
                    break;
                case 2:
                    description = "跨链";
                    break;
                default:
                    description = "Unknown"; // Handle unknown values if needed
                    break;
            }
            list.add(description);
        }
        vo.setContentTagList(list);
        return vo;
    }
}
