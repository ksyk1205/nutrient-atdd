package com.example.auth.authorization.strategy;

import com.example.auth.context.SecurityContext;

import javax.servlet.http.HttpServletRequest;

import static com.example.auth.context.SecurityContextHolder.SPRING_SECURITY_CONTEXT_KEY;

public class SessionSecurityContextHolderStrategy extends SecurityContextHolderStrategy {
    @Override
    public SecurityContext extract(HttpServletRequest request) {
        return (SecurityContext) request.getSession().getAttribute(SPRING_SECURITY_CONTEXT_KEY);
    }
}
