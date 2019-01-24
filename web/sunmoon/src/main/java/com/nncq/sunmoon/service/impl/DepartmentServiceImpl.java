package com.nncq.sunmoon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nncq.sunmoon.dao.DepartmentDao;
import com.nncq.sunmoon.entity.Department;
import com.nncq.sunmoon.entity.DepartmentStaff;
import com.nncq.sunmoon.service.DepartmentService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public void addDepartment(Department department) throws RuntimeException {
		String id = getLastId();
		if (id == null) {
			id = "DEP-1001";
		} else {
			id = "DEP-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		department.setDepartment_id(id);
		departmentDao.addDepartment(department);
	}

	public List<DepartmentStaff> getDepsBySE(SelectEntity selectEntity) {
		List<DepartmentStaff> re = null;
		try {
			re = departmentDao.getDepsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getDepsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = departmentDao.getDepsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public DepartmentStaff getDepById(String id) {
		DepartmentStaff re = null;
		try {
			re = departmentDao.getDepById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateDepartment(Department department) throws RuntimeException {
		departmentDao.updateDepartment(department);
	}

	public void delDepartment(String id) throws RuntimeException {
		departmentDao.delDepartment(id);
	}

	public String getLastId() {
		String re = null;
		try {
			re = departmentDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public DepartmentStaff getOrgChart() {
		DepartmentStaff re = null;
		try {
			re = departmentDao.getOrgChart();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Department> getAllOrgs() {
		List<Department> re = null;
		try {
			re = departmentDao.getAllOrgs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<Department> getAllMyOrgs(String dep_id) {
		List<Department> re = null;
		try {
			re = departmentDao.getAllMyOrgs(dep_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Department> getAllOrgsHadAdmin() {
		List<Department> re = null;
		try {
			re = departmentDao.getAllOrgsHadAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
