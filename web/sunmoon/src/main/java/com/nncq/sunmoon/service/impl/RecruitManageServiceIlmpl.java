package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.ApplyDao;
import com.nncq.sunmoon.dao.RecruitManageDao;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.entity.Recruit;
import com.nncq.sunmoon.service.RecruitManageService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.entity.SelectEntity;
@Transactional
@Service
public class RecruitManageServiceIlmpl implements RecruitManageService {

	@Autowired
	private RecruitManageDao recruitManageDao;
	

	@Autowired
	private ApplyDao applyDao;

	public String addRecruit(Recruit recruit) throws RuntimeException{
		String id = getLastId();
		if (id == null) {
			id = "REC-1001";
		} else {
			id = "REC-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		recruit.setRel_rec_id(id);
		//apply
		String aid = applyDao.getLastId();
		if (aid == null) {
			aid = "APPLY-1001";
		} else {
			aid = "APPLY-" + (Integer.parseInt(aid.split("-")[1]) + 1);
		}
		Apply apply=new Apply();
		apply.setApply_id(aid);
		apply.setApply_staff_id(recruit.getApply_staff_id());
		apply.setApply_time(Datetool.getTimeNowThroughDate());
		apply.setCheck_state("待审核");
		apply.setApply_type("recruit");
		apply.setParent_id(id);
		applyDao.addApply(apply);
		//apply-end
		recruitManageDao.addRecruit(recruit);
		return aid;
	}

	public List<Recruit> getRecruitsBySE(SelectEntity selectEntity) {
		List<Recruit> re = null;
		try {
			re = recruitManageDao.getRecruitsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getRecruitsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = recruitManageDao.getRecruitsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Recruit getRecruitById(String id) {
		Recruit re = null;
		try {
			re = recruitManageDao.getRecruitById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateRecruit(Recruit recruit) throws RuntimeException{
		recruitManageDao.updateRecruit(recruit);

	}

	public void delRecruit(String id) throws RuntimeException{
		recruitManageDao.delRecruit(id);
	}

	public String getLastId() {
		String re = null;
		try {
			re = recruitManageDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
