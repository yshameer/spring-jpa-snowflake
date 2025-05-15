package com.github.yshameer.springjpa.snowflake.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.yshameer.springjpa")
public class SpringJpaSnowflakeServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().load();
        
        // Set environment variables for Spring Boot to use
        System.setProperty("SNOWFLAKE_ACCOUNT", dotenv.get("SNOWFLAKE_ACCOUNT"));
        System.setProperty("SNOWFLAKE_USERNAME", dotenv.get("SNOWFLAKE_USERNAME"));
        System.setProperty("SNOWFLAKE_PASSWORD", dotenv.get("SNOWFLAKE_PASSWORD"));
        System.setProperty("SNOWFLAKE_WAREHOUSE", dotenv.get("SNOWFLAKE_WAREHOUSE"));
        System.setProperty("SNOWFLAKE_SCHEMA", dotenv.get("SNOWFLAKE_SCHEMA"));
        System.setProperty("SNOWFLAKE_DATABASE", dotenv.get("SNOWFLAKE_DATABASE"));
        
        SpringApplication.run(SpringJpaSnowflakeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

