package com.doit.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
  
  /**
   * Swagger api.
   *
   * @return Docket docket
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.doit.weather"))
        .build();
  }
  
  /**
   * Get Swagger Api Info.
   *
   * @return ApiInfo
   */
  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("Weather Forecast")
        .description(
            "This REST API has been developed for weather forecast.")
        .version("0.0.1")
        .build();
  }
  
  /**
   * addResourceHandlers for Swagger.
   *
   * @param registry registry
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
