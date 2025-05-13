//package com.recap.global.security;
//
//import com.recap.domain.user.entity.User;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@RequiredArgsConstructor
//@Slf4j
//public class CustomUserDetails implements UserDetails {
//
//    private final User user; // TODO: 사용자 도메인 엔티티 주입
//
//    public String getEmail() {
//        // TODO: 사용자 이메일 반환
//        return null;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // TODO: 권한 목록 반환
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        // TODO: 사용자 비밀번호 반환
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        // TODO: 사용자 이름 반환
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        // TODO: 계정 만료 여부 반환
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        // TODO: 계정 잠김 여부 반환
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        // TODO: 비밀번호 만료 여부 반환
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        // TODO: 계정 활성화 여부 반환
//        return false;
//    }
//}