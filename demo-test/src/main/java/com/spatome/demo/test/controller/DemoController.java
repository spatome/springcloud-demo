package com.spatome.demo.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.core.BaseVO;

@RestController
@RequestMapping(value = "/demo")
//@RefreshScope
public class DemoController extends BaseController {

	@Value("${jdbc_url}")
	String jdbcUrl;
	@Value("${jdbc_username}")
	String jdbcUsername;
	@Value("${jdbc_password}")
	String jdbcPassword;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		System.out.println("1:"+request.getRequestURL());
		
		result.setBody(String.format("url{%s},username{%s},password{%s}", jdbcUrl, jdbcUsername, jdbcPassword));

		return result;
	}
}
