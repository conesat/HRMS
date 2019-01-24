package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.DepartmentService;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 部门管理
 * 
 * @author duoduo
 *
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 嵌套查询所有部门记录
	 * 
	 * @param response
	 * @param page     从地page页开始
	 * @param limit    一次取limit条记录
	 * @param field    排序的列名
	 * @param order    排序规则 升降
	 * @param key      查询关键字
	 * @param filter   查询的列
	 */
	@RequestMapping(value = "getDepsBySE", method = RequestMethod.GET)
	public void getAddsBySE(HttpServletResponse response, int page, int limit, String field, String order, String key,
			String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(department_id,'')";
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
			field = "department_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<DepartmentStaff> list = departmentService.getDepsBySE(selectEntity);
		int num = departmentService.getDepsNumberBySE(selectEntity);

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

	@RequestMapping(value = "getAllMyOrgs", method = RequestMethod.GET)
	public void getAllMyOrgs(HttpServletResponse response, HttpServletRequest request) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<Department> departments = new ArrayList<Department>();
		if (staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null) {
			System.out.println(11);
			departments = departmentService.getAllMyOrgs(staff.getDepartment_id());
		} else {
			System.out.println(22);
			departments = departmentService.getAllOrgs();
		}
		json.put("code", code);
		json.put("data", departments);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getAllOrgs", method = RequestMethod.GET)
	public void getAllOrgs(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<Department> departments = departmentService.getAllOrgs();
		json.put("code", code);
		json.put("data", departments);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getAllOrgsHadAdmin", method = RequestMethod.GET)
	public void getAllOrgsHadAdmin(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<Department> departments = departmentService.getAllOrgsHadAdmin();
		json.put("code", code);
		json.put("data", departments);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "getOrgChart", method = RequestMethod.GET)
	public void getOrgChart(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		DepartmentStaff org = departmentService.getOrgChart();

		json.put("code", code);
		json.put("data", org);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "addDepartment", method = RequestMethod.POST)
	public void addDepartment(HttpServletResponse response, HttpServletRequest request, Department department) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("department/addDepartment")) == null) {
				code = 102;
			} else {
				departmentService.addDepartment(department);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除部门
	 * 
	 * @param response
	 * @param request
	 * @param ids
	 */
	@RequestMapping(value = "delDepartment", method = RequestMethod.POST)
	public void delDepartment(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		int re = 100;
		if (staff.getPowerMap().get(StaticValues.powerMap.get("department/delDepartment")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					departmentService.delDepartment(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				re = 101;
			}
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新部门
	 * 
	 * @param response
	 * @param request
	 * @param department
	 */
	@RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
	public void updateDepartment(HttpServletResponse response, HttpServletRequest request, Department department) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("department/updateDepartment")) == null) {
				code = 102;
			} else {
				departmentService.updateDepartment(department);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
