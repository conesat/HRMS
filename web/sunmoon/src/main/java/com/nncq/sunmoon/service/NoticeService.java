package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffIdAndNoticeId;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 公告
 * @author 拉布拉多是条狗
 *
 */
public interface NoticeService {
	/**
	 * 添加一条公告
	 * @param notice
	 */
	public void addNotice(Notice notice);
	
	/**
	 * 按条件查询
	 * @param selectEntity
	 * @return
	 */
	public List<Notice> getNoticesBySE(SelectEntity selectEntity);
	
	/**
	 * 按条件查询条数
	 * @param selectEntity
	 * @return
	 */
	public int getNoticesNumberBySE(SelectEntity selectEntity);
	
	/**
	 * 获取最新一条未读公告
	 * @param staff_id
	 * @return
	 */
	public Notice getNoticesByStaffID(StaffAndPosition staffAndPosition);

	/**
	 * 删除一条
	 * @param id
	 */
	public void delNotice(String id);
	
	/**
	 * 设置已读
	 * @param noticeId
	 */
	public void readNotice(StaffIdAndNoticeId staffIdAndNoticeId);
	
	/**
	 * 获取20条公司公告
	 * @param staffAndPosition
	 * @return
	 */
	public List<Notice> getNoticesAll (String notice_department_id);
	
	public Notice getNoticesById(String id);
}
