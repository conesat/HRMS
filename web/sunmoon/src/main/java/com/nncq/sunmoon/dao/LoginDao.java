package com.nncq.sunmoon.dao;

import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;

public interface LoginDao {

	/**
	 * 查询是否存在员工ID
	 * 
	 * @param id
	 * @return 返回id存在条数
	 */
	public int existenceStaffID(String id);

	/**
	 * 根据账号密码查询存在几条员工信息
	 * 
	 * @param login （id 和密码）
	 * @return 返回信息条数
	 */
	public int verification(Login login);

	/**
	 * 根据id 查询员工所有信息
	 * 
	 * @param id
	 * @return 一个员工的所有信息
	 */

	public StaffAndPosition selectStaffData(String id);

	/**
	 * 根据身份证号登陆
	 * 
	 * @param idCard 身份证
	 * @return 员工id
	 */
	public String selectIDByIDCard(String idCard);
	
	/**
	 * 获取职员数量
	 * @return
	 */
	public Integer getStaffNumber();

}
