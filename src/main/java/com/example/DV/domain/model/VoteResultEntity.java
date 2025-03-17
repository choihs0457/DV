package com.example.DV.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteResultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "vote_topic_id", nullable = false)
    private VoteTopicEntity voteTopic;


    @Column(nullable = false)
    private String voteOption; // "YES" 또는 "NO" 등
}
