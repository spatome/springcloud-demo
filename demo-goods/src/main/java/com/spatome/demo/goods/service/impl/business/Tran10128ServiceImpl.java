package com.spatome.demo.goods.service.impl.business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatome.demo.core.BaseVO;
import com.spatome.demo.core.service.TranService;
import com.spatome.demo.core.vo.SSVO;
import com.spatome.demo.goods.service.impl.BaseService;

import lombok.extern.slf4j.Slf4j;

/** 
 * @Description: prize
 * 加
 */
@Service
@Slf4j
public class Tran10128ServiceImpl extends BaseService implements TranService {

	@Override
	@Transactional
	public Object execute(Map<String, String> inMap, HttpServletRequest request, HttpServletResponse response) {
		BaseVO<SSVO> result = new BaseVO<SSVO>();

		log.debug("获取参数");
		String prizeId = inMap.get("prizeId");
		String count = inMap.get("count");
		String sleep = inMap.get("sleep");
		log.debug("检查参数");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("prizeId", prizeId);
		paramMap.put("count", count);
		super.checkNotEmpty(paramMap);

		log.debug("===========================业务处理=========================");
		int countInt = Integer.valueOf(count);
		if(countInt<=0){
			result.setCodeMessage("9999", "数量格式不正确");
			return result;
		}

		int ret = serviceFactory.getGoodsService().addPrizeBalanceCount(Long.valueOf(prizeId), countInt, sleep);
		result.setBody(new SSVO(String.valueOf(ret)));

		return result;
	}
}
