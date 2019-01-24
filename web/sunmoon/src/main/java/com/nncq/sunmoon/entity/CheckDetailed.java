package com.nncq.sunmoon.entity;
//考勤详细表
public class CheckDetailed {
	private String check_detailed_id;//考勤记录详细id
	private String check_detailed_day;//考勤详细日期
	private String check_detailed__time1;//第一次打卡时间
	private String check_detailed__time2;//第二次打卡时间
	private String check_detailed__time3;//第三次打卡时间
	private String check_detailed__time4;//第四次打卡时间
	private String check_detailed__time5;//第五次打卡时间
	private String check_detailed__time6;//第六次打卡时间
	private String check_detailed_state;//状态 迟到 早退 旷工
	private String staff_id;//职员id
	private String staff_name;//职员
	private String work_address_id;//地址id
	private String work_address_name;//地址
	private String morning_start;//
	private String morning_end;//
	private String afternoon_start;//
	private String afternoon_end;//
	private String night_start;//
	private String night_end;//
	public CheckDetailed(){
		
		
	}
	public String getCheck_detailed_id() {
		return check_detailed_id;
	}
	public void setCheck_detailed_id(String check_detailed_id) {
		this.check_detailed_id = check_detailed_id;
	}
	public String getCheck_detailed_day() {
		return check_detailed_day;
	}
	public void setCheck_detailed_day(String check_detailed_day) {
		this.check_detailed_day = check_detailed_day;
	}
	public String getCheck_detailed__time1() {
		return check_detailed__time1;
	}
	public void setCheck_detailed__time1(String check_detailed__time1) {
		this.check_detailed__time1 = check_detailed__time1;
	}
	public String getCheck_detailed__time2() {
		return check_detailed__time2;
	}
	public void setCheck_detailed__time2(String check_detailed__time2) {
		this.check_detailed__time2 = check_detailed__time2;
	}
	public String getCheck_detailed__time3() {
		return check_detailed__time3;
	}
	public void setCheck_detailed__time3(String check_detailed__time3) {
		this.check_detailed__time3 = check_detailed__time3;
	}
	public String getCheck_detailed__time4() {
		return check_detailed__time4;
	}
	public void setCheck_detailed__time4(String check_detailed__time4) {
		this.check_detailed__time4 = check_detailed__time4;
	}
	public String getCheck_detailed__time5() {
		return check_detailed__time5;
	}
	public void setCheck_detailed__time5(String check_detailed__time5) {
		this.check_detailed__time5 = check_detailed__time5;
	}
	public String getCheck_detailed__time6() {
		return check_detailed__time6;
	}
	public void setCheck_detailed__time6(String check_detailed__time6) {
		this.check_detailed__time6 = check_detailed__time6;
	}
	public String getCheck_detailed_state() {
		return check_detailed_state;
	}
	public void setCheck_detailed_state(String check_detailed_state) {
		this.check_detailed_state = check_detailed_state;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getWork_address_id() {
		return work_address_id;
	}
	public void setWork_address_id(String work_address_id) {
		this.work_address_id = work_address_id;
	}
	public String getWork_address_name() {
		return work_address_name;
	}
	public void setWork_address_name(String work_address_name) {
		this.work_address_name = work_address_name;
	}
	public String getMorning_start() {
		return morning_start;
	}
	public void setMorning_start(String morning_start) {
		this.morning_start = morning_start;
	}
	public String getMorning_end() {
		return morning_end;
	}
	public void setMorning_end(String morning_end) {
		this.morning_end = morning_end;
	}
	public String getAfternoon_start() {
		return afternoon_start;
	}
	public void setAfternoon_start(String afternoon_start) {
		this.afternoon_start = afternoon_start;
	}
	public String getAfternoon_end() {
		return afternoon_end;
	}
	public void setAfternoon_end(String afternoon_end) {
		this.afternoon_end = afternoon_end;
	}
	public String getNight_start() {
		return night_start;
	}
	public void setNight_start(String night_start) {
		this.night_start = night_start;
	}
	public String getNight_end() {
		return night_end;
	}
	public void setNight_end(String night_end) {
		this.night_end = night_end;
	}
	@Override
	public String toString() {
		return "CheckDetailed [check_detailed_id=" + check_detailed_id + ", check_detailed_day=" + check_detailed_day
				+ ", check_detailed__time1=" + check_detailed__time1 + ", check_detailed__time2="
				+ check_detailed__time2 + ", check_detailed__time3=" + check_detailed__time3
				+ ", check_detailed__time4=" + check_detailed__time4 + ", check_detailed__time5="
				+ check_detailed__time5 + ", check_detailed__time6=" + check_detailed__time6 + ", check_detailed_state="
				+ check_detailed_state + ", staff_id=" + staff_id + ", staff_name=" + staff_name + ", work_address_id="
				+ work_address_id + ", work_address_name=" + work_address_name + ", morning_start=" + morning_start
				+ ", morning_end=" + morning_end + ", afternoon_start=" + afternoon_start + ", afternoon_end="
				+ afternoon_end + ", night_start=" + night_start + ", night_end=" + night_end + "]";
	}
	public CheckDetailed(String check_detailed_id, String check_detailed_day, String check_detailed__time1,
			String check_detailed__time2, String check_detailed__time3, String check_detailed__time4,
			String check_detailed__time5, String check_detailed__time6, String check_detailed_state, String staff_id,
			String staff_name, String work_address_id, String work_address_name, String morning_start,
			String morning_end, String afternoon_start, String afternoon_end, String night_start, String night_end) {
		super();
		this.check_detailed_id = check_detailed_id;
		this.check_detailed_day = check_detailed_day;
		this.check_detailed__time1 = check_detailed__time1;
		this.check_detailed__time2 = check_detailed__time2;
		this.check_detailed__time3 = check_detailed__time3;
		this.check_detailed__time4 = check_detailed__time4;
		this.check_detailed__time5 = check_detailed__time5;
		this.check_detailed__time6 = check_detailed__time6;
		this.check_detailed_state = check_detailed_state;
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.work_address_id = work_address_id;
		this.work_address_name = work_address_name;
		this.morning_start = morning_start;
		this.morning_end = morning_end;
		this.afternoon_start = afternoon_start;
		this.afternoon_end = afternoon_end;
		this.night_start = night_start;
		this.night_end = night_end;
	}
	

}
