package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.service.MyAttendanceService;
import com.nncq.sunmoon.tools.Datetool;

import net.sf.json.JSONObject;
/**
 * 我的出勤。
 * @author 77
 *
 */
@Controller
@RequestMapping("myAttendance")
public class MyAttendanceController {
	@Autowired
	private MyAttendanceService attendance;
	@RequestMapping(value = "getAbsence", method = RequestMethod.GET)
	public void getAbsence(HttpServletResponse response, HttpServletRequest request,StaffCheckMonth staffCheck) {
		int re = 100;
		response.setCharacterEncoding("utf-8");
		JSONObject json = new JSONObject();
		StaffCheckMonth c1=null;
		// 获取系统时间当前月份
		String time=null;
		String f="-";
		String year=Datetool.getYearNow();
		String moth=Datetool.getMothNow();
		time=year+f+moth;
       /* System.out.println(time);*/
		staffCheck.setMonth(time);
	    System.out.println(staffCheck.toString());
		try {
		c1=attendance.selectAttendance(staffCheck);
	   
	} catch (Exception e) {
		re = 101;// 数据库查询失败
		e.printStackTrace();
	}	
	json.put("code", re);
	json.put("data", c1);
		

	try {
		response.getWriter().print(json);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
