package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.RisksGoldDao;
import com.nncq.sunmoon.entity.RisksGold;
import com.nncq.sunmoon.service.RisksGoldService;

@Transactional
@Service
public class RisksGoldServiceImpl implements RisksGoldService {

	@Autowired
	private RisksGoldDao risksGoldDao;

	 
	public void updateRisksGold(RisksGold risksGold) throws RuntimeException {
		risksGoldDao.updateRisksGold(risksGold);
	}

	 
	public RisksGold getRisksGold() {
		RisksGold re = null;
		try {
			re = risksGoldDao.getRisksGold();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
