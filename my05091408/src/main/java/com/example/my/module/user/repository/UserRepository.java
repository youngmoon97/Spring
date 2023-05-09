package com.example.my.module.user.repository;

import com.example.my.module.todo.entity.TodoEntity;
import com.example.my.module.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {

    UserEntity findById(String id);
    List<TodoEntity> findByIdAndDeleteYn(@Param("id") String id, @Param("deleteYn") Character deleteYn);
    Integer insert(UserEntity userEntity);
}
