package com.spatome.demo.goods.controller.client;

import org.springframework.stereotype.Component;

import com.spatome.demo.core.BaseVO;

@Component
public class UserClientFallBack implements UserClient {

	@Override
	public BaseVO<Object> queryEnterpriseByNo(String enterpriseId) {
		BaseVO<Object> result = new BaseVO<Object>();
		result.setCodeMessage("9999", "哈哈哈，连不上:DEMO-USER");
		return result;
	}

}
