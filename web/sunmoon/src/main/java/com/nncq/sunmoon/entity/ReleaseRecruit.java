package com.nncq.sunmoon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 招聘信息
 * @author 拉布拉多是条狗
 *
 */
public class ReleaseRecruit {
	private String rel_rec_id;
	private String position_id;
	private String rel_rec_title;
	private String rel_rec_desc;
	private int rel_rec_number;
	private String rel_rec_state;
	private String rel_rec_money;
	private String c_staff_id;//申请人id
	private String p_staff_id;//审核人id
	private int rel_rec_use_state;//状态
	private List<MyFile> files=new ArrayList<MyFile>();//附件
	
	public ReleaseRecruit() {
		// TODO Auto-generated constructor stub
	}

	public String getRel_rec_id() {
		return rel_rec_id;
	}

	public void setRel_rec_id(String rel_rec_id) {
		this.rel_rec_id = rel_rec_id;
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

	public String getRel_rec_state() {
		return rel_rec_state;
	}

	public void setRel_rec_state(String rel_rec_state) {
		this.rel_rec_state = rel_rec_state;
	}

	public String getRel_rec_money() {
		return rel_rec_money;
	}

	public void setRel_rec_money(String rel_rec_money) {
		this.rel_rec_money = rel_rec_money;
	}

	public String getC_staff_id() {
		return c_staff_id;
	}

	public void setC_staff_id(String c_staff_id) {
		this.c_staff_id = c_staff_id;
	}

	public String getP_staff_id() {
		return p_staff_id;
	}

	public void setP_staff_id(String p_staff_id) {
		this.p_staff_id = p_staff_id;
	}

	public int getRel_rec_use_state() {
		return rel_rec_use_state;
	}

	public void setRel_rec_use_state(int rel_rec_use_state) {
		this.rel_rec_use_state = rel_rec_use_state;
	}

	public List<MyFile> getFiles() {
		return files;
	}

	public void setFiles(List<MyFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "ReleaseRecruit [rel_rec_id=" + rel_rec_id + ", position_id=" + position_id + ", rel_rec_title="
				+ rel_rec_title + ", rel_rec_desc=" + rel_rec_desc + ", rel_rec_number=" + rel_rec_number
				+ ", rel_rec_state=" + rel_rec_state + ", rel_rec_money=" + rel_rec_money + ", c_staff_id=" + c_staff_id
				+ ", p_staff_id=" + p_staff_id + ", rel_rec_use_state=" + rel_rec_use_state + ", files=" + files + "]";
	}

	public ReleaseRecruit(String rel_rec_id, String position_id, String rel_rec_title, String rel_rec_desc,
			int rel_rec_number, String rel_rec_state, String rel_rec_money, String c_staff_id, String p_staff_id,
			int rel_rec_use_state, List<MyFile> files) {
		super();
		this.rel_rec_id = rel_rec_id;
		this.position_id = position_id;
		this.rel_rec_title = rel_rec_title;
		this.rel_rec_desc = rel_rec_desc;
		this.rel_rec_number = rel_rec_number;
		this.rel_rec_state = rel_rec_state;
		this.rel_rec_money = rel_rec_money;
		this.c_staff_id = c_staff_id;
		this.p_staff_id = p_staff_id;
		this.rel_rec_use_state = rel_rec_use_state;
		this.files = files;
	}
	
	

	
}
