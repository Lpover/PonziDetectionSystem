package cn.qkl.webserver.common.cert;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @Author sunxiaen
 * @Date 2023/6/29 22:27
 **/
public class FreemarkerUtils {

    public static String getTemplate(String template, Map<String, Object> map) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setTemplateLoader(new ClassTemplateLoader(
                FreemarkerUtils.class.getClass().getClassLoader(), "/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        Template temp = cfg.getTemplate(template, "UTF-8");
        StringWriter stringWriter = new StringWriter();
        temp.process(map, stringWriter);
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

}