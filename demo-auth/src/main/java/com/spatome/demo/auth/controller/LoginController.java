package com.spatome.demo.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.util.security.JwtUtil;
import com.spatome.demo.core.vo.SSVO;

@RestController
@RequestMapping(value = "")
public class LoginController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseVO<Object> result = new BaseVO<Object>();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(userName.equals(password)){
			Map<String, Object> map = new HashMap<String, Object>();
			if(userName.length()>10){
				map.put("role", "USER");
			}else{
				map.put("role", "ADMIN");
			}

			String token = JwtUtil.buildJwt(userName, map, 0l);
			result.setBody(new SSVO(token));
		}else{
			result.setCodeMessage("9999", "密码错误");
		}

		return result;
	}
}
