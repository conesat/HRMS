package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Rank;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.RankManageService;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("rankManage")
@Controller
public class RankManageController {

	@Autowired
	private RankManageService rankManageService;

	@RequestMapping(value = "getRanksBySE", method = RequestMethod.GET)
	public void getRanksBySE(HttpServletResponse response, int page, int limit, String field, String order, String key,
			String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(rank_level,'')";
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
			field = "rank_level";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Rank> list = rankManageService.getRanksBySE(selectEntity);
		int num = rankManageService.getRanksNumberBySE(selectEntity);
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

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, HttpServletRequest request, Rank rank) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		System.out.println(rank.toString());
		if (staff == null) {
			code = 101;
		} else {
			if (rankManageService.getRankByLevel(rank.getRank_level()) != null) {
				code = 103;
			} else {
				if (staff.getPowerMap().get(StaticValues.powerMap.get("rankManage/add")) == null) {
					code = 102;
				} else {
					rankManageService.addRank(rank);
				}
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
	public void update(HttpServletResponse response, HttpServletRequest request, Rank rank) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("rankManage/update")) == null) {
				code = 102;
			} else {
				rankManageService.updateRank(rank);
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
		int re = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff.getPowerMap().get(StaticValues.powerMap.get("rankManage/del")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					rankManageService.delRank(id);
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

	@RequestMapping(value = "getAllRank", method = RequestMethod.GET)
	public void getAllRank(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<Rank> list = rankManageService.getAllRank();
		json.put("data", list);
		System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getRankByLevel", method = RequestMethod.GET)
	public void getRankByLevel(HttpServletResponse response, HttpServletRequest request, int level) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		Rank rank = rankManageService.getRankByLevel(level);
		json.put("data", rank);
		System.out.println(rank.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
