package com.example.DV.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

public class DotenvPropertyLoader implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .directory("./")  // .env 파일이 위치한 디렉토리 (애플리케이션 루트)
                    .ignoreIfMissing()  // .env 파일이 없으면 무시
                    .load();

            dotenv.entries().forEach(entry -> {
                // System 속성에 등록 (Spring Boot에서 우선순위가 높아짐)
                System.setProperty(entry.getKey(), entry.getValue());
            });
        } catch (Exception e) {
            // 로드 실패 시 로깅
            System.err.println("Failed to load .env file: " + e.getMessage());
        }
    }
}
