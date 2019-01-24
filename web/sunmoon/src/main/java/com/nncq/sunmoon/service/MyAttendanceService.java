package com.nncq.sunmoon.service;

import com.nncq.sunmoon.entity.StaffCheckMonth;

public interface MyAttendanceService {
	/**
	 * 员工端 考勤
	 * @param id
	 * @return
	 */
public StaffCheckMonth selectAttendance(StaffCheckMonth staffCheckMonth);

}
