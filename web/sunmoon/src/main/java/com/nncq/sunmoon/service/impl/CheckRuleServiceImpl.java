package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.CheckRuleDao;
import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.service.CheckRuleService;

@Transactional
@Service
public class CheckRuleServiceImpl implements CheckRuleService {
	
	@Autowired
	private CheckRuleDao checkRuleDao;

	public void updateRule(CheckRule checkRule) throws RuntimeException{
		checkRuleDao.updateRule(checkRule);
	}

	public CheckRule getRule() {
		CheckRule re=null;
		try {
			re=checkRuleDao.getRule();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
