package com.INGRES.INGRES.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig loaded!"); // Check Render logs for this
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS Mappings are being configured!");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // ADD OPTIONS
                .allowedHeaders("*")
                .allowCredentials(false); // Set to false when using "*" origin
    }
}