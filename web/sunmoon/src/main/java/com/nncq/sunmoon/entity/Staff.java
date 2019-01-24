package com.nncq.sunmoon.entity;
//职员表
public class Staff {
	private String staff_id;//职员id（编号）
	private String staff_name;//职员名称
	private String staff_sex;//职员性别
	private String staff_certificates_type;//证件类型
	private String staff_certificates_number;//证件号
	private String staff_birthday;//职员生日
	private String staff_education;//职员学历
	private String staff_phone;//职员电话
	private String staff_address;//职员住址
	private String staff_email;//职员邮箱地址
	private String department_id;//职员所属部门id
	private String position_id;//职员职位id
	private String work_address_id;//工作地点id
	private String staff_msg;//备注
	private String staff_person_picture;//职员个人图片地址
	private String staff_idcard_picture_one;//职员身份证图片地址
	private String staff_idcard_picture_tow;//职员身份证图片地址
	private String staff_state;//职员在职状态
	private String staff_in_date;//入职日期
	private String staff_type;//职员类型
	private String staff_marriage;//婚否
	
	//其他
	private String staff_password;//登录密码
	
	//列表所需
	private String work_address_name;//上班地点
	private String department_name;//部门
	private String position_name;//职位
	
	public Staff(){
		
		
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_sex() {
		return staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}

	public String getStaff_certificates_type() {
		return staff_certificates_type;
	}

	public void setStaff_certificates_type(String staff_certificates_type) {
		this.staff_certificates_type = staff_certificates_type;
	}

	public String getStaff_certificates_number() {
		return staff_certificates_number;
	}

	public void setStaff_certificates_number(String staff_certificates_number) {
		this.staff_certificates_number = staff_certificates_number;
	}

	public String getStaff_birthday() {
		return staff_birthday;
	}

	public void setStaff_birthday(String staff_birthday) {
		this.staff_birthday = staff_birthday;
	}

	public String getStaff_education() {
		return staff_education;
	}

	public void setStaff_education(String staff_education) {
		this.staff_education = staff_education;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
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

	public String getWork_address_id() {
		return work_address_id;
	}

	public void setWork_address_id(String work_address_id) {
		this.work_address_id = work_address_id;
	}

	public String getStaff_msg() {
		return staff_msg;
	}

	public void setStaff_msg(String staff_msg) {
		this.staff_msg = staff_msg;
	}

	public String getStaff_person_picture() {
		return staff_person_picture;
	}

	public void setStaff_person_picture(String staff_person_picture) {
		this.staff_person_picture = staff_person_picture;
	}

	public String getStaff_idcard_picture_one() {
		return staff_idcard_picture_one;
	}

	public void setStaff_idcard_picture_one(String staff_idcard_picture_one) {
		this.staff_idcard_picture_one = staff_idcard_picture_one;
	}

	public String getStaff_idcard_picture_tow() {
		return staff_idcard_picture_tow;
	}

	public void setStaff_idcard_picture_tow(String staff_idcard_picture_tow) {
		this.staff_idcard_picture_tow = staff_idcard_picture_tow;
	}

	public String getStaff_state() {
		return staff_state;
	}

	public void setStaff_state(String staff_state) {
		this.staff_state = staff_state;
	}

	public String getStaff_in_date() {
		return staff_in_date;
	}

	public void setStaff_in_date(String staff_in_date) {
		this.staff_in_date = staff_in_date;
	}

	public String getStaff_type() {
		return staff_type;
	}

	public void setStaff_type(String staff_type) {
		this.staff_type = staff_type;
	}

	public String getStaff_marriage() {
		return staff_marriage;
	}

	public void setStaff_marriage(String staff_marriage) {
		this.staff_marriage = staff_marriage;
	}

	public String getStaff_password() {
		return staff_password;
	}

	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}

	public String getWork_address_name() {
		return work_address_name;
	}

	public void setWork_address_name(String work_address_name) {
		this.work_address_name = work_address_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_sex=" + staff_sex
				+ ", staff_certificates_type=" + staff_certificates_type + ", staff_certificates_number="
				+ staff_certificates_number + ", staff_birthday=" + staff_birthday + ", staff_education="
				+ staff_education + ", staff_phone=" + staff_phone + ", staff_address=" + staff_address
				+ ", staff_email=" + staff_email + ", department_id=" + department_id + ", position_id=" + position_id
				+ ", work_address_id=" + work_address_id + ", staff_msg=" + staff_msg + ", staff_person_picture="
				+ staff_person_picture + ", staff_idcard_picture_one=" + staff_idcard_picture_one
				+ ", staff_idcard_picture_tow=" + staff_idcard_picture_tow + ", staff_state=" + staff_state
				+ ", staff_in_date=" + staff_in_date + ", staff_type=" + staff_type + ", staff_marriage="
				+ staff_marriage + ", staff_password=" + staff_password + ", work_address_name=" + work_address_name
				+ ", department_name=" + department_name + ", position_name=" + position_name + "]";
	}

	public Staff(String staff_id, String staff_name, String staff_sex, String staff_certificates_type,
			String staff_certificates_number, String staff_birthday, String staff_education, String staff_phone,
			String staff_address, String staff_email, String department_id, String position_id, String work_address_id,
			String staff_msg, String staff_person_picture, String staff_idcard_picture_one,
			String staff_idcard_picture_tow, String staff_state, String staff_in_date, String staff_type,
			String staff_marriage, String staff_password, String work_address_name, String department_name,
			String position_name) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_sex = staff_sex;
		this.staff_certificates_type = staff_certificates_type;
		this.staff_certificates_number = staff_certificates_number;
		this.staff_birthday = staff_birthday;
		this.staff_education = staff_education;
		this.staff_phone = staff_phone;
		this.staff_address = staff_address;
		this.staff_email = staff_email;
		this.department_id = department_id;
		this.position_id = position_id;
		this.work_address_id = work_address_id;
		this.staff_msg = staff_msg;
		this.staff_person_picture = staff_person_picture;
		this.staff_idcard_picture_one = staff_idcard_picture_one;
		this.staff_idcard_picture_tow = staff_idcard_picture_tow;
		this.staff_state = staff_state;
		this.staff_in_date = staff_in_date;
		this.staff_type = staff_type;
		this.staff_marriage = staff_marriage;
		this.staff_password = staff_password;
		this.work_address_name = work_address_name;
		this.department_name = department_name;
		this.position_name = position_name;
	}

}
