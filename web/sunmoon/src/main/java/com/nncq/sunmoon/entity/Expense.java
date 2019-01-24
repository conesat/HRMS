package com.nncq.sunmoon.entity;
/**
 * 报销申请
 * @author 77
 *
 */
public class Expense {
	public String expense_id;//自增ID
	private String expense_staff_name;
	private String expense_staff_id;
	private String expense_department;
	private String expense_post;
	private String expense_type;
	private String expense_total_price;
	private String expense_actual_price;
	private String expense_msg;
	private String expense_file;
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(String expense_id, String expense_staff_name, String expense_staff_id, String expense_department,
			String expense_post, String expense_type, String expense_total_price, String expense_actual_price,
			String expense_msg, String expense_file) {
		super();
		this.expense_id = expense_id;
		this.expense_staff_name = expense_staff_name;
		this.expense_staff_id = expense_staff_id;
		this.expense_department = expense_department;
		this.expense_post = expense_post;
		this.expense_type = expense_type;
		this.expense_total_price = expense_total_price;
		this.expense_actual_price = expense_actual_price;
		this.expense_msg = expense_msg;
		this.expense_file = expense_file;
	}
	@Override
	public String toString() {
		return "Expense [expense_id=" + expense_id + ", expense_staff_name=" + expense_staff_name
				+ ", expense_staff_id=" + expense_staff_id + ", expense_department=" + expense_department
				+ ", expense_post=" + expense_post + ", expense_type=" + expense_type + ", expense_total_price="
				+ expense_total_price + ", expense_actual_price=" + expense_actual_price + ", expense_msg="
				+ expense_msg + ", expense_file=" + expense_file + "]";
	}
	public String getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(String expense_id) {
		this.expense_id = expense_id;
	}
	public String getExpense_staff_name() {
		return expense_staff_name;
	}
	public void setExpense_staff_name(String expense_staff_name) {
		this.expense_staff_name = expense_staff_name;
	}
	public String getExpense_staff_id() {
		return expense_staff_id;
	}
	public void setExpense_staff_id(String expense_staff_id) {
		this.expense_staff_id = expense_staff_id;
	}
	public String getExpense_department() {
		return expense_department;
	}
	public void setExpense_department(String expense_department) {
		this.expense_department = expense_department;
	}
	public String getExpense_post() {
		return expense_post;
	}
	public void setExpense_post(String expense_post) {
		this.expense_post = expense_post;
	}
	public String getExpense_type() {
		return expense_type;
	}
	public void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}
	public String getExpense_total_price() {
		return expense_total_price;
	}
	public void setExpense_total_price(String expense_total_price) {
		this.expense_total_price = expense_total_price;
	}
	public String getExpense_actual_price() {
		return expense_actual_price;
	}
	public void setExpense_actual_price(String expense_actual_price) {
		this.expense_actual_price = expense_actual_price;
	}
	public String getExpense_msg() {
		return expense_msg;
	}
	public void setExpense_msg(String expense_msg) {
		this.expense_msg = expense_msg;
	}
	public String getExpense_file() {
		return expense_file;
	}
	public void setExpense_file(String expense_file) {
		this.expense_file = expense_file;
	}

}
