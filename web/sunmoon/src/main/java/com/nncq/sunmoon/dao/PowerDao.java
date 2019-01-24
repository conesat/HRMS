package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface PowerDao {
	public List<Power> getAllPower();
	public List<Power> getPostPowers(SelectEntity selectEntity);
	public List<Power> getAllPowerList();
}
