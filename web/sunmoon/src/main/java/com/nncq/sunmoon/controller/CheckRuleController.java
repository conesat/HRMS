package com.nncq.sunmoon.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.tools.StaticValues;

import net.sf.json.JSONObject;

@RequestMapping("checkRule")
@Controller
public class CheckRuleController {

	@Autowired
	private CheckRuleService checkRuleService;

	@RequestMapping(value = "updateCheckRule", method = RequestMethod.POST)
	public void updateCheckRule(HttpServletResponse response, HttpServletRequest request, CheckRule checkRule) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			checkRuleService.updateRule(checkRule);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getCheckRule", method = RequestMethod.GET)
	public void getCheckRule(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		CheckRule checkRule = null;
		checkRule = checkRuleService.getRule();
		json.put("data", checkRule);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
