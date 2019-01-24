package com.nncq.sunmoon.entity;
/**
 * 
 * @author 拉布拉多是条狗
 *
 */
public class StaffIdAndNoticeId {
	private String staff_id;
	private String notice_id;
	private String department_id;

	public StaffIdAndNoticeId() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "StaffIdAndNoticeId [staff_id=" + staff_id + ", notice_id=" + notice_id + ", department_id="
				+ department_id + "]";
	}

	public StaffIdAndNoticeId(String staff_id, String notice_id, String department_id) {
		super();
		this.staff_id = staff_id;
		this.notice_id = notice_id;
		this.department_id = department_id;
	}


}
