package com.nncq.sunmoon.entity;

/**
 * 员工与合同
 * @author 拉布拉多是条狗
 *
 */
public class StaffContract {
	
	private String staff_id;//职员id
	private String contract_name;//合同名称
	private String start_time;//开始时间
	private String end_time;//结束时间
	private String contract_url;//文件地址
	private String state;//合同状态
	private String change_msg;//变更原因
	
	public StaffContract() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getContract_url() {
		return contract_url;
	}

	public void setContract_url(String contract_url) {
		this.contract_url = contract_url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChange_msg() {
		return change_msg;
	}

	public void setChange_msg(String change_msg) {
		this.change_msg = change_msg;
	}

	@Override
	public String toString() {
		return "StaffContract [staff_id=" + staff_id + ", contract_name=" + contract_name + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", contract_url=" + contract_url + ", state=" + state + ", change_msg="
				+ change_msg + "]";
	}

	public StaffContract(String staff_id, String contract_name, String start_time, String end_time, String contract_url,
			String state, String change_msg) {
		super();
		this.staff_id = staff_id;
		this.contract_name = contract_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.contract_url = contract_url;
		this.state = state;
		this.change_msg = change_msg;
	}

}
