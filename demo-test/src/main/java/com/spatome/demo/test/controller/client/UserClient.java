package com.spatome.demo.test.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="DEMO-USER", fallback=UserClientFallBack.class)
public interface UserClient {

	@PostMapping(value="/process/10013")
	public Object queryEnterpriseById(
			@RequestParam(value="enterpriseId", required=true)
			String enterpriseId
			);

}
