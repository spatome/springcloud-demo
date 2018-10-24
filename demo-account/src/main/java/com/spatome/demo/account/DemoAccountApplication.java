package com.spatome.demo.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spatome.demo.account.dao")
public class DemoAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAccountApplication.class, args);
	}
}
