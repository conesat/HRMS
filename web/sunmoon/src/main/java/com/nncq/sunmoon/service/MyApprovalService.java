package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface MyApprovalService {
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Apply> selectAll(SelectEntity selectEntity);
	public int getmyApprovalNumberBySE(SelectEntity selectEntity);
	/**
	 * 查询一条申请的详细信息
	 * @param apply_id
	 * @return
	 */
	public Apply selectApplyByID(String apply_id);
	
}
