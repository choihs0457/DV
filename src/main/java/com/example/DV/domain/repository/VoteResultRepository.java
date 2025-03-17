package com.example.DV.domain.repository;

import com.example.DV.domain.model.VoteResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteResultRepository extends JpaRepository<VoteResultEntity, Long> {
}
