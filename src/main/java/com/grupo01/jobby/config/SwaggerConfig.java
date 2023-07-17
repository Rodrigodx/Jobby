package com.grupo01.jobby.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Jobby API para cadastro de currículo")
                        .description("API Rest desenvolvida para o cadastro de cv para que recrutadores busquem de forma prática"));
    }

}
