package com.spatome.demo.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.spatome.demo.auth.dao")
@ComponentScan("com.spatome.demo")
public class DemoAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAuthApplication.class, args);
	}
}
