// TODO : UserRepository 작성 후 주석 해제, loadUserByUsername 수정

//package com.recap.global.security;
//
//import com.recap.domain.user.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class CustomUserDetailsService implements UserDetailsService{
//
//    private final UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByUserId(email);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
//
//        return new CustomUserDetails(user);
//    }
//}
