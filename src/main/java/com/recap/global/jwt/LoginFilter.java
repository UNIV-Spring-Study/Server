// TODO: JwtUtil 문제 해결 후 주석 해제

//package com.recap.global.jwt;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.recap.global.repository.UserRepository;
//import com.recap.global.security.CustomUserDetails;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import java.io.IOException;
//
//@Slf4j
//public class LoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final JwtUtil jwtUtil; // TODO: JwtUtil 주입
//    private final CookieUtil cookieUtil; // TODO: 쿠키 유틸 주입
//    private final UserRepository userRepository; // TODO: 사용자 조회용 레포지토리
//
//    public LoginFilter(AuthenticationManager authenticationManager,
//                       JwtUtil jwtUtil,
//                       CookieUtil cookieUtil,
//                       UserRepository userRepository) {
//        this.jwtUtil = jwtUtil;
//        this.cookieUtil = cookieUtil;
//        this.userRepository = userRepository;
//        super.setAuthenticationManager(authenticationManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException {
//        // TODO: 요청 바디에서 로그인 정보(email, password) 파싱
//        // TODO: 해당 이메일로 DB 조회 및 소셜 로그인 여부 확인
//        // TODO: UsernamePasswordAuthenticationToken 생성 및 인증 시도
//        return null;
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authentication)
//            throws IOException, ServletException {
//        // TODO: 인증 성공 시 사용자 정보로 JWT 토큰 생성
//        // TODO: 응답 헤더 및 쿠키에 토큰 추가
//        // TODO: 응답 상태 코드 설정
//    }
//}