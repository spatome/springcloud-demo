package com.spatome.demo.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.spatome.demo.account.dao")
@ComponentScan("com.spatome.demo")
public class DemoAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAccountApplication.class, args);
	}
}
