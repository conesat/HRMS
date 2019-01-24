package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.CompanyDao;
import com.nncq.sunmoon.entity.Company;
import com.nncq.sunmoon.service.CompanyService;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;

	public Company selectCompany() {
		Company re = null;
		try {
			re = companyDao.selectCompany();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	public int updateCompany(Company company) {
		try {
			companyDao.updateCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public void updateSalaryBase(Float salary_base) throws RuntimeException{
		companyDao.updateSalaryBase(salary_base);
	}

}
