package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.MyPayService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 我的薪资福利
 * @author 77
 *
 */
@RequestMapping("myPay")
@Controller
public class MyPayController {
	@Autowired
	private MyPayService myPayService;

	@RequestMapping(value = "selectmypay", method = RequestMethod.GET)
	public void selectmyApproval(HttpServletResponse response,HttpServletRequest request, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		sql = "IFNULL(mypay_staff_id,'')";
		key = staff.getStaff_id();
		sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "mypay_moth";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<MyPay> list =myPayService.selectAll(selectEntity);
		int num = myPayService.getmyPayNumberBySE(selectEntity);
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
