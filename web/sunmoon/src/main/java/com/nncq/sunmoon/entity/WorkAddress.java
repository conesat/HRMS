package com.nncq.sunmoon.entity;

/**
 * 工作地址
 * 
 * @author 拉布拉多是条狗
 *
 */
public class WorkAddress {
	private String staff_id;
	
	private String work_address_id;// 主键
	private String work_address_name;// 名称
	private String work_address_xy;// 坐标
	private int work_address_use_state;//使用状态
	private String range_on;//是否开启范围
	private int range_value;//范围
	private String wifi_on;//是否开启wifi
	private String wifi_mac;//wifi mac
	private String face;//是否开启人脸
	private String finger;//是否开启指纹
	
	private String morning_start;//
	private String morning_end;//
	private String afternoon_start;//
	private String afternoon_end;//
	private String night_start;//
	private String night_end;//
	
	public WorkAddress() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
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

	public String getWork_address_xy() {
		return work_address_xy;
	}

	public void setWork_address_xy(String work_address_xy) {
		this.work_address_xy = work_address_xy;
	}

	public int getWork_address_use_state() {
		return work_address_use_state;
	}

	public void setWork_address_use_state(int work_address_use_state) {
		this.work_address_use_state = work_address_use_state;
	}

	public String getRange_on() {
		return range_on;
	}

	public void setRange_on(String range_on) {
		this.range_on = range_on;
	}

	public int getRange_value() {
		return range_value;
	}

	public void setRange_value(int range_value) {
		this.range_value = range_value;
	}

	public String getWifi_on() {
		return wifi_on;
	}

	public void setWifi_on(String wifi_on) {
		this.wifi_on = wifi_on;
	}

	public String getWifi_mac() {
		return wifi_mac;
	}

	public void setWifi_mac(String wifi_mac) {
		this.wifi_mac = wifi_mac;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getFinger() {
		return finger;
	}

	public void setFinger(String finger) {
		this.finger = finger;
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
		return "WorkAddress [staff_id=" + staff_id + ", work_address_id=" + work_address_id + ", work_address_name="
				+ work_address_name + ", work_address_xy=" + work_address_xy + ", work_address_use_state="
				+ work_address_use_state + ", range_on=" + range_on + ", range_value=" + range_value + ", wifi_on="
				+ wifi_on + ", wifi_mac=" + wifi_mac + ", face=" + face + ", finger=" + finger + ", morning_start="
				+ morning_start + ", morning_end=" + morning_end + ", afternoon_start=" + afternoon_start
				+ ", afternoon_end=" + afternoon_end + ", night_start=" + night_start + ", night_end=" + night_end
				+ "]";
	}

	public WorkAddress(String staff_id, String work_address_id, String work_address_name, String work_address_xy,
			int work_address_use_state, String range_on, int range_value, String wifi_on, String wifi_mac, String face,
			String finger, String morning_start, String morning_end, String afternoon_start, String afternoon_end,
			String night_start, String night_end) {
		super();
		this.staff_id = staff_id;
		this.work_address_id = work_address_id;
		this.work_address_name = work_address_name;
		this.work_address_xy = work_address_xy;
		this.work_address_use_state = work_address_use_state;
		this.range_on = range_on;
		this.range_value = range_value;
		this.wifi_on = wifi_on;
		this.wifi_mac = wifi_mac;
		this.face = face;
		this.finger = finger;
		this.morning_start = morning_start;
		this.morning_end = morning_end;
		this.afternoon_start = afternoon_start;
		this.afternoon_end = afternoon_end;
		this.night_start = night_start;
		this.night_end = night_end;
	}

	
}
