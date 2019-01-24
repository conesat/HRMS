package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.service.LoginService;
import com.nncq.sunmoon.service.PowerService;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;

import net.sf.json.JSONObject;

/**
 * 
 * 
 * @author 77
 *
 */
@Controller
public class LoginController {

	@Autowired
	private PowerService powerService;

	@Autowired
	private LoginService loginService;

	/**
	 * 登陆认证，
	 * 
	 * @param login     页面传值
	 * @param response  返回给页面
	 * @param staffType 判断你正在使用什么权限登陆
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, Login login, HttpServletResponse response, int staffType, String ip,
			String cname) {
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		int re = 100;
		String staffID = "";
		
		if (request.getSession().getAttribute("errorTime") != null) {
			String errorTime = (String) request.getSession().getAttribute("errorTime");
			Integer errorCount = (Integer) request.getSession().getAttribute("errorCount");
			long temp = Datetool.getMinOfDateToDate(errorTime);
			if (temp < (errorCount - 1)) {
				re = 105;
				json.put("msg", "账号密码连续错误，请" + (errorCount - temp - 1) + "分钟后尝试");
				json.put("time", errorCount - temp - 1);
				json.put("code", re);
				try {
					response.getWriter().print(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			} else {
				request.getSession().removeAttribute("errorTime");
			}

		}

		// 判断权限是否已获取
		if (StaticValues.powerMap.size() == 0) {
			List<Power> list = powerService.getAllPowerList();
			for (Power power : list) {
				StaticValues.powerMap.put(power.getPower_url(), power.getPower_id());// 写入静态类
			}
		}

		// 判断数据库中是否存在 员工ID
		if (loginService.existenceStaffID(login.getStaff_id()) > 0) {
			// 判断账号密码的正确性已经 权限
			re = loginJudge(request, login, staffType, ip, cname);
		} else {
			// 通过身份证 查询到员工ID 实现身份证登录
			staffID = loginService.selectIDByIDCard(login.getStaff_id());
			if (staffID == null) {
				re = 101;
			} else {
				login.setStaff_id(staffID + "");
				re = loginJudge(request, login, staffType, ip, cname);
			}
		}
		if (re != 100) {
			Integer errorCount = (Integer) request.getSession().getAttribute("errorCount");
			if (errorCount == null) {
				errorCount = 1;
			} else {
				errorCount++;
			}
			request.getSession().setAttribute("errorCount", errorCount);
			if (errorCount > 3) {
				re = 105;
				request.getSession().setAttribute("errorTime", Datetool.getTimeNowThroughDate());
				json.put("msg", "账号密码连续错误" + errorCount + "次,需要等待" + (errorCount - 1) + "分钟");
				json.put("time", errorCount - 1);
			}
		}

		json.put("code", re);

		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int loginJudge(HttpServletRequest request, Login login, int staffType, String ip, String cname) {
		int re = 100;
		// 根据账号密码查询带几条信息记录
		if (loginService.verification(login) > 0) {
			// - 返回根据id查询的所有信息到视图实体 。
			StaffAndPosition staff = loginService.selectStaffData(login.getStaff_id());
			if (staff==null) {
				return 101;
			}
			if (staff.getPowers() != null && staff.getPowers().compareTo("") != 0) {
				String[] pos = staff.getPowers().split("-");
				for (String string : pos) {
					staff.getPowerMap().put(Integer.parseInt(string), "true");
				}
			}

			// 权限判断，若正在使用管理员的登录则需要权限3 。 0为管理员 1为普通登录。
			
			if ((staffType == 0 && staff.getPowerMap().get(StaticValues.powerMap.get("login?staffType=0")) != null)
					|| staffType == 1
							&& staff.getPowerMap().get(StaticValues.powerMap.get("login?staffType=1")) != null) {
				// 保存查询来的信息 留待以后使用。
				request.getSession().setAttribute("staff", staff);
				request.getSession().setAttribute("staff_id", login.getStaff_id());
				request.getSession().setAttribute(staff.getStaff_id(), "断点ip:" + ip + "<br>断点地址:" + cname);
			} else {
				re = 104;
			}
		} else {
			re = 102;
		}
		return re;
	}

	/**
	 * 验证当前账号密码
	 * 
	 * @param request
	 * @param pass     密码
	 * @param response return 100完成 101失败 102过期
	 */
	@RequestMapping(value = "verifyStaff", method = RequestMethod.POST)
	public void verifyStaff(HttpServletRequest request, Login login, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		int re = 100;
		Object staff = request.getSession().getAttribute("staff");
		if (staff != null) {
			login.setStaff_id(((StaffAndPosition) staff).getStaff_id());// 使用传过来的密码 与保存的id 构建登录对象
			if (loginService.verification(login) <= 0) {// 判断登录
				re = 101;// 登录失败
			}
		} else {
			re = 102;
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 手机端登录
	 * 
	 * @param request
	 * @param login
	 * @param response
	 * @param staffType
	 * @param ip
	 * @param cname
	 */
	@RequestMapping(value = "appLogin", method = RequestMethod.POST)
	public void appLogin(HttpServletRequest request, Login login, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		int re = 100;
		String staffID = "";
		response.setCharacterEncoding("UTF-8");
		// 判断权限是否已获取
		if (StaticValues.powerMap.size() == 0) {
			List<Power> list = powerService.getAllPowerList();
			for (Power power : list) {
				StaticValues.powerMap.put(power.getPower_url(), power.getPower_id());// 写入静态类
			}
		}

		// 判断数据库中是否存在 员工ID
		if (loginService.existenceStaffID(login.getStaff_id()) > 0) {
			// 判断账号密码的正确性已经 权限
			if (loginService.verification(login) <= 0) {
				re = 102;
			}
		} else {
			// 通过身份证 查询到员工ID 实现身份证登录
			staffID = loginService.selectIDByIDCard(login.getStaff_id());
			if (staffID == null) {
				re = 101;
			} else {
				login.setStaff_id(staffID + "");
				if (loginService.verification(login) <= 0) {
					re = 102;
				}
			}
		}
		if (re == 100) {
			StaffAndPosition staffAndPosition = loginService.selectStaffData(login.getStaff_id());
			json.put("staff", staffAndPosition);
		}
		json.put("code", re);

		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
