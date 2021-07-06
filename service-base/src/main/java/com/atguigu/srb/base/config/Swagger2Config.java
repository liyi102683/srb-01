package com.atguigu.srb.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .groupName("adminApi")
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }
    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("尚融宝后台管理系统API文档")
                .description("本文档描述了尚融宝后台管理系统的各个模块的接口的调用方式")
                .version("1.0.0")
                .contact(new Contact("ly","http://www.atguigu.com","admin@atguigu.com"))
                .build();
    }



}