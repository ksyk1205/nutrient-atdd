package com.example.member.domain;

import com.example.auth.authorization.Role;
import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class MemberRole {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Role role;

    protected MemberRole() {
    }

    public MemberRole(Role role) {
        this.id = UUID.randomUUID();
        this.role = role;
    }
}
