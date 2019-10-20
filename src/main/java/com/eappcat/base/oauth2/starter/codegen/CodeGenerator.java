package com.eappcat.base.oauth2.starter.codegen;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.eappcat.base.oauth2.starter.conf.codegen.CodeGeneratorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodeGenerator {
    @Autowired
    private DataSourceProperties dataSourceProperties;
    @Autowired
    private CodeGeneratorProperties codeGeneratorProperties;

    public void generate() {
         // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(codeGeneratorProperties.getAuthor());
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(codeGeneratorProperties.isFileOverride());
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataSourceProperties.getUrl());
        dsc.setDriverName(dataSourceProperties.getDriverClassName());
        dsc.setUsername(dataSourceProperties.getUsername());
        dsc.setPassword(dataSourceProperties.getPassword());
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(codeGeneratorProperties.getModuleName());
        pc.setParent(codeGeneratorProperties.getPackageName());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
    //    String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(codeGeneratorProperties.getBaseEntityClass());
        strategy.setSuperServiceClass(codeGeneratorProperties.getBaseServiceClass());
        strategy.setSuperServiceImplClass(codeGeneratorProperties.getBaseServiceImplClass());
        strategy.setSuperControllerClass(codeGeneratorProperties.getBaseControllerClass());
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        if(codeGeneratorProperties.getIncludes()!=null){
            strategy.setInclude(codeGeneratorProperties.getIncludes().toArray(new String[]{}));
        }
        if(codeGeneratorProperties.getExcludes()!=null){
            strategy.setExclude(codeGeneratorProperties.getExcludes().toArray(new String[]{}));
        }
        if(codeGeneratorProperties.getBaseEntityColumns()!=null){
            strategy.setSuperEntityColumns(codeGeneratorProperties.getBaseEntityColumns().toArray(new String[]{}));
        }
        strategy.setControllerMappingHyphenStyle(true);
        if (codeGeneratorProperties.getTablePrefix()!=null){
            strategy.setTablePrefix(codeGeneratorProperties.getTablePrefix().toArray(new String[]{}));
        }
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();

    }

}
