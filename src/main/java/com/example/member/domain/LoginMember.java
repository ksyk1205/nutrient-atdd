package com.example.member.domain;


import com.example.auth.authentication.UserDetails;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class LoginMember implements UserDetails {
    private UUID id;
    private String email;
    private String password;
    private Integer age;
    private List<MemberRole> roles;

    public static LoginMember of(Member member) {
        return new LoginMember(member.getId().toString(), member.getEmail(), member.getPassword(), member.getAge(), member.getRoles());
    }

    public LoginMember(String id, String email, String password, Integer age, List<MemberRole> roles) {
        this.id = UUID.fromString(id);
        this.email = email;
        this.password = password;
        this.age = age;
        this.roles = roles;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
