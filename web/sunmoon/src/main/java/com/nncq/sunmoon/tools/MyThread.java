package com.nncq.sunmoon.tools;

import java.util.List;

import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.service.ContractManageService;
import com.nncq.sunmoon.service.StaffManageService;

/**
 * 考勤结算 线程
 * 统计上一个月出清情况
 * @author 拉布拉多是条狗
 *
 */
public class MyThread extends Thread{
	
	private ContractManageService contractManageService;
	private CheckManageService checkManageService;
	private CheckRuleService checkRuleService;
	private StaffManageService staffManageService;
	private ApplyService applyService;
	
	


	public MyThread(ContractManageService contractManageService, CheckManageService checkManageService,
			CheckRuleService checkRuleService, StaffManageService staffManageService, ApplyService applyService) {
		super();
		this.contractManageService = contractManageService;
		this.checkManageService = checkManageService;
		this.checkRuleService = checkRuleService;
		this.staffManageService = staffManageService;
		this.applyService = applyService;
	}




	@Override
	public void run() {
		super.run();
		String year="";
		String month="";
		new NewThread().start();
		try {
			while (true) {
				contractManageService.updateStaffOldContract();
				year=Datetool.getYearNow();
				month=Datetool.getMothNow();
				if (Datetool.getDayNow().equals("15")) {
					year=Datetool.getYearNow();
					month=Datetool.getMothNow();
					if (month.equals("1")) {
						month="12";
					}else {
						month=Integer.parseInt(month)-1+"";
					}
					Statistics.statisticsCheck(checkManageService, checkRuleService, staffManageService, applyService, year+"-"+month,Integer.parseInt(Datetool.getLastDayOfMonth(year, month)));
				}
				this.sleep(21600000);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class NewThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true) {
				try {
					List<String> staffs=applyService.getPassQuitApply();
					for (String string : staffs) {
						staffManageService.quitStaff(string);
						SessionListener.loginUser.remove(string);
					}
					Thread.sleep(120000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
