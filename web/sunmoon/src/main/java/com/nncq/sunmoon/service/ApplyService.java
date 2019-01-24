package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Leave;

public interface ApplyService {
	/**
	 * 添加一条申请
	 * 
	 * @param apply
	 */
	public String addApply(Apply apply);

	/**
	 * 审核申请
	 * 
	 * @param apply
	 */
	public void checkApply(Apply apply);

	/**
	 * 获取最后一条id
	 * 
	 * @return
	 */
	public String getLastId();

	/**
	 * 获取申请
	 * 
	 * @param id
	 * @return
	 */
	public Apply getApplyById(String id);

	/**
	 * 获取时间范围内 已通过的请假申请
	 * 
	 * @param time
	 * @return
	 */
	public Leave getPastLeaveApply(Leave leave);

	/**
	 * 获取审核通过的离职申请
	 * @return
	 */
	public List<String> getPassQuitApply();
}
