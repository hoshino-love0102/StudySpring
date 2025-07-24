package com.example.loginproject.config;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                        .disable())
                .headers(headers -> headers
                        .frameOptions().disable())
                .formLogin(form -> form.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login", "/login.html",
                                "/register", "/register.html",
                                "/main",
                                "/css/**", "/js/**", "/images/**",
                                "/h2-console/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
