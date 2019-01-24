package com.nncq.sunmoon.entity;
//部门表
public class Department {

	private String department_id;//部门id
	private String department_name;//部门名称
	private String department_describe;//部门描述
	private String parent_id;
	private String staff_id;//部门主管职员id
	private int department_use_state;
	
	public Department() {
		
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_describe() {
		return department_describe;
	}

	public void setDepartment_describe(String department_describe) {
		this.department_describe = department_describe;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public int getDepartment_use_state() {
		return department_use_state;
	}

	public void setDepartment_use_state(int department_use_state) {
		this.department_use_state = department_use_state;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_describe=" + department_describe + ", parent_id=" + parent_id + ", staff_id=" + staff_id
				+ ", department_use_state=" + department_use_state + "]";
	}

	public Department(String department_id, String department_name, String department_describe, String parent_id,
			String staff_id, int department_use_state) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_describe = department_describe;
		this.parent_id = parent_id;
		this.staff_id = staff_id;
		this.department_use_state = department_use_state;
	}

}
