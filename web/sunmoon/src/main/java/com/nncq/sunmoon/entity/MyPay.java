package com.nncq.sunmoon.entity;

public class MyPay {
 private int mypay_id;
 private String mypay_staff_id;
 private String mypay_moth;
 private String mypay_time;
 private String base_pay; //基本工资
 private String post_pay; //岗位工资
 private String bonus; //奖金
 private String achievements;	//绩效工资
 private String subsidy;//补贴
 private String deduction; //固定代扣
 private String social_insurance;//社保
 private String accumulation_fund;//公积金
 private String individual_income_tax;//个人所得税
 private String actual_pay;//实发工资	
 private String mypay_msg;//备注说明
 private String year_pay;//年限工资

 
public MyPay() {
	// TODO Auto-generated constructor stub
}


public MyPay(int mypay_id, String mypay_staff_id, String mypay_moth, String mypay_time, String base_pay,
		String post_pay, String bonus, String achievements, String subsidy, String deduction, String social_insurance,
		String accumulation_fund, String individual_income_tax, String actual_pay, String mypay_msg, String year_pay) {
	super();
	this.mypay_id = mypay_id;
	this.mypay_staff_id = mypay_staff_id;
	this.mypay_moth = mypay_moth;
	this.mypay_time = mypay_time;
	this.base_pay = base_pay;
	this.post_pay = post_pay;
	this.bonus = bonus;
	this.achievements = achievements;
	this.subsidy = subsidy;
	this.deduction = deduction;
	this.social_insurance = social_insurance;
	this.accumulation_fund = accumulation_fund;
	this.individual_income_tax = individual_income_tax;
	this.actual_pay = actual_pay;
	this.mypay_msg = mypay_msg;
	this.year_pay = year_pay;
}


@Override
public String toString() {
	return "MyPay [mypay_id=" + mypay_id + ", mypay_staff_id=" + mypay_staff_id + ", mypay_moth=" + mypay_moth
			+ ", mypay_time=" + mypay_time + ", base_pay=" + base_pay + ", post_pay=" + post_pay + ", bonus=" + bonus
			+ ", achievements=" + achievements + ", subsidy=" + subsidy + ", deduction=" + deduction
			+ ", social_insurance=" + social_insurance + ", accumulation_fund=" + accumulation_fund
			+ ", individual_income_tax=" + individual_income_tax + ", actual_pay=" + actual_pay + ", mypay_msg="
			+ mypay_msg + ", year_pay=" + year_pay + "]";
}


public String getYear_pay() {
	return year_pay;
}


public void setYear_pay(String year_pay) {
	this.year_pay = year_pay;
}


public int getMypay_id() {
	return mypay_id;
}


public void setMypay_id(int mypay_id) {
	this.mypay_id = mypay_id;
}


public String getMypay_staff_id() {
	return mypay_staff_id;
}


public void setMypay_staff_id(String mypay_staff_id) {
	this.mypay_staff_id = mypay_staff_id;
}


public String getMypay_moth() {
	return mypay_moth;
}


public void setMypay_moth(String mypay_moth) {
	this.mypay_moth = mypay_moth;
}


public String getMypay_time() {
	return mypay_time;
}


public void setMypay_time(String mypay_time) {
	this.mypay_time = mypay_time;
}


public String getBase_pay() {
	return base_pay;
}


public void setBase_pay(String base_pay) {
	this.base_pay = base_pay;
}


public String getPost_pay() {
	return post_pay;
}


public void setPost_pay(String post_pay) {
	this.post_pay = post_pay;
}


public String getBonus() {
	return bonus;
}


public void setBonus(String bonus) {
	this.bonus = bonus;
}


public String getAchievements() {
	return achievements;
}


public void setAchievements(String achievements) {
	this.achievements = achievements;
}


public String getSubsidy() {
	return subsidy;
}


public void setSubsidy(String subsidy) {
	this.subsidy = subsidy;
}


public String getDeduction() {
	return deduction;
}


public void setDeduction(String deduction) {
	this.deduction = deduction;
}


public String getSocial_insurance() {
	return social_insurance;
}


public void setSocial_insurance(String social_insurance) {
	this.social_insurance = social_insurance;
}


public String getAccumulation_fund() {
	return accumulation_fund;
}


public void setAccumulation_fund(String accumulation_fund) {
	this.accumulation_fund = accumulation_fund;
}


public String getIndividual_income_tax() {
	return individual_income_tax;
}


public void setIndividual_income_tax(String individual_income_tax) {
	this.individual_income_tax = individual_income_tax;
}


public String getActual_pay() {
	return actual_pay;
}


public void setActual_pay(String actual_pay) {
	this.actual_pay = actual_pay;
}


public String getMypay_msg() {
	return mypay_msg;
}


public void setMypay_msg(String mypay_msg) {
	this.mypay_msg = mypay_msg;
}


}
