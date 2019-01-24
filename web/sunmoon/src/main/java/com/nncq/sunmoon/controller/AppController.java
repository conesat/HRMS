package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.CheckDetailed;
import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffCheck;
import com.nncq.sunmoon.entity.WorkAddress;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.service.WorkAddressService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONObject;
@RequestMapping("app")
@Controller
public class AppController {
	
	@Autowired
	private CheckManageService checkManageService;
	
	@Autowired
	private WorkAddressService workAddressService;
	
	
	@Autowired
	private CheckRuleService checkRuleService;
	
	/**
	 * 获取工作地址 与 签到详细
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "getWACD", method = RequestMethod.GET)
	public void getAddByStaffId(HttpServletResponse response, HttpServletRequest request,String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		WorkAddress wAddress = workAddressService.getAddByStaffId(id);
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setSql("CONCAT(IFNULL(dates,'') )");
		selectEntity.setKey(Datetool.getDateNowThroughDate());
		selectEntity.setField("month");
		selectEntity.setOrder("desc");
		selectEntity.setStart(0);
		selectEntity.setLimit(10);
		List<Scheduling> list = checkManageService.getSchedulingBySE(selectEntity);
		
		if (list.size()>0) {
			wAddress.setMorning_start("");
			wAddress.setMorning_end("");
			wAddress.setAfternoon_start("");
			wAddress.setAfternoon_end("");
			wAddress.setNight_start("");
			wAddress.setNight_end("");
			
		}
		StaffCheck staffCheck=new StaffCheck();
		staffCheck.setStaff_id(id);
		staffCheck.setCheck_day(Datetool.getDateNowThroughDate());
		CheckDetailed checkDetailed =checkManageService.getCheckDetailedByStaffCheck(staffCheck);
		CheckRule checkRule=checkRuleService.getRule();
		if (checkDetailed==null) {
			json.put("checkDetailed", "");
		}else {
			json.put("checkDetailed", checkDetailed);
		}
		json.put("wAddress", wAddress);
		
		json.put("checkRule", checkRule);
		System.out.println(json.toString());
		//System.out.println("CH+"+checkDetailed.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
