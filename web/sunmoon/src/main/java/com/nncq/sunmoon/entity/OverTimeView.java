package com.nncq.sunmoon.entity;

public class OverTimeView {
	private String apply_id;
	private String apply_name;
	private String apply_type;
	private String parent_id;
	private String apply_staff_id;
	private String check_taff_id;
	private String apply_time;
	private String check_time;
	private String check_state;
	private String check_msg;
	private String apply_staff_name;
	private String check_staff_name;
	private String overtime_department;
	private String overtime_post;
	private String overtime_start_time;
	private String overtime_duration;
	private String overtime_end_time;
	private String overtime_msg;
	
	public OverTimeView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OverTimeView(String apply_id, String apply_name, String apply_type, String parent_id, String apply_staff_id,
			String check_taff_id, String apply_time, String check_time, String check_state, String check_msg,
			String apply_staff_name, String check_staff_name, String overtime_department, String overtime_post,
			String overtime_start_time, String overtime_duration, String overtime_end_time, String overtime_msg) {
		super();
		this.apply_id = apply_id;
		this.apply_name = apply_name;
		this.apply_type = apply_type;
		this.parent_id = parent_id;
		this.apply_staff_id = apply_staff_id;
		this.check_taff_id = check_taff_id;
		this.apply_time = apply_time;
		this.check_time = check_time;
		this.check_state = check_state;
		this.check_msg = check_msg;
		this.apply_staff_name = apply_staff_name;
		this.check_staff_name = check_staff_name;
		this.overtime_department = overtime_department;
		this.overtime_post = overtime_post;
		this.overtime_start_time = overtime_start_time;
		this.overtime_duration = overtime_duration;
		this.overtime_end_time = overtime_end_time;
		this.overtime_msg = overtime_msg;
	}

	@Override
	public String toString() {
		return "OverTimeView [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_type=" + apply_type
				+ ", parent_id=" + parent_id + ", apply_staff_id=" + apply_staff_id + ", check_taff_id=" + check_taff_id
				+ ", apply_time=" + apply_time + ", check_time=" + check_time + ", check_state=" + check_state
				+ ", check_msg=" + check_msg + ", apply_staff_name=" + apply_staff_name + ", check_staff_name="
				+ check_staff_name + ", overtime_department=" + overtime_department + ", overtime_post=" + overtime_post
				+ ", overtime_start_time=" + overtime_start_time + ", overtime_duration=" + overtime_duration
				+ ", overtime_end_time=" + overtime_end_time + ", overtime_msg=" + overtime_msg + "]";
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

	public String getCheck_taff_id() {
		return check_taff_id;
	}

	public void setCheck_taff_id(String check_taff_id) {
		this.check_taff_id = check_taff_id;
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

	public String getOvertime_department() {
		return overtime_department;
	}

	public void setOvertime_department(String overtime_department) {
		this.overtime_department = overtime_department;
	}

	public String getOvertime_post() {
		return overtime_post;
	}

	public void setOvertime_post(String overtime_post) {
		this.overtime_post = overtime_post;
	}

	public String getOvertime_start_time() {
		return overtime_start_time;
	}

	public void setOvertime_start_time(String overtime_start_time) {
		this.overtime_start_time = overtime_start_time;
	}

	public String getOvertime_duration() {
		return overtime_duration;
	}

	public void setOvertime_duration(String overtime_duration) {
		this.overtime_duration = overtime_duration;
	}

	public String getOvertime_end_time() {
		return overtime_end_time;
	}

	public void setOvertime_end_time(String overtime_end_time) {
		this.overtime_end_time = overtime_end_time;
	}

	public String getOvertime_msg() {
		return overtime_msg;
	}

	public void setOvertime_msg(String overtime_msg) {
		this.overtime_msg = overtime_msg;
	}



}
