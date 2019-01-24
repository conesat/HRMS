package com.nncq.sunmoon.entity;

public class StaffContractDTO {
	private String staff_id;
	private String staff_name;
	private String position_name;
	private String department_name;
	private String contract_name;
	private String contract_id;
	private String end_time;
	private String state;
	public StaffContractDTO() {
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
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "StaffContractDTO [staff_id=" + staff_id + ", staff_name=" + staff_name + ", position_name="
				+ position_name + ", department_name=" + department_name + ", contract_name=" + contract_name
				+ ", contract_id=" + contract_id + ", end_time=" + end_time + ", state=" + state + "]";
	}
	public StaffContractDTO(String staff_id, String staff_name, String position_name, String department_name,
			String contract_name, String contract_id, String end_time, String state) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.position_name = position_name;
		this.department_name = department_name;
		this.contract_name = contract_name;
		this.contract_id = contract_id;
		this.end_time = end_time;
		this.state = state;
	}
	
	
}
