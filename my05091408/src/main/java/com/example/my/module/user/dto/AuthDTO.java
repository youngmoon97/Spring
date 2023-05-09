package com.example.my.module.user.dto;

import com.example.my.module.user.entity.UserEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuthDTO {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReqJoin{
        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 3, message = "아이디는 3자 이상 입력해주세요.")
        private String id;

        @NotBlank(message = "비밀번호를 입력하세요.")
        @Size(min = 3, message = "비밀번호는 3자 이상으로 입력해주세요.")
        private String pw;


        public UserEntity toEntity(PasswordEncoder passwordEncoder){
            return UserEntity.builder()
                    .id(id)
                    .pw(passwordEncoder.encode(pw))
                    .deleteYn('N')
                    .createDate(LocalDateTime.now())
                    .build();
        }

    }
}
