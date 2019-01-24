package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Recruit;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface RecruitManageDao {
	public void addRecruit(Recruit recruit);

	public List<Recruit> getRecruitsBySE(SelectEntity selectEntity);

	public int getRecruitsNumberBySE(SelectEntity selectEntity);

	public Recruit getRecruitById(String id);

	public void updateRecruit(Recruit recruit);

	public void delRecruit(String id);

	public String getLastId();

}
