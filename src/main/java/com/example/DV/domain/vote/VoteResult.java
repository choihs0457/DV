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
    @Column(name = "vote_result_id")
    private Long voteResultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_topic_id")
    private VoteTopic voteTopic;

    private String voteOption;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
