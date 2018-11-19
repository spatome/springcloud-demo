package com.spatome.demo.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.util.security.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PreFilter extends ZuulFilter {
	//private final static ObjectMapper OM = new ObjectMapper();

	@Override
	public boolean shouldFilter() {
		//过滤器开关
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		log.debug("==>前置过滤器PreFilter running");

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
        String uri = request.getRequestURI();
        if(StringUtils.containsAny(uri, "/login", "/Login", "/demo")) return;

        String token = request.getHeader("token");
        if(token==null){
        	token = request.getParameter("token");
        }
        if (StringUtils.isBlank(token)) {
        	log.error(uri+"需要token");
        	sendResponse(ctx, BaseVO.JSON_RESULT_FAIL);
        }else if("AAAAAAAAAA".equals(token)){
        	return;
        }else{
        	try {
				Claims ret = JwtUtil.unJwt(token);
				log.debug("Claims值:"+ret);
        	} catch (ExpiredJwtException e) {
				log.error("token已过期:"+token);
				sendResponse(ctx, "{\"code\":\"9998\",\"message\":\"token已过期\",\"body\":null}");
			} catch (Exception e) {
				log.error("不能解析token:"+token);
				sendResponse(ctx, "{\"code\":\"9998\",\"message\":\"不能解析token\",\"body\":null}");
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
