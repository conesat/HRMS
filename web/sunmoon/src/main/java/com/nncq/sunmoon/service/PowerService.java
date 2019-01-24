package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.tools.entity.SelectEntity;
/**
 * 权限
 * @author 拉布拉多是条狗
 *
 */
public interface PowerService {
	public List<Power> getAllPower();
	public List<Power> getPostPowers(SelectEntity selectEntity);
	public List<Power> getAllPowerList();
}
