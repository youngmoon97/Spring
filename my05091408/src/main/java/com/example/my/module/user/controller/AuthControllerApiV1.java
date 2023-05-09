package com.example.my.module.user.controller;

import com.example.my.module.user.dto.AuthDTO;
import com.example.my.module.user.service.AuthServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

    private final AuthServiceApiV1 authServiceApiV1;
    @PostMapping("/join")
    public HttpEntity<?> joinProc(@Validated @RequestBody AuthDTO.ReqJoin reqDto){


        return authServiceApiV1.joinProc(reqDto);
    }
}
