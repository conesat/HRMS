package com.nncq.sunmoon.entity;
/**
 * 离职
 * @author 77
 *
 */
public class StaffQuitApply {
private String quit_id;
private String quit_staff_name;
private String quit_staff_id;
private String quit_department;
private String quit_post;
private String quit_time;
private String quit_msg;
public StaffQuitApply(String quit_id, String quit_staff_name, String quit_staff_id, String quit_department,
		String quit_post, String quit_time, String quit_msg) {
	super();
	this.quit_id = quit_id;
	this.quit_staff_name = quit_staff_name;
	this.quit_staff_id = quit_staff_id;
	this.quit_department = quit_department;
	this.quit_post = quit_post;
	this.quit_time = quit_time;
	this.quit_msg = quit_msg;
}
public StaffQuitApply() {

}

@Override
public String toString() {
	return "StaffQuitApply [quit_id=" + quit_id + ", quit_staff_name=" + quit_staff_name + ", quit_staff_id="
			+ quit_staff_id + ", quit_department=" + quit_department + ", quit_post=" + quit_post + ", quit_time="
			+ quit_time + ", quit_msg=" + quit_msg + "]";
}
public String getQuit_id() {
	return quit_id;
}
public void setQuit_id(String quit_id) {
	this.quit_id = quit_id;
}
public String getQuit_staff_name() {
	return quit_staff_name;
}
public void setQuit_staff_name(String quit_staff_name) {
	this.quit_staff_name = quit_staff_name;
}
public String getQuit_staff_id() {
	return quit_staff_id;
}
public void setQuit_staff_id(String quit_staff_id) {
	this.quit_staff_id = quit_staff_id;
}
public String getQuit_department() {
	return quit_department;
}
public void setQuit_department(String quit_department) {
	this.quit_department = quit_department;
}
public String getQuit_post() {
	return quit_post;
}
public void setQuit_post(String quit_post) {
	this.quit_post = quit_post;
}
public String getQuit_time() {
	return quit_time;
}
public void setQuit_time(String quit_time) {
	this.quit_time = quit_time;
}
public String getQuit_msg() {
	return quit_msg;
}
public void setQuit_msg(String quit_msg) {
	this.quit_msg = quit_msg;
}


}
