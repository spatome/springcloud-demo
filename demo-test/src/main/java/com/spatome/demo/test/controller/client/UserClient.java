//package com.spatome.demo.test.controller.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient(name="DEMO-USER", fallback=UserClientFallBack.class)
//public interface UserClient {
//
//	@PostMapping(value="/api/v1/test")
//	public Object test(
//			@RequestParam(value="userName", required=true) 
//			String userName,
//			@RequestParam(value="count", required=true)
//			String count
//			);
//
//}
