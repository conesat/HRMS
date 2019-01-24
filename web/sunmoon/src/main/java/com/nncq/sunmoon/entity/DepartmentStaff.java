package com.nncq.sunmoon.entity;

import java.util.List;

/**
 * 
 * @author duoduo
 *
 */
public class DepartmentStaff {
	private String department_id;
	private String department_name;
	private String department_describe;
	private String staff_id;
	private String staff_name;
	private int department_use_state;
	private String parent_id;
	private String parent_name;
	private List<DepartmentStaff> children;

	public DepartmentStaff() {
		// TODO Auto-generated constructor stub
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

	public int getDepartment_use_state() {
		return department_use_state;
	}

	public void setDepartment_use_state(int department_use_state) {
		this.department_use_state = department_use_state;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public List<DepartmentStaff> getChildren() {
		return children;
	}

	public void setChildren(List<DepartmentStaff> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "DepartmentStaff [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_describe=" + department_describe + ", staff_id=" + staff_id + ", staff_name="
				+ staff_name + ", department_use_state=" + department_use_state + ", parent_id=" + parent_id
				+ ", parent_name=" + parent_name + ", children=" + children + "]";
	}

	public DepartmentStaff(String department_id, String department_name, String department_describe, String staff_id,
			String staff_name, int department_use_state, String parent_id, String parent_name,
			List<DepartmentStaff> children) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_describe = department_describe;
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.department_use_state = department_use_state;
		this.parent_id = parent_id;
		this.parent_name = parent_name;
		this.children = children;
	}

}
