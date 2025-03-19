package com.example.DV.adapter.out.persistence;

import com.example.DV.domain.vote.VoteTopic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VoteTopicRepository extends JpaRepository<VoteTopic, Long> {
}
