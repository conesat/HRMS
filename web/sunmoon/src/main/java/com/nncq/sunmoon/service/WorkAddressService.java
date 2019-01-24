package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.WorkAddress;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 工作地址管理
 * 
 * @author 拉布拉多是条狗
 *
 */
public interface WorkAddressService {
	/**
	 * 添加一个工作地址
	 * 
	 * @param workAddress 新的工作地址
	 */
	public void addAddress(WorkAddress workAddress);

	/**
	 * 使用嵌套查询 查询工作地址
	 * 
	 * @return 查询到的地址集合
	 */
	public List<WorkAddress> getAddsBySE(SelectEntity selectEntity);

	/**
	 * 使用嵌套查询 获取条数
	 * 
	 * @param selectEntity
	 * @return 天数
	 */
	public int getAddsNumberBySE(SelectEntity selectEntity);

	/**
	 * 根据id获取精确地址
	 * 
	 * @return 查询到的地址
	 */
	public WorkAddress getAddById(String id);

	/**
	 * 更新一个工作地址
	 * 
	 * @param workAddress 需要更新的地址 id不能改变
	 */
	public void updateAddress(WorkAddress workAddress);

	/**
	 * 删除一个工作地址
	 * 
	 * @param id 地址的id
	 */
	public void delAddress(String id);

	/**
	 * 获取最后一条记录的id
	 * 
	 * @return
	 */
	public String getLastId();

	/**
	 * 获取地址id与名称
	 * 
	 * @return
	 */
	public List<WorkAddress> getAddsIdName();

	/**
	 * 更新地址考勤设置
	 * 
	 * @param workAddress
	 */
	public void updateCheckSetting(WorkAddress workAddress);

	/**
	 * 根据职员id获取地址
	 * 
	 * @param id
	 * @return
	 */
	public WorkAddress getAddByStaffId(String id);
}
