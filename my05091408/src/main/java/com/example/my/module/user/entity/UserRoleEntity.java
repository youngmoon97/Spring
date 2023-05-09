package com.example.my.module.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity {
    private Integer idx;
    private Integer userIdx;
    private String role;
    private LocalDateTime createDate;
}
