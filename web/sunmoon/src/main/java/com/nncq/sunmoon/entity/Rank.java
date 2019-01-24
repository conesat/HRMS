package com.nncq.sunmoon.entity;
/**
 * 职级
 * @author 拉布拉多是条狗
 *
 */
public class Rank {
	private int rank_id;
	private String rank_name;
	private int rank_level;
	private String rank_msg;
	private int rank_use_state;
	
	public Rank() {
		// TODO Auto-generated constructor stub
	}

	public int getRank_id() {
		return rank_id;
	}

	public void setRank_id(int rank_id) {
		this.rank_id = rank_id;
	}

	public String getRank_name() {
		return rank_name;
	}

	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}

	public int getRank_level() {
		return rank_level;
	}

	public void setRank_level(int rank_level) {
		this.rank_level = rank_level;
	}

	public String getRank_msg() {
		return rank_msg;
	}

	public void setRank_msg(String rank_msg) {
		this.rank_msg = rank_msg;
	}

	public int getRank_use_state() {
		return rank_use_state;
	}

	public void setRank_use_state(int rank_use_state) {
		this.rank_use_state = rank_use_state;
	}

	@Override
	public String toString() {
		return "Rank [rank_id=" + rank_id + ", rank_name=" + rank_name + ", rank_level=" + rank_level + ", rank_msg="
				+ rank_msg + ", rank_use_state=" + rank_use_state + "]";
	}

	public Rank(int rank_id, String rank_name, int rank_level, String rank_msg, int rank_use_state) {
		super();
		this.rank_id = rank_id;
		this.rank_name = rank_name;
		this.rank_level = rank_level;
		this.rank_msg = rank_msg;
		this.rank_use_state = rank_use_state;
	}

}
