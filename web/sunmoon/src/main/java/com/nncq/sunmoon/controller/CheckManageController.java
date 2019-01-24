package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Check;
import com.nncq.sunmoon.entity.CheckDetailed;
import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.entity.Contract;
import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffCheck;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.service.WorkAddressService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.Statistics;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("checkManage")
@Controller
public class CheckManageController {

	@Autowired
	private CheckManageService checkManageService;

	@Autowired
	private ApplyService applyService;

	@Autowired
	private CheckRuleService checkRuleService;

	@Autowired
	private StaffManageService staffManageService;

	@RequestMapping(value = "submitCheck", method = RequestMethod.POST)
	public void submitCheck(HttpServletResponse response, HttpServletRequest request, StaffCheck staffCheck) {
		JSONObject json = new JSONObject();
		int code = 100;
		if (staffCheck == null) {
			staffCheck = new StaffCheck();
			StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
			staffCheck.setStaff_id(staff.getStaff_id());
		}
		staffCheck.setCheck_day(Datetool.getDateNowThroughDate());
		CheckDetailed checkDetailed = checkManageService.getCheckDetailedByStaffCheck(staffCheck);
		if (checkDetailed == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.addCheckDetailed(staffCheck);
		} else if (checkDetailed.getCheck_detailed__time2() == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.check2(staffCheck);
		} else if (checkDetailed.getCheck_detailed__time3() == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.check3(staffCheck);
		} else if (checkDetailed.getCheck_detailed__time4() == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.check4(staffCheck);
		} else if (checkDetailed.getCheck_detailed__time5() == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.check5(staffCheck);
		} else if (checkDetailed.getCheck_detailed__time6() == null) {
			staffCheck.setCheck_time(Datetool.getHHmmssNowThroughDate());
			checkManageService.check6(staffCheck);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "addScheduling", method = RequestMethod.POST)
	public void addScheduling(HttpServletResponse response, HttpServletRequest request, Scheduling scheduling) {
		JSONObject json = new JSONObject();
		int code = 100;
		if (checkManageService.getSchedulingByMonth(scheduling.getMonth()) != null) {
			code = 101;
		} else {
			checkManageService.addScheduling(scheduling);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getSchedulingBySE", method = RequestMethod.GET)
	public void getSchedulingBySE(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(month,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "month";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Scheduling> list = checkManageService.getSchedulingBySE(selectEntity);
		int num = checkManageService.getSchedulingNumberBySE(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, Scheduling scheduling) {
		JSONObject json = new JSONObject();
		int code = 100;
		checkManageService.updateScheduling(scheduling);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public void del(HttpServletResponse response, HttpServletRequest request, String month) {
		JSONObject json = new JSONObject();
		int re = 100;
		try {
			checkManageService.delScheduling(month);
		} catch (Exception e) {
			e.printStackTrace();
			re = 101;
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取某员工某天签到
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getCheckDetailedByStaffCheck", method = RequestMethod.GET)
	public void getCheckDetailedByStaffCheck(HttpServletResponse response, HttpServletRequest request,
			StaffCheck staffCheck) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		CheckDetailed checkDetailed = null;
		checkDetailed = checkManageService.getCheckDetailedByStaffCheck(staffCheck);
		json.put("data", checkDetailed);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取今日打卡记录
	 * @param response
	 * @param request
	 * @param staffCheck
	 */
	@RequestMapping(value = "getDayCheckDetailed", method = RequestMethod.GET)
	public void getDayCheckDetailed(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter, String day) {
		// 构建查询语句
		String sql = "";
		if (day==null||day=="") {
			day=Datetool.getDateNowThroughDate();
		}
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(check_detailed_day,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "check_detailed_day ='" + day + "' and " + "CONCAT("
				+ sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "staff_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<CheckDetailed> list = checkManageService.getCheckDetailedsBySE(selectEntity);
		int num = checkManageService.getCheckDetailedsNumberBySE(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		// System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "getChecksBySE", method = RequestMethod.GET)
	public void getChecksBySE(HttpServletResponse response, int page, int limit, String field, String order, String key,
			String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(check_month,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_month";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Check> list = checkManageService.getChecksBySE(selectEntity);
		int num = checkManageService.getChecksNumberBySE(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		// System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getCheckDetailedsBySE", method = RequestMethod.GET)
	public void getCheckDetailedsBySE(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter, String month, String staff_id) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(check_detailed_day,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "check_detailed_day like concat('" + month + "','%') and staff_id='" + staff_id + "' and " + "CONCAT("
				+ sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "staff_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<CheckDetailed> list = checkManageService.getCheckDetailedsBySE(selectEntity);
		int num = checkManageService.getCheckDetailedsNumberBySE(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		// System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getCheckMothDetailedsBySE", method = RequestMethod.GET)
	public void getCheckMothDetailedsBySE(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter, String month) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(month,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "month = '" + month + "' and " + "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "month";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<StaffCheckMonth> list = checkManageService.getCheckMothDetailedsBySE(selectEntity);
		int num = checkManageService.getCheckMonthDetailedsNumberBySE(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		// System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 统计当前工作月考勤 每月20号结算
	 * 
	 * @param response
	 * @param request
	 * @param staffCheck
	 */
	@RequestMapping(value = "statisticsCheckDetailedByMoth", method = RequestMethod.GET)
	public void statisticsCheckDetailedByMoth(HttpServletResponse response, HttpServletRequest request,
			StaffCheck staffCheck) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		System.out.println("开始结算");
		String month = Datetool.getYearNow() + "-" + Datetool.getMothNow();// 当前月份
		int LastDay = Integer.parseInt(Datetool.getDayNow());// Integer.parseInt(Datetool.getLastDayOfMonth(Datetool.getYearNow(),
																// Datetool.getMothNow()));

		Statistics.statisticsCheck(checkManageService, checkRuleService, staffManageService, applyService, month,
				LastDay);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
