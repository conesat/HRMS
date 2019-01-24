package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 部门管理
 * 
 * @author duoduo
 *
 */
public interface DepartmentDao {

	/**
	 * 添加一个部门
	 * 
	 * @param department
	 */
	public void addDepartment(Department department);

	/**
	 * 嵌套查询部门
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<DepartmentStaff> getDepsBySE(SelectEntity selectEntity);

	/**
	 * 嵌套查询部门数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getDepsNumberBySE(SelectEntity selectEntity);

	/**
	 * 根据id获取部门
	 * 
	 * @param id
	 * @return
	 */
	public DepartmentStaff getDepById(String id);
	
	/**
	 * 获取组织架构
	 * @return
	 */
	public DepartmentStaff getOrgChart();

	/**
	 * 更新部门
	 * 
	 * @param department
	 */
	public void updateDepartment(Department department);

	/**
	 * 删除部门
	 * 
	 * @param id
	 */
	public void delDepartment(String id);
	

	/**
	 * 获取最后一条id
	 * 
	 * @return
	 */
	public String getLastId();
	
	/**
	 * 获取全部部门
	 * @return
	 */
	public List<Department> getAllOrgs();
	
	public List<Department> getAllMyOrgs(String dep_id);
	
	public List<Department> getAllOrgsHadAdmin();
	
}
