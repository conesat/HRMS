package com.nncq.sunmoon.entity;

public class Leave {
	public String leave_id;//自增ID
	private String leave_type;// 请假类型
	private String leave_start_time;//请假开始时间
	private String leave_end_time; //结束时间
	private String leave_msg;//备注时间
	private String leave_staff_name;// 请假人姓名
	private String leave_staff_id; //请假人工号
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Leave [leave_id=" + leave_id + ", leave_type=" + leave_type + ", leave_start_time=" + leave_start_time
				+ ", leave_end_time=" + leave_end_time + ", leave_msg=" + leave_msg + ", leave_staff_name="
				+ leave_staff_name + ", leave_staff_id=" + leave_staff_id + "]";
	}

	
	public Leave(String leave_id, String leave_type, String leave_start_time, String leave_end_time, String leave_msg,
			String leave_staff_name, String leave_staff_id) {
		super();
		this.leave_id = leave_id;
		this.leave_type = leave_type;
		this.leave_start_time = leave_start_time;
		this.leave_end_time = leave_end_time;
		this.leave_msg = leave_msg;
		this.leave_staff_name = leave_staff_name;
		this.leave_staff_id = leave_staff_id;
	}

	public String getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(String leave_id) {
		this.leave_id = leave_id;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getLeave_start_time() {
		return leave_start_time;
	}
	public void setLeave_start_time(String leave_start_time) {
		this.leave_start_time = leave_start_time;
	}
	public String getLeave_end_time() {
		return leave_end_time;
	}
	public void setLeave_end_time(String leave_end_time) {
		this.leave_end_time = leave_end_time;
	}
	public String getLeave_msg() {
		return leave_msg;
	}
	public void setLeave_msg(String leave_msg) {
		this.leave_msg = leave_msg;
	}
	public String getLeave_staff_name() {
		return leave_staff_name;
	}
	public void setLeave_staff_name(String leave_staff_name) {
		this.leave_staff_name = leave_staff_name;
	}
	public String getLeave_staff_id() {
		return leave_staff_id;
	}
	public void setLeave_staff_id(String leave_staff_id) {
		this.leave_staff_id = leave_staff_id;
	}


	
}