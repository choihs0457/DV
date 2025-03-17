package com.example.DV.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteTopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteTopicId;

    @Column(nullable = false)
    private String title;

    private LocalDateTime startTime; // 투표 시작 시간
    private LocalDateTime endTime; // 투표 시작 시간

    private boolean isActive; // 투표 진행 여부
}
