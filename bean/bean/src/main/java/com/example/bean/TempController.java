package com.example.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TempController {

    @Autowired
    private TempComponent tempComponent;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Robot robot;

    @ResponseBody
    @GetMapping
    public String tempRobot(){
        System.out.println(robot.arm.name);
        return "ㅎㅇ";
    }


//    @ResponseBody
//    @GetMapping
//    public String temp() throws JsonProcessingException {
//        String writeValueAsString = objectMapper.writeValueAsString(new ArrayList<>());
//        tempComponent.print();
//        System.out.println(writeValueAsString);
//        return "안녕하세요 ";
//    }
}
