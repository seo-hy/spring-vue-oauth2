package com.springvueoauth2.server.security;

import com.springvueoauth2.server.model.Role;
import com.springvueoauth2.server.model.User;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OAuthAttribute {

  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;

  public OAuthAttribute(Map<String, Object> attributes, String nameAttributeKey, String name,
      String email, String picture) {
    this.attributes = attributes;
    this.nameAttributeKey = nameAttributeKey;
    this.name = name;
    this.email = email;
    this.picture = picture;
  }

  public static OAuthAttribute of(String registrationId, String userNameAttributeName,
      Map<String, Object> attributes) {
    return ofGoogle(userNameAttributeName, attributes);
  }

  private static OAuthAttribute ofGoogle(String userNameAttributeName,
      Map<String, Object> attributes) {
    return OAuthAttribute.builder()
        .name((String) attributes.get("name"))
        .email((String) attributes.get("email"))
        .picture((String) attributes.get("picture"))
        .attributes(attributes)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }


  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .password(OAuthConsts.OAUTH_PASSWORD_ENCODE)
        .imagePath(picture)
        .role(Role.USER)
        .build();
  }
}
