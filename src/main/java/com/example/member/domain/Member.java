package com.example.member.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "member_id",
            nullable = false,
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_member_role_to_member")
    )
    private List<MemberRole> roles = new ArrayList<>();

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
        this.roles = member.roles;
    }

    public void addRole(MemberRole memberRole) {
        this.roles.add(memberRole);
    }
}
