package com.example.DV.adapter.out.persistence;

import com.example.DV.domain.vote.VoteCount;
import com.example.DV.domain.vote.VoteTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteCountRepository extends JpaRepository<VoteCount, Long> {
    List<VoteCount> findByVoteTopic(VoteTopic voteTopic);
}
