package com.recap.oauth2.service;

import com.recap.domain.user.entity.User;
import com.recap.domain.user.repository.UserRepository;
import com.recap.oauth2.exception.OAuth2AuthenticationProcessingException;
import com.recap.oauth2.user.OAuth2UserInfo;
import com.recap.oauth2.user.OAuth2UserInfoFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private OAuth2UserRequest oAuth2UserRequest;
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationProcessingException {
        this.oAuth2UserRequest = oAuth2UserRequest;

        log.info("loadUser is called");

        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {

        log.info("processOAuth2User is called");

        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId();

        log.info("registrationId : {}", registrationId);

        String accessToken = userRequest.getAccessToken().getTokenValue();


        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId,
                accessToken,
                oAuth2User.getAttributes());

        if (!StringUtils.hasText(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<User> existingUser = userRepository.findById(1L);

        if (existingUser.isEmpty()){
            User user = User.builder()
                    .name(oAuth2UserInfo.getName())
                    .userId(oAuth2UserInfo.getEmail())
                    .build();
            userRepository.save(user);
        }
        return new OAuth2UserPrincipal(oAuth2UserInfo);
    }
}