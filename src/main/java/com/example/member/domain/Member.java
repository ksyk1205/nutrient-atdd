package com.example.member.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "members")
@Entity
@Getter
public class Member {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;
    private String email;
    private String password;
    private Integer age;

    protected Member() {
    }

    public Member(String email, String password, Integer age) {
        this(UUID.randomUUID(), email, password, age);
    }

    public Member(UUID id, String email, String password, Integer age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public void update(Member member) {
        this.email = member.email;
        this.password = member.password;
        this.age = member.age;
    }
}
