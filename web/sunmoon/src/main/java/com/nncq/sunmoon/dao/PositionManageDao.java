package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Position;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 职位管理
 * 
 * @author duoduo
 *
 */
public interface PositionManageDao {
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
