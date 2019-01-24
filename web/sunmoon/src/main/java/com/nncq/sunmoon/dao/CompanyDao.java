package com.nncq.sunmoon.dao;

import com.nncq.sunmoon.entity.Company;

public interface CompanyDao {

	/**
	 * 修改公司信息
	 * 
	 * @return
	 */
	public int updateCompany(Company company);

	/**
	 * 查询已有的公司信息
	 * 
	 * @param id
	 * @return 返回所有信息。
	 */
	public Company selectCompany();

	/**
	 * 更新基本工资
	 * 
	 * @param salary_base
	 */
	public void updateSalaryBase(Float salary_base);

}
