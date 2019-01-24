package com.nncq.sunmoon.dao;

import com.nncq.sunmoon.entity.CheckRule;

/**
 * 打卡规则
 * @author 拉布拉多是条狗
 *
 */
public interface CheckRuleDao {
	/**
	 * 更新规则
	 * @param checkRule
	 */
	public void updateRule(CheckRule checkRule);
	
	/**
	 * 获取规则
	 * @return
	 */
	public CheckRule getRule();
}
