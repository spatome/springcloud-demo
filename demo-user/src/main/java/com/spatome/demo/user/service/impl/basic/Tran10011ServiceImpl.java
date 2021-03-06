package com.spatome.demo.user.service.impl.basic;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.entity.Enterprise;
import com.spatome.demo.core.service.TranService;
import com.spatome.demo.user.service.impl.BaseService;

/** 
 * 增删查改
 * @Description: enterprise
 * 删除/激活
 */
@Service
public class Tran10011ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();

		//获取参数
		String enterpriseNo = inMap.get("enterpriseNo");
		String status = inMap.get("status");		//ON OFF
		//检查参数
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("enterpriseNo", enterpriseNo);
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

		Enterprise record = daoFactory.getEnterpriseMapper().selectByEnterpriseNo(enterpriseNo);
		if(record==null){
			result.setCodeMessage("9999", "商家不存在");
			return result;
		}
		if(record.getStatus().equals(status)){
			return result;
		}

		Enterprise updateRecord = new Enterprise();
		updateRecord.setId(record.getId());
		updateRecord.setStatus(status);
		daoFactory.getEnterpriseMapper().updateByPrimaryKeySelective(updateRecord);

		return result;
	}
}
