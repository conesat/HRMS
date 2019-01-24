package com.nncq.sunmoon.entity;

/**
 * 
 * @author 拉布拉多是条狗
 *
 */
public class StaffIdName {
	private String staff_id;
	private String staff_name;
	private String staff_in_date;

	public StaffIdName() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_in_date() {
		return staff_in_date;
	}

	public void setStaff_in_date(String staff_in_date) {
		this.staff_in_date = staff_in_date;
	}

	@Override
	public String toString() {
		return "StaffIdName [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_in_date=" + staff_in_date
				+ "]";
	}

	public StaffIdName(String staff_id, String staff_name, String staff_in_date) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_in_date = staff_in_date;
	}

}
