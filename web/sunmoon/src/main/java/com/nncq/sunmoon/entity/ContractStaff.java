package com.nncq.sunmoon.entity;
/**
 * 合同表
 * @author 拉布拉多是条狗
 *
 */
public class ContractStaff {

	private String contract_id;//合同id
	private String contract_start_date;//合同开始日期
	private String contract_end_date;//合同结束日期
	private String staff_id;//职员id
	
	public ContractStaff(){
		
		
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getContract_start_date() {
		return contract_start_date;
	}

	public void setContract_start_date(String contract_start_date) {
		this.contract_start_date = contract_start_date;
	}

	public String getContract_end_date() {
		return contract_end_date;
	}

	public void setContract_end_date(String contract_end_date) {
		this.contract_end_date = contract_end_date;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	@Override
	public String toString() {
		return "Contract [contract_id=" + contract_id + ", contract_start_date=" + contract_start_date
				+ ", contract_end_date=" + contract_end_date + ", staff_id=" + staff_id + "]";
	}

	public ContractStaff(String contract_id, String contract_start_date, String contract_end_date, String staff_id) {
		super();
		this.contract_id = contract_id;
		this.contract_start_date = contract_start_date;
		this.contract_end_date = contract_end_date;
		this.staff_id = staff_id;
	}

}
