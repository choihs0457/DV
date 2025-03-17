package com.example.DV.domain.repository;

import com.example.DV.domain.model.VoteCountEntity;
import com.example.DV.domain.model.VoteTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteCountRepository extends JpaRepository<VoteCountEntity, Long> {
    List<VoteCountEntity> findByVoteTopic(VoteTopicEntity voteTopic);
}
