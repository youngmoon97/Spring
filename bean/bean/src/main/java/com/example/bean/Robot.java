package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Component
public class Robot {

    public Arm arm;
    private Leg leg;

    public Robot(Arm arm, Leg leg) {
        this.arm = arm;
        this.leg = leg;
    }
}
