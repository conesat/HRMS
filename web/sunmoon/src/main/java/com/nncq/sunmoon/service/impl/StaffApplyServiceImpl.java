package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nncq.sunmoon.dao.StaffApplyDao;
import com.nncq.sunmoon.entity.Evection;
import com.nncq.sunmoon.entity.Expense;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.OverTime;
import com.nncq.sunmoon.entity.Quit;
import com.nncq.sunmoon.entity.StaffQuitApply;
import com.nncq.sunmoon.entity.Transfer;
import com.nncq.sunmoon.service.StaffApplyService;
@Service
public class StaffApplyServiceImpl implements StaffApplyService {
@Autowired
 public StaffApplyDao applyDao;
    
	public String staffLeave(Leave leave) {
	
		String id = getLeaveID();
		if (id == null) {
			id = "Leave-1001";
		} else {
			id = "Leave-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		leave.setLeave_id(id);
		applyDao.staffLeave(leave);
		return id;
				
	}

    
	public String staffEvection(Evection evection) {
		String id = getEvectionID();
		if (id == null) {
			id = "Evection-1001";
		} else {
			id = "Evection-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		evection.setEvection_id(id);
		applyDao.staffEvection(evection);
		return id;
	}


	 
	public String staffTransfer(Transfer transfer) {
		String id = getTransferID();
		if (id == null) {
			id = "Transfer-1001";
		} else {
			id = "Transfer-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		transfer.setTransfer_id(id);
		applyDao.staffTransfer(transfer);
		return id;
	}

	 
	public String staffOverTime(OverTime overTime) {
		String id = getoverTimeID();
		if (id == null) {
			id = "OverTime-1001";
		} else {
			id = "OverTime-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		overTime.setOvertime_id(id);
		applyDao.staffOverTime(overTime);
		return id;
	}

	 
	public String staffExpense(Expense expense) {
		String id = getExpenseID();
		if (id == null) {
			id = "Expense-1001";
		} else {
			id = "Expense-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		expense.setExpense_id(id);
		applyDao.staffExpense(expense);
		return id;
	}

	 
	public String staffQuit(StaffQuitApply quit) {
		String id = getQuitID();
		if (id == null) {
			id = "Quit-1001";
		} else {
			id = "Quit-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		quit.setQuit_id(id);
		applyDao.staffQuit(quit);
		return id;
	}


	/**
	 * 获取leave表最后一条ID
	 * 
	 * @return
	 */
	public String getLeaveID(){
		String re = null;
		try {
			re = applyDao.getLeaveID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
/**
 * 获取 APPly 表的最后徐一条ID
 */
	 
	public String getApplyID() {
		String re = null;
		try {
			re = applyDao.getApplyID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
/**
 * 获取各自表单中的最后一条ID 以便于添加
 */
 
public String getEvectionID() {
	String re = null;
	try {
		re = applyDao.getEvectionID();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return re;
}

 
public String getTransferID() {
	String re = null;
	try {
		re = applyDao.getTransferID();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return re;
}

 
public String getoverTimeID() {
	String re = null;
	try {
		re = applyDao.getoverTimeID();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return re;
}

 
public String getQuitID() {
	String re = null;
	try {
		re = applyDao.getQuitID();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return re;
}
 
 
public String getExpenseID() {
	String re = null;
	try {
		re = applyDao.getExpenseID();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return re;
}


}
