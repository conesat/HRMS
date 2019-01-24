package com.nncq.sunmoon.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Evection;
import com.nncq.sunmoon.entity.Expense;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.OverTime;
import com.nncq.sunmoon.entity.StaffQuitApply;
import com.nncq.sunmoon.entity.Transfer;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.StaffApplyService;
import com.nncq.sunmoon.tools.Datetool;

import net.sf.json.JSONObject;

/**
 * 控制员工填写各种申请
 * 
 * @author 77
 *
 */
@Controller
@RequestMapping("staffApply")
public class StaffApplyController {
	@Autowired
	private StaffApplyService StaffApplyService;
	
	@Autowired
    private ApplyService ApplyService;

	/**
	 * 请假申请
	 */
	@RequestMapping(value = "staff_leave", method = RequestMethod.POST)
	public void staff_leave(Leave leave, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffLeave(leave);
			apply.setParent_id(levaeID);
			apply.setApply_name("请假申请");
			apply.setApply_type("staff_leave_apply");
			apply.setCheck_state("待审核");
			apply.setApply_staff_id(leave.getLeave_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 出差申请
	 * 
	 * @param evection
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="staff_evection", method = RequestMethod.POST)
	public void staff_evection(Evection evection, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffEvection(evection);
			apply.setParent_id(levaeID);
			apply.setApply_name("出差申请");
			apply.setCheck_state("待审核");
			apply.setApply_type("staff_evection_apply");
			apply.setApply_staff_id(evection.getEvection_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	/**
	 * 调动申请
	 * @param transfer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="staff_transfer", method = RequestMethod.POST)
	public void staff_transfer(Transfer transfer, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffTransfer(transfer);
			apply.setParent_id(levaeID);
			apply.setApply_name("调动申请");
			apply.setCheck_state("待审核");
			apply.setApply_type("staff_transfer_apply");
			apply.setApply_staff_id(transfer.getTransfer_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 加班申请
	 * @param overTime
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="staff_overtime", method = RequestMethod.POST)
	public void staff_overtime(OverTime overTime, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffOverTime(overTime);
			apply.setParent_id(levaeID);
			apply.setApply_name("加班申请");
			apply.setCheck_state("待审核");
			apply.setApply_type("staff_overtime_apply");
			apply.setApply_staff_id(overTime.getOvertime_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 报销申请
	 * @param expense
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="staff_expense", method = RequestMethod.POST)
	public void staff_expense(Expense expense, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffExpense(expense);
			apply.setParent_id(levaeID);
			apply.setApply_name("报销申请");
			apply.setCheck_state("待审核");
			apply.setApply_type("staff_expense_apply");
			apply.setApply_staff_id(expense.getExpense_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 离职申请
	 * @param quit
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="staff_quit", method = RequestMethod.POST)
	public void staff_quit(StaffQuitApply quit, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		//获取当前表的ID 主键
		String levaeID=null;
		Apply apply=new Apply();
		JSONObject json = new JSONObject();
		try {
			levaeID=StaffApplyService.staffQuit(quit);
			apply.setParent_id(levaeID);
			apply.setApply_name("离职申请");
			apply.setCheck_state("待审核");
			apply.setApply_type("staff_quit_apply");
			apply.setApply_staff_id(quit.getQuit_staff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			ApplyService.addApply(apply);

		} catch (Exception e) {
			re = 101;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
