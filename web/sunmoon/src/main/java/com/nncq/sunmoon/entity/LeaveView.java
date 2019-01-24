package com.nncq.sunmoon.entity;

public class LeaveView {
private String apply_id;
private String apply_name;
private String apply_type;
private String parent_id;
private String apply_staff_id;
private String check_staff_id;
private String apply_time;
private String check_time;
private String check_state;
private String check_msg;
private String apply_staff_name;
private String check_staff_name;

private String leave_start_time;
private String leave_end_time;
private String leave_msg;
private String leave_type;

public LeaveView() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "LeaveView [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_type=" + apply_type
			+ ", parent_id=" + parent_id + ", apply_staff_id=" + apply_staff_id + ", check_taff_id=" + check_staff_id
			+ ", apply_time=" + apply_time + ", check_time=" + check_time + ", check_state=" + check_state
			+ ", check_msg=" + check_msg + ", leave_start_time=" + leave_start_time + ", leave_end_time="
			+ leave_end_time + ", leave_msg=" + leave_msg + ", leave_type=" + leave_type + ", apply_staff_name="
			+ apply_staff_name + ", check_staff_name=" + check_staff_name + "]";
}




public LeaveView(String apply_id, String apply_name, String apply_type, String parent_id, String apply_staff_id,
		String check_staff_id, String apply_time, String check_time, String check_state, String check_msg,
		String leave_start_time, String leave_end_time, String leave_msg, String leave_type, String apply_staff_name,
		String check_staff_name) {
	super();
	this.apply_id = apply_id;
	this.apply_name = apply_name;
	this.apply_type = apply_type;
	this.parent_id = parent_id;
	this.apply_staff_id = apply_staff_id;
	this.check_staff_id = check_staff_id;
	this.apply_time = apply_time;
	this.check_time = check_time;
	this.check_state = check_state;
	this.check_msg = check_msg;
	this.leave_start_time = leave_start_time;
	this.leave_end_time = leave_end_time;
	this.leave_msg = leave_msg;
	this.leave_type = leave_type;
	this.apply_staff_name = apply_staff_name;
	this.check_staff_name = check_staff_name;
}


public String getLeave_type() {
	return leave_type;
}

public void setLeave_type(String leave_type) {
	this.leave_type = leave_type;
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
	return check_staff_id;
}
public void setCheck_taff_id(String check_staff_id) {
	this.check_staff_id = check_staff_id;
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
public String getLeave_start_time() {
	return leave_start_time;
}
public void setLeave_start_time(String leave_start_time) {
	this.leave_start_time = leave_start_time;
}
public String getLeave_end_time() {
	return leave_end_time;
}
public void setLeave_end_time(String leave_end_time) {
	this.leave_end_time = leave_end_time;
}
public String getLeave_msg() {
	return leave_msg;
}
public void setLeave_msg(String leave_msg) {
	this.leave_msg = leave_msg;
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





}
