package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.entity.StaffPay;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface SalaryDao {
	public void addSalary(MyPay myPay);

	public MyPay getMyPayByMyPay(MyPay myPay);

	public void updateSalary(MyPay myPay);
	
	public List<StaffPay> getStaffPayBySe(SelectEntity selectEntity);

	public int getStaffPayNumberBySe(SelectEntity selectEntity);

	public List<StaffPay> getNowStaffPayBySe(SelectEntity selectEntity);

	public int getNowStaffPayNumberBySe(SelectEntity selectEntity);
	
	public void payBeforMonth(String payTime);
	
}
