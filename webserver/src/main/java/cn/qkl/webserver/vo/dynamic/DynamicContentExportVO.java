package cn.qkl.webserver.vo.dynamic;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ContentStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)
@HeadStyle(horizontalAlignment = HorizontalAlignmentEnum.CENTER)
@Slf4j
public class DynamicContentExportVO {
    @ExcelProperty("名称")
    private String name;
    @ExcelProperty("合约地址")
    private String address;
    @ExcelProperty("缩略图")
    private String metaUrl;
    @ExcelProperty("风险评级")
    private String riskLevel;
}
