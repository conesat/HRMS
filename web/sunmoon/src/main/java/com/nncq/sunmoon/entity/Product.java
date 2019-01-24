package com.nncq.sunmoon.entity;
//产品表
public class Product {
	private int Product_id;//主键ID
	private String Product_name;//产品名
	private String Product_type;//产品类型
	private String Product_Model;//产品型号
	private double Product_cost;//产品成本
	private double Product_price;//产品价格
	private String Product_time;//生产时间
	private String Product_ser;//备注
	private int staff_id;//负责人（关联员工表）
	public Product() {
		
	}
	
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_type() {
		return Product_type;
	}
	public void setProduct_type(String product_type) {
		Product_type = product_type;
	}
	public String getProduct_Model() {
		return Product_Model;
	}
	public void setProduct_Model(String product_Model) {
		Product_Model = product_Model;
	}
	public double getProduct_cost() {
		return Product_cost;
	}
	public void setProduct_cost(double product_cost) {
		Product_cost = product_cost;
	}
	public double getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(double product_price) {
		Product_price = product_price;
	}
	public String getProduct_time() {
		return Product_time;
	}
	public void setProduct_time(String product_time) {
		Product_time = product_time;
	}
	public String getProduct_ser() {
		return Product_ser;
	}
	public void setProduct_ser(String product_ser) {
		Product_ser = product_ser;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", Product_name=" + Product_name + ", Product_type=" + Product_type
				+ ", Product_Model=" + Product_Model + ", Product_cost=" + Product_cost + ", Product_price="
				+ Product_price + ", Product_time=" + Product_time + ", Product_ser=" + Product_ser + ", staff_id="
				+ staff_id + "]";
	}
	public Product(int product_id, String product_name, String product_type, String product_Model, double product_cost,
			double product_price, String product_time, String product_ser, int staff_id) {
		super();
		Product_id = product_id;
		Product_name = product_name;
		Product_type = product_type;
		Product_Model = product_Model;
		Product_cost = product_cost;
		Product_price = product_price;
		Product_time = product_time;
		Product_ser = product_ser;
		this.staff_id = staff_id;
	}
	
	
	

}
