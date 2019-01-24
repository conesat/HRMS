package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface MyPayService {
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<MyPay> selectAll(SelectEntity selectEntity);
	public int getmyPayNumberBySE(SelectEntity selectEntity);
	
}
