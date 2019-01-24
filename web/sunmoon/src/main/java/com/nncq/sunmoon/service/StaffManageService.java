package com.nncq.sunmoon.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.AdminTransferStaff;
import com.nncq.sunmoon.entity.ChartsKeyValue;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffContract;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.entity.StaffIdSetting;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface StaffManageService {

	public String addStaff(Staff staff);

	public void addLogin(Staff staff);

	public List<Staff> getStaffsBySE(SelectEntity selectEntity);

	public int getStaffsNumberBySE(SelectEntity selectEntity);

	public Staff getStaffById(String id);

	public void updateStaff(Staff staff);

	public void delStaff(String id);

	public String getLastId();

	public List<StaffIdName> getAllStaffIdName();

	public void updateStaffIdSetting(StaffIdSetting staffIdSetting);

	public StaffIdSetting getStaffIdSetting();

	public int getStaffNumber();

	public void updateImagOne(Staff staff);

	public void updateImagTow(Staff staff);

	public void updateImagThree(Staff staff);

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public StaffAndPosition selectStaffData(String id);

	/**
	 * 添加员工合同
	 * 
	 * @param staffContract
	 */
	public void addStaffContract(StaffContract staffContract);

	/**
	 * 更新员工合同
	 * 
	 * @param staffContract
	 */
	public void updateStaffContract(StaffContract staffContract);

	/**
	 * 获取员工合同
	 * 
	 * @param id
	 * @return
	 */
	public List<StaffContract> getStaffContractByStaffId(String id);

	/**
	 * 转正
	 * 
	 * @param id
	 */
	public void regularStaff(String id);

	/**
	 * 离职
	 * 
	 * @param id
	 */
	public void quitStaff(String id);

	/**
	 * 调动
	 * 
	 * @param staff
	 */
	public void transferStaff(Staff staff, Notice notice);

	/**
	 * 重置密码
	 * 
	 * @param login0
	 */
	public void resetPassword(Login login0);

	/**
	 * 设置密码
	 * 
	 * @param login
	 */
	public void setPassword(Login login);

	/**
	 * 获取性别与数量
	 * 
	 * @return
	 */
	public List<ChartsKeyValue> getStaffSex();

	/**
	 * 获取年龄比例
	 * 
	 * @return
	 */
	public List<ChartsKeyValue> getAgeProp();

	/**
	 * 获取工作地址分布
	 * 
	 * @return
	 */
	public List<ChartsKeyValue> getWorkAddProp();

	/**
	 * 获取薪资比例
	 * 
	 * @return
	 */
	public List<ChartsKeyValue> getPayProp();

	/**
	 * 获取可操作的用户
	 * 
	 * @return
	 */
	public List<StaffIdName> getDepartmentStaff(StaffAndPosition staffAndPosition);

	/**
	 * 调动申请
	 * 
	 * @param staffAndPosition
	 */
	public void transferAdminStaff(AdminTransferStaff adminTransferStaff);
	
	public AdminTransferStaff getTransferAdminStaff(String id);
	
	public void transferStaffRes(String state,String id);
	
	public List<StaffAndPosition> getStaffByDepId(SelectEntity selectEntity);
	
	public int getStaffNumberByDepId(SelectEntity selectEntity);
}
