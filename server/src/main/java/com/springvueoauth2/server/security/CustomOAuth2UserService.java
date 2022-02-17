package com.springvueoauth2.server.security;

import com.springvueoauth2.server.model.User;
import com.springvueoauth2.server.repository.UserRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  private final UserRepository userRepository;

  private final AuthProvider authProvider;


  @Override
  @SneakyThrows
  public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest)
      throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
    OAuthAttribute attribute = OAuthAttribute.of(
        oAuth2UserRequest.getClientRegistration().getRegistrationId(),
        oAuth2UserRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
            .getUserNameAttributeName(),
        oAuth2User.getAttributes()
    );

    User user = this.saveOrUpdate(attribute);

    authProvider.setToken(user.getEmail());

    return new DefaultOAuth2User(
        Collections.singleton(new SimpleGrantedAuthority(user.getRole().getKey())),
        attribute.getAttributes(),
        attribute.getNameAttributeKey());
  }


  private User saveOrUpdate(OAuthAttribute attribute) {

    User user = userRepository.findByEmail(attribute.getEmail())
        .map(entity -> entity.update(attribute.getName(), attribute.getPicture()))
        .orElse(attribute.toEntity());

    return userRepository.save(user);
  }


}