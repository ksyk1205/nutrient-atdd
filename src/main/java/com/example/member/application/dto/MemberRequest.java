package com.example.member.application.dto;

import com.example.auth.authorization.Role;
import com.example.member.domain.Member;
import com.example.member.domain.MemberRole;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberRequest {
    private String email;
    private String password;
    private Integer age;
    private List<Role> roles;

    public MemberRequest() {
    }

    public MemberRequest(String email, String password, Integer age, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.roles = roles;
    }

    public Member toMember() {
        Member member = new Member(email, password, age);
        roles.forEach(role -> member.addRole(new MemberRole(role)));
        return member;
    }
}
