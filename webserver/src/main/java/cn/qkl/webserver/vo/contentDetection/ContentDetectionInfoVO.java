package cn.qkl.webserver.vo.contentDetection;

import cn.hutool.core.bean.BeanUtil;
import cn.qkl.common.repository.model.Content;
import cn.qkl.webserver.common.enums.ContentRiskCategoryEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @title:
 * @Author wang xin
 * @Date: 2022/8/14 15:43
 * @wiki
 */
@Data
public class ContentDetectionInfoVO {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("数字内容项目名称")
    private String name;

    @ApiModelProperty("平台URL")
    private String url;

    @ApiModelProperty("平台LOGO")
    private String logo;

    @ApiModelProperty("平台名字")
    private String platformName;

    @ApiModelProperty("平台类别： 0 nft  1 web3")
    private Integer platformType;

    @ApiModelProperty("拥有者：数字内容当前的拥有者账户地址")
    private String owner;

    @ApiModelProperty("合约地址")
    private String address;

    @ApiModelProperty("风险标签: 0 无风险 1 政治风险,2, '恐怖风险',3, '暴力风险 ,4, '低俗风险,5, '犯罪风险,6, '赌博风险',7, '毒品风险'")
    private String contentTag;

    @ApiModelProperty("风险标签列表: 0 无风险 1 政治风险,2, '恐怖风险',3, '暴力风险 ,4, '低俗风险,5, '犯罪风险,6, '赌博风险',7, '毒品风险'")
    private List<Integer> contentTagList;

    @ApiModelProperty("动态风险属性：0静态 5读动态 10写动态")
    private Integer dynamicType;

    @ApiModelProperty("风险评级：1低风险 2中风险 3高风险")
    private Integer riskLevel;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    public static ContentDetectionInfoVO transform(ContentDetectionInfoVO vo) {
        //string contentTag转化为List<Integer>
        String[] split = vo.getContentTag().split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }

        vo.setContentTagList(list);
        return vo;
    }
}
