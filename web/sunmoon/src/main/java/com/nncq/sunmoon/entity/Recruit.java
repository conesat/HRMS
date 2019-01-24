package com.nncq.sunmoon.entity;

/**
 * 招聘信息 实体类
 * 
 * @author 拉布拉多是条狗
 *
 */
public class Recruit {
	private String rel_rec_id;
	private String position_name;
	private String position_id;
	private String rel_rec_title;
	private String rel_rec_desc;
	private int rel_rec_number;
	private String check_state;
	private String rel_rec_money;
	private String apply_staff_id;// 申请人id
	private String check_staff_id;// 审核人id
	private int rel_rec_use_state;// 状态
	private String apply_staff_name;// 审核人的名字
	private String check_staff_name;// 审核人的名字
	private String check_time;// 审核时间
	private String apply_time;// 审核时间
	private String apply_id;//申请id
	private String check_msg;//审核意见
	private String department_name;//部门名称

	public Recruit() {
		// TODO Auto-generated constructor stub
	}

	public String getRel_rec_id() {
		return rel_rec_id;
	}

	public void setRel_rec_id(String rel_rec_id) {
		this.rel_rec_id = rel_rec_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	public String getRel_rec_title() {
		return rel_rec_title;
	}

	public void setRel_rec_title(String rel_rec_title) {
		this.rel_rec_title = rel_rec_title;
	}

	public String getRel_rec_desc() {
		return rel_rec_desc;
	}

	public void setRel_rec_desc(String rel_rec_desc) {
		this.rel_rec_desc = rel_rec_desc;
	}

	public int getRel_rec_number() {
		return rel_rec_number;
	}

	public void setRel_rec_number(int rel_rec_number) {
		this.rel_rec_number = rel_rec_number;
	}

	public String getCheck_state() {
		return check_state;
	}

	public void setCheck_state(String check_state) {
		this.check_state = check_state;
	}

	public String getRel_rec_money() {
		return rel_rec_money;
	}

	public void setRel_rec_money(String rel_rec_money) {
		this.rel_rec_money = rel_rec_money;
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

	public int getRel_rec_use_state() {
		return rel_rec_use_state;
	}

	public void setRel_rec_use_state(int rel_rec_use_state) {
		this.rel_rec_use_state = rel_rec_use_state;
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

	public String getCheck_time() {
		return check_time;
	}

	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}

	public String getApply_time() {
		return apply_time;
	}

	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getCheck_msg() {
		return check_msg;
	}

	public void setCheck_msg(String check_msg) {
		this.check_msg = check_msg;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "Recruit [rel_rec_id=" + rel_rec_id + ", position_name=" + position_name + ", position_id=" + position_id
				+ ", rel_rec_title=" + rel_rec_title + ", rel_rec_desc=" + rel_rec_desc + ", rel_rec_number="
				+ rel_rec_number + ", check_state=" + check_state + ", rel_rec_money=" + rel_rec_money
				+ ", apply_staff_id=" + apply_staff_id + ", check_staff_id=" + check_staff_id + ", rel_rec_use_state="
				+ rel_rec_use_state + ", apply_staff_name=" + apply_staff_name + ", check_staff_name="
				+ check_staff_name + ", check_time=" + check_time + ", apply_time=" + apply_time + ", apply_id="
				+ apply_id + ", check_msg=" + check_msg + ", department_name=" + department_name + "]";
	}

	public Recruit(String rel_rec_id, String position_name, String position_id, String rel_rec_title,
			String rel_rec_desc, int rel_rec_number, String check_state, String rel_rec_money, String apply_staff_id,
			String check_staff_id, int rel_rec_use_state, String apply_staff_name, String check_staff_name,
			String check_time, String apply_time, String apply_id, String check_msg, String department_name) {
		super();
		this.rel_rec_id = rel_rec_id;
		this.position_name = position_name;
		this.position_id = position_id;
		this.rel_rec_title = rel_rec_title;
		this.rel_rec_desc = rel_rec_desc;
		this.rel_rec_number = rel_rec_number;
		this.check_state = check_state;
		this.rel_rec_money = rel_rec_money;
		this.apply_staff_id = apply_staff_id;
		this.check_staff_id = check_staff_id;
		this.rel_rec_use_state = rel_rec_use_state;
		this.apply_staff_name = apply_staff_name;
		this.check_staff_name = check_staff_name;
		this.check_time = check_time;
		this.apply_time = apply_time;
		this.apply_id = apply_id;
		this.check_msg = check_msg;
		this.department_name = department_name;
	}

}
