package com.springvueoauth2.server.config;

import com.springvueoauth2.server.security.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class SecurityResourceConfig extends ResourceServerConfigurerAdapter {

  private final OAuth2AuthenticationSuccessHandler successHandler;

  private final CustomOAuth2UserService customOAuth2UserService;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.anonymous().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(new OAuth2AccessDeniedHandler())
        .and()
        .logout()
        .and()
        .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService).and()
        .successHandler(successHandler);
  }

}
