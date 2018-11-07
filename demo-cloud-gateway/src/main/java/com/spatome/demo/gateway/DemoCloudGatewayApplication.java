package com.spatome.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan("com.spatome.demo")
public class DemoCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudGatewayApplication.class, args);
	}
}
