package com.nncq.sunmoon.entity;
//合同表
public class Contract {

	private String contract_id;//合同id
	private int contract_long;//合同时长
	private String contract_msg;//合同描述
	private String contract_name;//名称
	private String contract_url;//文件地址
	private String contract_use_state;
	
	public Contract(){
		
		
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public int getContract_long() {
		return contract_long;
	}

	public void setContract_long(int contract_long) {
		this.contract_long = contract_long;
	}

	public String getContract_msg() {
		return contract_msg;
	}

	public void setContract_msg(String contract_msg) {
		this.contract_msg = contract_msg;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_url() {
		return contract_url;
	}

	public void setContract_url(String contract_url) {
		this.contract_url = contract_url;
	}

	public String getContract_use_state() {
		return contract_use_state;
	}

	public void setContract_use_state(String contract_use_state) {
		this.contract_use_state = contract_use_state;
	}

	@Override
	public String toString() {
		return "Contract [contract_id=" + contract_id + ", contract_long=" + contract_long + ", contract_msg="
				+ contract_msg + ", contract_name=" + contract_name + ", contract_url=" + contract_url
				+ ", contract_use_state=" + contract_use_state + "]";
	}

	public Contract(String contract_id, int contract_long, String contract_msg, String contract_name,
			String contract_url, String contract_use_state) {
		super();
		this.contract_id = contract_id;
		this.contract_long = contract_long;
		this.contract_msg = contract_msg;
		this.contract_name = contract_name;
		this.contract_url = contract_url;
		this.contract_use_state = contract_use_state;
	}

}
