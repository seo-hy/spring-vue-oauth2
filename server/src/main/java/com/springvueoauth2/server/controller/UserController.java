package com.springvueoauth2.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "User", tags = {"User"})
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  @SneakyThrows
  @ApiOperation("일반 사용자 등록")
  @PostMapping("/user/add")
  public ResponseEntity addUser() {
    return null;
  }

  @SneakyThrows
  @ApiOperation("일반 관리자 등록")
  @PostMapping("/admin/add")
  public ResponseEntity addAdmin() {
    return null;
  }

}
