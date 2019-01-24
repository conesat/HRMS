package com.nncq.sunmoon.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nncq.sunmoon.entity.Contract;
import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.Rank;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.nncq.sunmoon.entity.AdminTransferStaff;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.ChartsKeyValue;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffContract;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.entity.StaffIdSetting;
import com.nncq.sunmoon.entity.Transfer;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.ContractManageService;
import com.nncq.sunmoon.service.DepartmentService;
import com.nncq.sunmoon.service.LoginService;
import com.nncq.sunmoon.service.MsgService;
import com.nncq.sunmoon.service.NoticeService;
import com.nncq.sunmoon.service.StaffApplyService;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.SendMail;
import com.nncq.sunmoon.tools.SessionListener;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 职员管理 控制层
 * 
 * @author duoduo
 *
 */
@RequestMapping("staffManage")
@Controller
public class StaffManageController {

	@Autowired
	private ContractManageService contractManageService;

	@Autowired
	private StaffManageService staffManageService;

	@Autowired
	private MsgService msgService;

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private StaffApplyService staffApplyService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private NoticeService noticeService;

	/**
	 * 查询员工
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getStaffsBySE", method = RequestMethod.GET)
	public void getStaffsBySE(HttpServletRequest request, HttpServletResponse response, int page, int limit,
			String field, String order, String key, String[] filter, String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(staff_id,'')";
		}
		if (key == null) {
			key = "";
		}
		if (department_id != null && department_id != "") {
			sql = "department_id = '" + department_id + "' and CONCAT(" + sql + ")";
		} else if (staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null) {
			sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"
					+ staff.getDepartment_id() + "')) ) and CONCAT(" + sql + ")";
		} else {
			sql = "CONCAT(" + sql + ")";
		}
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "staff_id";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Staff> list = staffManageService.getStaffsBySE(selectEntity);
		int num = staffManageService.getStaffsNumberBySE(selectEntity);
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
	 * 查询员工花名册
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getStaffsRosterBySE", method = RequestMethod.GET)
	public void getStaffsRosterBySE(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(staff_id,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "staff_state='在职' and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "staff_id";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Staff> list = staffManageService.getStaffsBySE(selectEntity);
		int num = staffManageService.getStaffsNumberBySE(selectEntity);
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

	@RequestMapping(value = "getAllStaffIdName", method = RequestMethod.GET)
	public void getAllStaffIdName(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<StaffIdName> list = staffManageService.getAllStaffIdName();
		json.put("code", code);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getStaffByDepId", method = RequestMethod.GET)
	public void getStaffByDepId(HttpServletRequest request, HttpServletResponse response, int page, int limit,
			String field, String order, String key, String[] filter, String department_id) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(staff_id,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "department_id='"+staff.getDepartment_id()+"' and staff_id <> '"+staff.getStaff_id()+"' and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "staff_id";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<StaffAndPosition> list = staffManageService.getStaffByDepId(selectEntity);
		int num = staffManageService.getStaffNumberByDepId(selectEntity);
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
	
	@RequestMapping(value = "startPerformance", method = RequestMethod.POST)
	public void startPerformance(HttpServletResponse response, HttpServletRequest request) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		List<Department> departments=departmentService.getAllOrgs();
		String dep="";
		for (Department department : departments) {
			dep+=department.getDepartment_id()+",";
		}
		Notice notice=new Notice();
		notice.setNotice_title("绩效评估通知");
		notice.setNotice_msg("管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>");
		notice.setNotice_department_id(dep);
		notice.setNotice_time(Datetool.getTimeNowThroughDate());
		notice.setNotice_staff_name(staff.getStaff_name());
		notice.setRead_staff_id(staff.getStaff_id());
		noticeService.addNotice(notice);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, HttpServletRequest request, Staff staffNew) {
		JSONObject json = new JSONObject();
		int code = 100;
		String id = "";
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("gotoJsp?jsp=admin/content/addStaff")) == null) {
				code = 102;
			} else {
				if (staffManageService.getStaffById(staffNew.getStaff_id()) != null) {
					code = 103;
				} else {
					id = staffManageService.addStaff(staffNew);
				}
			}

		}
		json.put("id", id);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getStaffIdSetting", method = RequestMethod.GET)
	public void getStaffIdSetting(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;
		response.setCharacterEncoding("UTF-8");
		StaffIdSetting data = staffManageService.getStaffIdSetting();
		json.put("code", code);
		json.put("data", data);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "updateStaffSetting", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, StaffIdSetting staffIdSetting) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap()
					.get(StaticValues.powerMap.get("gotoJsp?jsp=admin/content/staffIdSetting")) == null) {
				code = 102;
			} else {
				staffManageService.updateStaffIdSetting(staffIdSetting);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转正员工
	 * 
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "regularStaff", method = RequestMethod.POST)
	public void regularStaff(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(id);
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				staffManageService.regularStaff(id);
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 职员离职 辞职或辞退
	 * 
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "quitStaff", method = RequestMethod.POST)
	public void quitStaff(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(id);
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				Staff opStaff = staffManageService.getStaffById(id);
				if (opStaff.getStaff_email() != null) {
					try {
						SendMail.sendMail(opStaff.getStaff_email(), "您已离开公司，谢谢你为公司付出的努力。", "离职信息");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				staffManageService.quitStaff(id);
			}

		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 调动
	 * 
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "transferStaff", method = RequestMethod.POST)
	public void transferStaff(HttpServletResponse response, HttpServletRequest request, Staff staffTransfer,
			Notice notice) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(staffTransfer.getStaff_id());
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				Staff opStaff = staffManageService.getStaffById(staffTransfer.getStaff_id());
				if (opStaff.getStaff_email() != null) {
					try {
						SendMail.sendMail(opStaff.getStaff_email(), "您职位已变更请登录系统查看。", "调动信息");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				notice.setNotice_time(Datetool.getTimeNowThroughDate());
				notice.setNotice_staff_name(staff.getStaff_name());
				notice.setRead_staff_id(staff.getStaff_id());
				staffManageService.transferStaff(staffTransfer, notice);
				SessionListener.loginUser.remove(staffTransfer.getStaff_id());
			}

		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新职员基本信息
	 * 
	 * @param response
	 * @param request
	 * @param staffBase
	 */
	@RequestMapping(value = "updateStaffBase", method = RequestMethod.POST)
	public void updateStaffBase(HttpServletResponse response, HttpServletRequest request, Staff staffBase) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(staffBase.getStaff_id());
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				staffManageService.updateStaff(staffBase);
			}

		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转界面
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @param jsp
	 * @return
	 */
	@RequestMapping(value = "gotoJsp", method = RequestMethod.GET)
	public String gotoJsp(HttpServletRequest request, Model model, String id, String jsp) {
		model.addAttribute("staff", staffManageService.getStaffById(id));
		return "admin/iframe/" + jsp;
	}

	@RequestMapping(value = "gotoTransferStaff", method = RequestMethod.GET)
	public String gotoTransferStaff(HttpServletRequest request, Model model, String id) {
		model.addAttribute("transfer", staffManageService.getTransferAdminStaff(id));
		return "admin/transferStaff";
	}

	@RequestMapping(value = "transferStaffRes", method = RequestMethod.POST)
	public void transferStaffRes(HttpServletResponse response, HttpServletRequest request, String id, String ok) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			Msg msg = new Msg();
			AdminTransferStaff adminTransferStaff = staffManageService.getTransferAdminStaff(id);
			msg.setType("staff_id");
			msg.setObject_id(adminTransferStaff.getApply_staff_id());
			msg.setMsg_type("sys");
			msg.setMsg_title("职员调动申请反馈");
			msg.setSend_id(adminTransferStaff.getObject_staff_id());
			msg.setSend_name("系统反馈");
			msg.setSend_time(Datetool.getTimeNowThroughDate());
			if (ok.equals("ok")) {
				staffManageService.transferStaffRes("同意", id);
				msg.setMsg_body("申请已被对方部门主管同意，现已将申请转发至人事管理，请耐心等待回馈消息");
				String levaeID = null;
				Apply apply = new Apply();
				Transfer transfer = new Transfer();
				transfer.setTransfer_staff_name(adminTransferStaff.getStaff_name());
				transfer.setTransfer_staff_id(adminTransferStaff.getStaff_id());
				transfer.setTransfer_position_name_old("仅调动部门");
				transfer.setTransfer_position_name_new("仅调动部门");
				if (adminTransferStaff.getTransfer_type().equals("in")) {
					transfer.setTransfer_department_name_old(adminTransferStaff.getObject_department_name());
					transfer.setTransfer_department_name_new(adminTransferStaff.getDepartment_name());
					;
				} else {
					transfer.setTransfer_department_name_new(adminTransferStaff.getObject_department_name());
					transfer.setTransfer_department_name_old(adminTransferStaff.getDepartment_name());
					;
				}
				transfer.setTransfer_msg("原由信息:" + adminTransferStaff.getMsg() + "<br>该申请由系统转发，双方部门已同意");
				levaeID = staffApplyService.staffTransfer(transfer);
				apply.setParent_id(levaeID);
				apply.setApply_name("调动申请");
				apply.setCheck_state("待审核");
				apply.setApply_type("staff_transfer_apply");
				apply.setApply_staff_id(transfer.getTransfer_staff_id());
				apply.setApply_time(Datetool.getTimeNowThroughDate());
				applyService.addApply(apply);
			} else {
				staffManageService.transferStaffRes("拒绝", id);
				msg.setMsg_body("申请已被对方部门主管拒绝");
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

	/**
	 * 获取合同列表
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getStaffContractByStaffId", method = RequestMethod.GET)
	public void getStaffContractByStaffId(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		int code = 0;
		response.setCharacterEncoding("UTF-8");
		List<StaffContract> list = staffManageService.getStaffContractByStaffId(id);
		json.put("code", code);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重置密码
	 * 
	 * @param response
	 * @param request
	 * @param login
	 */
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public void resetPassword(HttpServletResponse response, HttpServletRequest request, Login login) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(login.getStaff_id());
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				staffManageService.resetPassword(login);
				SessionListener.loginUser.remove(login.getStaff_id());
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "setPassword", method = RequestMethod.POST)
	public void setPassword(HttpServletResponse response, HttpServletRequest request, Login login) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			login.setStaff_id(staff.getStaff_id());
			staffManageService.setPassword(login);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id获取用户信息
	 * 
	 * @param response
	 * @param request
	 * @param id
	 */
	@RequestMapping(value = "getMyInfo", method = RequestMethod.POST)
	public void getStaffById(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staffp = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staffp == null) {
			code = 101;
		} else {
			Staff staff = staffManageService.getStaffById(staffp.getStaff_id());
			json.put("staff", staff);
		}

		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "transferAdminStaff", method = RequestMethod.POST)
	public void transferAdminStaff(HttpServletResponse response, HttpServletRequest request,
			AdminTransferStaff adminTransferStaff) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		StaffAndPosition staffp = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staffp == null) {
			code = 101;
		} else {
			adminTransferStaff.setApply_staff_id(staffp.getStaff_id());
			adminTransferStaff.setApply_staff_name(staffp.getStaff_name());
			adminTransferStaff.setDepartment_id(staffp.getDepartment_id());
			adminTransferStaff.setDepartment_name(staffp.getDepartment_name());
			DepartmentStaff departmentStaff = departmentService
					.getDepById(adminTransferStaff.getObject_department_id());
			adminTransferStaff.setObject_staff_id(departmentStaff.getStaff_id());

			staffManageService.transferAdminStaff(adminTransferStaff);
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getDepartmentStaff", method = RequestMethod.GET)
	public void getDepartmentStaff(HttpServletResponse response, HttpServletRequest request, String depid) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		StaffAndPosition staffAndPosition = new StaffAndPosition();
		staffAndPosition.setRank_level(staff.getRank_level());
		staffAndPosition.setDepartment_id(staff.getDepartment_id());
		JSONObject json = new JSONObject();
		int code = 0;
		response.setCharacterEncoding("UTF-8");
		if (depid != null) {
			staffAndPosition.setDepartment_id(depid);
		}
		List<StaffIdName> list = staffManageService.getDepartmentStaff(staffAndPosition);
		json.put("code", code);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 合同变更
	 * 
	 * @param response
	 * @param request
	 * @param login
	 */
	@RequestMapping(value = "changeStaffContract", method = RequestMethod.POST)
	public void changeStaffContract(HttpServletResponse response, HttpServletRequest request, int changeType, Msg msg,
			String change_msg) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			StaffAndPosition staff2 = staffManageService.selectStaffData(msg.getStaff_id());
			if (staff.getPowerMap().get(StaticValues.powerMap.get("staffManage/regularStaff")) == null
					|| (staff2.getRank_level() >= staff.getRank_level()
							&& staff.getPowerMap().get(StaticValues.powerMap.get("span")) == null)) {
				code = 102;
			} else {
				if (msg.getMsg_type().indexOf("email") != -1 && msg.getEmail() != null) {
					try {
						SendMail.sendMail(msg.getEmail(), msg.getMsg_body(), msg.getMsg_title());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (msg.getMsg_type().indexOf("sys") != -1) {
					msg.setType("staff_id");
					msg.setObject_id(msg.getStaff_id());
					msg.setSend_id(staff.getStaff_id());
					msg.setSend_name(staff.getStaff_name());
					msg.setSend_time(Datetool.getTimeNowThroughDate());
					msgService.addMsg(msg);
				}
				if (changeType == 0) {
					StaffContract staffContract = new StaffContract();
					staffContract.setStaff_id(msg.getStaff_id());
					staffContract.setChange_msg(change_msg);
					staffManageService.updateStaffContract(staffContract);
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

	/**
	 * 获取性别比例
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getStaffSex", method = RequestMethod.GET)
	public void getStaffSex(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		List<ChartsKeyValue> sexProportions = staffManageService.getStaffSex();
		json.put("code", code);
		json.put("data", sexProportions);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取年龄比例
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getAgeProp", method = RequestMethod.GET)
	public void getAgeProp(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		List<ChartsKeyValue> sexProportions = staffManageService.getAgeProp();
		json.put("code", code);
		json.put("data", sexProportions);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取年龄分布
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getWorkAddProp", method = RequestMethod.GET)
	public void getWorkAddProp(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		List<ChartsKeyValue> sexProportions = staffManageService.getWorkAddProp();
		json.put("code", code);
		json.put("data", sexProportions);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取薪资分布
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getPayProp", method = RequestMethod.GET)
	public void getPayProp(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		int code = 100;
		List<ChartsKeyValue> sexProportions = staffManageService.getPayProp();
		json.put("code", code);
		json.put("data", sexProportions);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传证件图片 与一寸照
	 * 
	 * @param response
	 * @param request
	 * @param contract
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(HttpServletResponse response, HttpServletRequest request, Staff staff, String name) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					try {
						myFileName = new String(myFileName.getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {

						System.out.println(myFileName);

						// 定义上传路径
						try {
							File file2 = new File(StaticValues.STAFF_DISK + staff.getStaff_id() + "/pic");
							if (!file2.exists()) {
								file2.mkdirs();
							}
							String fileName = name + "." + myFileName.substring(myFileName.lastIndexOf(".") + 1);
							String path = StaticValues.STAFF_DISK + staff.getStaff_id() + "/pic/" + fileName;
							// 存文件
							File localFile = new File(path);
							file.transferTo(localFile);
							if (name.compareTo("imgOne") == 0) {
								staff.setStaff_idcard_picture_one(path);
								staffManageService.updateImagOne(staff);
							} else if (name.compareTo("imgTow") == 0) {
								staff.setStaff_idcard_picture_tow(path);
								staffManageService.updateImagTow(staff);
							} else if (name.compareTo("imgThree") == 0) {
								staff.setStaff_person_picture(path);
								staffManageService.updateImagThree(staff);
							}
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
		json.put("code", 100);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传合同
	 * 
	 * @param response
	 * @param request
	 * @param staff
	 * @param name
	 */
	@RequestMapping(value = "uploadContract", method = RequestMethod.POST)
	public void uploadContract(HttpServletResponse response, HttpServletRequest request, StaffContract staffContract,
			String contract_id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					try {
						System.out.println(myFileName + " " + staffContract.getState());
						myFileName = new String(myFileName.getBytes("ISO-8859-1"), "UTF-8");
						if (staffContract.getState().equals("0")) {
							staffContract.setState("使用中");
						} else {
							staffContract.setState("待使用");
						}
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {

						// 定义上传路径
						try {
							File file2 = new File(StaticValues.STAFF_DISK + staffContract.getStaff_id() + "/contract");
							if (!file2.exists()) {
								file2.mkdirs();
							}
							Contract contract = contractManageService.getContractById(contract_id);

							staffContract.setContract_name(contract.getContract_name());

							staffContract.setEnd_time(Datetool.dateToString(
									Datetool.dateAdd(Datetool.strringToDate(staffContract.getStart_time()),
											contract.getContract_long())));

							String fileName = (new Date()).getTime() + "."
									+ myFileName.substring(myFileName.lastIndexOf(".") + 1);
							String path = StaticValues.STAFF_DISK + staffContract.getStaff_id() + "/contract/"
									+ fileName;

							staffContract.setContract_url(path);
							// 存文件
							File localFile = new File(path);
							file.transferTo(localFile);
							staffManageService.addStaffContract(staffContract);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
		json.put("code", 100);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
