//package com.spatome.demo.auth.filter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class JwtUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    // 是否开启验证码功能
//	//private boolean isOpenValidateCode = true;
//	//public static final String VALIDATE_CODE = "validateCode";
//
//	//private final ObjectMapper OM;
//
//	protected JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authManager) {
//		super(new AntPathRequestMatcher("/user/login", "POST"));
//        setAuthenticationManager(authManager);
//        //OM = new ObjectMapper();
//	}
//
//	//覆盖授权验证方法
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException, IOException, ServletException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println("attemptAuthentication："+username+"  "+password);
//
//		return super.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
//                username, password, Collections.emptyList()));
//	}
//
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//		super.successfulAuthentication(request, response, chain, authResult);
//	}
//
//}
