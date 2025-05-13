// TODO: UserRepository 재작성 후 수정

//package com.recap.global.jwt;
//
//import com.recap.global.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//
//@Component
//@Slf4j
//public class JwtUtil {
//
//    private static final long ACCESS_TOKEN_EXPIRE_TIME = 10 * 60 * 1000; // TODO: 액세스 토큰 만료 시간 설정
//    private static final long REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 1000; // TODO: 리프레시 토큰 만료 시간 설정
//
//    private SecretKey secretKey; // TODO: 서명용 시크릿 키
//    private final UserRepository userRepository; // TODO: 사용자 정보 조회용 리포지토리
//
//    public JwtUtil(@Value("${jwt.secret}") String secret, UserRepository userRepository) {
//        // TODO: secret 기반 SecretKey 생성
//        this.userRepository = userRepository;
//    }
//
//    public String getEmail(String token) {
//        // TODO: 토큰에서 이메일 클레임 추출
//        return null;
//    }
//
//    public String getCategory(String token) {
//        // TODO: 토큰에서 카테고리 클레임 추출
//        return null;
//    }
//
//    public Boolean isExpired(String token) {
//        // TODO: 토큰 만료 여부 확인
//        return null;
//    }
//
//    public String createAccess(String email) {
//        // TODO: 액세스 토큰 생성
//        return null;
//    }
//
//    public String createRefresh(String email) {
//        // TODO: 리프레시 토큰 생성
//        return null;
//    }
//
//    public Authentication getAuthentication(String token) {
//        // TODO: 사용자 정보로부터 Authentication 객체 생성
//        return null;
//    }
//
//    public String reIssueToken(String refreshToken) {
//        // TODO: 리프레시 토큰 유효 시 새 액세스 토큰 재발급
//        return null;
//    }
//}