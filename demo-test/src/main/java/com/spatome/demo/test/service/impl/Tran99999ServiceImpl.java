package com.spatome.demo.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.test.service.TranService;

/** 
 * @Description: 测试
 */
@Service
public class Tran99999ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		LOGGER.debug("获取参数");
		String enterpriseNo = request.get("enterpriseNo");
		String amount = request.get("amount");
		String sleep = request.get("sleep");
		LOGGER.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		paramMap.put("amount", amount);
		super.checkNotEmpty(paramMap);

		LOGGER.debug("===========================业务处理=========================");
		this.test(result, enterpriseNo, amount, sleep);
		
		return result;
	}

	private void test(BaseVO<Object> result, String enterpriseNo, String amount, String sleep){
		 Map map = (Map)serviceFactory.getAccountClient().addAmount(enterpriseNo, amount, sleep);
		 LOGGER.info(map.get("code").toString());
		 LOGGER.info(map.get("message").toString());
		 Map map1 = (Map)map.get("body");
		 LOGGER.info(map1.get("value").toString());
		 result.setBody(map);
	}
}
