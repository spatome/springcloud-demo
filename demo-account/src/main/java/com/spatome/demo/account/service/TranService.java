package com.spatome.demo.account.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface TranService {

	public Object execute(Map<String, String> request, HttpServletResponse response);

}
