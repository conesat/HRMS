package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.ApplyDao;
import com.nncq.sunmoon.dao.MsgDao;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.SessionListener;

@Transactional
@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao applyDao;
	@Autowired
	private MsgDao msgdao;

	public String addApply(Apply apply) throws RuntimeException {
		String id = getLastId();
		if (id == null) {
			id = "APPLY-1001";
		} else {
			id = "APPLY-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		apply.setApply_id(id);
		applyDao.addApply(apply);
		return id;
	}

	public void checkApply(Apply apply) throws RuntimeException {
		applyDao.checkApply(apply);
		Apply apply2 = applyDao.getApplyById(apply.getApply_id());
		Msg msg = new Msg();
		msg.setMsg_type("sys");
		msg.setType("staff_id");
		msg.setObject_id(apply2.getApply_staff_id());
		msg.setSend_name(apply2.getCheck_staff_name());
		msg.setSend_id(apply.getCheck_staff_id());
		msg.setSend_time(Datetool.getTimeNowThroughDate());
		msg.setMsg_title("审核通知");
		if (apply2.getApply_type().equals("staff_quit_apply") && apply2.getCheck_state().equals("已通过")) {
			msg.setMsg_body("您于" + apply2.getApply_time() + "提交的离职申请已通过，请于30个工作日内完成工作交接，30个工作日后你无法登陆系统");
		} else if (apply2.getApply_type().equals("staff_transfer_apply") && apply2.getCheck_state().equals("已通过")) {
			msg.setMsg_body("您于" + apply2.getApply_time() + "提交的调动申请已通过，请尽快前往人事部办理相关手续");
			SessionListener.loginUser.remove(apply2.getApply_staff_id());
		} else {
			msg.setMsg_body("您于" + apply2.getApply_time() + "发送的<br>" + apply2.getApply_name() + "已得到审核,该审核结果为 <br>"
					+ " “ " + apply.getCheck_state() + "”");
		}
		msgdao.addMsg(msg);
	}

	public String getLastId() {
		String re = null;
		try {
			re = applyDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Apply getApplyById(String id) {
		Apply re = null;
		try {
			re = applyDao.getApplyById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public Leave getPastLeaveApply(Leave leave) {
		Leave re = null;
		try {
			re = applyDao.getPastLeaveApply(leave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<String> getPassQuitApply() {
		List<String> re = null;
		try {
			re = applyDao.getPassQuitApply();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
