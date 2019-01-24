package com.nncq.sunmoon.entity;

import java.util.List;

//权限表
public class Power {

	private int power_id;// 职位id
	private String power_name;// 权限名称
	private String power_msg;// 权限描述
	private String power_url;// 地址
	private List<Power> children;
	private String checked;
	private String spread = "false";

	public Power() {

	}

	public int getPower_id() {
		return power_id;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}

	public String getPower_name() {
		return power_name;
	}

	public String getSpread() {
		return spread;
	}

	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}

	public String getPower_msg() {
		return power_msg;
	}

	public void setPower_msg(String power_msg) {
		this.power_msg = power_msg;
	}

	public String getPower_url() {
		return power_url;
	}

	public void setPower_url(String power_url) {
		this.power_url = power_url;
	}

	public List<Power> getChildren() {
		return children;
	}

	public void setChildren(List<Power> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Power [power_id=" + power_id + ", power_name=" + power_name + ", power_msg=" + power_msg
				+ ", power_url=" + power_url + ", children=" + children + ", checked=" + checked + ", spread=" + spread
				+ "]";
	}

	public Power(int power_id, String power_name, String power_msg, String power_url, List<Power> children,
			String checked, String spread) {
		super();
		this.power_id = power_id;
		this.power_name = power_name;
		this.power_msg = power_msg;
		this.power_url = power_url;
		this.children = children;
		this.checked = checked;
		this.spread = spread;
	}

}
