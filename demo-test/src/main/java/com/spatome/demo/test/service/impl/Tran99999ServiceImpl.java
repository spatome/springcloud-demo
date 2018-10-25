package com.spatome.demo.test.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Account;
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
		LOGGER.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		paramMap.put("amount", amount);
		super.checkNotEmpty(paramMap);

		LOGGER.debug("===========================业务处理=========================");
		BigDecimal amt = new BigDecimal(amount);

		Account account = daoFactory.getAccountMapper().selectByAccountNo(enterpriseNo);
		result.setBody(account);
		
		return result;
	}
}
