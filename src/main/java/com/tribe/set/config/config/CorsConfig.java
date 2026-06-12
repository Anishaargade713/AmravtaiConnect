package com.tribe.set.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // 1. MUST be the exact Netlify URL (NO trailing slash!)
                        .allowedOrigins("https://effervescent-conkies-739628.netlify.app") 
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        // 2. This line is absolutely mandatory for login cookies to work!
                        .allowCredentials(true); 
            }
        };
    }
}
