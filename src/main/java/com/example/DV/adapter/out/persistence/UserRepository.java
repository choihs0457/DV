package com.example.DV.adapter.out.persistence;

import com.example.DV.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
