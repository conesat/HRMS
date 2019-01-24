package com.nncq.sunmoon.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.Performance;
import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.entity.RisksGold;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.entity.StaffPay;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CompanyService;
import com.nncq.sunmoon.service.DepartmentService;
import com.nncq.sunmoon.service.NoticeService;
import com.nncq.sunmoon.service.PerformanceService;
import com.nncq.sunmoon.service.PositionManageService;
import com.nncq.sunmoon.service.RisksGoldService;
import com.nncq.sunmoon.service.SalaryService;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.StaticValues;
import com.nncq.sunmoon.tools.entity.SelectEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("salary")
@Controller
public class SalaryController {

	/*
	 * 发放历史 缺省 AND ( `mypay`.`mypay_time` IS NOT NULL )
	 */
	@Autowired
	private SalaryService salaryService;

	@Autowired
	private RisksGoldService risksGoldService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CheckManageService checkManageService;

	@Autowired
	private StaffManageService staffManageService;

	@Autowired
	private PositionManageService positionManageService;

	@Autowired
	private PerformanceService performanceService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 保存核对结果
	 * 
	 * @param response
	 * @param request
	 * @param myPay
	 */
	@RequestMapping(value = "saveMonthSalaryCheck", method = RequestMethod.POST)
	public void saveMonthSalaryCheck(HttpServletResponse response, HttpServletRequest request, MyPay myPay) {
		JSONObject json = new JSONObject();
		int code = 100;
		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else if (staff.getPowerMap().get(StaticValues.powerMap.get("salary/saveMonthSalaryCheck")) == null) {
			code = 102;
		} else {

			int month = Integer.parseInt(Datetool.getMothNow());
			int year = Integer.parseInt(Datetool.getYearNow());
			if (month == 1) {
				year--;
				month = 12;
			} else {
				month--;
			}
			myPay.setMypay_moth(year + "-" + month);
			if (salaryService.getMyPayByMyPay(myPay) == null) {
				salaryService.addSalary(myPay);
			} else {
				salaryService.updateSalary(myPay);
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
	 * 发放工资
	 * 
	 * @param response
	 * @param request
	 * @param myPay
	 */
	@RequestMapping(value = "payBeforMonth", method = RequestMethod.POST)
	public void payBeforMonth(HttpServletResponse response, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int code = 100;

		StaffAndPosition staff = (StaffAndPosition) request.getSession().getAttribute("staff");
		if (staff == null) {
			code = 101;
		} else {
			if (staff.getPowerMap().get(StaticValues.powerMap.get("salary/payBeforMonth")) == null) {
				code = 102;
			} else {
				List<Department> departments = departmentService.getAllOrgs();
				String dep = "";
				Notice notice = new Notice();
				notice.setNotice_time(Datetool.getTimeNowThroughDate());
				notice.setNotice_staff_name(staff.getStaff_name());
				notice.setRead_staff_id(staff.getStaff_id());
				for (int i = 0; i < departments.size() - 1; i++) {
					dep += departments.get(i).getDepartment_id() + ",";
				}
				notice.setNotice_department_id(dep);
				notice.setNotice_title("工资发放公告");
				notice.setNotice_msg("工资已发放，请各位职员注意核查，如有疑问请联系人事部");
				noticeService.addNotice(notice);
				salaryService.payBeforMonth(Datetool.getDateNowThroughDate());
			}
		}
		json.put("code", code);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "checkBeforMonthSalary", method = RequestMethod.GET)
	public String checkBeforMonthSalary(HttpServletResponse response, HttpServletRequest request, String staff_id,
			Model model) {
		RisksGold risksGold = risksGoldService.getRisksGold();// 五险一金
		MyPay myPay = new MyPay();// 工资详细
		DecimalFormat fnum = new DecimalFormat("##0.00"); // 浮点格式化
		Performance performance = new Performance();// 绩效

		Staff staff = staffManageService.getStaffById(staff_id);// 职员信息
		Position position = positionManageService.getPositionById(staff.getPosition_id());// 职位信息 用于获取岗位工资

		StaffCheckMonth staffCheckMonth = new StaffCheckMonth();// 考勤月份信息
		Float base = companyService.selectCompany().getSalary_base();// 获取公司基本工资
		if (base == null) {
			base = 0f;
		}

		int month = Integer.parseInt(Datetool.getMothNow());
		int year = Integer.parseInt(Datetool.getYearNow());
		if (month == 1) {
			year--;
			month = 12;
		} else {
			month--;
		}

		staffCheckMonth.setStaff_id(staff_id);
		staffCheckMonth.setMonth(year + "-" + month);
		staffCheckMonth = checkManageService.getStaffCheckMonthByMonth(staffCheckMonth);// 获取月份考勤
		model.addAttribute("monthCheck", staffCheckMonth);// 传值

		myPay.setMypay_moth(year + "-" + month);
		myPay.setMypay_staff_id(staff_id);
		myPay = salaryService.getMyPayByMyPay(myPay);

		if (myPay == null) {
			myPay = new MyPay();
			myPay.setPost_pay(Float.toString(position.getSalaryBase()));// 设置岗位工资
			myPay.setBase_pay(base.toString());
			performance.setMonth(year + "-" + month);
			performance.setStaff_id(staff_id);
			performance = performanceService.getStaffPerformanceByPerformance(performance);
			if (performance != null) {
				myPay.setAchievements(Float.toString(performance.getPerformance()));// 绩效
			} else {
				myPay.setAchievements("0");// 绩效
			}

			if (risksGold != null) {
				Float RG = risksGold.getP1() + risksGold.getP2() + risksGold.getP3() + risksGold.getP4()
						+ risksGold.getP5() + risksGold.getP6();// 统计五险一金
				myPay.setDeduction(RG.toString());
			} else {
				myPay.setDeduction("");
			}

			// 判断考勤情况 进行奖惩
			if (staffCheckMonth != null) {
				if (staffCheckMonth.getAbsence() != 0) {
					myPay.setBonus("-" + fnum.format(staffCheckMonth.getAbsence() * (base / 21.75)));
					myPay.setMypay_msg("旷工:" + staffCheckMonth.getAbsence() + "天，扣除工资:"
							+ fnum.format(staffCheckMonth.getAbsence() * (base / 21.75)));
				}
				if (staffCheckMonth.getLate() != 0) {
					if (myPay.getBonus() != null) {
						myPay.setBonus(-staffCheckMonth.getLate() * 10 + Float.parseFloat(myPay.getBonus()) + "");
					} else {
						myPay.setBonus(staffCheckMonth.getLate() * 10 + "");
					}
					myPay.setMypay_msg(myPay.getMypay_msg() + "&#10;迟到:" + staffCheckMonth.getLate() + "次，扣除工资:"
							+ fnum.format(staffCheckMonth.getLate() * 10));
				}

			} else {
				myPay.setMypay_msg("无打卡记录");
			}

			// 判断是否未满一月员工
			if (Datetool.compareDayToDay(staff.getStaff_in_date(), year + "-" + month + "-01") > 0) {
				model.addAttribute("msg", "这是一个新员工，请仔细核对薪资信息，并扣除未满一个月部分薪水");
				myPay.setYear_pay("0");
			} else {
				model.addAttribute("workYear", Integer.parseInt(Datetool.getYearNow())
						- Integer.parseInt(staff.getStaff_in_date().split("-")[0]));
				myPay.setYear_pay((Integer.parseInt(Datetool.getYearNow())
						- Integer.parseInt(staff.getStaff_in_date().split("-")[0])) * 50 + "");
			}

		}
		if (myPay.getMypay_time() != null) {
			model.addAttribute("checkCode", '0');
		} else {
			model.addAttribute("checkCode", '1');
		}
		model.addAttribute("staff", staff);
		model.addAttribute("risksGold", myPay);
		return "admin/iframe/salaryCheck";
	}

	@RequestMapping(value = "salaryShow", method = RequestMethod.GET)
	public String salaryShow(HttpServletResponse response, HttpServletRequest request, String staff_id, Model model,
			String month) {
		RisksGold risksGold = risksGoldService.getRisksGold();// 五险一金
		MyPay myPay = new MyPay();// 工资详细
		DecimalFormat fnum = new DecimalFormat("##0.00"); // 浮点格式化
		Performance performance = new Performance();// 绩效

		Staff staff = staffManageService.getStaffById(staff_id);// 职员信息
		Position position = positionManageService.getPositionById(staff.getPosition_id());// 职位信息 用于获取岗位工资

		StaffCheckMonth staffCheckMonth = new StaffCheckMonth();// 考勤月份信息
		Float base = companyService.selectCompany().getSalary_base();// 获取公司基本工资
		if (base == null) {
			base = 0f;
		}

		staffCheckMonth.setStaff_id(staff_id);
		staffCheckMonth.setMonth(month);
		staffCheckMonth = checkManageService.getStaffCheckMonthByMonth(staffCheckMonth);// 获取月份考勤
		model.addAttribute("monthCheck", staffCheckMonth);// 传值

		myPay.setMypay_moth(month);
		myPay.setMypay_staff_id(staff_id);
		myPay = salaryService.getMyPayByMyPay(myPay);

		myPay = new MyPay();
		myPay.setPost_pay(Float.toString(position.getSalaryBase()));// 设置岗位工资
		myPay.setBase_pay(base.toString());
		performance.setMonth(month);
		performance.setStaff_id(staff_id);
		performance = performanceService.getStaffPerformanceByPerformance(performance);
		if (performance != null) {
			myPay.setAchievements(Float.toString(performance.getPerformance()));// 绩效
		} else {
			myPay.setAchievements("0");// 绩效
		}

		if (risksGold != null) {
			Float RG = risksGold.getP1() + risksGold.getP2() + risksGold.getP3() + risksGold.getP4() + risksGold.getP5()
					+ risksGold.getP6();// 统计五险一金
			myPay.setDeduction(RG.toString());
		} else {
			myPay.setDeduction("");
		}

		// 判断考勤情况 进行奖惩
		if (staffCheckMonth != null) {
			if (staffCheckMonth.getAbsence() != 0) {
				myPay.setBonus("-" + fnum.format(staffCheckMonth.getAbsence() * (base / 21.75)));
				myPay.setMypay_msg("旷工:" + staffCheckMonth.getAbsence() + "天，扣除工资:"
						+ fnum.format(staffCheckMonth.getAbsence() * (base / 21.75)));
			}
			if (staffCheckMonth.getLate() != 0) {
				if (myPay.getBonus() != null) {
					myPay.setBonus(-staffCheckMonth.getLate() * 10 + Float.parseFloat(myPay.getBonus()) + "");
				} else {
					myPay.setBonus(staffCheckMonth.getLate() * 10 + "");
				}
				myPay.setMypay_msg(myPay.getMypay_msg() + "&#10;迟到:" + staffCheckMonth.getLate() + "次，扣除工资:"
						+ fnum.format(staffCheckMonth.getLate() * 10));
			}

		} else {
			myPay.setMypay_msg("无打卡记录");
		}

		// 判断是否未满一月员工
		if (Datetool.compareDayToDay(staff.getStaff_in_date(), month + "-01") > 0) {
			model.addAttribute("msg", "这是一个新员工，请仔细核对薪资信息，并扣除未满一个月部分薪水");
			myPay.setYear_pay("0");
		} else {
			model.addAttribute("workYear",
					Integer.parseInt(Datetool.getYearNow()) - Integer.parseInt(staff.getStaff_in_date().split("-")[0]));
			myPay.setYear_pay(
					(Integer.parseInt(Datetool.getYearNow()) - Integer.parseInt(staff.getStaff_in_date().split("-")[0]))
							* 50 + "");
		}

		model.addAttribute("staff", staff);
		model.addAttribute("risksGold", myPay);
		return "admin/iframe/salaryShow";
	}

	@RequestMapping(value = "getStaffPayBySe", method = RequestMethod.GET)
	public void getStaffPayBySe(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter);
		} else {
			sql = "IFNULL(actual_pay,'')";
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
			field = "actual_pay";
			order = "desc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<StaffPay> list = salaryService.getStaffPayBySe(selectEntity);
		int num = salaryService.getStaffPayNumberBySe(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "getNowStaffPayBySe", method = RequestMethod.GET)
	public void getNowStaffPayBySe(HttpServletResponse response, int page, int limit, String field, String order,
			String key, String[] filter) {
		// 构建查询语句
		String sql = "";
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {
				filter[i] = "IFNULL(" + filter[i] + ",'')";
			}
			sql = String.join(",", filter) + ",IFNULL(mypay_moth,'')";
		} else {
			sql = "IFNULL(staff_id,'')";
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
			field = "mypay_time,actual_pay";
			order = "asc";
		}
		selectEntity.setField(field);
		selectEntity.setOrder(order);
		// 执行查询
		List<StaffPay> list = salaryService.getNowStaffPayBySe(selectEntity);
		int num = salaryService.getNowStaffPayNumberBySe(selectEntity);

		JSONObject json = new JSONObject();
		JSONArray data = JSONArray.fromObject(list);
		json.put("code", 0);
		json.put("msg", "");
		json.put("count", num);
		json.put("data", data);
		System.out.println(list.toString());
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
