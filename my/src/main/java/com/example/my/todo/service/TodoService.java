package com.example.my.todo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.my.todo.entity.TodoEntity;
import com.example.my.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity findByIdx(Integer idx){
        return todoRepository.findByIdx(idx);
    }

    public List<TodoEntity> findByDeleteYn(Character deleteYn){
        return todoRepository.findByDeleteYn(deleteYn);
    }
    public void insert(String content){
        TodoEntity todoEntity = TodoEntity.builder()
                .content(content)
                .doneYn('N')
                .deleteYn('N')
                .createDate(LocalDateTime.now())
                .build();
        todoRepository.insert(todoEntity);
    }
    public void update(Integer idx){
        TodoEntity todoEntity = todoRepository.findByIdx(idx);

        if(todoEntity.getDoneYn().equals('N')){
            todoEntity.setDoneYn('Y');
        }else{
            todoEntity.setDoneYn('N');
        }
        todoEntity.setUpdateDate(LocalDateTime.now());

        todoRepository.update(todoEntity);

    }

    public void delete(Integer idx){
        TodoEntity todoEntity = todoRepository.findByIdx(idx);
        todoEntity.setDeleteYn('Y');
        todoEntity.setDeleteDate(LocalDateTime.now());

        todoRepository.update(todoEntity);
    }


}
