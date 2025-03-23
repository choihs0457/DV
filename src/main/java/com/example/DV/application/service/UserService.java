package com.example.DV.application.service;

import com.example.DV.application.dto.SignUpRequest;
import com.example.DV.application.port.out.UserRepository;
import com.example.DV.domain.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository; // 포트(인터페이스)
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignUpRequest request) {
        // 이메일 중복 체크
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }
        // 신규 사용자 생성 (기본 role: ROLE_USER)
        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();
        userRepository.save(user);
        return user;
    }
}
