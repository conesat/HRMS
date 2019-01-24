package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.GetMsgList;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffIdAndNoticeId;
import com.nncq.sunmoon.service.MsgService;
import com.nncq.sunmoon.service.NoticeService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.SessionListener;
import com.nncq.sunmoon.tools.SpringWebSocketHandler;

import net.sf.json.JSONObject;

/**
 * 信息
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("msg")
@Controller
public class MsgController {
	@Bean 
	public SpringWebSocketHandler infoHandler() {
		return new SpringWebSocketHandler();
	}


	@Autowired
	private NoticeService noticeService;

	@Autowired
	private MsgService msgService;

	@RequestMapping(value = "getMsg", method = RequestMethod.POST)
	public void getMsg(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		int re = SessionListener.verifyUser(request);
		if (re == 1 || staff == null) {
			request.getSession().setAttribute("msg", "身份已过期，请重新登录");
			code = 101;
		} else {
			if (re == 2) {
				String ipCname = request.getSession().getAttribute(staff.getStaff_id()).toString();
				request.getSession().setAttribute("msg", "您的账号在别处登录，如非本人操作，请及时更改密码<br>" + ipCname);
				code = 102;
			} else {
				Notice notice = noticeService.getNoticesByStaffID(staff);
				if (notice != null) {
					code = 103;
					json.put("notice", notice);
				} else {
					List<Msg> lMsgs = new ArrayList<Msg>();
					Msg useMsg = new Msg();
					useMsg.setStaff_id(staff.getStaff_id());
					useMsg.setType("staff_id");
					useMsg.setObject_id(staff.getStaff_id());
					Msg msg = msgService.getNoReadMsg(useMsg);
					if (msg != null) {

						if (request.getSession().getAttribute("msg_staff_id") == null) {
							request.getSession().setAttribute("msg_staff_id", msg.getSend_time());
							lMsgs.add(msg);
						} else if (request.getSession().getAttribute("msg_staff_id").toString()
								.compareTo(msg.getSend_time()) != 0) {
							request.getSession().setAttribute("msg_staff_id", msg.getSend_time());
							lMsgs.add(msg);
						}
					}
					useMsg.setType("department_id");
					useMsg.setObject_id(staff.getDepartment_id());
					msg = msgService.getNoReadMsg(useMsg);
					if (msg != null) {
						if (request.getSession().getAttribute("department_id") == null) {
							request.getSession().setAttribute("department_id", msg.getSend_time());
							lMsgs.add(msg);
						} else if (request.getSession().getAttribute("department_id").toString()
								.compareTo(msg.getSend_time()) != 0) {
							request.getSession().setAttribute("department_id", msg.getSend_time());
							lMsgs.add(msg);
						}
					}
					useMsg.setType("position_id");
					useMsg.setObject_id(staff.getPosition_id());
					msg = msgService.getNoReadMsg(useMsg);
					if (msg != null) {
						if (request.getSession().getAttribute("position_id") == null) {
							request.getSession().setAttribute("position_id", msg.getSend_time());
							lMsgs.add(msg);
						} else if (request.getSession().getAttribute("position_id").toString()
								.compareTo(msg.getSend_time()) != 0) {
							request.getSession().setAttribute("position_id", msg.getSend_time());
							lMsgs.add(msg);
						}

					}

					if (lMsgs.size() > 0) {
						code = 104;
						json.put("msgs", lMsgs);
					}

				}

			}
		}

		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "readMsg", method = RequestMethod.POST)
	public void readMsg(HttpServletResponse response, HttpServletRequest request,Msg msg) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff != null) {
			msg.setStaff_id(staff.getStaff_id());
			msgService.readMsg(msg);
		}
	}
	
	@RequestMapping(value = "sendMsg", method = RequestMethod.POST)
	public void sendMsg(HttpServletResponse response, HttpServletRequest request, Msg msg) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			infoHandler().sendMessageToUsers(new TextMessage("msg"));
			msg.setSend_id(staff.getStaff_id());
			msg.setSend_name(staff.getStaff_name());
			msg.setSend_time(Datetool.getTimeNowThroughDate());
			msg.setMsg_type("sys");
			msg.setType("staff_id");
			msg.setRead_staff_id(staff.getStaff_id());
			if (msg.getMsg_body().length()>5) {
				msg.setMsg_title(msg.getMsg_body().substring(0, 5));
			}else {
				msg.setMsg_title(msg.getMsg_body());
			}
			
			msgService.addMsg(msg);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "getMsgList", method = RequestMethod.GET)
	public void getMsgList(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff != null) {
			GetMsgList getMsgList=new GetMsgList();
			List<Msg> msgs=null;
			getMsgList.setStaff_id(staff.getStaff_id());
			getMsgList.setPosition_id(staff.getPosition_id());
			getMsgList.setDepartment_id(staff.getDepartment_id());
			msgs=msgService.getMsgList(getMsgList);
			json.put("data", msgs);
			json.put("code", code);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@RequestMapping(value = "getStaffOnline", method = RequestMethod.GET)
	public void getStaffOnline(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff != null) {
			List<StaffAndPosition> list=new ArrayList<StaffAndPosition>();
			Map<String, StaffAndPosition> map=SessionListener.staffOnline;
			for (Map.Entry<String, StaffAndPosition> entry : map.entrySet()) { 
				if (!entry.getKey().equals(staff.getStaff_id())) {
					StaffAndPosition staffAndPosition=new StaffAndPosition();
					staffAndPosition.setStaff_name(entry.getValue().getStaff_name());
					staffAndPosition.setStaff_id(entry.getValue().getStaff_id());
					staffAndPosition.setDepartment_name(entry.getValue().getDepartment_name());
					staffAndPosition.setPosition_name(entry.getValue().getPosition_name());
					staffAndPosition.setStaff_person_picture(entry.getValue().getStaff_person_picture());
					list.add(staffAndPosition);
				}
			}
			json.put("data", list);
		}else {
			code=101;
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "gotoSendMsg", method = RequestMethod.GET)
	public String gotoSendMsg(HttpServletResponse response, HttpServletRequest request,String staff_id,String staff_name,Model model) {
		model.addAttribute("staff_id", staff_id);
		model.addAttribute("staff_name", staff_name);
		return "admin/iframe/sendMsg";
	}
	
}
