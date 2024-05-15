package cn.xrb.clouduser.common.FreeMarker;

import freemarker.template.*;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerExample {
    public static void main(String[] args) throws Exception {
        // 创建配置对象
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        File dir = new File("cloud-user/src/main/resources/templates");
        cfg.setDirectoryForTemplateLoading(dir); // 设置模板文件存放路径
        cfg.setDefaultEncoding("UTF-8"); // 设置编码格式

        // 获取模板对象
        Template template = cfg.getTemplate("example.ftl");

        // 准备数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "John");
        dataModel.put("age", 25);

        // 渲染模板并输出结果

        File to = new File("cloud-user/src/main/resources/html/example.html");

        FileWriter out = new FileWriter(to);
        template.process(dataModel, out);
        out.flush();
    }
}
