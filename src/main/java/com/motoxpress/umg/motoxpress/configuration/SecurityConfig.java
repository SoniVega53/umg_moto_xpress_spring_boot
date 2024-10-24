package com.motoxpress.umg.motoxpress.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;

import com.motoxpress.umg.motoxpress.jwt_token.JwtAuthenticationFilter;
import com.motoxpress.umg.motoxpress.model.RoleUser;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final AuthenticationProvider authProvider;
        private final String apiAuth = "/api/proyecto/noauth/**";
        private final String apiAuthAdmin = "/api/proyecto/user/admin/**";

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .cors(withDefaults())
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(authRequest -> authRequest
                            .requestMatchers(apiAuth).permitAll()
                            .requestMatchers(apiAuthAdmin).hasAuthority(RoleUser.ADMIN.name().toLowerCase())
                            .anyRequest().authenticated())
                    .sessionManagement(sessionManager -> sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(authProvider)
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }
}
