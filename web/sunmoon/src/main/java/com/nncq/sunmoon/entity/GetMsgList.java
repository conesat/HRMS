package com.nncq.sunmoon.entity;
/**
 * 公告推送
 * @author 77
 *
 */
public class GetMsgList {
private String staff_id;
private String department_id;
private String position_id;
public GetMsgList() {
	
}
public GetMsgList(String staff_id, String department_id, String position_id) {
	super();
	this.staff_id = staff_id;
	this.department_id = department_id;
	this.position_id = position_id;
}
@Override
public String toString() {
	return "GetMsgList [staff_id=" + staff_id + ", department_id=" + department_id + ", position_id=" + position_id
			+ "]";
}
public String getStaff_id() {
	return staff_id;
}
public void setStaff_id(String staff_id) {
	this.staff_id = staff_id;
}
public String getDepartment_id() {
	return department_id;
}
public void setDepartment_id(String department_id) {
	this.department_id = department_id;
}
public String getPosition_id() {
	return position_id;
}
public void setPosition_id(String position_id) {
	this.position_id = position_id;
}

}
