package com.nncq.sunmoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.MyAttendanceDao;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.service.MyAttendanceService;
@Service
public class MyAttendanceServiceImpl implements MyAttendanceService{
	@Autowired
	public MyAttendanceDao myAttendanceDao;
	 
	public StaffCheckMonth selectAttendance(StaffCheckMonth staffCheckMonth) {
		StaffCheckMonth staffCheckMonth2=null;
		try {
			 staffCheckMonth2=myAttendanceDao.selectAttendance(staffCheckMonth);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return staffCheckMonth2;
	}

}
