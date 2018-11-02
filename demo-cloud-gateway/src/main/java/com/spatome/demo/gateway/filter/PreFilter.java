package com.spatome.demo.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.util.security.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class PreFilter extends ZuulFilter {
	private final static Logger LOGGER = LoggerFactory.getLogger(ZuulFilter.class);

	ObjectMapper OM = new ObjectMapper();
	
	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("===================pre==================");
		checkToken();

		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	private void checkToken(){
		RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();
        if(StringUtils.containsAny(request.getRequestURI(), "login", "Login")) return;

        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
        	sendResponse(ctx, BaseVO.JSON_RESULT_FAIL);
        }else if("A".equals(token)){
        	return;
        }else{
        	try {
				Claims ret = JwtUtil.unJwt(token);
				System.out.println("Claims值:"+ret);
			} catch (Exception e) {
				LOGGER.error("不能解析token:"+token);
				sendResponse(ctx, "{\"code\":\"9999\",\"message\":\"不能解析token\",\"body\":null}");
			}
        }
	}

	private void sendResponse(RequestContext ctx, String returnJson){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(200);
        ctx.addZuulResponseHeader("content-type","application/json;charset=utf-8");
        ctx.setResponseBody(returnJson);
	}
}
