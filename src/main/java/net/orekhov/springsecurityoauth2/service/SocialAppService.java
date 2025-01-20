package net.orekhov.springsecurityoauth2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SocialAppService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger logger = LoggerFactory.getLogger(SocialAppService.class);

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User user = delegate.loadUser(userRequest);

        logger.info("User {} logged in successfully.", (Object) user.getAttribute("email"));


        // Логика назначения роли или сохранения пользователя в базе
        return user;
    }
}

