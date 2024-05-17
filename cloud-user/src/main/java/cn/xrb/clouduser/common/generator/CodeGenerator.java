package cn.xrb.clouduser.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("表名:");
        String t_table = scanner.nextLine();
        String capitalizedStr = t_table.substring(0, 1).toUpperCase() + t_table.substring(1);
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/cloud-user/src/main/java");
        gc.setAuthor("xrb");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setControllerName(capitalizedStr+"Controller");
        gc.setServiceName(capitalizedStr+"Service");
        gc.setServiceImplName(capitalizedStr+"ServiceImpl");
        gc.setMapperName(capitalizedStr+"Mapper");
        gc.setXmlName(capitalizedStr+"Mapper");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://112.124.2.133:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("visitor");
        dsc.setPassword("visitor");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.xrb.clouduser");
        pc.setModuleName("");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setXml("mapper/xml");
        mpg.setPackageInfo(pc);

        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(t_table);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        mpg.execute();
    }

    /**
     * 读取控制台内容
     * @param tipMessage 提示信息
     * @return 控制台输入的内容
     */
}
