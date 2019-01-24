package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffIdAndNoticeId;
import com.nncq.sunmoon.service.NoticeService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.SpringWebSocketHandler;

import net.sf.json.JSONObject;

/**
 * 公告
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("notice")
@Controller
public class NoticeController {
	
	@Bean 
	public SpringWebSocketHandler infoHandler() {
		return new SpringWebSocketHandler();
	}


	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "readNotice", method = RequestMethod.POST)
	public void readNotice(HttpServletResponse response, HttpServletRequest request,
			StaffIdAndNoticeId staffIdAndNoticeId) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");

		if (staff != null) {
			staffIdAndNoticeId.setStaff_id(staff.getStaff_id());
			noticeService.readNotice(staffIdAndNoticeId);
		}

	}

	@RequestMapping(value = "addNotice", method = RequestMethod.POST)
	public void readNotice(HttpServletResponse response, HttpServletRequest request, Notice notice) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		JSONObject json = new JSONObject();
		int code = 100;
		if (staff != null) {
			infoHandler().sendMessageToUsers(new TextMessage("msg"));
			notice.setNotice_time(Datetool.getTimeNowThroughDate());
			notice.setNotice_staff_name(staff.getStaff_name());
			notice.setRead_staff_id(staff.getStaff_id());
			noticeService.addNotice(notice);
		} else {
			code = 101;
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "gotoAddNotice", method = RequestMethod.GET)
	public String gotoAddNotice(HttpServletResponse response, HttpServletRequest request) {
		return "admin/iframe/newNotice";
	}

	@RequestMapping(value = "getNoticesAll", method = RequestMethod.GET)
	public void getNoticesAll(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff != null) {
			List<Notice> Notices = null;
			Notices = noticeService.getNoticesAll(staff.getDepartment_id());
			json.put("data", Notices);
			json.put("code", code);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "getNoticesById", method = RequestMethod.GET)
	public void getNoticesById(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff != null) {
			Notice notice = noticeService.getNoticesById(id);
			if (notice != null) {
				json.put("data", notice);
			}else {
				code = 101;
			}
			json.put("code", code);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
