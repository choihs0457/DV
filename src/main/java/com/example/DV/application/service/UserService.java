package com.example.DV.application.service;

import com.example.DV.application.dto.SignUpRequest;
import com.example.DV.domain.user.User;
import com.example.DV.adapters.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User signUp(SignUpRequest request) {
        // 이메일 중복 체크
        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new IllegalArgumentException("이미 등록된 이메일입니다.");
                });

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 기본 역할은 ROLE_USER로 지정
        User newUser = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(encodedPassword)
                .role("ROLE_USER")
                .build();

        return userRepository.save(newUser);
    }
}
