package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.entity.StaffPay;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface SalaryService {
	
	/**
	 * 添加一条
	 * @param staffPay
	 */
	public void addSalary(MyPay myPay);

	/**
	 * 获取薪资某个记录
	 * @param staffPay
	 * @return
	 */
	public MyPay getMyPayByMyPay(MyPay myPay);

	/**
	 * 更新 薪资
	 * @param staffPay
	 */
	public void updateSalary(MyPay myPay);
	
	/**
	 * 获取历史发放薪资
	 * @param selectEntity
	 * @return
	 */
	public List<StaffPay> getStaffPayBySe(SelectEntity selectEntity);

	/**
	 * 获取历史发放薪资查询数
	 * @param selectEntity
	 * @return
	 */
	public int getStaffPayNumberBySe(SelectEntity selectEntity);

	/**
	 * 获取核对列表
	 * @param selectEntity
	 * @return
	 */
	public List<StaffPay> getNowStaffPayBySe(SelectEntity selectEntity);

	/**
	 * 获取核对列表 查询数
	 * @param selectEntity
	 * @return
	 */
	public int getNowStaffPayNumberBySe(SelectEntity selectEntity);
	
	/**
	 * 发放上一个月工资
	 * @param myPay
	 */
	public void payBeforMonth(String payTime);

}
