package com.example.DV.config;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User user = super.loadUser(userRequest);
        System.out.println("Google 사용자 정보: " + user.getAttributes());
        // 여기서 사용자 정보를 DB에 저장하거나, 기존 사용자와 매핑하는 로직을 추가할 수 있음
        return user;
    }
}
