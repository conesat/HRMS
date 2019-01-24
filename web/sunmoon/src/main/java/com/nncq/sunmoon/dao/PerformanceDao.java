package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.Performance;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface PerformanceDao {
	public void addPerformance(Performance performance);

	public void updateStaffPerformance(Performance performance);

	public Performance getStaffPerformanceByPerformance(Performance performance);

	public List<Performance> getPerformanceBySe(SelectEntity selectEntity);

	public int getPerformanceNumberBySe(SelectEntity selectEntity);

	public List<Performance> getStaffPerformanceBySe(SelectEntity selectEntity);

	public int getStaffPerformanceNumberBySe(SelectEntity selectEntity);
}
