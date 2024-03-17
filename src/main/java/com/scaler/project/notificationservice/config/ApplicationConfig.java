package com.scaler.project.notificationservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new Jackson2ObjectMapperBuilder().build();
    }
}
