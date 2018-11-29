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

import lombok.extern.slf4j.Slf4j;

/**
 * Zuul回退机制处理器
 */
@Component
@Slf4j
public class ZuulFallBack implements FallbackProvider {

	/* 返回值表示需要针对此微服务做回退处理（该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称）
	 * 如果需要所有调用都支持回退，则return "*"或return null
	 */
	@Override
	public String getRoute() {
		return null;
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {

			/* 微服务出现宕机后，客户端再请求时候就会返回 fallback 等字样的字符串提示
			 * 如果请求用户服务失败，返回什么信息给消费者客户端
			 */
			@Override
			public InputStream getBody() throws IOException {
				log.error("route:"+route, cause);

                JSONObject json =new JSONObject();
                json.put("code","9999");
                json.put("message","gateway服务调用失败:"+route);
                return new ByteArrayInputStream(json.toJSONString().getBytes("UTF-8"));
			}

			@Override
			public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
			}

			/* 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的
			 * 不应该把api的404,500等问题抛给客户端
			 * 网关和api服务集群对于客户端来说是黑盒子
			 */
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
