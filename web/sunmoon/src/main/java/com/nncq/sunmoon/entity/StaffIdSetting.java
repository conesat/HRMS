package com.nncq.sunmoon.entity;

/**
 * 工号设置
 * 
 * @author 拉布拉多是条狗
 *
 */
public class StaffIdSetting {
	private String prefix;// 前缀
	private String middle;// 中部
	private String suffix;// 后缀
	private String separate;// 分隔符
	private String auto;// 自动生成
	private String password;// 初始密码
	public StaffIdSetting() {
		// TODO Auto-generated constructor stub
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getMiddle() {
		return middle;
	}
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getSeparate() {
		return separate;
	}
	public void setSeparate(String separate) {
		this.separate = separate;
	}
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "StaffIdSetting [prefix=" + prefix + ", middle=" + middle + ", suffix=" + suffix + ", separate="
				+ separate + ", auto=" + auto + ", password=" + password + "]";
	}
	public StaffIdSetting(String prefix, String middle, String suffix, String separate, String auto, String password) {
		super();
		this.prefix = prefix;
		this.middle = middle;
		this.suffix = suffix;
		this.separate = separate;
		this.auto = auto;
		this.password = password;
	}
	
}
