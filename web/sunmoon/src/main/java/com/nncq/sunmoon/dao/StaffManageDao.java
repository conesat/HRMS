package com.nncq.sunmoon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.AdminTransferStaff;
import com.nncq.sunmoon.entity.ChartsKeyValue;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffContract;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.entity.StaffIdSetting;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 员工管理
 * 
 * @author 拉布拉多是条狗
 *
 */
public interface StaffManageDao {

	/**
	 * 添加一个员工
	 * @param staff
	 */
	public void addStaff(Staff staff);
	
	/**
	 * 添加登录信息
	 * @param staff
	 */
	public void addLogin(Staff staff);

	/**
	 * 搜索员工
	 * @param selectEntity
	 * @return
	 */
	public List<Staff> getStaffsBySE(SelectEntity selectEntity);

	/**
	 * 获取搜索总数
	 * @param selectEntity
	 * @return
	 */
	public int getStaffsNumberBySE(SelectEntity selectEntity);

	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public Staff getStaffById(String id);

	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public StaffAndPosition selectStaffData(String id);
	

	/**
	 * 更新员工信息
	 * @param staff
	 */
	public void updateStaff(Staff staff);

	/**
	 * 删除员工
	 * @param id
	 */
	public void delStaff(String id);

	/**
	 * 获取最后一条id
	 * @return
	 */
	public String getLastId();

	/**
	 * 获取全部员工id与名字
	 * @return
	 */
	public List<StaffIdName> getAllStaffIdName();
	
	/**
	 * 更新工号设置
	 * @param staffIdSetting
	 */
	public void updateStaffIdSetting(StaffIdSetting staffIdSetting);
	
	/**
	 * 获取工号设置
	 * @return
	 */
	public StaffIdSetting getStaffIdSetting();
	
	/**
	 * 获取总员工数
	 * @return
	 */
	public int getStaffNumber();
	
	/**
	 * 更新身份证正面图片地址
	 * @param staff
	 */
	public void updateImagOne(Staff staff);
	
	/**
	 * 更新身份证反面图片地址
	 * @param staff
	 */
	public void updateImagTow(Staff staff);
	
	/**
	 * 更新一寸照
	 * @param staff
	 */
	public void updateImagThree(Staff staff);
	
	/**
	 * 添加员工合同
	 * @param staffContract
	 */
	public void addStaffContract(StaffContract staffContract);
	
	/**
	 * 更新员工合同
	 * @param staffContract
	 */
	public void updateStaffContract(StaffContract staffContract);
	
	/**
	 * 获取员工合同
	 * @param id
	 * @return
	 */
	public List<StaffContract> getStaffContractByStaffId(String id);

	/**
	 * 转正
	 * @param id
	 */
	public void regularStaff(String id);
	
	/**
	 * 离职
	 * @param id
	 */
	public void quitStaff(String id);
	
	/**
	 * 调动
	 * @param staff
	 */
	public void transferStaff(Staff staff);
	
	/**
	 * 重置密码
	 * @param login
	 */
	public void resetPassword(Login login);
	
	/**
	 * 设置密码
	 * @param login
	 */
	public void setPassword(Login login);
	
	/**
	 * 获取性别与数量
	 * @return
	 */
	public List<ChartsKeyValue> getStaffSex();
	
	/**
	 * 获取年龄比例
	 * @return
	 */
	public List<ChartsKeyValue> getAgeProp();
	
	/**
	 * 获取工作地址分布
	 * @return
	 */
	public List<ChartsKeyValue> getWorkAddProp();
	
	/**
	 * 获取薪资比例
	 * @return
	 */
	public List<ChartsKeyValue> getPayProp();
	
	/**
	 * 获取可操作的用户
	 * @return
	 */
	public List<StaffIdName> getDepartmentStaff(StaffAndPosition staffAndPosition);
	
	/**
	 * 调动申请
	 * @param staffAndPosition
	 */
	public void transferAdminStaff(AdminTransferStaff adminTransferStaff);
	
	public AdminTransferStaff getTransferAdminStaff(String id);
	
	public void transferStaffRes(@Param("state") String state,@Param("id") String id);
	
	public List<StaffAndPosition> getStaffByDepId(SelectEntity selectEntity);
	
	public int getStaffNumberByDepId(SelectEntity selectEntity);
	
}
