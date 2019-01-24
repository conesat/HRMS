package com.nncq.sunmoon.entity;

public class StaffCheckMonth {
	
	private String staff_name;
	private String staff_id;
	private String month;
	private int staff_leave = 0;//请假
	private float absence = 0f;// 旷工
	private int late = 0;// 迟到
	private int early = 0;// 早退
	private int attendance = 0;// 实际出勤天数
	private int attendance_need = 0;// 需要出勤

	public StaffCheckMonth() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getStaff_leave() {
		return staff_leave;
	}

	public void setStaff_leave(int staff_leave) {
		this.staff_leave = staff_leave;
	}

	public float getAbsence() {
		return absence;
	}

	public void setAbsence(float absence) {
		this.absence = absence;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getEarly() {
		return early;
	}

	public void setEarly(int early) {
		this.early = early;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public int getAttendance_need() {
		return attendance_need;
	}

	public void setAttendance_need(int attendance_need) {
		this.attendance_need = attendance_need;
	}

	@Override
	public String toString() {
		return "StaffCheckMonth [staff_name=" + staff_name + ", staff_id=" + staff_id + ", month=" + month
				+ ", staff_leave=" + staff_leave + ", absence=" + absence + ", late=" + late + ", early=" + early
				+ ", attendance=" + attendance + ", attendance_need=" + attendance_need + "]";
	}

	public StaffCheckMonth(String staff_name, String staff_id, String month, int staff_leave, float absence, int late,
			int early, int attendance, int attendance_need) {
		super();
		this.staff_name = staff_name;
		this.staff_id = staff_id;
		this.month = month;
		this.staff_leave = staff_leave;
		this.absence = absence;
		this.late = late;
		this.early = early;
		this.attendance = attendance;
		this.attendance_need = attendance_need;
	}

	
}
