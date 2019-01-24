package com.nncq.sunmoon.controller;

/**
 * 审计
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.EvectionView;
import com.nncq.sunmoon.entity.ExpenseView;
import com.nncq.sunmoon.entity.LeaveView;
import com.nncq.sunmoon.entity.OverTimeView;
import com.nncq.sunmoon.entity.QuitView;
import com.nncq.sunmoon.entity.Recruit;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.TransferView;
import com.nncq.sunmoon.service.AuditService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("Audit")
@Controller
public class AuditController {
	@Autowired
	private AuditService AuditService;

	/**
	 * 请假审计
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getLeaveBySE", method = RequestMethod.GET)
	public void getRecruitBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
	//	sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<LeaveView> list = AuditService.getLeaveBySE(selectEntity);
		int num = AuditService.getLeaveNumberBySE(selectEntity);
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

	/**
	 * 出差
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getEvectionBySE", method = RequestMethod.GET)
	public void getEvectionBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
		//sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);

		// 执行查询
		List<EvectionView> list = AuditService.getEvectionBySE(selectEntity);
		int num = AuditService.getEvectionNumberBySE(selectEntity);
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

	/**
	 * 调动
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */

	@RequestMapping(value = "getTransferBySE", method = RequestMethod.GET)
	public void gettransferBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
		//sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<TransferView> list = AuditService.getTransferBySE(selectEntity);
		int num = AuditService.getTransferNumberBySE(selectEntity);
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

	/**
	 * 加班
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getOverTimeBySE", method = RequestMethod.GET)
	public void getOverTimeBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
		//sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<OverTimeView> list = AuditService.getOverTimeBySE(selectEntity);
		int num = AuditService.getOverTimeNumberBySE(selectEntity);
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

	/**
	 * 加班
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getExpenseBySE", method = RequestMethod.GET)
	public void getExpenseBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
		//sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<ExpenseView> list = AuditService.getExpenseBySE(selectEntity);
		int num = AuditService.getExpenseNumberBySE(selectEntity);
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

	/**
	 * 加班
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */

	@RequestMapping(value = "getQuitBySE", method = RequestMethod.GET)
	public void getQuitBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order, String key,
			String[] filter,String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(apply_id,'')";
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
		//sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<QuitView> list = AuditService.getQuitBySE(selectEntity);
		int num = AuditService.getQuitNumberBySE(selectEntity);
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

	@RequestMapping(value = "updateApply", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, Apply apply) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		
		if (staff == null) {
			code = 101;
		} else {
			apply.setCheck_staff_id(staff.getStaff_id());
			apply.setCheck_time(Datetool.getTimeNowThroughDate());
			AuditService.updateApply(apply);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
