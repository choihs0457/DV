package com.example.DV.adapter.out.persistence;

import com.example.DV.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteTopicRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
