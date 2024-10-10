package com.motoxpress.umg.motoxpress.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:"); // Agrega el dominio permitido
        corsConfiguration.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, etc.)
        corsConfiguration.addAllowedHeader("*"); // Permitir todos los headers
        corsConfiguration.setAllowCredentials(true); // Permitir credenciales (cookies, authorization headers, etc.)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Aplicar esta configuración a todas las rutas
        return new CorsFilter(source);
    }
}