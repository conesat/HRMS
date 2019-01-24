package com.nncq.sunmoon.entity;

public class StaffPay {
	private String actual_pay;// 实际工资
	private String staff_name;// 姓名
	private String staff_id;// 工号
	private String work_address_name;// 工作地址
	private String department_name;// 部门
	private String position_name;// 职位
	private String mypay_moth;// 月份
	private String mypay_time;// 发工资时间
	
	public StaffPay() {
		// TODO Auto-generated constructor stub
	}

	public String getActual_pay() {
		return actual_pay;
	}

	public void setActual_pay(String actual_pay) {
		this.actual_pay = actual_pay;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
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

	public String getMypay_moth() {
		return mypay_moth;
	}

	public void setMypay_moth(String mypay_moth) {
		this.mypay_moth = mypay_moth;
	}

	public String getMypay_time() {
		return mypay_time;
	}

	public void setMypay_time(String mypay_time) {
		this.mypay_time = mypay_time;
	}

	@Override
	public String toString() {
		return "StaffPay [actual_pay=" + actual_pay + ", staff_name=" + staff_name + ", staff_id=" + staff_id
				+ ", work_address_name=" + work_address_name + ", department_name=" + department_name
				+ ", position_name=" + position_name + ", mypay_moth=" + mypay_moth + ", mypay_time=" + mypay_time
				+ "]";
	}

	public StaffPay(String actual_pay, String staff_name, String staff_id, String work_address_name,
			String department_name, String position_name, String mypay_moth, String mypay_time) {
		super();
		this.actual_pay = actual_pay;
		this.staff_name = staff_name;
		this.staff_id = staff_id;
		this.work_address_name = work_address_name;
		this.department_name = department_name;
		this.position_name = position_name;
		this.mypay_moth = mypay_moth;
		this.mypay_time = mypay_time;
	}
	
}
