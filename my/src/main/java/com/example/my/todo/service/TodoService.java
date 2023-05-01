package com.example.my.todo.service;

import com.example.my.todo.entity.TodoEntity;
import com.example.my.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    //재료를 받아 상품 만들어서 컨트롤러에게
    private final TodoRepository todoRepository;


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
