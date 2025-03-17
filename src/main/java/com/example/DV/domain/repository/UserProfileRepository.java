package com.example.DV.domain.repository;

import com.example.DV.domain.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    List<UserProfileEntity> findByGender(String gender);
    List<UserProfileEntity> findByAgeBetween(Integer minAge, Integer maxAge);
}