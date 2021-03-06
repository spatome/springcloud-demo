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

/** 
 * 增删查改
 * @Description: enterprise
 * 增加
 */
@Service
public class Tran10010ServiceImpl extends BaseService implements TranService {

	@Override
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		//获取参数
		String enterpriseNo = inMap.get("enterpriseNo");
		String enterpriseName = inMap.get("enterpriseName");
		//检查参数"
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
		paramMap.put("enterpriseName", enterpriseName);
		super.checkNotEmpty(paramMap);

		//===========================业务处理=========================
		Enterprise record = daoFactory.getEnterpriseMapper().selectByEnterpriseNo(enterpriseNo);
		if(record!=null){
			result.setCodeMessage("9999", "账号已存在");
			return result;
		}

		Enterprise newRecord = new Enterprise();
		newRecord.setStatus("ON");
		newRecord.setCreateTime(new Date());
		newRecord.setUpdateTime(new Date());
		newRecord.setEnterpriseNo(enterpriseNo);
		newRecord.setEnterpriseName(enterpriseName);
		daoFactory.getEnterpriseMapper().insertSelective(newRecord);

		result.setBody(new SSVO(SUtil.NTS(newRecord.getId())));

		return result;
	}

}
