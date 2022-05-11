package com.example.auth.authorization.strategy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.auth.authorization.AuthorizationExtractor;
import com.example.auth.authorization.AuthorizationType;
import com.example.auth.context.Authentication;
import com.example.auth.context.SecurityContext;
import com.example.auth.token.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class TokenSecurityContextHolderStrategy extends SecurityContextHolderStrategy {
    private final JwtTokenProvider jwtTokenProvider;

    public TokenSecurityContextHolderStrategy(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public SecurityContext extract(HttpServletRequest request) {
        String credentials = AuthorizationExtractor.extract(request, AuthorizationType.BEARER);
        if (!jwtTokenProvider.validateToken(credentials)) {
            return null;
        }
        return extractSecurityContext(credentials);
    }

    private SecurityContext extractSecurityContext(String credentials) {
        try {
            String payload = jwtTokenProvider.getPayload(credentials);
            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };

            Map<String, Object> principal = new ObjectMapper().readValue(payload, typeRef);
            return new SecurityContext(new Authentication(principal));
        } catch (Exception e) {
            return null;
        }
    }
}
