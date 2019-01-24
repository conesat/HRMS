package com.nncq.sunmoon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.EvectionView;
import com.nncq.sunmoon.entity.ExpenseView;
import com.nncq.sunmoon.entity.LeaveView;
import com.nncq.sunmoon.entity.OverTimeView;
import com.nncq.sunmoon.entity.QuitView;
import com.nncq.sunmoon.entity.TransferView;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface AuditService {
	
	/**
	 * 审批请假申请
	 * @param apply
	 */
	public void updateApply(Apply apply);
	
	
	/**
	 * 请假申请审计
	 * 查询视图中 所有Leave 数据，分页
	 * @param selectEntity
	 * @return
	 */
	public List<LeaveView> getLeaveBySE(SelectEntity selectEntity);
	public int getLeaveNumberBySE(SelectEntity selectEntity);
	/**
	 * 查看单条记录
	 * @param id
	 * @return
	 */
	public LeaveView getLeaveById(String id);
	
	/**
	 * 出差申请审计
	 * @param selectEntity
	 * @return
	 */
	public List<EvectionView> getEvectionBySE(SelectEntity selectEntity);
	public int getEvectionNumberBySE(SelectEntity selectEntity);
	public EvectionView getEvectionById(String id);
	
	/**
	 * 调动 Transfer
	 * @param selectEntity
	 * @return
	 */
	public List<TransferView> getTransferBySE(SelectEntity selectEntity);
	public int getTransferNumberBySE(SelectEntity selectEntity);
	public TransferView getTransferById(String id);

	/**
	 * 加班 OverTime
	 * @param selectEntity
	 * @return
	 */
	public List<OverTimeView> getOverTimeBySE(SelectEntity selectEntity);
	public int getOverTimeNumberBySE(SelectEntity selectEntity);
	public OverTimeView getOverTimeById(String id);
	
	/**
	 *  ExpenseView
	 * @param selectEntity
	 * @return
	 */
	public List<ExpenseView> getExpenseBySE(SelectEntity selectEntity);
	public int getExpenseNumberBySE(SelectEntity selectEntity);
	public ExpenseView getExpenseById(String id);
	
	/**
	 *  QuitView
	 * @param selectEntity
	 * @return
	 */
	public List<QuitView> getQuitBySE(SelectEntity selectEntity);
	public int getQuitNumberBySE(SelectEntity selectEntity);
	public QuitView getQuitById(String id);
	
}
