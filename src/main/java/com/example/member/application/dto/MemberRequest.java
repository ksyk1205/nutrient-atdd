package com.example.member.application.dto;

import com.example.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberRequest {
    private String email;
    private String password;
    private Integer age;

    public MemberRequest() {
    }

    public MemberRequest(String email, String password, Integer age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Member toMember() {
        return new Member(email, password, age);
    }
}
