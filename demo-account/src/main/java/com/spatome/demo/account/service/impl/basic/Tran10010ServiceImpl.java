package com.spatome.demo.account.service.impl.basic;

import java.util.Date;
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
import com.spatome.demo.core.util.SUtil;
import com.spatome.demo.core.vo.SSVO;

import lombok.extern.slf4j.Slf4j;

/** 
 * 增删查改
 * @Description: account
 * 增加
 */
@Service
@Slf4j
public class Tran10010ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		//获取参数
		String accountNo = inMap.get("accountNo");
		//检查参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("accountNo", accountNo);
		super.checkNotEmpty(paramMap);

		//===========================业务处理=========================
		Account record = daoFactory.getAccountMapper().selectByAccountNo(accountNo);
		if(record!=null){
			result.setCodeMessage("9999", "账号已存在");
			return result;
		}

		Account newRecord = new Account();
		newRecord.setStatus("ON");
		newRecord.setCreateTime(new Date());
		newRecord.setUpdateTime(new Date());
		newRecord.setAccountNo(accountNo);
		daoFactory.getAccountMapper().insertSelective(newRecord);
		log.debug("==>增加account:"+accountNo);

		result.setBody(new SSVO(SUtil.NTS(newRecord.getId())));

		return result;
	}
}
