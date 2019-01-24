package com.nncq.sunmoon.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nncq.sunmoon.entity.Contract;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffContractDTO;
import com.nncq.sunmoon.service.ContractManageService;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 合同管理
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("contractManage")
@Controller
public class ContractManageController {
	@Autowired
	private ContractManageService contractManageService;

	/**
	 * 查询
	 * 
	 * @param response
	 * @param page     第几页
	 * @param limit    条数
	 * @param field    排序列
	 * @param order    排序方法
	 * @param key      关键字
	 * @param filter   查询列
	 */
	@RequestMapping(value = "getContractsBySE", method = RequestMethod.GET)
	public void getContractsBySE(HttpServletRequest request, HttpServletResponse response, int page, int limit,
			String field, String order, String key, String[] filter) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(contract_id,'')";
		}
		if (key == null) {
			key = "";
		}
		sql = "CONCAT(" + sql + ")";
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "contract_id";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<Contract> list = contractManageService.getContractsBySE(selectEntity);
		int num = contractManageService.getContractsNumberBySE(selectEntity);
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
	 * 获取员工合同
	 * 
	 * @param response
	 * @param page
	 * @param limit
	 * @param field
	 * @param order
	 * @param key
	 * @param filter
	 */
	@RequestMapping(value = "getStaffContractsBySE", method = RequestMethod.GET)
	public void getStaffContractsBySE(HttpServletRequest request, HttpServletResponse response, int page, int limit,
			String field, String order, String key, String[] filter, String department_id) {
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			return;
		}
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
		if (department_id != null && department_id != "") {
			sql = "department_id = '"+department_id+"' and CONCAT(" + sql + ")";
		} else if(staff.getPowerMap().get(StaticValues.powerMap.get("span/department")) == null){
			sql = "department_id in( select department_id from department where FIND_IN_SET(department_id,getChildList('"+staff.getDepartment_id()+"')) ) and CONCAT(" + sql + ")";
		}else {
			sql = "CONCAT(" + sql + ")";
		}
		
		response.setCharacterEncoding("UTF-8");
		SelectEntity selectEntity = new SelectEntity();
		selectEntity.setStart((page - 1) * limit);
		selectEntity.setLimit(limit);
		selectEntity.setKey(key);
		selectEntity.setSql(sql);
		if (field == null) {
			field = "state";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<StaffContractDTO> list = contractManageService.getStaffContractsBySE(selectEntity);
		int num = contractManageService.getStaffContractsNumberBySE(selectEntity);
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
	public void add(HttpServletResponse response, HttpServletRequest request, Contract contract) {
		JSONObject json = new JSONObject();
		int code = 100;
		String id = "";
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("contractManage/add")) == null) {
				code = 102;
			} else {
				id = contractManageService.addContract(contract);
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

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, HttpServletRequest request, Contract contract) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("contractManage/update")) == null) {
				code = 102;
			} else {
				contractManageService.updateContract(contract);
			}
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
		int re = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff.getPowerMap().get(StaticValues.powerMap.get("contractManage/del")) == null) {
			re = 102;
		} else {
			try {
				for (String id : ids) {
					contractManageService.delContract(id);
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

	@RequestMapping(value = "getAllContractIdName", method = RequestMethod.GET)
	public void getAllContractIdName(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<Contract> list = contractManageService.getAllContractIdName();
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(HttpServletResponse response, HttpServletRequest request, Contract contract) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		System.out.println(contract.toString());
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
						// 重命名上传后的文件名 按照年月日时分秒进行命名
						String fileName = contract.getContract_id() + "."
								+ myFileName.substring(myFileName.lastIndexOf(".") + 1);
						// 定义上传路径
						try {
							String path = StaticValues.COMPANY_CONTRACT_DISK + fileName;
							contract.setContract_url(path);
							// 存文件
							File localFile = new File(path);
							file.transferTo(localFile);
							contractManageService.uploadContract(contract);
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
}
