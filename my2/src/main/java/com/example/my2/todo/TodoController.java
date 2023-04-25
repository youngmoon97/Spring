package com.example.my2.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping
    @ResponseBody
    public String hello(){
        return todoRepository.hello();
    }

    @GetMapping("/todoList")
    public String todoList(){
        return "todoList";
    }
}
