package com.springvueoauth2.server.config;

import com.springvueoauth2.server.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class SecurityAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

  private final TokenStore tokenStore;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final UserDetailsServiceImpl userDetailsService;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
        .withClient("seohyun")
        .secret(passwordEncoder.encode("seohyun218"))
        .authorizedGrantTypes("password", "refresh_token")
        .scopes("read", "write")
        .accessTokenValiditySeconds(60 * 60)
        .refreshTokenValiditySeconds(60 * 60 * 60)
        .and()
        .withClient("hyun")
        .secret(passwordEncoder.encode("hyun218"))
        .authorizedGrantTypes("password", "refresh_token")
        .scopes("read", "write")
        .accessTokenValiditySeconds(60 * 60 * 60)
        .refreshTokenValiditySeconds(60 * 60 * 60);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore)
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
//        .pathMapping("/oauth/token", "/api/login/get-token");
  }

}
