//package com.spatome.demo.test.controller.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient(name="DEMO-ACCOUNT", fallback=AccountClientFallBack.class)
//public interface AccountClient {
//
//	@PostMapping(value="/api/v1/addAmount")
//	public Object addAmount(
//			@RequestParam(value="accountNo", required=true) 
//			String accountNo,
//			@RequestParam(value="amount", required=true)
//			String amount
//			);
//
//}
