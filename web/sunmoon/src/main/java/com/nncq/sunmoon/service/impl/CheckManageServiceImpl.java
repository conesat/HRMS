package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.CheckManageDao;
import com.nncq.sunmoon.entity.Check;
import com.nncq.sunmoon.entity.CheckDetailed;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffCheck;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class CheckManageServiceImpl implements CheckManageService {
	
	@Autowired
	private CheckManageDao checkManageDao;

	 
	public void addCheckDetailed(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.addCheckDetailed(staffCheck);
	}

	 
	public List<CheckDetailed> getCheckDetailedByDay(String day) {
		List<CheckDetailed> re=null;
		try {
			re=checkManageDao.getCheckDetailedByDay(day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<CheckDetailed> getCheckDetailedByDayMoth(String moth) {
		List<CheckDetailed> re=null;
		try {
			re=checkManageDao.getCheckDetailedByDayMoth(moth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void supplementByStaffId(CheckDetailed checkDetailed) throws RuntimeException{
		checkManageDao.supplementByStaffId(checkDetailed);
	}

	 
	public void check1(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check1(staffCheck);
	}

	 
	public void check2(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check2(staffCheck);
	}

	 
	public void check3(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check3(staffCheck);
	}

	 
	public void check4(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check4(staffCheck);
	}

	 
	public void check5(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check5(staffCheck);
	}

	 
	public void check6(StaffCheck staffCheck) throws RuntimeException{
		checkManageDao.check6(staffCheck);
	}
	
	 
	public void updateState(CheckDetailed checkDetailed) throws RuntimeException{
		checkManageDao.updateState(checkDetailed);
	}

	 
	public CheckDetailed getCheckDetailedByStaffCheck(StaffCheck staffCheck) {
		CheckDetailed re=null;
		try {
			re=checkManageDao.getCheckDetailedByStaffCheck(staffCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void addScheduling(Scheduling scheduling) throws RuntimeException{
		checkManageDao.addScheduling(scheduling);
	}

	 
	public Scheduling getSchedulingByMonth(String month) {
		Scheduling re=null;
		try {
			re=checkManageDao.getSchedulingByMonth(month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void delScheduling(String month) throws RuntimeException{
		checkManageDao.delScheduling(month);
	}

	 
	public List<Scheduling> getSchedulingBySE(SelectEntity selectEntity) {
		List<Scheduling> re=null;
		try {
			re=checkManageDao.getSchedulingBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getSchedulingNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
			re=checkManageDao.getSchedulingNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateScheduling(Scheduling scheduling) throws RuntimeException{
		checkManageDao.updateScheduling(scheduling);
	}

	 
	public List<Check> getChecksBySE(SelectEntity selectEntity) {
		List<Check> re=null;
		try {
			re=checkManageDao.getChecksBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getChecksNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
			re=checkManageDao.getChecksNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<CheckDetailed> getCheckDetailedsBySE(SelectEntity selectEntity) {
		List<CheckDetailed> re=null;
		try {
			re=checkManageDao.getCheckDetailedsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getCheckDetailedsNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
			re=checkManageDao.getCheckDetailedsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<CheckDetailed> getCheckDetailedsByMoth(String month) {
		List<CheckDetailed> re=null;
		try {
			re=checkManageDao.getCheckDetailedsByMoth(month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public CheckDetailed getCheckDetailedsByStaffCheck(StaffCheck staffCheck) {
		CheckDetailed re=null;
		try {
			re=checkManageDao.getCheckDetailedsByStaffCheck(staffCheck);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void addCheck(Check check) throws RuntimeException{
		checkManageDao.addCheck(check);
	}

	 
	public void updateCheck(Check check) throws RuntimeException {
		checkManageDao.updateCheck(check);
	}

	 
	public Check getCheckByMonth(String month) {
		Check re=null;
		try {
			re=checkManageDao.getCheckByMonth(month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void addStaffCheckMonth(StaffCheckMonth staffCheckMonth)  throws RuntimeException{
		checkManageDao.addStaffCheckMonth(staffCheckMonth);
	}

	 
	public void updateStaffCheckMonth(StaffCheckMonth staffCheckMonth)  throws RuntimeException{
		checkManageDao.updateStaffCheckMonth(staffCheckMonth);
	}

	 
	public StaffCheckMonth getStaffCheckMonthByMonth(StaffCheckMonth staffCheckMonth) {
		StaffCheckMonth re=null;
		try {
			re=checkManageDao.getStaffCheckMonthByMonth(staffCheckMonth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<StaffCheckMonth> getStaffCheckMonthsBySE(SelectEntity selectEntity) {
		List<StaffCheckMonth> re=null;
		try {
			re=checkManageDao.getStaffCheckMonthsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getStaffCheckMonthsNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
			re=checkManageDao.getStaffCheckMonthsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<StaffCheckMonth> getCheckMothDetailedsBySE(SelectEntity selectEntity) {
		List<StaffCheckMonth> re=null;
		try {
			re=checkManageDao.getCheckMothDetailedsBySE( selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getCheckMonthDetailedsNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
			re=checkManageDao.getCheckMonthDetailedsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	

}
