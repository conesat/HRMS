package com.nncq.sunmoon.entity;

public class EvectionView {
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
	
	private String evection_acc;
	private String evection_acc_position;
	private String evection_vehicle;
	private String evection_start_time;
	private String evection_end_time;
	private String evection_path;
	private String evection_msg;

	
	public EvectionView() {

	}

	@Override
	public String toString() {
		return "EvectionView [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_type=" + apply_type
				+ ", parent_id=" + parent_id + ", apply_staff_id=" + apply_staff_id + ", check_taff_id=" + check_taff_id
				+ ", apply_time=" + apply_time + ", check_time=" + check_time + ", check_state=" + check_state
				+ ", check_msg=" + check_msg + ", evection_acc=" + evection_acc + ", evection_acc_position="
				+ evection_acc_position + ", evection_vehicle=" + evection_vehicle + ", evection_start_time="
				+ evection_start_time + ", evection_end_time=" + evection_end_time + ", evection_path=" + evection_path
				+ ", evection_msg=" + evection_msg + ", apply_staff_name=" + apply_staff_name + ", check_staff_name="
				+ check_staff_name + "]";
	}

	public EvectionView(String apply_id, String apply_name, String apply_type, String parent_id, String apply_staff_id,
			String check_taff_id, String apply_time, String check_time, String check_state, String check_msg,
			String evection_acc, String evection_acc_position, String evection_vehicle, String evection_start_time,
			String evection_end_time, String evection_path, String evection_msg, String apply_staff_name,
			String check_staff_name) {
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
		this.evection_acc = evection_acc;
		this.evection_acc_position = evection_acc_position;
		this.evection_vehicle = evection_vehicle;
		this.evection_start_time = evection_start_time;
		this.evection_end_time = evection_end_time;
		this.evection_path = evection_path;
		this.evection_msg = evection_msg;
		this.apply_staff_name = apply_staff_name;
		this.check_staff_name = check_staff_name;
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
	public String getEvection_acc() {
		return evection_acc;
	}
	public void setEvection_acc(String evection_acc) {
		this.evection_acc = evection_acc;
	}
	public String getEvection_acc_position() {
		return evection_acc_position;
	}
	public void setEvection_acc_position(String evection_acc_position) {
		this.evection_acc_position = evection_acc_position;
	}
	public String getEvection_vehicle() {
		return evection_vehicle;
	}
	public void setEvection_vehicle(String evection_vehicle) {
		this.evection_vehicle = evection_vehicle;
	}
	public String getEvection_start_time() {
		return evection_start_time;
	}
	public void setEvection_start_time(String evection_start_time) {
		this.evection_start_time = evection_start_time;
	}
	public String getEvection_end_time() {
		return evection_end_time;
	}
	public void setEvection_end_time(String evection_end_time) {
		this.evection_end_time = evection_end_time;
	}
	public String getEvection_path() {
		return evection_path;
	}
	public void setEvection_path(String evection_path) {
		this.evection_path = evection_path;
	}
	public String getEvection_msg() {
		return evection_msg;
	}
	public void setEvection_msg(String evection_msg) {
		this.evection_msg = evection_msg;
	}
	

}
