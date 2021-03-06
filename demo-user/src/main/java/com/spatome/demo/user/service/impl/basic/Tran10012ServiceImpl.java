package com.spatome.demo.user.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Enterprise;
import com.spatome.demo.core.service.TranService;
import com.spatome.demo.user.service.impl.BaseService;

/** 
 * 增删查改
 * @Description: enterprise
 * 修改
 */
@Service
public class Tran10012ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		//获取参数
		String enterpriseNo = inMap.get("enterpriseNo");
		String enterpriseName = inMap.get("enterpriseName");
		//检查参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		super.checkNotEmpty(paramMap);

		//===========================业务处理=========================
		Enterprise record = daoFactory.getEnterpriseMapper().selectByEnterpriseNo(enterpriseNo);
		if(record==null){
			result.setCodeMessage("9999", "商家不存在");
			return result;
		}

		Enterprise updateRecord = new Enterprise();
		updateRecord.setId(record.getId());
		updateRecord.setEnterpriseName(StringUtils.isBlank(enterpriseName)?null:enterpriseName);
		daoFactory.getEnterpriseMapper().updateByPrimaryKeySelective(updateRecord);

		return result;
	}

}
