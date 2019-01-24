package com.nncq.sunmoon.entity;

/**
 * 签到
 * @author 拉布拉多是条狗
 *
 */
public class StaffCheck {
	private String staff_id;//签到的账号
	private String check_time;//签到的时间
	private String check_day;//签到的时间
	public StaffCheck() {
		// TODO Auto-generated constructor stub
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_day() {
		return check_day;
	}
	public void setCheck_day(String check_day) {
		this.check_day = check_day;
	}
	@Override
	public String toString() {
		return "StaffCheck [staff_id=" + staff_id + ", check_time=" + check_time + ", check_day=" + check_day + "]";
	}
	public StaffCheck(String staff_id, String check_time, String check_day) {
		super();
		this.staff_id = staff_id;
		this.check_time = check_time;
		this.check_day = check_day;
	}
	
	
}
