package com.spatome.demo.goods.service.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.spatome.demo.core.entity.Prize;
import com.spatome.demo.core.exception.SException;
import com.spatome.demo.goods.service.GoodsService;

@Service
public class GoodsServiceImpl extends BaseService implements GoodsService {

	public final static Lock prizeBalanceLock = new ReentrantLock();

	@Override
	public int addPrizeBalanceCount(long prizeId, int count, String sleep) {
		prizeBalanceLock.lock();

		if(StringUtils.isNotBlank(sleep)){
			try {
				Thread.sleep(new Long(sleep).longValue());
			} catch (Exception e) {
			}			
		}

		try{
			Prize prize = daoFactory.getPrizeMapper().selectByPrimaryKey(prizeId);
			if(prize==null)	throw new SException("9999", "奖品不存在:" + prizeId);

			Prize updatePrize = new Prize();
			updatePrize.setId(prize.getId());
			updatePrize.setPrizeTotalCount(prize.getPrizeTotalCount()+count);
			int afterPrizeBalanceCount = prize.getPrizeBalanceCount()+count;
			updatePrize.setPrizeBalanceCount(afterPrizeBalanceCount);
			daoFactory.getPrizeMapper().updateByPrimaryKeySelective(updatePrize);

			return afterPrizeBalanceCount;
		}finally{
			prizeBalanceLock.unlock();
		}
	}

	@Override
	public int subPrizeBalanceCount(long prizeId, int count, String sleep) {
		prizeBalanceLock.lock();

		if(StringUtils.isNotBlank(sleep)){
			try {
				Thread.sleep(new Long(sleep).longValue());
			} catch (Exception e) {
			}			
		}

		try{
			Prize prize = daoFactory.getPrizeMapper().selectByPrimaryKey(prizeId);
			if(prize==null)	throw new SException("9999", "奖品不存在:" + prizeId);

			int afterPrizeBalanceCount = prize.getPrizeBalanceCount()-count;
			if(afterPrizeBalanceCount<0) throw new SException("9999", String.format("奖品｛%s｝余额不足,剩余｛%s｝,扣减｛%s｝", prizeId, prize.getPrizeBalanceCount(), count));
			
			Prize updatePrize = new Prize();
			updatePrize.setId(prize.getId());
			updatePrize.setPrizeBalanceCount(afterPrizeBalanceCount);
			daoFactory.getPrizeMapper().updateByPrimaryKeySelective(updatePrize);

			return afterPrizeBalanceCount;
		}finally{
			prizeBalanceLock.unlock();
		}
	}

}
