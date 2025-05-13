// TODO: JwtUtil 주석 해제 후 로직 구현

//package com.recap.global.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@RequiredArgsConstructor
//@Slf4j
//public class JwtFilter extends OncePerRequestFilter {
//
//    private final JwtUtil jwtUtil; // TODO: JwtUtil 주입
//    private final UserDetailsService userDetailsService; // TODO: 사용자 정보 로딩에 사용
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        // TODO: Authorization 헤더에서 토큰 추출
//        // TODO: 토큰 유효성 검사
//        // TODO: 사용자 이메일 추출
//        // TODO: UserDetailsService로 사용자 정보 조회
//        // TODO: UsernamePasswordAuthenticationToken 생성 후 SecurityContext에 저장
//
//        filterChain.doFilter(request, response); // 다음 필터 실행
//    }
//}ㅋㅗ