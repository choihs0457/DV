package com.example.DV.adapters.out.persistence;

import com.example.DV.application.port.out.UserRepository;
import com.example.DV.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Spring Data JPA Repository 인터페이스를 포트(UserRepository)를 확장하여 작성
@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
    Optional<User> findByEmail(String email);
}
