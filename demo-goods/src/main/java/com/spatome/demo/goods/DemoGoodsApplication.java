package com.spatome.demo.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spatome.demo")
@MapperScan("com.spatome.demo.goods.dao")
public class DemoGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGoodsApplication.class, args);
	}
}
