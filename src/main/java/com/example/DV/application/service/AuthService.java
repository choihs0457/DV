package com.example.DV.application.service;

import com.example.DV.application.port.out.UserRepository;
import com.example.DV.domain.user.User;
import com.example.DV.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String email, String password) {
        // 이메일로 사용자 조회
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // 비밀번호 일치 여부 확인
        if (passwordEncoder.matches(password, user.getPassword())) {
            // 인증 성공 시 JWT 발행
            return JwtUtil.generateToken(email);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
