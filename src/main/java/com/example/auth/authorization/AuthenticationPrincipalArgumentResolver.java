package com.example.auth.authorization;

import com.example.auth.authentication.AuthenticationException;
import com.example.auth.context.Authentication;
import com.example.auth.context.SecurityContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.*;

public class AuthenticationPrincipalArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticationPrincipal.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.isNull(authentication)) {
            throw new AuthenticationException();
        }
        if (!containsRole(parameter, authentication)) {
            throw new AuthenticationException();
        }
        if (authentication.getPrincipal() instanceof Map) {
            return extractPrincipal(parameter, authentication);
        }

        return authentication.getPrincipal();
    }

    private boolean containsRole(MethodParameter parameter, Authentication authentication) {
        Map<String, Object> principal = (Map) authentication.getPrincipal();
        List<Map<String, String>> roles = (List<Map<String, String>>) principal.get("roles");
        List<Role> roleParams = Arrays.asList(Objects.requireNonNull(parameter.getParameterAnnotation(AuthenticationPrincipal.class)).role());
        for (Map<String, String> role : roles) {
            if (roleParams.contains(Role.valueOf(role.get("role")))) {
                return true;
            }
        }

        return false;
    }

    private Object extractPrincipal(MethodParameter parameter, Authentication authentication) {
        try {
            Map<String, Object> principal = (Map) authentication.getPrincipal();

            Object[] params = Arrays.stream(parameter.getParameterType().getDeclaredFields())
                    .map(it -> toObject(it.getType(), principal.get(it.getName())))
                    .toArray();

            return parameter.getParameterType().getConstructors()[0].newInstance(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object toObject(Class clazz, Object value) {
        if (Boolean.class == clazz) return (Boolean) value;
        if (Byte.class == clazz) return (Byte) value;
        if (Short.class == clazz) return (Short) value;
        if (Integer.class == clazz) return (Integer) value;
        if (Long.class == clazz) return (Long) value;
        if (Float.class == clazz) return (Float) value;
        if (Double.class == clazz) return (Double) value;
        return value;
    }
}
