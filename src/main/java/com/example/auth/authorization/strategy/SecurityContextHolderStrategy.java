package com.example.auth.authorization.strategy;

import com.example.auth.context.SecurityContext;
import com.example.auth.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

public abstract class SecurityContextHolderStrategy {
    public abstract SecurityContext extract(HttpServletRequest request);
    public void setContext(SecurityContext securityContext) {
        if (securityContext != null) {
            SecurityContextHolder.setContext(securityContext);
        }
    }
}
