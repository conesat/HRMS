package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface MyApprovalDao {
	/**
	 * 查询所有审批数据 byid
	 * @return
	 */
	public List<Apply> selectAll(SelectEntity selectEntity);
	/**
	 * 获取搜索总数
	 * @param selectEntity
	 * @return
	 */
	public int getmyApprovalNumberBySE(SelectEntity selectEntity);
	/**
	 * 查询一条申请的详细信息
	 * @param apply_id
	 * @return
	 */
	public Apply selectApplyByID(String apply_id);
}
