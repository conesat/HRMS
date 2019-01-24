package com.nncq.sunmoon.entity;

public class AdminTransferStaff {
	private String id;
	private String department_id;
	private String object_department_id;
	private String department_name;
	private String object_department_name;
	private String staff_id;
	private String staff_name;
	private String apply_staff_id;
	private String apply_staff_name;
	private String object_staff_id;
	private String transfer_type;
	private String msg;
	private String state;
	public AdminTransferStaff() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getObject_department_id() {
		return object_department_id;
	}
	public void setObject_department_id(String object_department_id) {
		this.object_department_id = object_department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getObject_department_name() {
		return object_department_name;
	}
	public void setObject_department_name(String object_department_name) {
		this.object_department_name = object_department_name;
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
	public String getApply_staff_id() {
		return apply_staff_id;
	}
	public void setApply_staff_id(String apply_staff_id) {
		this.apply_staff_id = apply_staff_id;
	}
	public String getApply_staff_name() {
		return apply_staff_name;
	}
	public void setApply_staff_name(String apply_staff_name) {
		this.apply_staff_name = apply_staff_name;
	}
	public String getObject_staff_id() {
		return object_staff_id;
	}
	public void setObject_staff_id(String object_staff_id) {
		this.object_staff_id = object_staff_id;
	}
	public String getTransfer_type() {
		return transfer_type;
	}
	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "AdminTransferStaff [id=" + id + ", department_id=" + department_id + ", object_department_id="
				+ object_department_id + ", department_name=" + department_name + ", object_department_name="
				+ object_department_name + ", staff_id=" + staff_id + ", staff_name=" + staff_name + ", apply_staff_id="
				+ apply_staff_id + ", apply_staff_name=" + apply_staff_name + ", object_staff_id=" + object_staff_id
				+ ", transfer_type=" + transfer_type + ", msg=" + msg + ", state=" + state + "]";
	}
	public AdminTransferStaff(String id, String department_id, String object_department_id, String department_name,
			String object_department_name, String staff_id, String staff_name, String apply_staff_id,
			String apply_staff_name, String object_staff_id, String transfer_type, String msg, String state) {
		super();
		this.id = id;
		this.department_id = department_id;
		this.object_department_id = object_department_id;
		this.department_name = department_name;
		this.object_department_name = object_department_name;
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.apply_staff_id = apply_staff_id;
		this.apply_staff_name = apply_staff_name;
		this.object_staff_id = object_staff_id;
		this.transfer_type = transfer_type;
		this.msg = msg;
		this.state = state;
	}
	
}
