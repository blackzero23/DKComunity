package com.dokyun.DKComunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

@Configuration
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        //TODO: 스프링 인증 기능 전까지 사용
        return () -> Optional.of(UUID.randomUUID().toString());
    }
}
