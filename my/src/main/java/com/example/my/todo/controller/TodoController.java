package com.example.my.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.my.todo.entity.TodoEntity;
import com.example.my.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
    // 스프링 IoC 컨테이너에서 서비스를 주입(의존성 주입)
    // 서비스한테 상품받아서 유저한테 제공
    private final TodoService todoService;

    @GetMapping("/todoList")
    public String todoList(Model model) {

        List<TodoEntity> todoList = todoService.findByDeleteYn('N');
        long todoCount = todoList.stream().filter((todoEntity) -> todoEntity.getDoneYn().equals('N')).count();
        
        model.addAttribute("todoList", todoList);
        model.addAttribute("todoCount", todoCount);

        return "todoList";
    }

}
