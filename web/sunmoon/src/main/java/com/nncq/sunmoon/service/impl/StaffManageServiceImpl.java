package com.nncq.sunmoon.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.MsgDao;
import com.nncq.sunmoon.dao.NoticeDao;
import com.nncq.sunmoon.dao.StaffManageDao;
import com.nncq.sunmoon.entity.Login;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.AdminTransferStaff;
import com.nncq.sunmoon.entity.ChartsKeyValue;
import com.nncq.sunmoon.entity.Staff;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffContract;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.entity.StaffIdSetting;
import com.nncq.sunmoon.service.StaffManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Service
public class StaffManageServiceImpl implements StaffManageService {
	@Autowired
	private StaffManageDao staffManageDao;

	@Autowired
	private NoticeDao noticeDao;

	@Autowired
	private MsgDao msgDao;

	public String addStaff(Staff staff) throws RuntimeException {
		String id = staff.getStaff_id();
		String mid = "";
		StaffIdSetting setting = getStaffIdSetting();
		staff.setStaff_password(setting.getPassword());
		if (setting.getAuto().compareTo("on") == 0) {
			int num = getStaffNumber();
			if (num < 10) {
				mid = "000";
			} else if (num < 100) {
				mid = "00";
			} else if (num < 1000) {
				mid = "0";
			}
			if (setting.getMiddle().compareTo("1") == 0) {
				mid += Calendar.getInstance().get(Calendar.YEAR) + num + "";
			} else {
				mid += num + "";
			}
			if (!setting.getPrefix().equals("")) {
				id = setting.getPrefix() + setting.getSeparate();
			}
			id += mid;
			if (!setting.getSuffix().equals("")) {
				id += setting.getSeparate() + setting.getSuffix();
			}
			staff.setStaff_id(id);
		}
		staffManageDao.addStaff(staff);
		staffManageDao.addLogin(staff);
		return id;
	}

	public List<Staff> getStaffsBySE(SelectEntity selectEntity) {
		List<Staff> re = null;
		try {
			re = staffManageDao.getStaffsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getStaffsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = staffManageDao.getStaffsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Staff getStaffById(String id) {
		Staff re = null;
		try {
			re = staffManageDao.getStaffById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateStaff(Staff staff) throws RuntimeException {
		staffManageDao.updateStaff(staff);
	}

	public void delStaff(String id) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	public String getLastId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StaffIdName> getAllStaffIdName() {
		List<StaffIdName> re = null;
		try {
			re = staffManageDao.getAllStaffIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateStaffIdSetting(StaffIdSetting staffIdSetting) throws RuntimeException {
		staffManageDao.updateStaffIdSetting(staffIdSetting);

	}

	public StaffIdSetting getStaffIdSetting() {
		StaffIdSetting re = null;
		try {
			re = staffManageDao.getStaffIdSetting();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getStaffNumber() {
		return staffManageDao.getStaffNumber();
	}

	public void addLogin(Staff staff) throws RuntimeException {
		staffManageDao.addLogin(staff);
	}

	public void updateImagOne(Staff staff) throws RuntimeException {
		staffManageDao.updateImagOne(staff);
	}

	public void updateImagTow(Staff staff) throws RuntimeException {
		staffManageDao.updateImagTow(staff);
	}

	public void updateImagThree(Staff staff) throws RuntimeException {
		staffManageDao.updateImagThree(staff);
	}

	public void addStaffContract(StaffContract staffContract) throws RuntimeException {
		staffManageDao.addStaffContract(staffContract);
	}

	public void updateStaffContract(StaffContract staffContract) throws RuntimeException {
		staffManageDao.updateStaffContract(staffContract);
	}

	public List<StaffContract> getStaffContractByStaffId(String id) {
		List<StaffContract> re = null;
		try {
			re = staffManageDao.getStaffContractByStaffId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void regularStaff(String id) throws RuntimeException {
		staffManageDao.regularStaff(id);
	}

	public void quitStaff(String id) throws RuntimeException {
		staffManageDao.quitStaff(id);
	}

	public void transferStaff(Staff staff, Notice notice) throws RuntimeException {
		staffManageDao.transferStaff(staff);
		noticeDao.addNotice(notice);

	}

	public void resetPassword(Login login) {
		StaffIdSetting setting = getStaffIdSetting();
		login.setStaff_password(setting.getPassword());
		staffManageDao.resetPassword(login);
	}

	public void setPassword(Login login) throws RuntimeException {
		staffManageDao.setPassword(login);
	}

	public List<ChartsKeyValue> getStaffSex() {
		List<ChartsKeyValue> re = null;
		try {
			re = staffManageDao.getStaffSex();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<ChartsKeyValue> getAgeProp() {
		List<ChartsKeyValue> re = null;
		try {
			re = staffManageDao.getAgeProp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<ChartsKeyValue> getWorkAddProp() {
		List<ChartsKeyValue> re = null;
		try {
			re = staffManageDao.getWorkAddProp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<ChartsKeyValue> getPayProp() {
		List<ChartsKeyValue> re = null;
		try {
			re = staffManageDao.getPayProp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public StaffAndPosition selectStaffData(String id) {
		StaffAndPosition re = null;
		try {
			re = staffManageDao.selectStaffData(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<StaffIdName> getDepartmentStaff(StaffAndPosition staffAndPosition) {
		List<StaffIdName> re = null;
		try {
			re = staffManageDao.getDepartmentStaff(staffAndPosition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	

	public void transferAdminStaff(AdminTransferStaff adminTransferStaff) throws RuntimeException {
		adminTransferStaff.setId(Long.toString((new Date()).getTime()));
		Msg msg = new Msg();
		msg.setType("staff_id");
		msg.setObject_id(adminTransferStaff.getObject_staff_id());
		msg.setMsg_type("sys");
		msg.setMsg_title("职员调动申请");
		msg.setMsg_body(adminTransferStaff.getMsg()+"<br><a href=staffManage/gotoTransferStaff?id="+adminTransferStaff.getId()+" target=view_window>点击进入详细</a>");
		msg.setSend_id(adminTransferStaff.getApply_staff_id());
		msg.setSend_name(adminTransferStaff.getApply_staff_name());
		msg.setSend_time(Datetool.getTimeNowThroughDate());
		msgDao.addMsg(msg);
		adminTransferStaff.setState("待反馈");
		staffManageDao.transferAdminStaff(adminTransferStaff);
		
	}

	public AdminTransferStaff getTransferAdminStaff(String id) {
		AdminTransferStaff re = null;
		try {
			re = staffManageDao.getTransferAdminStaff(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void transferStaffRes(String state, String id) throws RuntimeException{
		staffManageDao.transferStaffRes(state, id);
	}

	public List<StaffAndPosition> getStaffByDepId(SelectEntity selectEntity) {
		List<StaffAndPosition> re = null;
		try {
			re = staffManageDao.getStaffByDepId(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getStaffNumberByDepId(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = staffManageDao.getStaffNumberByDepId(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
}
