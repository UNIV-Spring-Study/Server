//package com.recap.global.jwt;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.ResponseCookie;
//import org.springframework.security.web.csrf.CsrfToken;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class CookieUtil {
//
//    private static final int COOKIE_EXPIRE_TIME = 30 * 60; // TODO: 쿠키 만료 시간 설정
//
//    public static Cookie createCookie(String key, String value) {
//        // TODO: HttpOnly, Secure, SameSite 속성 설정 후 쿠키 생성
//        return null;
//    }
//
//    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
//        // TODO: 응답에 쿠키 추가
//    }
//
//    public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
//        // TODO: 요청에서 쿠키 추출
//        return Optional.empty();
//    }
//
//    public ResponseCookie createResponseCookie(String refreshToken){
//        // TODO: ResponseCookie 객체 생성
//        return null;
//    }
//
//    public Cookie createCsrfCookie(HttpServletRequest request, HttpServletResponse response){
//        // TODO: CSRF 토큰 기반 쿠키 생성
//        return null;
//    }
//
//    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
//        // TODO: 요청에서 지정된 이름의 쿠키 삭제 처리
//    }
//
//    public static String serialize(Object object) {
//        // TODO: 객체 직렬화 후 Base64 인코딩
//        return null;
//    }
//
//    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
//        // TODO: 쿠키 값 디코딩 후 역직렬화
//        return null;
//    }
//
//    public static Optional<String> getRefreshTokenFromRequest(HttpServletRequest request) {
//        // TODO: 요청에서 refresh 토큰 쿠키값 가져오기
//        return Optional.empty();
//    }
//}