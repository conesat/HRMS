package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.ApplyDao;
import com.nncq.sunmoon.dao.AuditDao;
import com.nncq.sunmoon.dao.MsgDao;
import com.nncq.sunmoon.entity.Apply;
import com.nncq.sunmoon.entity.EvectionView;
import com.nncq.sunmoon.entity.ExpenseView;
import com.nncq.sunmoon.entity.LeaveView;
import com.nncq.sunmoon.entity.Msg;
import com.nncq.sunmoon.entity.OverTimeView;
import com.nncq.sunmoon.entity.QuitView;
import com.nncq.sunmoon.entity.TransferView;
import com.nncq.sunmoon.service.AuditService;
import com.nncq.sunmoon.tools.Datetool;
import com.nncq.sunmoon.tools.SessionListener;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	private AuditDao AuditDao;
	@Autowired
	private MsgDao msgdao;
	@Autowired
	private ApplyDao applyDao;

	/**
	 * 查询 请假申请 分页
	 */
	 
	public List<LeaveView> getLeaveBySE(SelectEntity selectEntity) {
		List<LeaveView> re = null;
		try {
			re = AuditDao.getLeaveBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getLeaveNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getLeaveNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public LeaveView getLeaveById(String id) {
		LeaveView re = null;
		try {
			AuditDao.getLeaveById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateApply(Apply apply) {
		AuditDao.updateApply(apply);
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

	 
	public List<EvectionView> getEvectionBySE(SelectEntity selectEntity) {
		List<EvectionView> re = null;
		try {
			re = AuditDao.getEvectionBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getEvectionNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getEvectionNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public EvectionView getEvectionById(String id) {
		EvectionView re = null;
		try {
			AuditDao.getEvectionById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<TransferView> getTransferBySE(SelectEntity selectEntity) {
		List<TransferView> re = null;
		try {
			re = AuditDao.getTransferBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getTransferNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getTransferNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public TransferView getTransferById(String id) {
		TransferView re = null;
		try {
			AuditDao.getEvectionById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<OverTimeView> getOverTimeBySE(SelectEntity selectEntity) {
		List<OverTimeView> re = null;
		try {
			re = AuditDao.getOverTimeBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getOverTimeNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getOverTimeNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public OverTimeView getOverTimeById(String id) {
		OverTimeView re = null;
		try {
			AuditDao.getOverTimeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<ExpenseView> getExpenseBySE(SelectEntity selectEntity) {
		List<ExpenseView> re = null;
		try {
			re = AuditDao.getExpenseBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getExpenseNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getExpenseNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public ExpenseView getExpenseById(String id) {
		ExpenseView re = null;
		try {
			AuditDao.getExpenseById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public List<QuitView> getQuitBySE(SelectEntity selectEntity) {
		List<QuitView> re = null;
		try {
			re = AuditDao.getQuitBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public int getQuitNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = AuditDao.getQuitNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return re;
	}

	 
	public QuitView getQuitById(String id) {
		QuitView re = null;
		try {
			AuditDao.getQuitById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
