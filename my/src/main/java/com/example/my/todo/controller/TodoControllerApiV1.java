package com.example.my.todo.controller;

import com.example.my.common.ResDTO;
import com.example.my.todo.service.TodoServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoControllerApiV1 {

    private final TodoServiceApiV1 todoServiceApiV1;

    @GetMapping
    public ResDTO<?> select(){
        return todoServiceApiV1.findByDeleteYn('N');
    }

    @PostMapping
    public ResDTO<?> insert(@RequestParam String content) {
        return todoServiceApiV1.insert(content);
    }
    @PutMapping
    public ResDTO<?> update(@RequestParam Integer idx) {
        return todoServiceApiV1.update(idx);
    }
    @DeleteMapping
    public ResDTO<?> delete(@RequestParam Integer idx) {
        return todoServiceApiV1.delete(idx);
    }
}
