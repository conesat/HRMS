package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nncq.sunmoon.dao.WorkAddressDao;
import com.nncq.sunmoon.entity.WorkAddress;
import com.nncq.sunmoon.service.WorkAddressService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 工作地址管理
 * 
 * @author 拉布拉多是条狗
 *
 */
@Transactional
@Service
public class WorkAddressServiceImpl implements WorkAddressService {

	@Autowired
	private WorkAddressDao workAddressDao;

	public void addAddress(WorkAddress workAddress) throws RuntimeException {
		String id = getLastId();
		if (id == null) {
			id = "W-A-1001";
		} else {
			id = "W-A-" + (Integer.parseInt(id.split("-")[2]) + 1);
		}
		workAddress.setWork_address_id(id);
		workAddressDao.addAddress(workAddress);
	}

	public List<WorkAddress> getAddsBySE(SelectEntity selectEntity) {
		List<WorkAddress> re = null;
		try {
			re = workAddressDao.getAddsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public WorkAddress getAddById(String id) {
		WorkAddress re = null;
		try {
			re = workAddressDao.getAddById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateAddress(WorkAddress workAddress) throws RuntimeException {
		workAddressDao.updateAddress(workAddress);
	}

	public void delAddress(String id) throws RuntimeException {
		workAddressDao.delAddress(id);
	}

	public String getLastId() {
		String re = null;
		try {
			re = workAddressDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getAddsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = workAddressDao.getAddsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<WorkAddress> getAddsIdName() {
		List<WorkAddress> re = null;
		try {
			re = workAddressDao.getAddsIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateCheckSetting(WorkAddress workAddress) throws RuntimeException{
		workAddressDao.updateCheckSetting(workAddress);
		
	}

	 
	public WorkAddress getAddByStaffId(String id) {
		WorkAddress re = null;
		try {
			re = workAddressDao.getAddByStaffId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
