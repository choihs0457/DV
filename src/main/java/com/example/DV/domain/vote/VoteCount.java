package com.example.DV.domain.vote;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vote_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteCountId;

    @ManyToOne
    @JoinColumn(name = "vote_topic_id", nullable = false)
    private VoteTopic voteTopic;

    @Column(nullable = false)
    private String voteOption;

    @Column(nullable = false)
    private Long count;
}
