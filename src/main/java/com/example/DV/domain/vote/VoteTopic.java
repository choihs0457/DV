package com.example.DV.domain.vote;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vote_topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteTopicId;

    @Column(nullable = false)
    private String title;

    private LocalDateTime startTime; // 투표 시작 시간
    private LocalDateTime endTime; // 투표 시작 시간

}
