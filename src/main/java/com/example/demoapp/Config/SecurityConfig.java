package com.example.demoapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                // .authorizeRequests(authorize -> authorize
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/books/**").authenticated()
                //.requestMatchers("/admin/**").hasRole("ADMIN")// Restrict access to /admin/** to users with role ADMIN
                .requestMatchers(HttpMethod.GET, "/api/books/**").authenticated() // Allow only GET requests for /user/** to users with role USER
//                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .httpBasic()
                .and()
                .build();
    }
}
