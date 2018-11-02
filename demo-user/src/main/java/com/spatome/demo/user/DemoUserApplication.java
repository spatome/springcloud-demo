package com.spatome.demo.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.spatome.demo.user")
public class DemoUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserApplication.class, args);
	}
}
