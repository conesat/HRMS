package com.nncq.sunmoon.tools.entity;

/**
 * 查询类 用于搜索数据
 * @author zhilong
 *
 */
public class SelectEntity {
	private int start=0;//开始值
	private int limit=0;//每次条数
	private String key="";//搜索关键字
	private String sql="";//sql注入
	private String field="";//排序列
	private String order="";//排序类型
	public SelectEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "SelectEntity [start=" + start + ", limit=" + limit + ", key=" + key + ", sql=" + sql + ", field="
				+ field + ", order=" + order + "]";
	}
	public SelectEntity(int start, int limit, String key, String sql, String field, String order) {
		super();
		this.start = start;
		this.limit = limit;
		this.key = key;
		this.sql = sql;
		this.field = field;
		this.order = order;
	}
	
}
