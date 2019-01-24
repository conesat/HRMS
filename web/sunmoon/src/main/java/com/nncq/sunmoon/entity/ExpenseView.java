package com.nncq.sunmoon.entity;

public class ExpenseView {
	private String apply_id;
	private String apply_name;
	private String apply_type;
	private String parent_id;
	private String apply_staff_id;
	private String check_staff_id;
	private String apply_time;
	private String check_time;
	private String check_state;
	private String check_msg;
	private String apply_staff_name;
	private String check_staff_name;

	private String expense_post;
	private String expense_department;
	private String expense_type;
	private String expense_total_price;
	private String expense_actual_price;
	private String expense_msg;
	public ExpenseView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseView(String apply_id, String apply_name, String apply_type, String parent_id, String apply_staff_id,
			String check_staff_id, String apply_time, String check_time, String check_state, String check_msg,
			String apply_staff_name, String check_staff_name, String expense_post, String expense_department,
			String expense_type, String expense_total_price, String expense_actual_price, String expense_msg) {
		super();
		this.apply_id = apply_id;
		this.apply_name = apply_name;
		this.apply_type = apply_type;
		this.parent_id = parent_id;
		this.apply_staff_id = apply_staff_id;
		this.check_staff_id = check_staff_id;
		this.apply_time = apply_time;
		this.check_time = check_time;
		this.check_state = check_state;
		this.check_msg = check_msg;
		this.apply_staff_name = apply_staff_name;
		this.check_staff_name = check_staff_name;
		this.expense_post = expense_post;
		this.expense_department = expense_department;
		this.expense_type = expense_type;
		this.expense_total_price = expense_total_price;
		this.expense_actual_price = expense_actual_price;
		this.expense_msg = expense_msg;
	}
	@Override
	public String toString() {
		return "ExpenseView [apply_id=" + apply_id + ", apply_name=" + apply_name + ", apply_type=" + apply_type
				+ ", parent_id=" + parent_id + ", apply_staff_id=" + apply_staff_id + ", check_staff_id="
				+ check_staff_id + ", apply_time=" + apply_time + ", check_time=" + check_time + ", check_state="
				+ check_state + ", check_msg=" + check_msg + ", apply_staff_name=" + apply_staff_name
				+ ", check_staff_name=" + check_staff_name + ", expense_post=" + expense_post + ", expense_department="
				+ expense_department + ", expense_type=" + expense_type + ", expense_total_price=" + expense_total_price
				+ ", expense_actual_price=" + expense_actual_price + ", expense_msg=" + expense_msg + "]";
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	public String getApply_name() {
		return apply_name;
	}
	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
	}
	public String getApply_type() {
		return apply_type;
	}
	public void setApply_type(String apply_type) {
		this.apply_type = apply_type;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getApply_staff_id() {
		return apply_staff_id;
	}
	public void setApply_staff_id(String apply_staff_id) {
		this.apply_staff_id = apply_staff_id;
	}
	public String getCheck_staff_id() {
		return check_staff_id;
	}
	public void setCheck_staff_id(String check_staff_id) {
		this.check_staff_id = check_staff_id;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getCheck_state() {
		return check_state;
	}
	public void setCheck_state(String check_state) {
		this.check_state = check_state;
	}
	public String getCheck_msg() {
		return check_msg;
	}
	public void setCheck_msg(String check_msg) {
		this.check_msg = check_msg;
	}
	public String getApply_staff_name() {
		return apply_staff_name;
	}
	public void setApply_staff_name(String apply_staff_name) {
		this.apply_staff_name = apply_staff_name;
	}
	public String getCheck_staff_name() {
		return check_staff_name;
	}
	public void setCheck_staff_name(String check_staff_name) {
		this.check_staff_name = check_staff_name;
	}
	public String getExpense_post() {
		return expense_post;
	}
	public void setExpense_post(String expense_post) {
		this.expense_post = expense_post;
	}
	public String getExpense_department() {
		return expense_department;
	}
	public void setExpense_department(String expense_department) {
		this.expense_department = expense_department;
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

	
}
