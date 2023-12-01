package cn.qkl.webserver.vo.detail;

import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import cn.qkl.webserver.vo.dynamic.DynamicContentVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class ContentDynamicMonitorVO {
    @ApiModelProperty("单条记录的id")
    private Long id;
    @ApiModelProperty("数字内容风险评级：0无风险 1低风险 2中风险 3高风险")
    private Integer riskLevel;
    @ApiModelProperty("内容标签，用逗号隔开每个标签，-1待定 0静态 1读动态 2写动态 10 跨链")
    private String contentTag;
    @ApiModelProperty("识别结果列表，用逗号隔开每个标签，-1待定 0静态 1读动态 2写动态 10 跨链")
    private List<String> resultList;
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
        String contentTag = vo.getContentTag();
        if (contentTag == null || contentTag.trim().isEmpty()) {
            // 如果contentTag为空，则将resultList设为空列表
            vo.setResultList(Collections.emptyList());
            return vo;
        }
        String[] split = vo.getContentTag().split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            int enumValue = Integer.parseInt(s);
            String description;
            switch (enumValue) {
                case -1:
                    description = "待定";
                    break;
                case 0:
                    description = "静态";
                    break;
                case 1:
                    description = "读动态";
                    break;
                case 2:
                    description = "写动态";
                    break;
                case 10:
                    description = "跨链";
                default:
                    description = "Unknown"; // Handle unknown values if needed
                    break;
            }
            list.add(description);
        }
        vo.setResultList(list);
        return vo;
    }
}
