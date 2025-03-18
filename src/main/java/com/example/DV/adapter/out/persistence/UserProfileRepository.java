package com.example.DV.adapter.out.persistence;

import com.example.DV.domain.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByGender(String gender);
    List<UserProfile> findByAgeBetween(Integer minAge, Integer maxAge);
}