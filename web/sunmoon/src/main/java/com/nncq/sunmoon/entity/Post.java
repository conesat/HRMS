package com.nncq.sunmoon.entity;

//模块表
public class Post {

	private String post_id;// 模块id
	private String post_name; // 模块名称
	private String post_msg;// 模块描述
	private String powers;// 权限
	private int post_use_state;

	public Post() {

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

	public String getPost_msg() {
		return post_msg;
	}

	public void setPost_msg(String post_msg) {
		this.post_msg = post_msg;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public int getPost_use_state() {
		return post_use_state;
	}

	public void setPost_use_state(int post_use_state) {
		this.post_use_state = post_use_state;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", post_name=" + post_name + ", post_msg=" + post_msg + ", powers=" + powers
				+ ", post_use_state=" + post_use_state + "]";
	}

	public Post(String post_id, String post_name, String post_msg, String powers, int post_use_state) {
		super();
		this.post_id = post_id;
		this.post_name = post_name;
		this.post_msg = post_msg;
		this.powers = powers;
		this.post_use_state = post_use_state;
	}

}
