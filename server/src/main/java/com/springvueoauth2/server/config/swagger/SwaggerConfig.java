package com.springvueoauth2.server.config.swagger;


import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {

    // Header Authorization
    ParameterBuilder aParameterBuilder = new ParameterBuilder();
    aParameterBuilder.name("Authorization")
        .description("Access Tocken")
        .modelRef(new ModelRef("string"))
        .parameterType("header")
        .required(false)
        .build();

    List<Parameter> aParameters = new ArrayList<>();
    aParameters.add(aParameterBuilder.build());

    Docket docket = new Docket(DocumentationType.SWAGGER_2);
    docket.apiInfo(apiInfo())
        .globalOperationParameters(aParameters)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/api/**"))
        .build();

    int tagOrd = 0;
    docket.tags(
        new Tag("User", "유저 API", ++tagOrd),
        new Tag("Login", "로그인 API", ++tagOrd),
        new Tag("Log", "로그 API", ++tagOrd)
    );
    return docket;
  }

  private static final String INFO_TITLE = "spring-vue-oauth2 REST API";
  private static final String INFO_VERSION = "0.0.1";
  private static final String INFO_DESC = "spring-vue-oauth2 REST API Specification";


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(INFO_TITLE)
        .version(INFO_VERSION)
        .description(INFO_DESC)
        .build();
  }
}
