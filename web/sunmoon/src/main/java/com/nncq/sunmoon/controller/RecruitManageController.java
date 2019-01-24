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
import com.nncq.sunmoon.entity.Recruit;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.RecruitManageService;
import com.nncq.sunmoon.service.UploadAndDownloadService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("recruitManage")
@Controller
public class RecruitManageController {
	@Autowired
	private RecruitManageService recruitManageService;

	@Autowired
	private UploadAndDownloadService uploadAndDownloadService;

	@RequestMapping(value = "getRecruitBySE", method = RequestMethod.GET)
	public void getRecruitBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter,String department_id) {
		
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(rel_rec_id,'')";
		}
		if (key == null) {
			key = "";
		}
		
		if (department_id != null && department_id != "") {
			sql = "department_id = '"+department_id+"' and CONCAT(" + sql + ")";
		} else if(staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null){
			sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		}else {
			sql = "CONCAT(" + sql + ")";
		}
		
		
	//	sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state"; 
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Recruit> list = recruitManageService.getRecruitsBySE(selectEntity);
		int num = recruitManageService.getRecruitsNumberBySE(selectEntity);
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
	
	@RequestMapping(value = "getMyRecruitBySE", method = RequestMethod.GET)
	public void getMyRecruitBySE(HttpServletRequest request,HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff==null) {
			return;
		}
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(rel_rec_id,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "apply_staff_id ='"+staff.getStaff_id()+"' and CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "check_state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Recruit> list = recruitManageService.getRecruitsBySE(selectEntity);
		int num = recruitManageService.getRecruitsNumberBySE(selectEntity);
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

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, HttpServletRequest request, Recruit recruit) {
		JSONObject json = new JSONObject();
		int code = 100;
		String id = "";
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("gotoJsp?jsp=admin/content/recruitManage")) == null) {
				code = 102;
			} else {
				recruit.setApply_staff_id(staff.getStaff_id());
				id = recruitManageService.addRecruit(recruit);
			}
		}
		json.put("code", code);
		json.put("id", id);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "addApply", method = RequestMethod.POST)
	public void upload(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			// if (staff.getPosition_level() < 4) {
			// code = 102;
			// } else {
			code = uploadAndDownloadService.addFile(request, StaticValues.RELEASE_RECRUIT_DISK, id, "recruit");

			// }
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, Recruit recruit) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			// if (staff.getPosition_level() < 4) {
			// code = 102;
			// } else {
			recruitManageService.updateRecruit(recruit);
			// }
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "del", method = RequestMethod.POST)
	public void del(HttpServletResponse response, HttpServletRequest request, String[] ids) {
		JSONObject json = new JSONObject();
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		int re = 100;
		if (staff.getPowerMap().get(StaticValues.powerMap.get("recruitManage/del")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					recruitManageService.delRecruit(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				re = 101;
			}
		}
		
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印凭条
	 * 
	 * @param response
	 * @param request
	 * @param ids
	 */
	@RequestMapping(value = "printer", method = RequestMethod.GET)
	public String printer(HttpServletResponse response, HttpServletRequest request, Recruit recruit, Model model) {
		recruit = recruitManageService.getRecruitById(recruit.getRel_rec_id());
		model.addAttribute("recruit", recruit);
		model.addAttribute("title", "招聘凭条");
		return "admin/iframe/tickertape";
	}

}
