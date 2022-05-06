package com.example.member.application.dto;

import com.example.member.domain.LoginMember;
import com.example.member.domain.Member;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MemberResponse {
    private UUID id;
    private String email;
    private Integer age;

    public MemberResponse() {
    }

    public MemberResponse(UUID id, String email, Integer age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getAge());
    }

    public static MemberResponse of(LoginMember member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getAge());
    }
}
