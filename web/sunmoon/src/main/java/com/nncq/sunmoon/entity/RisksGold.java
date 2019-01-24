package com.nncq.sunmoon.entity;

/**
 * 五险一金 p个人部分 c公司部分
 * @author 拉布拉多是条狗
 *
 */
public class RisksGold {
	private int id;
	private Float p1;
	private Float p2;
	private Float p3;
	private Float p4;
	private Float p5;
	private Float p6;
	private Float c1;
	private Float c2;
	private Float c3;
	private Float c4;
	private Float c5;
	private Float c6;
	public RisksGold() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getP1() {
		return p1;
	}
	public void setP1(Float p1) {
		this.p1 = p1;
	}
	public Float getP2() {
		return p2;
	}
	public void setP2(Float p2) {
		this.p2 = p2;
	}
	public Float getP3() {
		return p3;
	}
	public void setP3(Float p3) {
		this.p3 = p3;
	}
	public Float getP4() {
		return p4;
	}
	public void setP4(Float p4) {
		this.p4 = p4;
	}
	public Float getP5() {
		return p5;
	}
	public void setP5(Float p5) {
		this.p5 = p5;
	}
	public Float getP6() {
		return p6;
	}
	public void setP6(Float p6) {
		this.p6 = p6;
	}
	public Float getC1() {
		return c1;
	}
	public void setC1(Float c1) {
		this.c1 = c1;
	}
	public Float getC2() {
		return c2;
	}
	public void setC2(Float c2) {
		this.c2 = c2;
	}
	public Float getC3() {
		return c3;
	}
	public void setC3(Float c3) {
		this.c3 = c3;
	}
	public Float getC4() {
		return c4;
	}
	public void setC4(Float c4) {
		this.c4 = c4;
	}
	public Float getC5() {
		return c5;
	}
	public void setC5(Float c5) {
		this.c5 = c5;
	}
	public Float getC6() {
		return c6;
	}
	public void setC6(Float c6) {
		this.c6 = c6;
	}
	@Override
	public String toString() {
		return "RisksGold [id=" + id + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", p5=" + p5
				+ ", p6=" + p6 + ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + ", c4=" + c4 + ", c5=" + c5 + ", c6=" + c6
				+ "]";
	}
	public RisksGold(int id, Float p1, Float p2, Float p3, Float p4, Float p5, Float p6, Float c1, Float c2, Float c3,
			Float c4, Float c5, Float c6) {
		super();
		this.id = id;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
		this.c5 = c5;
		this.c6 = c6;
	}
	
}
