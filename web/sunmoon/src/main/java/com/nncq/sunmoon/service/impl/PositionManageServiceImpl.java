package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nncq.sunmoon.dao.PositionManageDao;
import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.service.PositionManageService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Service
public class PositionManageServiceImpl implements PositionManageService {
	@Autowired
	private PositionManageDao positionManageDao;

	public String getLastId() {
		String re = null;
		try {
			re = positionManageDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void addPosition(Position position) throws RuntimeException {
		String id = getLastId();
		if (id == null) {
			id = "POS-1001";
		} else {
			id = "POS-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		position.setPosition_id(id);
		positionManageDao.addPosition(position);
	}

	public List<Position> getPositionsBySE(SelectEntity selectEntity) {
		List<Position> re = null;
		try {
			re = positionManageDao.getPositionsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getPositionsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = positionManageDao.getPositionsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Position getPositionById(String id) {
		Position re = null;
		try {
			re = positionManageDao.getPositionById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updatePosition(Position position) throws RuntimeException {
		positionManageDao.updatePosition(position);

	}

	public void delPosition(String id) throws RuntimeException {
		positionManageDao.delPosition(id);
	}

	public List<Position> getAllPositionIdName() {
		List<Position> re = null;
		try {
			re = positionManageDao.getAllPositionIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateSalary(Position position) throws RuntimeException{
		positionManageDao.updateSalary(position);
	}

}
