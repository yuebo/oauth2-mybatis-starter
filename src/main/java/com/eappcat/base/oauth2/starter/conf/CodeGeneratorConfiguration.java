package com.eappcat.base.oauth2.starter.conf;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CodeGeneratorProperties.class)
@Data
public class CodeGeneratorConfiguration {

}
