package com.nncq.sunmoon.entity;

public class Evection {
	private String evection_id;
	private String evection_staff_id;
	private String evection_staff_name;
	private String evection_acc;
	private String evection_acc_position;
	private String evection_vehicle;
	private String evection_start_time;
	private String evection_end_time;
	private String evection_path;
	private String evection_msg;
	public Evection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evection(String evection_id, String evection_staff_id, String evection_staff_name, String evection_acc,
			String evection_acc_position, String evection_vehicle, String evection_start_time, String evection_end_time,
			String evection_path, String evection_msg) {
		super();
		this.evection_id = evection_id;
		this.evection_staff_id = evection_staff_id;
		this.evection_staff_name = evection_staff_name;
		this.evection_acc = evection_acc;
		this.evection_acc_position = evection_acc_position;
		this.evection_vehicle = evection_vehicle;
		this.evection_start_time = evection_start_time;
		this.evection_end_time = evection_end_time;
		this.evection_path = evection_path;
		this.evection_msg = evection_msg;
	}
	@Override
	public String toString() {
		return "Evection [evection_id=" + evection_id + ", evection_staff_id=" + evection_staff_id
				+ ", evection_staff_name=" + evection_staff_name + ", evection_acc=" + evection_acc
				+ ", evection_acc_position=" + evection_acc_position + ", evection_vehicle=" + evection_vehicle
				+ ", evection_start_time=" + evection_start_time + ", evection_end_time=" + evection_end_time
				+ ", evection_path=" + evection_path + ", evection_msg=" + evection_msg + "]";
	}
	public String getEvection_id() {
		return evection_id;
	}
	public void setEvection_id(String evection_id) {
		this.evection_id = evection_id;
	}
	public String getEvection_staff_id() {
		return evection_staff_id;
	}
	public void setEvection_staff_id(String evection_staff_id) {
		this.evection_staff_id = evection_staff_id;
	}
	public String getEvection_staff_name() {
		return evection_staff_name;
	}
	public void setEvection_staff_name(String evection_staff_name) {
		this.evection_staff_name = evection_staff_name;
	}
	public String getEvection_acc() {
		return evection_acc;
	}
	public void setEvection_acc(String evection_acc) {
		this.evection_acc = evection_acc;
	}
	public String getEvection_acc_position() {
		return evection_acc_position;
	}
	public void setEvection_acc_position(String evection_acc_position) {
		this.evection_acc_position = evection_acc_position;
	}
	public String getEvection_vehicle() {
		return evection_vehicle;
	}
	public void setEvection_vehicle(String evection_vehicle) {
		this.evection_vehicle = evection_vehicle;
	}
	public String getEvection_start_time() {
		return evection_start_time;
	}
	public void setEvection_start_time(String evection_start_time) {
		this.evection_start_time = evection_start_time;
	}
	public String getEvection_end_time() {
		return evection_end_time;
	}
	public void setEvection_end_time(String evection_end_time) {
		this.evection_end_time = evection_end_time;
	}
	public String getEvection_path() {
		return evection_path;
	}
	public void setEvection_path(String evection_path) {
		this.evection_path = evection_path;
	}
	public String getEvection_msg() {
		return evection_msg;
	}
	public void setEvection_msg(String evection_msg) {
		this.evection_msg = evection_msg;
	}
	
}
