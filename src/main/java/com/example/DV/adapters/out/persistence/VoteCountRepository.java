package com.example.DV.adapters.out.persistence;

import com.example.DV.domain.vote.VoteCount;
import com.example.DV.domain.vote.VoteTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VoteCountRepository extends JpaRepository<VoteCount, Long> {
    Optional<VoteCount> findByVoteTopicAndVoteOption(VoteTopic topic, String voteOption);
}
