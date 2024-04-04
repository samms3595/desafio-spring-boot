package com.moveapps.tasks.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .addSecurityItem(segurityRequirement())
                .components(components());
    }

    private Components components() {
        return new Components().addSecuritySchemes
                ("Bearer", createAPIKeyScheme());
    }

    private SecurityRequirement segurityRequirement() {
        return new SecurityRequirement().
                addList("Bearer");
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    private Info apiInfo() {
        return new Info()
                .title("Documentación API Tareas")
                .description("Documentación API Tareas")
                .version("1.0")
                .contact(contactInfo());
    }

    private Contact contactInfo() {
        return new Contact()
                .name("Sebastian Mendez");
    }
}