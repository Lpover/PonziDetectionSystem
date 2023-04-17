package cn.qkl.common.framework.request;

import cn.hutool.core.date.DateUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateConverter implements Converter<String, Date> {
    /**
     * 可对value进行正则匹配，支持日期、时间等多种类型转换
     * cn.hutool.core.date.DateUtil
     *
     * @param value 时间序列
     * @return date对象
     */
    @Override
    public Date convert(String value) {
        return DateUtil.parse(value.trim());
    }
}
