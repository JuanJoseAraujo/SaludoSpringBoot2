package com.example.SaludoSpringBoot2.config;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Collections;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails (){
        return new ApiInfo("Spring Boot Laptop Api Rest", "Api Rest de Laptops", "1.0"
                , "www.laptops.com"
                , new Contact("Juan José", "www.jjap.com", "infilter@gmail.com")
                , "CC", "www.cc.com"
                , Collections.emptyList());
    }

}
