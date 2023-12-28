package cn.qkl.webserver.common.log;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
// 表示该注解可在类或方法上使用
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface ApiRecord {
    Class<? extends ApiType> apiType();
}
