package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.MyApprovalDao;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.service.MyApprovalService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Service
public class MyApprovalServiceImpl implements MyApprovalService {
	@Autowired
	public MyApprovalDao myApprovalDao;

	public List<Apply> selectAll(SelectEntity selectEntity) {
		List<Apply> re = null;
		try {
			re = myApprovalDao.selectAll(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	public int getmyApprovalNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = myApprovalDao.getmyApprovalNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
/**
 * 根据 申请ID 查询一条记录的详细信息。
 */
	 
	public Apply selectApplyByID(String apply_id) {
		Apply re = null;
		try {
			re=myApprovalDao.selectApplyByID(apply_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
