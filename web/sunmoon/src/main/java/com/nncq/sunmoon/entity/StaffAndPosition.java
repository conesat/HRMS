package com.nncq.sunmoon.entity;

import java.util.HashMap;
import java.util.Map;

public class StaffAndPosition {
	private String staff_id;
	private String staff_name;
	private String powers;
	private String department_name;
	private String department_id;
	private String position_name;
	private String position_id;
	private String staff_person_picture;//职员个人图片地址
	private Integer rank_level;
	private Map<Integer, String> powerMap=new HashMap<Integer, String>();

	public StaffAndPosition(String staff_id, String staff_name, String powers, String department_name,
			String department_id, String position_name, String position_id, String staff_person_picture,
			Integer rank_level, Map<Integer, String> powerMap) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.powers = powers;
		this.department_name = department_name;
		this.department_id = department_id;
		this.position_name = position_name;
		this.position_id = position_id;
		this.staff_person_picture = staff_person_picture;
		this.rank_level = rank_level;
		this.powerMap = powerMap;
	}

	@Override
	public String toString() {
		return "StaffAndPosition [staff_id=" + staff_id + ", staff_name=" + staff_name + ", powers=" + powers
				+ ", department_name=" + department_name + ", department_id=" + department_id + ", position_name="
				+ position_name + ", position_id=" + position_id + ", staff_person_picture=" + staff_person_picture
				+ ", rank_level=" + rank_level + ", powerMap=" + powerMap + "]";
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

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
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

	public String getStaff_person_picture() {
		return staff_person_picture;
	}

	public void setStaff_person_picture(String staff_person_picture) {
		this.staff_person_picture = staff_person_picture;
	}

	public Integer getRank_level() {
		return rank_level;
	}

	public void setRank_level(Integer rank_level) {
		this.rank_level = rank_level;
	}

	public Map<Integer, String> getPowerMap() {
		return powerMap;
	}

	public void setPowerMap(Map<Integer, String> powerMap) {
		this.powerMap = powerMap;
	}

	public StaffAndPosition() {
		// TODO Auto-generated constructor stub
	}
}
