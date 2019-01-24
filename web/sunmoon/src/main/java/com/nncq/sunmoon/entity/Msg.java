package com.nncq.sunmoon.entity;

/**
 * 变更合同消息通知
 * @author 拉布拉多是条狗
 *
 */
public class Msg {
	private String type;//类型
	private String object_id;//对象id
	private String msg_type;//通知方式
	private String msg_title;//信息头
	private String msg_body;//信息体
	private int msg_id;//信息id
	private String read_staff_id;//已读用户
	private String email;//通知邮箱
	private String send_id;//发送者id
	private String send_name;//发送者名称
	private String staff_id;//当前用户id
	private String send_time;//发送时间
	public Msg() {
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getObject_id() {
		return object_id;
	}
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getMsg_title() {
		return msg_title;
	}
	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}
	public String getMsg_body() {
		return msg_body;
	}
	public void setMsg_body(String msg_body) {
		this.msg_body = msg_body;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public String getRead_staff_id() {
		return read_staff_id;
	}
	public void setRead_staff_id(String read_staff_id) {
		this.read_staff_id = read_staff_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	@Override
	public String toString() {
		return "Msg [type=" + type + ", object_id=" + object_id + ", msg_type=" + msg_type + ", msg_title=" + msg_title
				+ ", msg_body=" + msg_body + ", msg_id=" + msg_id + ", read_staff_id=" + read_staff_id + ", email="
				+ email + ", send_id=" + send_id + ", send_name=" + send_name + ", staff_id=" + staff_id
				+ ", send_time=" + send_time + "]";
	}
	public Msg(String type, String object_id, String msg_type, String msg_title, String msg_body, int msg_id,
			String read_staff_id, String email, String send_id, String send_name, String staff_id, String send_time) {
		super();
		this.type = type;
		this.object_id = object_id;
		this.msg_type = msg_type;
		this.msg_title = msg_title;
		this.msg_body = msg_body;
		this.msg_id = msg_id;
		this.read_staff_id = read_staff_id;
		this.email = email;
		this.send_id = send_id;
		this.send_name = send_name;
		this.staff_id = staff_id;
		this.send_time = send_time;
	}

}
