package com.nncq.sunmoon.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.tools.Datetool;

import net.sf.json.JSONObject;

@RequestMapping("apply")
@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyService;

	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	public void addApply(HttpServletResponse response, HttpServletRequest request, Apply apply) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			apply.setApply_staff_id(staff.getStaff_id());
			apply.setApply_time(Datetool.getTimeNowThroughDate());
			apply.setCheck_state("待审核");
			applyService.addApply(apply);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "checkApply", method = RequestMethod.POST)
	public void checkApply(HttpServletResponse response, HttpServletRequest request, Apply apply) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			apply.setCheck_staff_id(staff.getStaff_id());
			apply.setCheck_time(Datetool.getTimeNowThroughDate());
			applyService.checkApply(apply);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getApplyCheckState", method = RequestMethod.POST)
	public void getApplyCheckState(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		Apply apply = null;
		apply = applyService.getApplyById(id);
		if (!apply.getCheck_state().equals("待审核")) {
			code = 101;
		}
		json.put("data", apply);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
