package com.spatome.demo.gateway.controller.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class ZuulFallBack implements FallbackProvider {

	@Override
	public String getRoute() {
		return null;
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
                JSONObject json =new JSONObject();
                json.put("code","9999");
                json.put("message","服务调用失败:"+route);
                return new ByteArrayInputStream(json.toJSONString().getBytes("UTF-8"));
			}

			@Override
			public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {
			}
			
		};
	}

}
