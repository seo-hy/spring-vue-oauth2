package com.springvueoauth2.server.security;

import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Component;

@Component
public class AuthTokenProvider implements InitializingBean {

  private final TokenEndpoint tokenEndpoint;

  public AuthTokenProvider(@Lazy TokenEndpoint tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
  }

  private String accessToken;

  @SneakyThrows
  public void setToken(String email) {
    Map<String, String> map = new HashMap<>();
    map.put("username", email);
    map.put("password", OAuthConsts.OAUTH_PASSWORD_DECODE);
    map.put("grant_type", "password");

    this.accessToken = String.valueOf(tokenEndpoint.postAccessToken(
        new UsernamePasswordAuthenticationToken(OAuthConsts.OAUTH_CLIENT_ID, null, null), map
    ).getBody());
  }

  public String getToken() {
    return this.accessToken;
  }


  @Override
  public void afterPropertiesSet() throws Exception {

  }
}
