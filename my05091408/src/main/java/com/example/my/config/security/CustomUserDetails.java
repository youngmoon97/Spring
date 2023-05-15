package com.example.my.config.security;

import com.example.my.module.user.entity.UserEntity;
import com.example.my.module.user.entity.UserRoleEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 스프링 시큐리티에서 사용하는 유저 정보 저장소 => UserDetails
// JSP의 Session 대용
@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {

    // UserDetails에 UserEntity를 넣어 놓으면
    // 컨트롤러나 서비스에서 편하게 사용 가능
    private final UserEntity userEntity;
    private final List<UserRoleEntity> userRoleEntityList;

    //유저가 가진 모든 권한 가져오기
    //유저는 여러가지 권한을 가질 수 있다.
    //카페 개설자 ADMIN
    //이용자 USER
    //댓글을 10번 적어서 새싹회원->열심회원
    //이용자 중에 스태프로 선정됨
    //해당 이용자는 USER, 열심회원, STAFF 셋의 권한을 모두 가짐
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //1. userRoleEntityList에서 role(String)만 가져오기
        //2. role로 GrantedAuthority 객체 만들기
        //3. 리스트에 집어넣기
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        for (UserRoleEntity userRoleEntity: userRoleEntityList) {
            grantedAuthoritiesList.add(new GrantedAuthority() {
                //익명 클래스
                //인터페이스가 구현해 달라고 한 것들만 구현하면 익명 클래스를 만들 수 있다.
                @Override
                public String getAuthority() {
                    //스프링 시큐리티에서는 권한 앞에 ROLE_ 를 붙인다.
                    return "ROLE_" + userRoleEntity.getRole();
                }
            });
        }
        //결과값 리턴
        return grantedAuthoritiesList;
    }

    // 비밀번호 가져오기
    @Override
    public String getPassword() {
        return userEntity.getPw();
    }
    // 아이디 가져오기
    @Override
    public String getUsername() {
        return userEntity.getId();
    }
    // 계정이 만료되지 않았는지 체크
    @Override
    public boolean isAccountNonExpired() {
        // 만료될 서비스가 아니라서 true
        return true;
    }
    // 계정이
    @Override
    public boolean isAccountNonLocked() {
            return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //  세션 방식이라 true
        return true;
    }
    // 일시정지
    @Override
    public boolean isEnabled() {
        // 일시정지, 신고
        return true;
    }
}
