package com.chetan.College_Admission_Portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for testing
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/students/**").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2Login(withDefaults())
                .build();
    }
}