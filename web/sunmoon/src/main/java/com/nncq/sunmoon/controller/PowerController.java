package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.service.PowerService;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONObject;

/**
 * 权限管理
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("power")
@Controller
public class PowerController {

	@Autowired
	private PowerService powerService;

	@RequestMapping(value = "getAllPower", method = RequestMethod.GET)
	public void getAllPower(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<Power> list = powerService.getAllPower();
		json.put("code", code);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取职位拥有的权限
	 * @param response
	 * @param request
	 * @param powers
	 */
	@RequestMapping(value = "getPostPowers", method = RequestMethod.GET)
	public void getPostPowers(HttpServletResponse response, HttpServletRequest request, String powers) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		if (powers.length() == 0) {
			selectEntity.setSql("power_id=-2");
		} else {
			String[] pos = powers.split("-");
			for (int i = 0; i < pos.length; i++) {
				pos[i] = "power_id=" + pos[i];
			}
			selectEntity.setSql(String.join(" or ", pos));
		}
		List<Power> list = powerService.getPostPowers(selectEntity);
		json.put("code", code);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取全部权限
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getAllPowerList", method = RequestMethod.GET)
	public void getAllPowerList(HttpServletResponse response, HttpServletRequest request) {
		if (StaticValues.powerMap.size()==0) {
			List<Power> list=powerService.getAllPowerList();
			for (Power power : list) {
				StaticValues.powerMap.put(power.getPower_url(), power.getPower_id());//写入静态类
			}
		}
	}
	

}
