package com.springboot.web.config;

import com.springboot.web.security.CustomUserDetailsService;
import com.springboot.web.security.filter.CustomAuthenticationFilter;
import com.springboot.web.security.handler.AuthFailureHandler;
import com.springboot.web.security.handler.AuthSuccessHandler;
import com.springboot.web.security.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
        ;

        http
                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        ;

        http
                .authorizeRequests()
//                .antMatchers("/api/user/admin").hasRole(Role.ADMIN.name())
//                .anyRequest().hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                .anyRequest().permitAll();
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

    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(customUserDetailsService, passwordEncoder());
    }

    public void customAuthenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        customAuthenticationManagerBuilder(authenticationManagerBuilder);
        return authenticationConfiguration.getAuthenticationManager();
    }

    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(authenticationConfiguration));
        customAuthenticationFilter.setFilterProcessesUrl("/login-process");
        customAuthenticationFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        customAuthenticationFilter.setAuthenticationFailureHandler(authFailureHandler);
        return customAuthenticationFilter;
    }

}
