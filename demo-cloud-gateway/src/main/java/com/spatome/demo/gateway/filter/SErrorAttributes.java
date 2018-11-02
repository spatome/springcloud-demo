package com.spatome.demo.gateway.filter;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class SErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);

        result.put("code", "9999");
        result.put("message", result.get("error"));
        result.remove("status");
        result.remove("timestamp");
        result.remove("error");

		return result;
	}

}
