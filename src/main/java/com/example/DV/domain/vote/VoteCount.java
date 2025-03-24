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
    @Column(name = "vote_count_id")
    private Long voteCountId;

    @OneToOne
    @JoinColumn(name = "vote_topic_id")
    private VoteTopic voteTopic;

    private Integer count;

}
