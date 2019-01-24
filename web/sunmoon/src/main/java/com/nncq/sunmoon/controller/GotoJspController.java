package com.nncq.sunmoon.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.service.ContractManageService;
import com.nncq.sunmoon.service.PowerService;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.tools.MyThread;
import com.nncq.sunmoon.tools.SessionListener;
import com.nncq.sunmoon.tools.StaticValues;

/**
 * 
 * @author 拉布拉多是条狗
 *
 */
@Controller
public class GotoJspController {

	@Autowired
	private PowerService powerService;
	
	@Autowired
	private StaffManageService staffManageService;
	@Autowired
	private ContractManageService contractManageService;
	@Autowired
	private CheckManageService checkManageService;
	@Autowired
	private CheckRuleService checkRuleService;
	@Autowired
	private ApplyService applyService;

	@RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
	public String gotoJsp(HttpServletRequest request, Model model, String jsp, String type, String con) {
		model.addAttribute("url", jsp.replaceAll("/", "-"));// 头部标识
		// con为加载内容
		model.addAttribute("con", con);
		return jsp;
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model, String jsp, String type, String key) {
		model.addAttribute("key", key);
		return "admin/search";
	}
	
	@RequestMapping(value = "nopowers", method = RequestMethod.GET)
	public String nopowers(HttpServletRequest request) {
		return "nopowers";
	}

	@RequestMapping(value = "loginOut", method = RequestMethod.GET)
	public String loginOut(HttpServletRequest request, Model model, String jsp) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		request.getSession().removeAttribute("staff_id");
		request.getSession().removeAttribute("staff");
		request.getSession().setAttribute("msg", "");
		if (staff!=null) {
			SessionListener.staffOnline.remove(staff.getStaff_id());
		}
		
		Enumeration em = request.getSession().getAttributeNames();
		while(em.hasMoreElements()){
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		return "redirect:gotoLogin";
	}

	@RequestMapping(value = "gotoLogin", method = RequestMethod.GET)
	public String gotoLogin(HttpServletRequest request, Model model, String jsp) {
		return "login";
	}

	// 加载系统
	@RequestMapping(value = "loadSystem", method = RequestMethod.GET)
	public String loadSystem(HttpServletRequest request, Model model, String jsp) {
		File proFile = new File(StaticValues.PROJECT_DISK);
		if (!proFile.exists()) {
			proFile.mkdirs();
		}
		
		List<Power> list = powerService.getAllPowerList();
		for (Power power : list) {
			StaticValues.powerMap.put(power.getPower_url(), power.getPower_id());// 写入静态类
		}
		(new MyThread(contractManageService, checkManageService, checkRuleService, staffManageService, applyService)).start();
		return "login";
	}
}
