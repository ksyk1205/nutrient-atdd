package com.example.member.application.dto;

import com.example.member.domain.LoginMember;
import com.example.member.domain.Member;
import com.example.member.domain.MemberRole;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class MemberResponse {
    private UUID id;
    private String email;
    private Integer age;
    private List<MemberRole> roles;

    public MemberResponse() {
    }

    public MemberResponse(UUID id, String email, Integer age, List<MemberRole> roles) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.roles = roles;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getAge(), member.getRoles());
    }

    public static MemberResponse of(LoginMember member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getAge(), member.getRoles());
    }
}
