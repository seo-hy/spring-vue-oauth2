package com.springvueoauth2.server.security;

import com.springvueoauth2.server.model.Role;
import com.springvueoauth2.server.model.User;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OAuthAttribute {

  private Long id;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;
  private OAuthProvider provider;
  private String uniqueId;
  private Map<String, Object> attributes;

  public static OAuthAttribute of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {

    // kakao
    if (OAuthConsts.KAKAO.equals(registrationId)) {
      return ofKakao(userNameAttributeName, attributes, OAuthProvider.kakao);
    }
    // google
    return ofGoogle(userNameAttributeName, attributes, OAuthProvider.google);
  }

  private static OAuthAttribute ofGoogle(String userNameAttributeName,
      Map<String, Object> attributes, OAuthProvider oAuthProvider) {
    return OAuthAttribute.builder()
        .name((String) attributes.get("name"))
        .email((String) attributes.get("email"))
        .picture((String) attributes.get("picture"))
        .attributes(attributes)
        .provider(oAuthProvider)
        .nameAttributeKey(userNameAttributeName)
        .id((Long) attributes.get(userNameAttributeName))
        .uniqueId(String.format("%s%s", oAuthProvider.getValue(),
            (String) attributes.get(userNameAttributeName)))
        .build();
  }

  private static OAuthAttribute ofKakao(String userNameAttributeName,
      Map<String, Object> attributes, OAuthProvider oAuthProvider) {
    Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
    Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");

    return OAuthAttribute.builder()
        .name((String) kakaoProfile.get("nickname"))
        .email((String) kakaoAccount.get("email"))
        .picture((String) kakaoProfile.get("profile_image_url"))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .provider(oAuthProvider)
        .id((Long) attributes.get(userNameAttributeName))
        .uniqueId(String.format("%s%s", oAuthProvider.getValue(),
            (String) attributes.get(userNameAttributeName)))
        .build();
  }


  public User toEntity() {
    return User.builder()
        .loginId(this.uniqueId)
        .name(this.name)
        .email(this.email)
        .password(OAuthConsts.OAUTH_PASSWORD_ENCODE)
        .imagePath(this.picture)
        .role(Role.USER)
        .provider(this.provider.getValue())
        .build();
  }
}
