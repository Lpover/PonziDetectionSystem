package cn.qkl.webserver.vo.board;

import cn.qkl.common.repository.model.ContentCrossDailyStatistics;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @param
 * @return
 */
@Data
public class CrossContentTxViewVO {
    @ApiModelProperty("风险交易数量的列表")
    List<Integer> txNum;

    @ApiModelProperty("时间列表")
    List<Date> timeList;

    public static CrossContentTxViewVO transform(List<ContentCrossDailyStatistics> list) {
        CrossContentTxViewVO crossContentTxViewVO = new CrossContentTxViewVO();
        List<Integer> txNum = new ArrayList<>();
        List<Date> timeList = new ArrayList<>();
        for (ContentCrossDailyStatistics contentCrossDailyStatistics : list) {
            txNum.add(contentCrossDailyStatistics.getTxNum());
            timeList.add(contentCrossDailyStatistics.getCreateTime());
        }
        crossContentTxViewVO.setTxNum(txNum);
        crossContentTxViewVO.setTimeList(timeList);
        return crossContentTxViewVO;
    }
}
