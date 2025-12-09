package com.example.SimpleProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Password Encoder Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for secure password hashing
        return new BCryptPasswordEncoder();
    }

    // 2. Security Filter Chain Configuration (Spring Security 6+)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Only disable for simple demos/APIs, keep enabled for production web MVC
                .authorizeHttpRequests(authorize -> authorize
                        // Allow public access to registration, login, static assets, and home page
                        .requestMatchers("/register/**", "/login**", "/css/**", "/js/**").permitAll()

                        // All other requests must be authenticated (logged in)
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                // Specify our custom login page path
                                .loginPage("/login")
                                // CRITICAL: Allow everyone access to the form page and processing endpoint
                                .permitAll()
                                // Redirect on successful login (to the root URL)
                                .defaultSuccessUrl("/", true)
                        // Optional: set custom parameter names if not using default "username" and "password"
                )
                .logout(logout -> logout
                        // The default logout URL is /logout (POST request)
                        .logoutUrl("/logout")
                        // Redirect to the login page with a success message after logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}