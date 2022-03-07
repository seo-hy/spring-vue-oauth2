package com.springvueoauth2.server.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserForm {

  public static class Input {

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add {

      @ApiModelProperty(value = "아이디")
      private String loginId;

      @ApiModelProperty(value = "이름")
      private String name;

      @ApiModelProperty(value = "비밀번호")
      private String password;

      @ApiModelProperty(value = "이메일")
      private String email;

      @ApiModelProperty(value = "휴대폰번호")
      private String phone;

    }

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Modify {

      @ApiModelProperty(value = "이름")
      private String name;

      @ApiModelProperty(value = "비밀번호")
      private String password;

      @ApiModelProperty(value = "이메일")
      private String email;

      @ApiModelProperty(value = "휴대폰번호")
      private String phone;

    }
  }

  public static class Output {

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Get {

      @ApiModelProperty(value = "아이디")
      private String loginId;

      @ApiModelProperty(value = "이름")
      private String name;

      @ApiModelProperty(value = "이메일")
      private String email;

      @ApiModelProperty(value = "휴대폰번호")
      private String phone;

      @ApiModelProperty(value = "권한")
      private String role;


    }
  }

}
