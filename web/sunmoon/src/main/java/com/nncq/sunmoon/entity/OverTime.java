package com.nncq.sunmoon.entity;
/**
 * 员工加班申请
 * @author 77
 *
 */
public class OverTime {
	public String overtime_id;//自增ID
	public String overtime_staff_id;
	public String overtime_staff_name;
	private String overtime_department;
	private String overtime_post;
	private String overtime_start_time;
	private String overtime_duration;
	private String overtime_end_time;
	private String overtime_msg;
	public OverTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OverTime(String overtime_id, String overtime_staff_id, String overtime_staff_name, String overtime_department,
			String overtime_post, String overtime_start_time, String overtime_duration, String overtime_end_time,
			String overtime_msg) {
		super();
		this.overtime_id = overtime_id;
		this.overtime_staff_id = overtime_staff_id;
		this.overtime_staff_name = overtime_staff_name;
		this.overtime_department = overtime_department;
		this.overtime_post = overtime_post;
		this.overtime_start_time = overtime_start_time;
		this.overtime_duration = overtime_duration;
		this.overtime_end_time = overtime_end_time;
		this.overtime_msg = overtime_msg;
	}
	@Override
	public String toString() {
		return "OverTime [overtime_id=" + overtime_id + ", overtime_staff_id=" + overtime_staff_id
				+ ", overtime_staff_name=" + overtime_staff_name + ", overtime_department=" + overtime_department
				+ ", overtime_post=" + overtime_post + ", overtime_start_time=" + overtime_start_time
				+ ", overtime_duration=" + overtime_duration + ", overtime_end_time=" + overtime_end_time
				+ ", overtime_msg=" + overtime_msg  + "]";
	}
	public String getOvertime_id() {
		return overtime_id;
	}
	public void setOvertime_id(String overtime_id) {
		this.overtime_id = overtime_id;
	}
	public String getOvertime_staff_id() {
		return overtime_staff_id;
	}
	public void setOvertime_staff_id(String overtime_staff_id) {
		this.overtime_staff_id = overtime_staff_id;
	}
	public String getOvertime_staff_name() {
		return overtime_staff_name;
	}
	public void setOvertime_staff_name(String overtime_staff_name) {
		this.overtime_staff_name = overtime_staff_name;
	}
	public String getOvertime_department() {
		return overtime_department;
	}
	public void setOvertime_department(String overtime_department) {
		this.overtime_department = overtime_department;
	}
	public String getOvertime_post() {
		return overtime_post;
	}
	public void setOvertime_post(String overtime_post) {
		this.overtime_post = overtime_post;
	}
	public String getOvertime_start_time() {
		return overtime_start_time;
	}
	public void setOvertime_start_time(String overtime_start_time) {
		this.overtime_start_time = overtime_start_time;
	}
	public String getOvertime_duration() {
		return overtime_duration;
	}
	public void setOvertime_duration(String overtime_duration) {
		this.overtime_duration = overtime_duration;
	}
	public String getOvertime_end_time() {
		return overtime_end_time;
	}
	public void setOvertime_end_time(String overtime_end_time) {
		this.overtime_end_time = overtime_end_time;
	}
	public String getOvertime_msg() {
		return overtime_msg;
	}
	public void setOvertime_msg(String overtime_msg) {
		this.overtime_msg = overtime_msg;
	}


}
