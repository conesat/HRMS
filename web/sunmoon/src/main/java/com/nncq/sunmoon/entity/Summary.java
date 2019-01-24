package com.nncq.sunmoon.entity;
//季度报表
public class Summary {
	private int Summary_id;//ID
	private String summary_month;//月
	private String summary_season;//季
	private String summary_year;//年
	private int product_id;//链接产品表
	
	public Summary() {
		
	}
	
	public int getSummary_id() {
		return Summary_id;
	}
	public void setSummary_id(int summary_id) {
		Summary_id = summary_id;
	}
	public String getSummary_month() {
		return summary_month;
	}
	public void setSummary_month(String summary_month) {
		this.summary_month = summary_month;
	}
	public String getSummary_season() {
		return summary_season;
	}
	public void setSummary_season(String summary_season) {
		this.summary_season = summary_season;
	}
	public String getSummary_year() {
		return summary_year;
	}
	public void setSummary_year(String summary_year) {
		this.summary_year = summary_year;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Summary [Summary_id=" + Summary_id + ", summary_month=" + summary_month + ", summary_season="
				+ summary_season + ", summary_year=" + summary_year + ", product_id=" + product_id + "]";
	}
	public Summary(int summary_id, String summary_month, String summary_season, String summary_year, int product_id) {
		super();
		Summary_id = summary_id;
		this.summary_month = summary_month;
		this.summary_season = summary_season;
		this.summary_year = summary_year;
		this.product_id = product_id;
	}

}
