package com.spatome.demo.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.core.BaseVO;

@RestController
@RequestMapping(value = "/demo")
public class DemoController extends BaseController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Object test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		LOGGER.info("端口："+request.getLocalPort());

		return result;
	}
}
