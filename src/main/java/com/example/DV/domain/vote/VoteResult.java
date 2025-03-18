package com.example.DV.domain.vote;

import com.example.DV.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vote_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteResultId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vote_topic_id", nullable = false)
    private VoteTopic voteTopic;


    @Column(nullable = false)
    private String voteOption; // "YES" 또는 "NO" 등

}
