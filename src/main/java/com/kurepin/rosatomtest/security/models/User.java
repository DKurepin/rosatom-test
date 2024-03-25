package com.kurepin.rosatomtest.security.models;

import com.kurepin.rosatomtest.entities.Message;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @JoinColumn(name = "message_id")
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Message messageId;
}
