package com.nncq.sunmoon.entity;
/**
 * 员工调动申请
 * @author 77
 *
 */
public class Transfer {
	public String transfer_id;//
	private String transfer_staff_name;
	private String transfer_staff_id;
	private String transfer_position_name_old;//原职位
	private String transfer_department_name_old;//原部门
	private String transfer_position_name_new;//新职位  
	private String transfer_department_name_new;//。。
	private String transfer_msg;
	public Transfer() {
		super(); 
		// TODO Auto-generated constructor stub
	}
	public Transfer(String transfer_id, String transfer_staff_name, String transfer_staff_id,
			String transfer_position_name_old, String transfer_department_name_old, String transfer_position_name_new,
			String transfer_department_name_new, String transfer_msg) {
		super();
		this.transfer_id = transfer_id;
		this.transfer_staff_name = transfer_staff_name;
		this.transfer_staff_id = transfer_staff_id;
		this.transfer_position_name_old = transfer_position_name_old;
		this.transfer_department_name_old = transfer_department_name_old;
		this.transfer_position_name_new = transfer_position_name_new;
		this.transfer_department_name_new = transfer_department_name_new;
		this.transfer_msg = transfer_msg;
	}
	@Override
	public String toString() {
		return "Transfer [transfer_id=" + transfer_id + ", transfer_staff_name=" + transfer_staff_name
				+ ", transfer_staff_id=" + transfer_staff_id + ", transfer_position_name_old="
				+ transfer_position_name_old + ", transfer_department_name_old=" + transfer_department_name_old
				+ ", transfer_position_name_new=" + transfer_position_name_new + ", transfer_department_name_new="
				+ transfer_department_name_new + ", transfer_msg=" + transfer_msg + "]";
	}
	public String getTransfer_id() {
		return transfer_id;
	}
	public void setTransfer_id(String transfer_id) {
		this.transfer_id = transfer_id;
	}
	public String getTransfer_staff_name() {
		return transfer_staff_name;
	}
	public void setTransfer_staff_name(String transfer_staff_name) {
		this.transfer_staff_name = transfer_staff_name;
	}
	public String getTransfer_staff_id() {
		return transfer_staff_id;
	}
	public void setTransfer_staff_id(String transfer_staff_id) {
		this.transfer_staff_id = transfer_staff_id;
	}
	public String getTransfer_position_name_old() {
		return transfer_position_name_old;
	}
	public void setTransfer_position_name_old(String transfer_position_name_old) {
		this.transfer_position_name_old = transfer_position_name_old;
	}
	public String getTransfer_department_name_old() {
		return transfer_department_name_old;
	}
	public void setTransfer_department_name_old(String transfer_department_name_old) {
		this.transfer_department_name_old = transfer_department_name_old;
	}
	public String getTransfer_position_name_new() {
		return transfer_position_name_new;
	}
	public void setTransfer_position_name_new(String transfer_position_name_new) {
		this.transfer_position_name_new = transfer_position_name_new;
	}
	public String getTransfer_department_name_new() {
		return transfer_department_name_new;
	}
	public void setTransfer_department_name_new(String transfer_department_name_new) {
		this.transfer_department_name_new = transfer_department_name_new;
	}
	public String getTransfer_msg() {
		return transfer_msg;
	}
	public void setTransfer_msg(String transfer_msg) {
		this.transfer_msg = transfer_msg;
	}

	
}
