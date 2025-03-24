package com.example.DV.domain.vote;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "vote_topic_id")
    private Long voteTopicId;

    private String title;

    @OneToMany(mappedBy = "voteTopic", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<VoteResult> voteResults = new ArrayList<>();

    @OneToOne(mappedBy = "voteTopic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VoteCount voteCount;

}