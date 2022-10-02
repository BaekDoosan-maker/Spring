package com.sparta.week4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
@SpringBootApplication // 스프링 부트임을 선언합니다.
public class Week4Application {
    public static void main(String[] args) {
        SpringApplication.run(Week4Application.class, args);
    }
}
