package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Performance;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.PerformanceService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("performance")
@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;
	
	/**
	 * 结算某员工绩效
	 * @param response
	 * @param request
	 * @param performance
	 */
	@RequestMapping(value = "settlementStaffPerformance", method = RequestMethod.POST)
	public void settlementStaffPerformance(HttpServletResponse response, HttpServletRequest request, Performance performance) {
		JSONObject json = new JSONObject();
		int code = 100;
		performance.setMonth(Datetool.getYearNow()+"-"+Datetool.getMothNow());
		if (performanceService.getStaffPerformanceByPerformance(performance)==null) {
			performanceService.addPerformance(performance);
		}else {
			performanceService.updateStaffPerformance(performance);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "getPerformanceBySe", method = RequestMethod.GET)
	public void getPerformanceBySe(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
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
		if (department_id != null && department_id != "") {
			sql = "department_id = '"+department_id+"' and CONCAT(" + sql + ")";
		} else if(staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null){
			sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		}else {
			sql = "CONCAT(" + sql + ")";
		}
		//sql = "CONCAT(" + sql + ")";
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
		List<Performance> list = performanceService.getPerformanceBySe(selectEntity);
		int num = performanceService.getPerformanceNumberBySe(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "getStaffPerformanceBySe", method = RequestMethod.GET)
	public void getStaffPerformanceBySe(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter)+",IFNULL(month,'')";
		} else {
			sql = "IFNULL(staff_id,'')";
		}
		if (key == null) {
			key = "";
		}
		if (department_id != null && department_id != "") {
			sql = "department_id = '"+department_id+"' and CONCAT(" + sql + ")";
		} else if(staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null){
			sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		}else {
			sql = "CONCAT(" + sql + ")";
		}
		//sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "performance";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Performance> list = performanceService.getStaffPerformanceBySe(selectEntity);
		int num = performanceService.getStaffPerformanceNumberBySe(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
