package com.springvueoauth2.server.config;

import com.springvueoauth2.server.security.AuthProvider;
import com.springvueoauth2.server.security.OAuthConsts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private final AuthProvider authProvider;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    String targetUrl = UriComponentsBuilder.fromUriString(OAuthConsts.REDIRECT_URL)
        .queryParam("token", authProvider.getToken()).build().toUriString();
    getRedirectStrategy().sendRedirect(request, response, targetUrl);
    this.clearAuthenticationAttributes(request);
  }

}
