package com.nncq.sunmoon.entity;

//职位表
public class Position {
	private String position_id;// 职位id
	private String position_name;// 职位名称
	private String position_msg;// 职位描述
	private String position_use_state;// 状态
	private String post_id;// 职务id
	private String post_name;// 职务id
	private int rank_level;// 职级
	private float salaryBase;//基本工资

	public Position() {

	}

	public String getPosition_id() {
		return position_id;
	}

	public void setPosition_id(String position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getPosition_msg() {
		return position_msg;
	}

	public void setPosition_msg(String position_msg) {
		this.position_msg = position_msg;
	}

	public String getPosition_use_state() {
		return position_use_state;
	}

	public void setPosition_use_state(String position_use_state) {
		this.position_use_state = position_use_state;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getPost_name() {
		return post_name;
	}

	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}

	public int getRank_level() {
		return rank_level;
	}

	public void setRank_level(int rank_level) {
		this.rank_level = rank_level;
	}

	public float getSalaryBase() {
		return salaryBase;
	}

	public void setSalaryBase(float salaryBase) {
		this.salaryBase = salaryBase;
	}

	@Override
	public String toString() {
		return "Position [position_id=" + position_id + ", position_name=" + position_name + ", position_msg="
				+ position_msg + ", position_use_state=" + position_use_state + ", post_id=" + post_id + ", post_name="
				+ post_name + ", rank_level=" + rank_level + ", salaryBase=" + salaryBase + "]";
	}

	public Position(String position_id, String position_name, String position_msg, String position_use_state,
			String post_id, String post_name, int rank_level, float salaryBase) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
		this.position_msg = position_msg;
		this.position_use_state = position_use_state;
		this.post_id = post_id;
		this.post_name = post_name;
		this.rank_level = rank_level;
		this.salaryBase = salaryBase;
	}


}
