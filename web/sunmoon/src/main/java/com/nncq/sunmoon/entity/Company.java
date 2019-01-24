package com.nncq.sunmoon.entity;
//公司概况表
public class Company {
	private String company_id;//ID
	private String company_name;//公司名称
	private String company_address;//公司地址
	private String company_phone;//公司电话
	private String company_fax;//公司传真
	private String company_msg;//公司描述
	private String company_net;//公司官网
	private String company_img="";//图
	private Float salary_base;
	public Company() {
		
		
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}
	public String getCompany_fax() {
		return company_fax;
	}
	public void setCompany_fax(String company_fax) {
		this.company_fax = company_fax;
	}
	public String getCompany_msg() {
		return company_msg;
	}
	public void setCompany_msg(String company_msg) {
		this.company_msg = company_msg;
	}
	public String getCompany_net() {
		return company_net;
	}
	public void setCompany_net(String company_net) {
		this.company_net = company_net;
	}
	public String getCompany_img() {
		return company_img;
	}
	public void setCompany_img(String company_img) {
		this.company_img = company_img;
	}
	public Float getSalary_base() {
		return salary_base;
	}
	public void setSalary_base(Float salary_base) {
		this.salary_base = salary_base;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", company_address="
				+ company_address + ", company_phone=" + company_phone + ", company_fax=" + company_fax
				+ ", company_msg=" + company_msg + ", company_net=" + company_net + ", company_img=" + company_img
				+ ", salary_base=" + salary_base + "]";
	}
	public Company(String company_id, String company_name, String company_address, String company_phone,
			String company_fax, String company_msg, String company_net, String company_img, Float salary_base) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.company_address = company_address;
		this.company_phone = company_phone;
		this.company_fax = company_fax;
		this.company_msg = company_msg;
		this.company_net = company_net;
		this.company_img = company_img;
		this.salary_base = salary_base;
	}
	


}
