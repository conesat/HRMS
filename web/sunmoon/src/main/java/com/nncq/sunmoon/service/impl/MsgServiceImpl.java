package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.MsgDao;
import com.nncq.sunmoon.entity.GetMsgList;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.service.MsgService;

@Transactional
@Service
public class MsgServiceImpl implements MsgService {

	@Autowired
	private MsgDao msgDao;
	
	public void addMsg(Msg msg) throws RuntimeException{
		msgDao.addMsg(msg);
	}

	public Msg getNoReadMsg(Msg msg) {
		Msg re=null;
		try {
			re=msgDao.getNoReadMsg(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void readMsg(Msg msg) throws RuntimeException{
		msgDao.readMsg(msg);
	}

	 
	public List<Msg> getMsgList(GetMsgList getMsgList) {
		List<Msg> re=null;
		try {
	        re=msgDao.getMsgList(getMsgList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
