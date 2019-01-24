package com.nncq.sunmoon.entity;

/**
 * 考勤排班
 * @author 拉布拉多是条狗
 *
 */
public class Scheduling {
	private String dates;
	private String month;
	public Scheduling() {
		// TODO Auto-generated constructor stub
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Scheduling [dates=" + dates + ", month=" + month + "]";
	}
	public Scheduling(String dates, String month) {
		super();
		this.dates = dates;
		this.month = month;
	}
	
	
}
