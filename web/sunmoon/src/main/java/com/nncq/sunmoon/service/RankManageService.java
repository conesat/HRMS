package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Rank;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface RankManageService {
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
