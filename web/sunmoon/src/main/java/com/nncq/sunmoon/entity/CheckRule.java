package com.nncq.sunmoon.entity;

/**
 * 打卡规则
 * @author 拉布拉多是条狗
 *
 */
public class CheckRule {
	private int id;
	private int rule1;
	private int rule2;
	private float rule3;
	private int rule4;
	private int rule5;
	private float rule6;
	public CheckRule() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRule1() {
		return rule1;
	}
	public void setRule1(int rule1) {
		this.rule1 = rule1;
	}
	public int getRule2() {
		return rule2;
	}
	public void setRule2(int rule2) {
		this.rule2 = rule2;
	}
	public float getRule3() {
		return rule3;
	}
	public void setRule3(float rule3) {
		this.rule3 = rule3;
	}
	public int getRule4() {
		return rule4;
	}
	public void setRule4(int rule4) {
		this.rule4 = rule4;
	}
	public int getRule5() {
		return rule5;
	}
	public void setRule5(int rule5) {
		this.rule5 = rule5;
	}
	public float getRule6() {
		return rule6;
	}
	public void setRule6(float rule6) {
		this.rule6 = rule6;
	}
	@Override
	public String toString() {
		return "CheckRule [id=" + id + ", rule1=" + rule1 + ", rule2=" + rule2 + ", rule3=" + rule3 + ", rule4=" + rule4
				+ ", rule5=" + rule5 + ", rule6=" + rule6 + "]";
	}
	public CheckRule(int id, int rule1, int rule2, float rule3, int rule4, int rule5, float rule6) {
		super();
		this.id = id;
		this.rule1 = rule1;
		this.rule2 = rule2;
		this.rule3 = rule3;
		this.rule4 = rule4;
		this.rule5 = rule5;
		this.rule6 = rule6;
	}
	
	
}
