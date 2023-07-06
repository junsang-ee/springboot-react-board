package com.springboot.web.security.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
@ToString
public class JwtProperties {

    private String secret;
    private String prefix;
    private String header;
    private Long accessExpiration;
    private Long refreshExpiration;
    private String algorithmName;

}
