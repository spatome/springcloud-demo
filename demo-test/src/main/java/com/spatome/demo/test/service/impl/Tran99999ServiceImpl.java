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
public class Tran99999ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		log.debug("获取参数");
		String enterpriseId = inMap.get("enterpriseId");
		String enterpriseNo = inMap.get("enterpriseNo");
		String amount = inMap.get("amount");
		String sleep = inMap.get("sleep");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		Map map = (Map)serviceFactory.getUserClient().queryEnterpriseByNo(enterpriseNo);

		result.setBody(map);

		return result;
	}
}
