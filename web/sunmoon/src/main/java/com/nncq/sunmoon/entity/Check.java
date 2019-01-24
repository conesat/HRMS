package com.nncq.sunmoon.entity;
//考勤表
public class Check {
	private String check_id;//考勤记录id
	private String check_month;//考勤年月份
	private int 	check_leave;//考勤请假天数
	private int check_attendance;//考勤出勤次数
	private float check_absence;//考勤缺勤次数数
	private int check_late;//考勤迟到次数数
	private int check_early_retreat;//早退次数
	
	public Check() {
		
	}

	public String getCheck_id() {
		return check_id;
	}

	public void setCheck_id(String check_id) {
		this.check_id = check_id;
	}

	public String getCheck_month() {
		return check_month;
	}

	public void setCheck_month(String check_month) {
		this.check_month = check_month;
	}

	public int getCheck_leave() {
		return check_leave;
	}

	public void setCheck_leave(int check_leave) {
		this.check_leave = check_leave;
	}

	public int getCheck_attendance() {
		return check_attendance;
	}

	public void setCheck_attendance(int check_attendance) {
		this.check_attendance = check_attendance;
	}

	public float getCheck_absence() {
		return check_absence;
	}

	public void setCheck_absence(float check_absence) {
		this.check_absence = check_absence;
	}

	public int getCheck_late() {
		return check_late;
	}

	public void setCheck_late(int check_late) {
		this.check_late = check_late;
	}

	public int getCheck_early_retreat() {
		return check_early_retreat;
	}

	public void setCheck_early_retreat(int check_early_retreat) {
		this.check_early_retreat = check_early_retreat;
	}

	@Override
	public String toString() {
		return "Check [check_id=" + check_id + ", check_month=" + check_month + ", check_leave=" + check_leave
				+ ", check_attendance=" + check_attendance + ", check_absence=" + check_absence + ", check_late="
				+ check_late + ", check_early_retreat=" + check_early_retreat + "]";
	}

	public Check(String check_id, String check_month, int check_leave, int check_attendance, float check_absence,
			int check_late, int check_early_retreat) {
		super();
		this.check_id = check_id;
		this.check_month = check_month;
		this.check_leave = check_leave;
		this.check_attendance = check_attendance;
		this.check_absence = check_absence;
		this.check_late = check_late;
		this.check_early_retreat = check_early_retreat;
	}


}
