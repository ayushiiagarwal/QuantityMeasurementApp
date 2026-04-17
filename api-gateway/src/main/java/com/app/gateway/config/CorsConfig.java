package com.app.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${FRONTEND_URL:http://localhost:4200}")
    private String frontendUrl;

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();
        List<String> originPatterns = new ArrayList<>();
        originPatterns.add("http://localhost:4200");
        originPatterns.add("https://*.railway.app");
        originPatterns.add("https://qma-apigateway.up.railway.app");
        originPatterns.add("https://quantity-measurement-app-frontend-beryl.vercel.app");
        if (frontendUrl != null && !frontendUrl.isBlank() && !originPatterns.contains(frontendUrl)) {
            originPatterns.add(frontendUrl);
        }

        config.setAllowedOriginPatterns(originPatterns);
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
