package com.example.auth;

import com.example.auth.authentication.SessionAuthenticationInterceptor;
import com.example.auth.authentication.TokenAuthenticationInterceptor;
import com.example.auth.authentication.converter.SessionAuthenticationConverter;
import com.example.auth.authentication.converter.TokenAuthenticationConverter;
import com.example.auth.authorization.AuthenticationPrincipalArgumentResolver;
import com.example.auth.authorization.SessionSecurityContextPersistenceInterceptor;
import com.example.auth.authorization.TokenSecurityContextPersistenceInterceptor;
import com.example.auth.authorization.strategy.SessionSecurityContextHolderStrategy;
import com.example.auth.authorization.strategy.TokenSecurityContextHolderStrategy;
import com.example.auth.token.JwtTokenProvider;
import com.example.member.application.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AuthConfig implements WebMvcConfigurer {
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    public AuthConfig(CustomUserDetailsService userDetailsService,
                      JwtTokenProvider jwtTokenProvider,
                      ObjectMapper objectMapper) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.objectMapper = objectMapper;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionAuthenticationInterceptor(userDetailsService, new SessionAuthenticationConverter()))
                .addPathPatterns("/login/session");
        registry.addInterceptor(new TokenAuthenticationInterceptor(userDetailsService,
                new TokenAuthenticationConverter(),
                jwtTokenProvider,
                objectMapper))
                .addPathPatterns("/login/token");
        registry.addInterceptor(new SessionSecurityContextPersistenceInterceptor(new SessionSecurityContextHolderStrategy()));
        registry.addInterceptor(new TokenSecurityContextPersistenceInterceptor(new TokenSecurityContextHolderStrategy(jwtTokenProvider)));
    }

    @Override
    public void addArgumentResolvers(List argumentResolvers) {
        argumentResolvers.add(new AuthenticationPrincipalArgumentResolver());
    }
}
