package com.spatome.demo.test.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DEMO-ACCOUNT", fallback=AccountClientFallBack.class)
public interface AccountClient {

	@GetMapping(value="/demo/test")
	public Object test();

	@PostMapping(value="/process/10128")
	public Object addAmount(
			@RequestParam(value="accountNo", required=true) 
			String accountNo,
			@RequestParam(value="amount", required=true)
			String amount,
			@RequestParam(value="sleep", required=false)
			String sleep
			);

	@PostMapping(value="/process/10129")
	public Object subAmount(
			@RequestParam(value="accountNo", required=true) 
			String accountNo,
			@RequestParam(value="amount", required=true)
			String amount,
			@RequestParam(value="sleep", required=false)
			String sleep
			);
}
