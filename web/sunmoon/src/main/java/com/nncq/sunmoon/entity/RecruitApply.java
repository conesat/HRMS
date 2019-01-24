package com.nncq.sunmoon.entity;
//入职申请表
public class RecruitApply {
	private String apply_id;//申请表id
	private String apply_name;//申请人姓名
	private int apply_idcard;//申请人身份证
	private String apply_birthday;//申请人生日
	private String apply_sex;//申请人性别
	private String apply_marital_status;//申请人婚姻状况
	private String apply_address;//申请人住址
	private String apply_phone;//申请人电话
	private String apply_email;//申请人邮箱地址
	private String apply_nation;//国籍
	private String apply_education;//申请人学历
	private String apply_political;//申请人政治面貌
	private String apply_person_picture;//申请人个人图片地址
	private String apply_idcard_picture;//申请人身份证图片地址
	private String apply_resume_url;//申请人简历地址
	private String position_id;//申请人申请职位id
	
	public RecruitApply() {
		
		
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

	public int getApply_idcard() {
		return apply_idcard;
	}

	public void setApply_idcard(int apply_idcard) {
		this.apply_idcard = apply_idcard;
	}

	public String getApply_birthday() {
		return apply_birthday;
	}

	public void setApply_birthday(String apply_birthday) {
		this.apply_birthday = apply_birthday;
	}

	public String getApply_sex() {
		return apply_sex;
	}

	public void setApply_sex(String apply_sex) {
		this.apply_sex = apply_sex;
	}

	public String getApply_marital_status() {
		return apply_marital_status;
	}

	public void setApply_marital_status(String apply_marital_status) {
		this.apply_marital_status = apply_marital_status;
	}

	public String getApply_address() {
		return apply_address;
	}

	public void setApply_address(String apply_address) {
		this.apply_address = apply_address;
	}

	public String getApply_phone() {
		return apply_phone;
	}

	public void setApply_phone(String apply_phone) {
		this.apply_phone = apply_phone;
	}

	public String getApply_email() {
		return apply_email;
	}

	public void setApply_email(String apply_email) {
		this.apply_email = apply_email;
	}

	public String getApply_nation() {
		return apply_nation;
	}

	public void setApply_nation(String apply_nation) {
		this.apply_nation = apply_nation;
	}

	public String getApply_education() {
		return apply_education;
	}

	public void setApply_education(String apply_education) {
		this.apply_education = apply_education;
	}

	public String getApply_political() {
		return apply_political;
	}

	public void setApply_political(String apply_political) {
		this.apply_political = apply_political;
	}

	public String getApply_person_picture() {
		return apply_person_picture;
	}

	public void setApply_person_picture(String apply_person_picture) {
		this.apply_person_picture = apply_person_picture;
	}

	public String getApply_idcard_picture() {
		return apply_idcard_picture;
	}

	public void setApply_idcard_picture(String apply_idcard_picture) {
		this.apply_idcard_picture = apply_idcard_picture;
	}

	public String getApply_resume_url() {
		return apply_resume_url;
	}

	public void setApply_resume_url(String apply_resume_url) {
		this.apply_resume_url = apply_resume_url;
	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	@Override
	public String toString() {
		return "Apply [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_idcard=" + apply_idcard
				+ ", apply_birthday=" + apply_birthday + ", apply_sex=" + apply_sex + ", apply_marital_status="
				+ apply_marital_status + ", apply_address=" + apply_address + ", apply_phone=" + apply_phone
				+ ", apply_email=" + apply_email + ", apply_nation=" + apply_nation + ", apply_education="
				+ apply_education + ", apply_political=" + apply_political + ", apply_person_picture="
				+ apply_person_picture + ", apply_idcard_picture=" + apply_idcard_picture + ", apply_resume_url="
				+ apply_resume_url + ", position_id=" + position_id + "]";
	}

	public RecruitApply(String apply_id, String apply_name, int apply_idcard, String apply_birthday, String apply_sex,
			String apply_marital_status, String apply_address, String apply_phone, String apply_email,
			String apply_nation, String apply_education, String apply_political, String apply_person_picture,
			String apply_idcard_picture, String apply_resume_url, String position_id) {
		super();
		this.apply_id = apply_id;
		this.apply_name = apply_name;
		this.apply_idcard = apply_idcard;
		this.apply_birthday = apply_birthday;
		this.apply_sex = apply_sex;
		this.apply_marital_status = apply_marital_status;
		this.apply_address = apply_address;
		this.apply_phone = apply_phone;
		this.apply_email = apply_email;
		this.apply_nation = apply_nation;
		this.apply_education = apply_education;
		this.apply_political = apply_political;
		this.apply_person_picture = apply_person_picture;
		this.apply_idcard_picture = apply_idcard_picture;
		this.apply_resume_url = apply_resume_url;
		this.position_id = position_id;
	}
	
	
	

}
