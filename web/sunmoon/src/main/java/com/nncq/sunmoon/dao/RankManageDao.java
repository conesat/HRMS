package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Rank;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 职级管理
 * @author 拉布拉多是条狗
 *
 */
public interface RankManageDao {
	public void addRank(Rank rank);

	public List<Rank> getRanksBySE(SelectEntity selectEntity);

	public int getRanksNumberBySE(SelectEntity selectEntity);

	public Rank getRankById(String id);

	public void updateRank(Rank rank);

	public void delRank(String id);

	public String getLastId();

	public List<Rank> getAllRank();
	
	public Rank getRankByLevel(int level);

}
