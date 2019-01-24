package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.MyPay;
import com.nncq.sunmoon.tools.entity.SelectEntity;

	public interface MyPayDao {
		/**
		 * 查询所有审批数据
		 * @return
		 */
		public List<MyPay> selectAll(SelectEntity selectEntity);
		/**
		 * 获取搜索总数
		 * @param selectEntity
		 * @return
		 */
		public int getmyPayNumberBySE(SelectEntity selectEntity);
	}


