package com.grupo.acert.temperature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConf {

    @Bean
    public Docket api() {
        var metadata = metaData();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.grupo.acert"))
                .build()
                .apiInfo(metadata)
                .enableUrlTemplating(true);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Temperature Service REST API")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Alex Freitas", "linkedin.com/in/alex-de-freitas/", "alexdefreitas99@hotmail.com"))
                .description("API to manipulate temperature")
                .build();
    }
}
