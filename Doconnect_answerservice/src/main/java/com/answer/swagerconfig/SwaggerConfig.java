package com.answer.swagerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("lilly@123gmail.com");
        contact.setName("Dev_Team");
        contact.setUrl("https://www.lilly.com/");
        
        License Bealicense = new License().name("lilly License").url("https://lilly/about.html");

        Info info = new Info().title(" Answer Configuration")
                               .version("V.2.0")
                               .contact(contact)
                               .description("DoConnect is a popular Question and Answer application in which technical questions are asked and answered")
                               .termsOfService("https://www.lilly.com/")
                               .license(Bealicense);

        
        var securityScheme = new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")
                                    .in(In.HEADER)
                                    .name("Authorization");
        
        
        var securityComponent = new Components().addSecuritySchemes("bearer", securityScheme);
        
        
        var securityItem = new SecurityRequirement().addList("bearer");

        
        return new OpenAPI().info(info)
                             .components(securityComponent)
                             .addSecurityItem(securityItem);
    }
}
