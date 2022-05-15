package com.example.auth.authorization;

import com.example.auth.authorization.strategy.SecurityContextHolderStrategy;
import com.example.auth.context.SecurityContext;
import com.example.auth.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenSecurityContextPersistenceInterceptor extends SecurityContextInterceptor {
    private final SecurityContextHolderStrategy strategy;

    public TokenSecurityContextPersistenceInterceptor(SecurityContextHolderStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            return true;
        }

        SecurityContext securityContext = strategy.extract(request);
        strategy.setContext(securityContext);
        return true;
    }
}
