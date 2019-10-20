package com.eappcat.base.oauth2.starter.conf.codegen;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "codegen")
@Data
public class CodeGeneratorProperties {
    private String moduleName="app";
    private String author="yuebo";
    private String packageName="com.eappcat";
    private boolean fileOverride;
    private String baseEntityClass;
    private String baseServiceClass;
    private String baseServiceImplClass;
    private String baseControllerClass;
    private List<String> includes;
    private List<String> excludes;
    private List<String> tablePrefix;
    private List<String> baseEntityColumns= Arrays.asList("id","created_by","created_date","updated_by","updated_date","version");
}
