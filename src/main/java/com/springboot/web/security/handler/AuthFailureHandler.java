package com.springboot.web.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("onAuthenticationFailure");
        String message;
        if(exception instanceof BadCredentialsException) {
            message = "BadCredentialsException";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            message = "InternalAuthenticationServiceException";
        } else if (exception instanceof UsernameNotFoundException) {
            message = "UsernameNotFoundException";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            message = "AuthenticationCredentialsNotFoundException";
        } else {
            message = "응애";
        }
        log.info("m -> {}", message);
    }
}
