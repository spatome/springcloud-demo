package com.spatome.demo.test.controller.client;

import org.springframework.stereotype.Component;

import com.spatome.demo.core.BaseVO;

@Component
public class AccountClientFallBack implements AccountClient {

	@Override
	public Object addAmount(String accountNo, String amount, String sleep) {
		BaseVO<Object> result = new BaseVO<Object>();
		result.setCodeMessage("9999", "哈哈哈，连不上:DEMO-ACCOUNT");
		return result;
	}

	@Override
	public Object subAmount(String accountNo, String amount, String sleep) {
		BaseVO<Object> result = new BaseVO<Object>();
		result.setCodeMessage("9999", "哈哈哈，连不上:DEMO-ACCOUNT");
		return result;
	}

	@Override
	public Object test() {
		BaseVO<Object> result = new BaseVO<Object>();
		result.setCodeMessage("9999", "哈哈哈，连不上:DEMO-ACCOUNT");
		return result;
	}

}
