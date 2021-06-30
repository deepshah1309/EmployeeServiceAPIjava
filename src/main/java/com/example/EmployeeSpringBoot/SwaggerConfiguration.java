package com.example.EmployeeSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration

public class SwaggerConfiguration {
    private static final Contact SUPPORTED_CONTACT =new Contact("deep-shah","https://github.com/deepshah1309","deepshah1309@gmail.com");

    @Bean
    public  Docket newAPI(){
        Set<String> prodUsers=new HashSet<>(Arrays.asList("application/json","application/xml"));
        Set<String> consumes=new HashSet<>(Arrays.asList("application/json","application/xml"));
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo())
                .produces(prodUsers)
                .consumes(consumes);
    }

    private ApiInfo apiinfo() {
        return new ApiInfoBuilder().title("Employee Service").
                description("Api SERVICE WITH swagger documentation -deep shah").
                termsOfServiceUrl("https://github.com/deepshah1309").
                contact(SUPPORTED_CONTACT).
                license("Employee SpringBoot V1.0 deep-shah").
                version("1.0").
                build();
    }
}
