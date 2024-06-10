package com.videoplatform.videoplatform.models;

import com.videoplatform.videoplatform.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role= Role.USER;

}
