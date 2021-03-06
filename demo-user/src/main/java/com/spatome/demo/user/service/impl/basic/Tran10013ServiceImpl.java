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
import com.spatome.demo.user.vo.EnterpriseVO;

/** 
 * 增删查改
 * @Description: enterprise
 * 查询
 */
@Service
public class Tran10013ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<Object> result = new BaseVO<Object>();
		EnterpriseVO VO = new EnterpriseVO();
		result.setBody(VO);

		//获取参数
		String enterpriseNo = inMap.get("enterpriseNo");
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

		VO.setEnterpriseId(record.getId());
		VO.setEnterpriseNo(record.getEnterpriseNo());
		VO.setEnterpriseName(record.getEnterpriseName());
		VO.setStatus(record.getStatus());
		VO.setStatusName(VO.getStatus());

		return result;
	}

}
