package com.spatome.demo.account.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spatome.demo.account.service.TranService;
import com.spatome.demo.account.service.impl.BaseService;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.vo.SSVO;

/** 
 * @Description: account
 * 修改
 */
@Service
public class Tran10120ServiceImpl extends BaseService implements TranService {

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
		if(record==null){
			result.setCodeMessage("9999", "账号不存在");
			return result;
		}

		Account accountUpdate = new Account();
		accountUpdate.setId(record.getId());
		daoFactory.getAccountMapper().updateByPrimaryKeySelective(accountUpdate);

		return result;
	}
}
