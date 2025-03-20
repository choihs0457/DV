package com.example.DV.adapters.out.persistence;

import com.example.DV.domain.vote.VoteTopic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VoteTopicRepository extends JpaRepository<VoteTopic, Long> {
}
