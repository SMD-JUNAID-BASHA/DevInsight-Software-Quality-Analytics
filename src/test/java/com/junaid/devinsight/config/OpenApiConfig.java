package com.junaid.devinsight.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI devInsightOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("DevInsight API")
                        .version("1.0.0")
                        .description(
                                "Software Quality and Data Analytics Platform REST API"
                        )
                        .contact(new Contact()
                                .name("Junaid Basha")
                                .email("smdjunaidbasha27@gmail.com")
                        )
                );
    }
}