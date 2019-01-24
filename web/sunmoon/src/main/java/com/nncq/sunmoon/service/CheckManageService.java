package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Check;
import com.nncq.sunmoon.entity.CheckDetailed;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffCheck;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 考勤管理
 * 
 * @author 拉布拉多是条狗
 *
 */
public interface CheckManageService {
	/**
	 * 添加一条空记录
	 * 
	 * @param checkDetailed
	 */
	public void addCheckDetailed(StaffCheck staffCheck);

	// 1-6次打卡
	public void check1(StaffCheck staffCheck);

	public void check2(StaffCheck staffCheck);

	public void check3(StaffCheck staffCheck);

	public void check4(StaffCheck staffCheck);

	public void check5(StaffCheck staffCheck);

	public void check6(StaffCheck staffCheck);
	
	public void updateState(CheckDetailed checkDetailed);
	// 1-6次打卡 -end

	/**
	 * 获取某日签到详细
	 * 
	 * @param day
	 * @return
	 */
	public List<CheckDetailed> getCheckDetailedByDay(String day);

	/**
	 * 获取某月签到详细
	 * 
	 * @param day
	 * @return
	 */
	public List<CheckDetailed> getCheckDetailedByDayMoth(String moth);

	/**
	 * 补签
	 * 
	 * @param checkDetailed
	 */
	public void supplementByStaffId(CheckDetailed checkDetailed);

	/**
	 * 查询某员工某天的签到
	 * 
	 * @param staffCheck
	 * @return
	 */
	public CheckDetailed getCheckDetailedByStaffCheck(StaffCheck staffCheck);

	/**
	 * 添加一个月排班
	 * 
	 * @param scheduling
	 */
	public void addScheduling(Scheduling scheduling);

	/**
	 * 获取一个月排班
	 * 
	 * @param month
	 * @return
	 */
	public Scheduling getSchedulingByMonth(String month);

	/**
	 * 删除排班
	 * 
	 * @param month
	 */
	public void delScheduling(String month);

	/**
	 * 获取排班
	 * 
	 * @param month
	 * @return
	 */
	public List<Scheduling> getSchedulingBySE(SelectEntity selectEntity);

	/**
	 * 获取数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getSchedulingNumberBySE(SelectEntity selectEntity);

	/**
	 * 更新排班
	 * 
	 * @param scheduling
	 */
	public void updateScheduling(Scheduling scheduling);

	/**
	 * 获取月份考勤记录
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<Check> getChecksBySE(SelectEntity selectEntity);

	/**
	 * 获取月份考勤记录数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getChecksNumberBySE(SelectEntity selectEntity);

	/**
	 * 获取考勤详细
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<CheckDetailed> getCheckDetailedsBySE(SelectEntity selectEntity);

	/**
	 * 获取考勤详细 数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getCheckDetailedsNumberBySE(SelectEntity selectEntity);

	/**
	 * 获取某月全部考勤
	 * 
	 * @param month
	 * @return
	 */
	public List<CheckDetailed> getCheckDetailedsByMoth(String month);

	/**
	 * 根据用户id与月份查找
	 * 
	 * @param staffCheck
	 * @return
	 */
	public CheckDetailed getCheckDetailedsByStaffCheck(StaffCheck staffCheck);

	/**
	 * 添加一个月的考勤情况
	 * 
	 * @param check
	 */
	public void addCheck(Check check);

	/**
	 * 更新一个月考勤情况
	 * 
	 * @param check
	 */
	public void updateCheck(Check check);

	/**
	 * 获取一个月考勤情况
	 * 
	 * @param month
	 * @return
	 */
	public Check getCheckByMonth(String month);

	/**
	 * 添加个人一个月考勤情况
	 * 
	 * @param staffCheckMonth
	 */
	public void addStaffCheckMonth(StaffCheckMonth staffCheckMonth);

	/**
	 * 更新一个月个人考勤情况
	 * 
	 * @param staffCheckMonth
	 */
	public void updateStaffCheckMonth(StaffCheckMonth staffCheckMonth);

	/**
	 * 获取一个月个人考勤情况
	 * 
	 * @param staffCheckMonth
	 * @return
	 */
	public StaffCheckMonth getStaffCheckMonthByMonth(StaffCheckMonth staffCheckMonth);

	/**
	 * 查询个人月份考勤情况
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<StaffCheckMonth> getStaffCheckMonthsBySE(SelectEntity selectEntity);

	/**
	 * 查询个人月份考勤情况 条数
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getStaffCheckMonthsNumberBySE(SelectEntity selectEntity);

	/**
	 * 获取月份考勤详细
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<StaffCheckMonth> getCheckMothDetailedsBySE(SelectEntity selectEntity);

	/**
	 * 获取月份考勤详细 数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getCheckMonthDetailedsNumberBySE(SelectEntity selectEntity);
}
