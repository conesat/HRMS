package com.nncq.sunmoon.entity;

public class Performance {
	private String staff_id;
	private String month;
	private float performance;
	private String staff_name;
	private String staff_sex;
	private String work_address_name;
	private String department_name;
	private String position_name;
	private String staff_phone;
	
	public Performance() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getPerformance() {
		return performance;
	}

	public void setPerformance(float performance) {
		this.performance = performance;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_sex() {
		return staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}

	public String getWork_address_name() {
		return work_address_name;
	}

	public void setWork_address_name(String work_address_name) {
		this.work_address_name = work_address_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	@Override
	public String toString() {
		return "Performance [staff_id=" + staff_id + ", month=" + month + ", performance=" + performance
				+ ", staff_name=" + staff_name + ", staff_sex=" + staff_sex + ", work_address_name=" + work_address_name
				+ ", department_name=" + department_name + ", position_name=" + position_name + ", staff_phone="
				+ staff_phone + "]";
	}

	public Performance(String staff_id, String month, float performance, String staff_name, String staff_sex,
			String work_address_name, String department_name, String position_name, String staff_phone) {
		super();
		this.staff_id = staff_id;
		this.month = month;
		this.performance = performance;
		this.staff_name = staff_name;
		this.staff_sex = staff_sex;
		this.work_address_name = work_address_name;
		this.department_name = department_name;
		this.position_name = position_name;
		this.staff_phone = staff_phone;
	}

	
	
}
