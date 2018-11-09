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
import com.spatome.demo.core.vo.SSVO;
import com.spatome.demo.user.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: account
 * 增加
 */
@Service
@Slf4j
public class Tran10012ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		log.debug("获取参数");
		String enterpriseId = inMap.get("enterpriseId");
		String enterpriseName = inMap.get("enterpriseName");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseId", enterpriseId);
		paramMap.put("enterpriseName", enterpriseName);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		Enterprise record = daoFactory.getEnterpriseMapper().selectByPrimaryKey(Long.valueOf(enterpriseId));
		if(record==null){
			result.setCodeMessage("9999", "不存在");
			return result;
		}

		Enterprise updateEnterprise = new Enterprise();
		updateEnterprise.setId(record.getId());
		updateEnterprise.setUpdateTime(new Date());
		updateEnterprise.setEnterpriseName(enterpriseName);
		daoFactory.getEnterpriseMapper().updateByPrimaryKeySelective(updateEnterprise);

		return result;
	}

}
