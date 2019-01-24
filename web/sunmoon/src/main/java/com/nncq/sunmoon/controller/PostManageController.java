package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.Post;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.PostManageService;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 职务管理
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("postManage")
@Controller
public class PostManageController {

	@Autowired
	private PostManageService postManageService;

	@RequestMapping(value = "getPostsBySE", method = RequestMethod.GET)
	public void getPostsBySE(HttpServletResponse response, int page, int limit, String field, String order, String key,
			String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(post_id,'')";
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
			field = "post_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Post> list = postManageService.getPostsBySE(selectEntity);
		int num = postManageService.getPostsNumberBySE(selectEntity);
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

	@RequestMapping(value = "addPost", method = RequestMethod.POST)
	public void addPost(HttpServletResponse response, HttpServletRequest request, Post post) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("postManage/addPost")) == null) {
				code = 102;
			} else {
				postManageService.addPost(post);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "updatePost", method = RequestMethod.POST)
	public void updatePost(HttpServletResponse response, HttpServletRequest request, Post post) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("postManage/updatePost")) == null) {
				code = 102;
			} else {
				postManageService.updatePost(post);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "delPost", method = RequestMethod.POST)
	public void delPost(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		int re = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff.getPowerMap().get(StaticValues.powerMap.get("postManage/delPost")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					postManageService.delPost(id);
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

	@RequestMapping(value = "getAllPostIdName", method = RequestMethod.GET)
	public void getAllPostIdName(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<Post> list = postManageService.getAllPostIdName();
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
