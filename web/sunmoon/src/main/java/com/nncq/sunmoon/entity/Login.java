package com.nncq.sunmoon.entity;

public class Login {
	private String staff_id;// id（编号）
	private String staff_idcard;//职员身份证号
	private String staff_password;//密码
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_idcard() {
		return staff_idcard;
	}
	public void setStaff_idcard(String staff_idcard) {
		this.staff_idcard = staff_idcard;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	@Override
	public String toString() {
		return "Login [staff_id=" + staff_id + ", staff_idcard=" + staff_idcard + ", staff_password=" + staff_password
				+ "]";
	}
	public Login(String staff_id, String staff_idcard, String staff_password) {
		super();
		this.staff_id = staff_id;
		this.staff_idcard = staff_idcard;
		this.staff_password = staff_password;
	}
	

}
