package com.nncq.sunmoon.service;

/**
 *  @author 77
 */
import com.nncq.sunmoon.entity.Evection;
import com.nncq.sunmoon.entity.Expense;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.OverTime;
import com.nncq.sunmoon.entity.StaffQuitApply;
import com.nncq.sunmoon.entity.Transfer;

public interface StaffApplyService {
	/**
	 * 员工填写请假申请表 插入数据库
	 * 
	 * @return
	 */
	public String staffLeave(Leave leave);
	/**
	 * 获取最后一条ID
	 * @return
	 */
	public String getLeaveID();

	/**
	 * 员工出差申请 插入数据库
	 * 
	 * @param evection
	 */
	public String staffEvection(Evection evection);

	/**
	 * 员工岗位调动申请 插入数据库
	 * 
	 * @param
	 */
	public String staffTransfer(Transfer transfer);

	/**
	 * 员工岗加班
	 * 
	 * @param
	 */
	public String staffOverTime(OverTime overTime);

	/**
	 * 费用报销申请
	 * 
	 * @param expense
	 */
	public String staffExpense(Expense expense);
	

	/**
	 * 离职申请
	 * 
	 * @param quit
	 */
	public String staffQuit(StaffQuitApply quit);
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getEvectionID();

	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getTransferID();
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getoverTimeID();
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getQuitID();
	/**
	 * 获取最后一条ID
	 * 
	 * @return
	 */
	public String getExpenseID();
	
	/**
	 * 获取总表Apply的结尾ID
	 * @return
	 */
	public String getApplyID();

}
