package com.greensuper.GreenSuper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public  void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry){
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000").allowedHeaders("*");
    }
}
