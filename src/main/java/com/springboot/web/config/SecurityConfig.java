package com.springboot.web.config;

import com.springboot.web.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
        ;

        http
                .authorizeRequests()
                .antMatchers("/api/user/admin").hasRole(Role.ADMIN.name())
                .anyRequest().hasAnyRole(Role.USER.name(), Role.ADMIN.name())
        ;

        http
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        ;

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
