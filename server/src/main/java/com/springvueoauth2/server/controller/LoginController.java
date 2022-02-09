package com.springvueoauth2.server.controller;

import com.springvueoauth2.server.form.LoginForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "Login", tags = {"Login"})
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

  @SneakyThrows
  @ApiOperation("로그인 토큰 발급")
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginForm.Input.Login in) {
    return null;
  }

}
