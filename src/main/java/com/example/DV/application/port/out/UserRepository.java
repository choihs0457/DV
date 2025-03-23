package com.example.DV.application.port.out;

import com.example.DV.domain.user.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
