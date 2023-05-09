package com.example.my.module.user.repository;

import com.example.my.module.user.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserRoleRepository {

    UserRoleEntity findByUserIdx(Integer userIdx);
    UserRoleEntity findByUserIdxAndRole(@Param("userIdx") Integer userIdx, @Param("role") String role);
    UserRoleEntity findRoleByUserIdx(Integer userIdx);
    Integer insert(UserRoleEntity userRoleEntity);
}
