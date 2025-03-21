package com.example.DV.config;

import com.example.DV.config.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // OAuth2 로그인 시 사용자 정보를 처리하기 위한 커스텀 서비스
    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (운영 환경에서는 신중히 적용)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                                .loginPage("/login")   // 커스텀 로그인 페이지가 있으면 지정, 없으면 기본 로그인 페이지 사용
                                // OAuth2 로그인 성공 시, CustomOAuth2UserService를 통해 사용자 정보를 처리
                                .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                );
        return http.build();
    }
}
