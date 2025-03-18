package com.example.DV.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileId;

    @Column(nullable = false)
    private String gender; // "MALE" or "FEMALE"

    @Column(nullable = false)
    private Long age; // 사용자 나이

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}