package com.spatome.demo.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.service.TranService;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: demo-test测试
 */
@Service
@Slf4j
public class Tran99998ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String enterpriseNo = inMap.get("enterpriseNo");
		String amount = inMap.get("amount");
		String sleep = inMap.get("sleep");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		paramMap.put("amount", amount);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		this.test(result, enterpriseNo, amount, sleep);
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	private void test(BaseVO<Object> result, String enterpriseNo, String amount, String sleep){
		 Map map = (Map)serviceFactory.getAccountClient().addAmount(enterpriseNo, amount, sleep);
		 log.info(map.get("code").toString());
		 log.info(map.get("message").toString());
		 Map map1 = (Map)map.get("body");
		 log.info(map1.get("value").toString());
		 result.setBody(map);
	}
}
