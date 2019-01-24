package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nncq.sunmoon.dao.MyPayDao;
import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.service.MyPayService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Service
public class MyPayServiceImpl implements MyPayService {
	@Autowired
	public MyPayDao myPayDao;

	 
	public List<MyPay> selectAll(SelectEntity selectEntity) {
		List<MyPay> re=null;
		try {
			re=myPayDao.selectAll(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}

	 
	public int getmyPayNumberBySE(SelectEntity selectEntity) {
		int re=0;
		try {
		re=myPayDao.getmyPayNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}



	
}
