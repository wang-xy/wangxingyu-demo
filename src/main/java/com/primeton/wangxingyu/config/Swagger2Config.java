package com.primeton.wangxingyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

	// 配置扫描包路径
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.primeton")).paths(PathSelectors.any()).build();
	}

	// 配置信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("用户微服务 API 文档").contact(new Contact("wangxy", "", "wangxy@primeton.com"))
				.description("用户管理微服务,具有用户登录、用户管理、组织管理等功能。").build();
	}
}
