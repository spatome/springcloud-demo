package com.spatome.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableConfigServer
public class DemoCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudConfigApplication.class, args);
	}

    @Configuration
    public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();
        	super.configure(http);
        }
    }
}
