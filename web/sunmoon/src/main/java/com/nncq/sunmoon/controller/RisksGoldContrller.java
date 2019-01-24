package com.nncq.sunmoon.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.RisksGold;
import com.nncq.sunmoon.service.RisksGoldService;

import net.sf.json.JSONObject;

@RequestMapping("risksGold")
@Controller
public class RisksGoldContrller {
	
	@Autowired
	private RisksGoldService risksGoldService;
	
	@RequestMapping(value = "updateRisksGold", method = RequestMethod.POST)
	public void updateRisksGold(HttpServletResponse response, HttpServletRequest request, RisksGold risksGold) {
		JSONObject json = new JSONObject();
		int code = 100;
		risksGoldService.updateRisksGold(risksGold);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "getRisksGold", method = RequestMethod.GET)
	public void getRisksGold(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		json.put("data", risksGoldService.getRisksGold());
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
