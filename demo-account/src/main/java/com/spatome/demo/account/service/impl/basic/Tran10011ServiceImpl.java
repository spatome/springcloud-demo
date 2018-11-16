package com.spatome.demo.account.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.account.service.impl.BaseService;
import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Account;
import com.spatome.demo.core.service.TranService;

import lombok.extern.slf4j.Slf4j;

/** 
 * 增删查改
 * @Description: account
 * 删除/激活
 */
@Service
@Slf4j
public class Tran10011ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		//获取参数
		String accountNo = inMap.get("accountNo");
		String status = inMap.get("status");		//ON OFF
		//检查参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountNo", accountNo);
		paramMap.put("status", status);
		super.checkNotEmpty(paramMap);

		//===========================业务处理=========================
		switch (status) {
		case "ON":
			break;
		case "OFF":
			break;
		default:
			result.setCodeMessage("9999", "未定义状态");
			return result;
		}

		Account record = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		if(record==null){
			result.setCodeMessage("9999", "账号不存在");
			return result;
		}
		if(record.getStatus().equals(status)){
			return result;
		}

		Account updateRecord = new Account();
		updateRecord.setId(record.getId());
		updateRecord.setStatus(status);
		daoFactory.getAccountMapper().updateByPrimaryKeySelective(updateRecord);
		log.debug("==>account{{}}修改状态{{}}", accountNo, status);

		return result;
	}
}
