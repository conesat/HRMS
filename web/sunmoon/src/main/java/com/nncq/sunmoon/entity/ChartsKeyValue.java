package com.nncq.sunmoon.entity;

/**
 * 性别
 * @author 拉布拉多是条狗
 *
 */
public class ChartsKeyValue {
	private String name;
	private String value;
	public ChartsKeyValue() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ChartsKeyValue [name=" + name + ", value=" + value + "]";
	}
	public ChartsKeyValue(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	
}
