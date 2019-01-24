package com.nncq.sunmoon.entity;
/**
 * 公告
 * @author 拉布拉多是条狗
 *
 */
public class Notice {
	private String notice_id;
	private String notice_title;
	private String notice_msg;
	private String notice_time;
	private String notice_staff_name;
	private String read_staff_id;
	private String notice_department_id;
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_msg() {
		return notice_msg;
	}
	public void setNotice_msg(String notice_msg) {
		this.notice_msg = notice_msg;
	}
	public String getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(String notice_time) {
		this.notice_time = notice_time;
	}
	public String getNotice_staff_name() {
		return notice_staff_name;
	}
	public void setNotice_staff_name(String notice_staff_name) {
		this.notice_staff_name = notice_staff_name;
	}
	public String getRead_staff_id() {
		return read_staff_id;
	}
	public void setRead_staff_id(String read_staff_id) {
		this.read_staff_id = read_staff_id;
	}
	public String getNotice_department_id() {
		return notice_department_id;
	}
	public void setNotice_department_id(String notice_department_id) {
		this.notice_department_id = notice_department_id;
	}
	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_msg=" + notice_msg
				+ ", notice_time=" + notice_time + ", notice_staff_name=" + notice_staff_name + ", read_staff_id="
				+ read_staff_id + ", notice_department_id=" + notice_department_id + "]";
	}
	public Notice(String notice_id, String notice_title, String notice_msg, String notice_time,
			String notice_staff_name, String read_staff_id, String notice_department_id) {
		super();
		this.notice_id = notice_id;
		this.notice_title = notice_title;
		this.notice_msg = notice_msg;
		this.notice_time = notice_time;
		this.notice_staff_name = notice_staff_name;
		this.read_staff_id = read_staff_id;
		this.notice_department_id = notice_department_id;
	}
	
}
