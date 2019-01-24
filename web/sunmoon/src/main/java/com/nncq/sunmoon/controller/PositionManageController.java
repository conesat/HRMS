package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.entity.Post;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.PositionManageService;
import com.nncq.sunmoon.service.PostManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 职位管理
 * 
 * @author duoduo
 *
 */
@RequestMapping("positionManage")
@Controller
public class PositionManageController {
	@Autowired
	private PositionManageService positionManageService;

	@RequestMapping(value = "getPositionsBySE", method = RequestMethod.GET)
	public void getPositionsBySE(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(position_id,'')";
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
			field = "position_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Position> list = positionManageService.getPositionsBySE(selectEntity);
		int num = positionManageService.getPositionsNumberBySE(selectEntity);
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

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, HttpServletRequest request, Position position) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("positionManage/add")) == null) {
				code = 102;
			} else {
				positionManageService.addPosition(position);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, Position position) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("positionManage/update")) == null) {
				code = 102;
			} else {
				positionManageService.updatePosition(position);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public void del(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		int re = 100;
		if (staff.getPowerMap().get(StaticValues.powerMap.get("positionManage/del")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					positionManageService.delPosition(id);
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

	@RequestMapping(value = "getAllPositionIdName", method = RequestMethod.GET)
	public void getAllPositionIdName(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<Position> list = positionManageService.getAllPositionIdName();
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新基本工资
	 * 
	 * @param response
	 * @param request
	 * @param position
	 */
	@RequestMapping(value = "updateSalary", method = RequestMethod.POST)
	public void updateSalary(HttpServletResponse response, HttpServletRequest request, Position position) {
		JSONObject json = new JSONObject();
		int code = 100;
		positionManageService.updateSalary(position);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
