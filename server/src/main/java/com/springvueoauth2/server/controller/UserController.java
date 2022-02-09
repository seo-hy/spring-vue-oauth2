package com.springvueoauth2.server.controller;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "User", tags = {"User"})
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private final UserService service;

  @SneakyThrows
  @ApiOperation("일반 사용자 등록")
  @PostMapping("/user")
  public ResponseEntity addUser(@RequestBody UserForm.Input.Add in) {
    return new ResponseEntity(service.addUser(in), null, HttpStatus.CREATED);
  }

  @SneakyThrows
  @ApiOperation("일반 관리자 등록")
  @PostMapping("/admin")
  public ResponseEntity addAdmin(@RequestBody UserForm.Input.Add in) {
    return null;
  }

  @SneakyThrows
  @ApiOperation("일반 사용자 목록 조회")
  @GetMapping("/user")
  public ResponseEntity getAll() {
    return new ResponseEntity(service.getAll(), null, HttpStatus.OK);
  }

}
