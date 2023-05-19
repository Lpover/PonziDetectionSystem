package cn.qkl.common.framework.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class EasyExcelUtil {
    public EasyExcelUtil() {
    }

    public static <T> void exportExcel(List<T> list, Class<?> entity, String fileName, HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        try {
            fileName = fileName.replaceAll(":", "-");
            String name = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename=" + name + ".xlsx");
            EasyExcel.write(response.getOutputStream(), entity).sheet(fileName).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).doWrite(list);
        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }
}