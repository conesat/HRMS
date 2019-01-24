package com.nncq.sunmoon.dao;

import com.nncq.sunmoon.entity.Evection;
import com.nncq.sunmoon.entity.Expense;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.OverTime;
import com.nncq.sunmoon.entity.StaffQuitApply;
import com.nncq.sunmoon.entity.Transfer;

/**
 * 员工申请管理
 * 
 * @author 77
 *
 */
public interface StaffApplyDao {
	/**
	 * 员工填写请假申请表
	 * 
	 */
	public void staffLeave(Leave leave);

	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getLeaveID();

	/**
	 * 员工出差申请
	 * 
	 * @param evection
	 */
	public void staffEvection(Evection evection);
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getEvectionID();

	/**
	 * 员工岗位调动申请
	 * 
	 * @param
	 */
	public void staffTransfer(Transfer transfer);

	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getTransferID();
	/**
	 * 员工岗加班
	 * 
	 * @param
	 */
	public void staffOverTime(OverTime overTime);
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getoverTimeID();
	/**
	 * 费用报销申请
	 * 
	 * @param expense
	 */
	public void staffExpense(Expense expense);
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getExpenseID();
	/**
	 * 离职申请
	 * 
	 * @param quit
	 */
	public void staffQuit(StaffQuitApply quit);
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getQuitID();
	/**
	 * 获取总表Apply的结尾ID
	 * @return
	 */
	public String getApplyID();

}
