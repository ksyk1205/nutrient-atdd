package com.example.auth.authentication;

public interface UserDetails {
    boolean checkPassword(String credentials);
}
