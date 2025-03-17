package com.example.DV.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteCountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteCountId;

    @ManyToOne
    @JoinColumn(name = "vote_topic_id", nullable = false)
    private VoteTopicEntity voteTopic;

    @Column(nullable = false)
    private String voteOption;

    @Column(nullable = false)
    private Long count;
}
