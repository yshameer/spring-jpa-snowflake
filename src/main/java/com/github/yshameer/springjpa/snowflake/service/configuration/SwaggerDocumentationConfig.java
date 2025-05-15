package com.github.yshameer.springjpa.snowflake.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public GroupedOpenApi customOpenApi() {
        return GroupedOpenApi.builder()
                .group("spring-jpa-snowflake")
                .packagesToScan("com.github.yshameer.springjpa.snowflake.service")
                .build();
    }

}
