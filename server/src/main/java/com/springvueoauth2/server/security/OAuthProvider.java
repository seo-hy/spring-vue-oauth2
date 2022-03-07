package com.springvueoauth2.server.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OAuthProvider {
  google("google"),
  nave("naver"),
  kakao("kakao");


  private final String value;
}

