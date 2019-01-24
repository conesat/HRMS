package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface PositionManageService {
	public void addPosition(Position position);

	public List<Position> getPositionsBySE(SelectEntity selectEntity);

	public int getPositionsNumberBySE(SelectEntity selectEntity);

	public Position getPositionById(String id);

	public void updatePosition(Position position);
	
	public void updateSalary(Position position);

	public void delPosition(String id);

	public String getLastId();
	
	public List<Position> getAllPositionIdName();
}
