package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.LoginDao;
import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.service.LoginService;

/**
 * 
 * @author 77 登录的实现类。
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	public int existenceStaffID(String id) {
		int re = 0;
		try {
			re = loginDao.existenceStaffID(id);

		} catch (Exception e) {
			re = -1;
			e.printStackTrace();
		}
		return re;
	}

	public int verification(Login login) {
		int re = 0;
		try {
			re = loginDao.verification(login);

		} catch (Exception e) {
			re = -1;
			e.printStackTrace();
		}
		return re;
	}

	public StaffAndPosition selectStaffData(String id) {

		StaffAndPosition re = null;
		try {
			re = loginDao.selectStaffData(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public String selectIDByIDCard(String idCard) {
		String re = null;
		try {
			re = loginDao.selectIDByIDCard(idCard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public Integer getStaffNumber() {
		Integer re = null;
		try {
			re = loginDao.getStaffNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
