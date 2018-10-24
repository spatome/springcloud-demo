package com.spatome.demo.account.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spatome.demo.account.service.TranService;
import com.spatome.demo.account.service.impl.BaseService;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.util.SUtil;
import com.spatome.demo.core.vo.SSVO;

/** 
 * @Description: account
 * 增加
 */
@Service
public class Tran10100ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		LOGGER.debug("获取参数");
		String accountNo = request.get("accountNo");
		LOGGER.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountNo", accountNo);
		super.checkNotEmpty(paramMap);

		LOGGER.debug("===========================业务处理=========================");
		Account record = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		if(record!=null){
			result.setCodeMessage("9999", "账号已存在");
			return result;
		}

		Account account = new Account();
		account.setAccountNo(accountNo);
		account.setStatus("ON");
		daoFactory.getAccountMapper().insertSelective(account);

		result.setBody(new SSVO(SUtil.NTS(account.getId())));

		return result;
	}
}
