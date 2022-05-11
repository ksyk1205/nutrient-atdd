package com.example.auth.authentication;

@FunctionalInterface
public interface UserDetailsService {
    UserDetails loadUserByUsername(String email);
}
