package com.spatome.demo.auth.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spatome.demo.core.BaseVO;

public interface AuthService {

	public BaseVO<?> userLogin(HttpServletRequest request, HttpServletResponse response);

}
