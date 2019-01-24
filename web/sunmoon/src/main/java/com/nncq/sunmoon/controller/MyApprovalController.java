package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.MyApprovalService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 我的审批结果
 * @author 77
 *
 */

@RequestMapping("myApproval")
@Controller
public class MyApprovalController {
	@Autowired
	private MyApprovalService myApprovalService;

	@RequestMapping(value = "selectmyApproval", method = RequestMethod.GET)
	public void selectmyApproval(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		//获取 当前员工信息
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		sql = "IFNULL(apply_staff_id,'')";
		key = staff.getStaff_id();
		sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "apply_id";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Apply> list =myApprovalService.selectAll(selectEntity);
		int num = myApprovalService.getmyApprovalNumberBySE(selectEntity);
		System.out.println(list.toString());
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
	 * 跳转页面
	 * @param apply_id 传递一个参数
	 * @param model APPLY的实体
	 * @return
	 */
	@RequestMapping(value = "Detailed", method = RequestMethod.GET)
	public String text77(String apply_id,Model model) {
	    Apply re=null;
		re=myApprovalService.selectApplyByID(apply_id);
		model.addAttribute("re", re); //model传递一个re 到页面
		return "staff/detailed";
	}


}

