package com.springvueoauth2.server.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class LoginForm {


  public static class Input {

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login {

      @ApiModelProperty(value = "아이디")
      private String loginId;

      @ApiModelProperty(value = "비밀번호")
      private String password;
    }

  }

}
