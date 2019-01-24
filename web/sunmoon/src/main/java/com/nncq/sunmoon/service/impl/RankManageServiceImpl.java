package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.RankManageDao;
import com.nncq.sunmoon.entity.Rank;
import com.nncq.sunmoon.service.RankManageService;
import com.nncq.sunmoon.tools.entity.SelectEntity;
@Transactional
@Service
public class RankManageServiceImpl implements RankManageService {
	
	@Autowired
	private RankManageDao rankManageDao;

	public void addRank(Rank rank) throws RuntimeException{
		rankManageDao.addRank(rank);
	}

	public List<Rank> getRanksBySE(SelectEntity selectEntity) {
		List<Rank> re = null;
		try {
			re = rankManageDao.getRanksBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getRanksNumberBySE(SelectEntity selectEntity) {
		int  re = 0;
		try {
			re = rankManageDao.getRanksNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Rank getRankById(String id) {
		 Rank  re = null;
		try {
			re = rankManageDao.getRankById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateRank(Rank rank) throws RuntimeException{
		rankManageDao.updateRank(rank);

	}

	public void delRank(String id) throws RuntimeException{
		rankManageDao.delRank(id);

	}

	public String getLastId() {
		String  re = null;
		try {
			re = rankManageDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Rank> getAllRank() {
		List<Rank> re = null;
		try {
			re = rankManageDao.getAllRank();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Rank getRankByLevel(int level) {
		Rank re = null;
		try {
			re = rankManageDao.getRankByLevel(level);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
