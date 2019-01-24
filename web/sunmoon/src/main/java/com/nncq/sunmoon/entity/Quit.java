package com.nncq.sunmoon.entity;
//离职申请表
public class Quit {
	private String quit_id;//离职申请id
	private String quit_type;//申请类型
	private String quit_url;//离职申请书地址
	private String quit_date;//申请日期
	private String quit_end_date;//离职日期
	private String quit_state;//申请状态
	private String quit_mop_opinion;//人事部经理
	private String quit_manager_opinion;//部门经理
	private String quit_general_manager_opinion;//总经理
	private String staff_id;//职员id
	public Quit() {
		
		
	}
	public String getQuit_id() {
		return quit_id;
	}
	public void setQuit_id(String quit_id) {
		this.quit_id = quit_id;
	}
	public String getQuit_type() {
		return quit_type;
	}
	public void setQuit_type(String quit_type) {
		this.quit_type = quit_type;
	}
	public String getQuit_url() {
		return quit_url;
	}
	public void setQuit_url(String quit_url) {
		this.quit_url = quit_url;
	}
	public String getQuit_date() {
		return quit_date;
	}
	public void setQuit_date(String quit_date) {
		this.quit_date = quit_date;
	}
	public String getQuit_end_date() {
		return quit_end_date;
	}
	public void setQuit_end_date(String quit_end_date) {
		this.quit_end_date = quit_end_date;
	}
	public String getQuit_state() {
		return quit_state;
	}
	public void setQuit_state(String quit_state) {
		this.quit_state = quit_state;
	}
	public String getQuit_mop_opinion() {
		return quit_mop_opinion;
	}
	public void setQuit_mop_opinion(String quit_mop_opinion) {
		this.quit_mop_opinion = quit_mop_opinion;
	}
	public String getQuit_manager_opinion() {
		return quit_manager_opinion;
	}
	public void setQuit_manager_opinion(String quit_manager_opinion) {
		this.quit_manager_opinion = quit_manager_opinion;
	}
	public String getQuit_general_manager_opinion() {
		return quit_general_manager_opinion;
	}
	public void setQuit_general_manager_opinion(String quit_general_manager_opinion) {
		this.quit_general_manager_opinion = quit_general_manager_opinion;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	@Override
	public String toString() {
		return "Quit [quit_id=" + quit_id + ", quit_type=" + quit_type + ", quit_url=" + quit_url + ", quit_date="
				+ quit_date + ", quit_end_date=" + quit_end_date + ", quit_state=" + quit_state + ", quit_mop_opinion="
				+ quit_mop_opinion + ", quit_manager_opinion=" + quit_manager_opinion
				+ ", quit_general_manager_opinion=" + quit_general_manager_opinion + ", staff_id=" + staff_id + "]";
	}
	public Quit(String quit_id, String quit_type, String quit_url, String quit_date, String quit_end_date,
			String quit_state, String quit_mop_opinion, String quit_manager_opinion,
			String quit_general_manager_opinion, String staff_id) {
		super();
		this.quit_id = quit_id;
		this.quit_type = quit_type;
		this.quit_url = quit_url;
		this.quit_date = quit_date;
		this.quit_end_date = quit_end_date;
		this.quit_state = quit_state;
		this.quit_mop_opinion = quit_mop_opinion;
		this.quit_manager_opinion = quit_manager_opinion;
		this.quit_general_manager_opinion = quit_general_manager_opinion;
		this.staff_id = staff_id;
	}
	

}
