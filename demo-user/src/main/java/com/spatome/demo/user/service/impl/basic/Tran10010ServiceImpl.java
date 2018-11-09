package com.spatome.demo.user.service.impl.basic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Enterprise;
import com.spatome.demo.core.service.TranService;
import com.spatome.demo.core.util.SUtil;
import com.spatome.demo.core.vo.SSVO;
import com.spatome.demo.user.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: account
 * 增加
 */
@Service
@Slf4j
public class Tran10010ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		log.debug("获取参数");
		String enterpriseNo = inMap.get("enterpriseNo");
		String enterpriseName = inMap.get("enterpriseName");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		paramMap.put("enterpriseName", enterpriseName);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		Enterprise newEnterprise = new Enterprise();
		newEnterprise.setCreateTime(new Date());
		newEnterprise.setUpdateTime(new Date());
		newEnterprise.setEnterpriseNo(enterpriseNo);
		newEnterprise.setEnterpriseName(enterpriseName);
		newEnterprise.setStatus("ON");
		daoFactory.getEnterpriseMapper().insertSelective(newEnterprise);

		result.setBody(new SSVO(SUtil.NTS(newEnterprise.getId())));

		return result;
	}

}
