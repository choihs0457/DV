package com.example.DV.adapters.out.persistence;

import com.example.DV.domain.vote.VoteResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteResultRepository extends JpaRepository<VoteResult, Long> {
}
