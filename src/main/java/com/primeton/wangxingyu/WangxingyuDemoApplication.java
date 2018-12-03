package com.primeton.wangxingyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class WangxingyuDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(WangxingyuDemoApplication.class, args);
	}
}
