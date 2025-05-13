// TODO: UserRepository 작성 후 주석 해제, loadUserByUsername 수정

//package com.recap.global.security;
//
//import com.recap.domain.user.repository.UserRepository;
//import com.recap.global.security.CustomUserDetails;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository; // TODO: 유저 조회용 리포지토리 주입
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // TODO: email을 기준으로 유저 조회
//        // TODO: 조회 실패 시 UsernameNotFoundException 던지기
//        // TODO: 성공 시 CustomUserDetails 객체로 래핑하여 반환
//        return null;
//    }
//}