package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.WorkAddress;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.WorkAddressService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 工作地点管理
 * 
 * @author 拉布拉多是条狗
 *
 */
@Controller
@RequestMapping("workAddress")
public class WorkAddressController {

	@Autowired
	private CheckManageService checkManageService;

	@Autowired
	private WorkAddressService workAddressService;

	/**
	 * 嵌套查询所有地址记录
	 * 
	 * @param response
	 * @param page     从地page页开始
	 * @param limit    一次取limit条记录
	 * @param field    排序的列名
	 * @param order    排序规则 升降
	 * @param key      查询关键字
	 * @param filter   查询的列
	 */
	@RequestMapping(value = "getAddsBySE", method = RequestMethod.GET)
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
			sql = "IFNULL(work_address_id,'')";
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
			field = "work_address_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<WorkAddress> list = workAddressService.getAddsBySE(selectEntity);
		int num = workAddressService.getAddsNumberBySE(selectEntity);
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

	/**
	 * 添加一个新地址
	 * 
	 * @param response
	 * @param request
	 * @param workAddress
	 */
	@RequestMapping(value = "addAddress", method = RequestMethod.POST)
	public void addAddress(HttpServletResponse response, HttpServletRequest request, WorkAddress workAddress) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("workAddress/addAddress")) == null) {
				code = 102;
			} else {
				workAddressService.addAddress(workAddress);
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
	 * 
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "delAddress", method = RequestMethod.POST)
	public void delAddress(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		int re = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff.getPowerMap().get(StaticValues.powerMap.get("workAddress/delAddress")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					workAddressService.delAddress(id);
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
	 * 更新地址
	 * 
	 * @param response
	 * @param request
	 * @param workAddress
	 */
	@RequestMapping(value = "updateAddress", method = RequestMethod.POST)
	public void updateAddress(HttpServletResponse response, HttpServletRequest request, WorkAddress workAddress) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("workAddress/updateAddress")) == null) {
				code = 102;
			} else {
				workAddressService.updateAddress(workAddress);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getAddsIdName", method = RequestMethod.GET)
	public void getAddsIdName(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<WorkAddress> list = workAddressService.getAddsIdName();
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新考勤设置
	 * 
	 * @param response
	 * @param request
	 * @param workAddress
	 */
	@RequestMapping(value = "updateCheckSetting", method = RequestMethod.POST)
	public void updateCheckSetting(HttpServletResponse response, HttpServletRequest request, WorkAddress workAddress) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			workAddressService.updateCheckSetting(workAddress);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取地址
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getAddById", method = RequestMethod.GET)
	public void getAddById(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		WorkAddress wAddress = workAddressService.getAddById(id);
		json.put("data", wAddress);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取地址
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getAddByStaffId", method = RequestMethod.GET)
	public void getAddByStaffId(HttpServletResponse response, HttpServletRequest request, String id) {
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
		System.out.println(list.toString());
		if (list.size() > 0) {
			wAddress.setMorning_start("");
			wAddress.setAfternoon_start("");
			wAddress.setNight_start("");
		}
		json.put("data", wAddress);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
