package com.spatome.demo.user.service.impl.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Enterprise;
import com.spatome.demo.core.service.TranService;
import com.spatome.demo.user.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: account
 * 增加
 */
@Service
@Slf4j
public class Tran10014ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String enterpriseNos = inMap.get("enterpriseNos");
		String enterpriseNames = inMap.get("enterpriseNames");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNos", enterpriseNos);
		paramMap.put("enterpriseNames", enterpriseNames);
		super.checkNotEmpty(paramMap);

		String[] enterpriseNoArray = enterpriseNos.split(";");
		String[] enterpriseNameArray = enterpriseNames.split(";");

		log.debug("===========================业务处理=========================");
		List<Enterprise> recordList = new ArrayList<Enterprise>();
		Date date = new Date();
		for (int i = 0; i < enterpriseNoArray.length; i++) {
			Enterprise record = new Enterprise();
			record.setCreateTime(date);
			record.setUpdateTime(date);
			record.setStatus("ON");
			record.setEnterpriseNo(enterpriseNoArray[i]);
			record.setEnterpriseName(enterpriseNameArray[i]);
			recordList.add(record);
		}

		if(recordList.size()>0){
			daoFactory.getEnterpriseMapper().batchInsert(recordList);
		}
		
		return result;
	}

}
