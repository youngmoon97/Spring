package com.example.my.module.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/join")
    public String getJoinPage(){
        return "join";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
