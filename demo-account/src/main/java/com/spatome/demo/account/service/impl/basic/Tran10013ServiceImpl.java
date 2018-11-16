package com.spatome.demo.account.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.account.service.impl.BaseService;
import com.spatome.demo.account.vo.AccountVO;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.service.TranService;

/** 
 * 增删查改
 * @Description: account
 * 查
 */
@Service
public class Tran10013ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();
		AccountVO VO = new AccountVO();
		result.setBody(VO);

		//获取参数
		String accountNo = inMap.get("accountNo");
		//检查参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountNo", accountNo);
		super.checkNotEmpty(paramMap);

		//===========================业务处理=========================
		Account record = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		if(record==null){
			result.setCodeMessage("9999", "账号不存在");
			return result;
		}

		VO.setAccountId(record.getId());
		VO.setAccountNo(record.getAccountNo());
		VO.setCurrentAmount(record.getCurrentAmount().toPlainString());

		return result;
	}
}
