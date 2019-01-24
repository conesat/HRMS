package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import com.nncq.sunmoon.dao.NoticeDao;
import com.nncq.sunmoon.entity.Notice;
import com.nncq.sunmoon.entity.StaffAndPosition;
import com.nncq.sunmoon.entity.StaffIdAndNoticeId;
import com.nncq.sunmoon.service.NoticeService;
import com.nncq.sunmoon.tools.SpringWebSocketHandler;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class NoticeServiceImpl implements NoticeService {

	
	@Autowired
	private NoticeDao noticeDao;

	public void addNotice(Notice notice) throws RuntimeException {
		
		noticeDao.addNotice(notice);
	}

	public List<Notice> getNoticesBySE(SelectEntity selectEntity) {
		List<Notice> re = null;
		try {
			re = noticeDao.getNoticesBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getNoticesNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = noticeDao.getNoticesNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Notice getNoticesByStaffID(StaffAndPosition staffAndPosition) {
		Notice re = null;
		try {
			re = noticeDao.getNoticesByStaffID(staffAndPosition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void delNotice(String id) throws RuntimeException {
		noticeDao.delNotice(id);
	}

	public void readNotice(StaffIdAndNoticeId staffIdAndNoticeId) throws RuntimeException {
		noticeDao.readNotice(staffIdAndNoticeId);
	}

	public List<Notice> getNoticesAll(String notice_department_id) {
		List<Notice> re = null;

		try {
			re = noticeDao.getNoticesAll(notice_department_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Notice getNoticesById(String id) {
		Notice re = null;
		try {
			re = noticeDao.getNoticesById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
