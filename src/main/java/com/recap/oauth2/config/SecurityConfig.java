package com.recap.oauth2.config;

import com.recap.domain.user.repository.UserRepository;
import com.recap.global.jwt.CookieUtil;
import com.recap.global.jwt.JwtFilter;
import com.recap.global.jwt.JwtUtil;
import com.recap.global.jwt.LoginFilter;
import com.recap.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.recap.oauth2.handler.OAuth2AuthenticationFailureHandler;
import com.recap.oauth2.handler.OAuth2AuthenticationSuccessHandler;
import com.recap.oauth2.service.CustomOAuth2UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final CookieUtil cookieUtil;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()
        ); // csrf 공격 방지

        //WebMvcConfig 설정에 따름
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        //FormLogin, BasicHttp 비활성화
        http.formLogin((auth) -> auth.disable());
        http.httpBasic((auth) -> auth.disable());
        http
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\": \"Unauthorized request\"}");
                        })
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/oauth2/**","/login", "/swagger-ui/**",    // Swagger UI 관련 경로
                                "/v3/api-docs/**","/csrf-token", "/posts/**", "/posts", "/universities", "/users").permitAll()
                        .requestMatchers("/task/**").hasAnyRole("MEMBER", "MANAGER", "VIEWER")
                        .anyRequest().authenticated()
                )
                .oauth2Login(configure ->
                        configure.authorizationEndpoint(config -> config.authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository))
                                .userInfoEndpoint(config -> config.userService(customOAuth2UserService))
                                .successHandler(oAuth2AuthenticationSuccessHandler)
                                .failureHandler(oAuth2AuthenticationFailureHandler)
                );

//        http
//                .addFilterAt(new JwtFilter(jwtUtil, userDetailsService), LoginFilter.class)
//                .addFilterBefore(
//                new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, cookieUtil, userRepository),
//                UsernamePasswordAuthenticationFilter.class);

//        http
//                .addFilterAt(new CustomLogoutFilter(jwtUtil), LogoutFilter.class);
        http
                .addFilterBefore(new JwtFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, cookieUtil, userRepository), UsernamePasswordAuthenticationFilter.class);

        // 필터 알맞는 위치 일단 주석으로 추가


        //세션 관리 상태 없음 으로 설정, 서버가 클라이언트의 세션 상태를 유지하지 않음
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception{
        http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("API_USER")
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(new JwtFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173", "http://localhost:63342"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-CSRF-TOKEN"));
        configuration.addExposedHeader("access");
        configuration.addExposedHeader("refresh");
        configuration.setAllowCredentials(true); // 쿠키 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

