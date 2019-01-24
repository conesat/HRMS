package com.nncq.sunmoon.dao;

import com.nncq.sunmoon.entity.StaffCheckMonth;

public interface MyAttendanceDao {
	/**
	 * 员工端 考勤
	 * @param id
	 * @return
	 */
public StaffCheckMonth selectAttendance(StaffCheckMonth staffCheckMonth);

}
