package com.example.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 파일
public class TempConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper(); //ObjectMapper는 객체를 JSON으로, JSON을 객체로 만든다.(jackson 라이브러리에서 온다.)
    }

}