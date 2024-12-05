package com.pinjolobp.pinjol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()           // Matikan CSRF
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Ijinkan semua request
            .formLogin().disable()      // Matikan form login
            .httpBasic().disable();     // Matikan otentikasi basic
        return http.build();
    }
}