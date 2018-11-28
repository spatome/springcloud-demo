package com.spatome.demo.tmp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "spatome")
@Getter
@Setter
public class SpatomeConfig {

	private String userName;

}
