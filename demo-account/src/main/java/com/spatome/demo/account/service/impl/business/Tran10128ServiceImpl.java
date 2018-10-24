package com.spatome.demo.account.service.impl.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.account.service.TranService;
import com.spatome.demo.account.service.impl.BaseService;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.vo.SSVO;

/** 
 * @Description: account
 * 加钱
 */
@Service
@Transactional
public class Tran10128ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		LOGGER.debug("获取参数");
		String accountNo = request.get("accountNo");
		String amount = request.get("amount");
		String sleep = request.get("sleep");
		LOGGER.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountNo", accountNo);
		paramMap.put("amount", amount);
		super.checkNotEmpty(paramMap);

		LOGGER.debug("===========================业务处理=========================");
		BigDecimal amt = new BigDecimal(amount);

		if(StringUtils.isNotBlank(sleep)){
			try {
				Thread.sleep(new Long(sleep).longValue());
			} catch (InterruptedException e) {
			}			
		}

		BigDecimal ret = serviceFactory.getAccountService().addAmount(accountNo, amt);
		result.setBody(new SSVO(ret.toPlainString()));

		return result;
	}
}
