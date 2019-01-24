package com.nncq.sunmoon.entity;

public class Apply {
	private String apply_id;//申请id
	private String apply_name;//申请名称
	private String apply_type;//申请类型
	private String parent_id;//父表id
	private String apply_staff_id;//申请人id
	private String check_staff_id;//审核人id
	private String apply_staff_name;//申请人姓名
	private String check_staff_name;//审核人姓名
	private String apply_time;//申请时间
	private String check_time;//审核时间
	private String check_state;//审核状态
	private String check_msg;//审核反馈
	public Apply() {
		// TODO Auto-generated constructor stub
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	public String getApply_name() {
		return apply_name;
	}
	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}
	public String getApply_type() {
		return apply_type;
	}
	public void setApply_type(String apply_type) {
		this.apply_type = apply_type;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getApply_staff_id() {
		return apply_staff_id;
	}
	public void setApply_staff_id(String apply_staff_id) {
		this.apply_staff_id = apply_staff_id;
	}
	public String getCheck_staff_id() {
		return check_staff_id;
	}
	public void setCheck_staff_id(String check_staff_id) {
		this.check_staff_id = check_staff_id;
	}
	public String getApply_staff_name() {
		return apply_staff_name;
	}
	public void setApply_staff_name(String apply_staff_name) {
		this.apply_staff_name = apply_staff_name;
	}
	public String getCheck_staff_name() {
		return check_staff_name;
	}
	public void setCheck_staff_name(String check_staff_name) {
		this.check_staff_name = check_staff_name;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_state() {
		return check_state;
	}
	public void setCheck_state(String check_state) {
		this.check_state = check_state;
	}
	public String getCheck_msg() {
		return check_msg;
	}
	public void setCheck_msg(String check_msg) {
		this.check_msg = check_msg;
	}
	@Override
	public String toString() {
		return "Apply [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_type=" + apply_type
				+ ", parent_id=" + parent_id + ", apply_staff_id=" + apply_staff_id + ", check_staff_id="
				+ check_staff_id + ", apply_staff_name=" + apply_staff_name + ", check_staff_name=" + check_staff_name
				+ ", apply_time=" + apply_time + ", check_time=" + check_time + ", check_state=" + check_state
				+ ", check_msg=" + check_msg + "]";
	}
	public Apply(String apply_id, String apply_name, String apply_type, String parent_id, String apply_staff_id,
			String check_staff_id, String apply_staff_name, String check_staff_name, String apply_time,
			String check_time, String check_state, String check_msg) {
		super();
		this.apply_id = apply_id;
		this.apply_name = apply_name;
		this.apply_type = apply_type;
		this.parent_id = parent_id;
		this.apply_staff_id = apply_staff_id;
		this.check_staff_id = check_staff_id;
		this.apply_staff_name = apply_staff_name;
		this.check_staff_name = check_staff_name;
		this.apply_time = apply_time;
		this.check_time = check_time;
		this.check_state = check_state;
		this.check_msg = check_msg;
	}
	

}
