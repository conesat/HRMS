package com.nncq.sunmoon.entity;

/**
 * 调动职员
 * 
 * @author 拉布拉多是条狗
 *
 */
public class TransferStaff {
	private String staff_id;
	private String position_id;
	private String department_id;
	private String work_address_id;
	private String notice_title;
	private String notice_msg;
	private String notice_time;
	private String notice_staff_name;
	private String read_staff_id;
	public TransferStaff() {
		// TODO Auto-generated constructor stub
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getPosition_id() {
		return position_id;
	}
	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getWork_address_id() {
		return work_address_id;
	}
	public void setWork_address_id(String work_address_id) {
		this.work_address_id = work_address_id;
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
	@Override
	public String toString() {
		return "TransferStaff [staff_id=" + staff_id + ", position_id=" + position_id + ", department_id="
				+ department_id + ", work_address_id=" + work_address_id + ", notice_title=" + notice_title
				+ ", notice_msg=" + notice_msg + ", notice_time=" + notice_time + ", notice_staff_name="
				+ notice_staff_name + ", read_staff_id=" + read_staff_id + "]";
	}
	public TransferStaff(String staff_id, String position_id, String department_id, String work_address_id,
			String notice_title, String notice_msg, String notice_time, String notice_staff_name,
			String read_staff_id) {
		super();
		this.staff_id = staff_id;
		this.position_id = position_id;
		this.department_id = department_id;
		this.work_address_id = work_address_id;
		this.notice_title = notice_title;
		this.notice_msg = notice_msg;
		this.notice_time = notice_time;
		this.notice_staff_name = notice_staff_name;
		this.read_staff_id = read_staff_id;
	}
	
}
