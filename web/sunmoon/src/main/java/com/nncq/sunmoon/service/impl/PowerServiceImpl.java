package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.PowerDao;
import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.service.PowerService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Service
public class PowerServiceImpl implements PowerService {
	
	@Autowired
	private PowerDao powerDao;

	public List<Power> getAllPower() {
		List<Power> re = null;
		try {
			re = powerDao.getAllPower();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Power> getPostPowers(SelectEntity selectEntity) {
		List<Power> re = null;
		try {
			re = powerDao.getPostPowers(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Power> getAllPowerList() {
		List<Power> re = null;
		try {
			re = powerDao.getAllPowerList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
