package com.nncq.sunmoon.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.entity.Company;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.CompanyService;
import net.sf.json.JSONObject;

/**
 * 9-27 编辑公司基本信息页
 * 
 * @author 77
 *
 */
@Controller
@RequestMapping("company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

//查询已有数据
	@RequestMapping(value = "getCompany", method = RequestMethod.GET)
	public void getCompany(HttpServletResponse response) {
		int re = 100;
		response.setCharacterEncoding("utf-8");
		JSONObject json = new JSONObject();
		Company c1 = null;
		try {
			c1 = companyService.selectCompany();
			System.out.println(c1.toString());
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

// 修改数据 
	@RequestMapping(value = "updateCompany", method = RequestMethod.POST)
	public void updateCompany(Company company, HttpServletRequest request, HttpServletResponse response) {
		int re = 100;
		JSONObject json = new JSONObject();

		System.out.println(company.toString());
		try {
			companyService.updateCompany(company);

		} catch (Exception e) {
			re = 102;// 更改失败失败
			e.printStackTrace();
		}
		json.put("code", re);

		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "upload3", method = RequestMethod.POST)
	public void upload(HttpSession session, @RequestParam("upload") CommonsMultipartFile upload,
			HttpServletResponse response) {

		int re = 100;
		JSONObject json = new JSONObject();
		// 获取上传的文件名：**.jpg
		String fileName = upload.getOriginalFilename();
		System.out.println(fileName);
		// 吧文件名命名为全球唯一。
		String extendName = fileName.substring(fileName.lastIndexOf("."));
		String onlyName = UUID.randomUUID().toString() + extendName;
		// 获取服务器的文件夹路径
		String serverPath = session.getServletContext().getRealPath("/upload");
		System.out.println(serverPath);
		// 判断upload路径是否存在。不存在则创建。
		File saveDir = new File(serverPath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		// io流的 File
		File saveFile = new File(serverPath, onlyName);
		try {
			upload.transferTo(saveFile);
		} catch (IllegalStateException e) {
			re = 101;// 無效狀態
			e.printStackTrace();
		} catch (IOException e) {
			re = 102;// 读写异常
			e.printStackTrace();
		}
		json.put("code", re);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 更新基本工资
	 * @param response
	 * @param request
	 * @param checkRule
	 */
	@RequestMapping(value = "updateSalaryBase", method = RequestMethod.POST)
	public void updateSalaryBase(HttpServletResponse response, HttpServletRequest request, Float salaryBase) {
		JSONObject json = new JSONObject();
		int code = 100;
		companyService.updateSalaryBase(salaryBase);
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
