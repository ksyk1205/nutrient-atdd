package com.example.member.domain;


import com.example.auth.authentication.UserDetails;
import lombok.Getter;

import java.util.UUID;

@Getter
public class LoginMember implements UserDetails {
    private UUID id;
    private String email;
    private String password;
    private Integer age;

    public static LoginMember of(Member member) {
        return new LoginMember(member.getId().toString(), member.getEmail(), member.getPassword(), member.getAge());
    }

    public LoginMember(String id, String email, String password, Integer age) {
        this.id = UUID.fromString(id);
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
