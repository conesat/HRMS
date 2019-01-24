package com.nncq.sunmoon.tools;

import java.util.List;

import com.nncq.sunmoon.entity.Check;
import com.nncq.sunmoon.entity.CheckDetailed;
import com.nncq.sunmoon.entity.CheckRule;
import com.nncq.sunmoon.entity.Leave;
import com.nncq.sunmoon.entity.Scheduling;
import com.nncq.sunmoon.entity.StaffCheck;
import com.nncq.sunmoon.entity.StaffCheckMonth;
import com.nncq.sunmoon.entity.StaffIdName;
import com.nncq.sunmoon.service.ApplyService;
import com.nncq.sunmoon.service.CheckManageService;
import com.nncq.sunmoon.service.CheckRuleService;
import com.nncq.sunmoon.service.StaffManageService;

public class Statistics {
	public static void statisticsCheck(CheckManageService checkManageService, CheckRuleService checkRuleService,
			StaffManageService staffManageService, ApplyService applyService, String month, int LastDay) {
		System.out.println(LastDay+"LLLLLLLLLLLLLLLLLLLLLLLLL");
		Check check = new Check();
		check.setCheck_month(month);

		List<StaffIdName> staffs = staffManageService.getAllStaffIdName();

		Scheduling scheduling = checkManageService.getSchedulingByMonth(month);

		if (scheduling == null) {
			scheduling = new Scheduling();
		}

		CheckRule checkRule = checkRuleService.getRule();

		// 总的
		int leaveNumCheck = 0;// 请假天数
		float absenceCheck = 0f;// 旷工
		int lateCheck = 0;// 迟到
		int earlyCheck = 0;// 早退
		int attendanceCheck = 0;// 实际出勤天数
		long timeTemp = 0;
		StaffCheckMonth staffCheckMonth = new StaffCheckMonth();

		String days = scheduling.getDates();// 无需打卡日期

		StaffCheck staffCheck = new StaffCheck();// 查询用户打卡记录 实体
		Leave leave = new Leave();// 请假情况
		staffCheckMonth.setMonth(month);
		check.setCheck_month(month);
		boolean LEAVE = false;// 是否请假
		boolean LATE = false;// 是否迟到
		boolean EARLY = false;// 是否迟到
		boolean ABSENCE = false;// 是否迟到
		for (StaffIdName staffIdName : staffs) {
			staffCheck.setStaff_id(staffIdName.getStaff_id());
			staffCheckMonth.setStaff_id(staffIdName.getStaff_id());
			leave.setLeave_staff_id(staffIdName.getStaff_id());
			// 个人的

			float absence = 0f;// 旷工
			int leaveNum = 0;// 请假天数
			int late = 0;// 迟到
			int early = 0;// 早退
			int attendance = 0;// 实际出勤天数
			int attendance_need = 0;// 需要出勤
			int i = 1;
			String[] inDates = staffIdName.getStaff_in_date().split("-");

			if (inDates.length < 3) {
				break;
			} else if ((inDates[0] + "-" + inDates[1]).compareTo(month) == 0) {
				i = Integer.parseInt(inDates[2]);
			}

			for (; i <= LastDay; i++) {// 循环该月份需要打卡日期
				if (i<10) {
					staffCheck.setCheck_day(month + "-0" + i);// 查询日期
				}else {
					staffCheck.setCheck_day(month + "-" + i);// 查询日期
				}
				
				if (days.indexOf(staffCheck.getCheck_day() + ",") == -1 && days.indexOf(staffCheck.getCheck_day()) != days.length() - 10) {// 需要打卡
					LEAVE = false;// 是否请假
					LATE = false;// 是否迟到
					EARLY = false;// 是否迟到
					ABSENCE = false;// 是否迟到
				
					
					attendance_need++;
					CheckDetailed checkDetailed = checkManageService.getCheckDetailedByStaffCheck(staffCheck);
					leave.setLeave_start_time(month + "-" + i);
					System.out.println("检查日期"+month + "-" + i);
					if (applyService.getPastLeaveApply(leave) == null) {
						System.out.println("检查"+staffIdName.getStaff_id());
						if (checkDetailed == null) {
							absence += 1;
							ABSENCE = true;
						} else {
							attendance++;
							if (checkDetailed.getMorning_start() != null) {
								if (checkDetailed.getCheck_detailed__time1() == null) {
									absence += 0.5;
									ABSENCE = true;
								} else {
									timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getCheck_detailed__time1(),
											checkDetailed.getMorning_start());
									System.out.println(timeTemp+"++"+checkRule.toString()+"******************************************************************");
									// 判断迟到
									if (timeTemp > checkRule.getRule1() && timeTemp < checkRule.getRule2()) {
										late++;
										LATE = false;// 是否迟到
									} else if (timeTemp > checkRule.getRule2()) {
										absence += checkRule.getRule3();
										System.out.println("迟到"+timeTemp+"******************************************************************");
										ABSENCE = true;

									}
								}

							}

							if (checkDetailed.getAfternoon_start() != null) {
								if (checkDetailed.getCheck_detailed__time3() == null) {
									absence += 0.5;
									ABSENCE = true;
								} else {
									timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getCheck_detailed__time3(),
											checkDetailed.getAfternoon_start());

									// 判断迟到
									if (timeTemp > checkRule.getRule1() && timeTemp < checkRule.getRule2()) {
										LATE = false;// 是否迟到
										late++;
									} else if (timeTemp > checkRule.getRule2()) {
										absence += checkRule.getRule3();

										ABSENCE = true;
									}
								}

							}

							if (checkDetailed.getNight_start() != null) {
								if (checkDetailed.getCheck_detailed__time5() == null) {
									absence += 0.5;
									ABSENCE = true;
								} else {
									timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getCheck_detailed__time5(),
											checkDetailed.getNight_start());
									// 判断迟到
									if (timeTemp > checkRule.getRule1() && timeTemp < checkRule.getRule2()) {
										late++;
										LATE = false;// 是否迟到
									} else if (timeTemp > checkRule.getRule2()) {
										absence += checkRule.getRule3();

										ABSENCE = true;
									}
								}

							}

							if (checkDetailed.getMorning_end() != null) {
								timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getMorning_end(),
										checkDetailed.getCheck_detailed__time2());
								// 判断早退
								if (timeTemp > checkRule.getRule4() && timeTemp < checkRule.getRule5()) {
									early++;
									EARLY = true;
								} else if (timeTemp > checkRule.getRule5()) {
									absence += checkRule.getRule6();

									ABSENCE = true;
								}
							}

							if (checkDetailed.getAfternoon_end() != null) {
								timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getAfternoon_end(),
										checkDetailed.getCheck_detailed__time4());
								// 判断早退
								if (timeTemp > checkRule.getRule4() && timeTemp < checkRule.getRule5()) {
									early++;
									EARLY = true;
								} else if (timeTemp > checkRule.getRule5()) {
									absence += checkRule.getRule6();

									ABSENCE = true;
								}
							}

							if (checkDetailed.getNight_end() != null) {
								timeTemp = Datetool.getMinOfDateToDate(checkDetailed.getNight_end(),
										checkDetailed.getCheck_detailed__time6());
								// 判断早退
								if (timeTemp > checkRule.getRule4() && timeTemp < checkRule.getRule5()) {
									early++;
									EARLY = true;
								} else if (timeTemp > checkRule.getRule5()) {
									absence += checkRule.getRule6();

									ABSENCE = true;
								}
							}
						}
					} else {
						LEAVE = true;
						leaveNum++;
						System.out.println("请假" + month + "-" + i);
					}

					if (checkDetailed != null) {
						checkDetailed.setCheck_detailed_state("正常");
						if (LEAVE) {
							checkDetailed.setCheck_detailed_state("请假");
						} else if (ABSENCE) {
							checkDetailed.setCheck_detailed_state("旷工");
						} else if (EARLY && LATE) {
							checkDetailed.setCheck_detailed_state("迟到且早退");
						} else if (EARLY) {
							checkDetailed.setCheck_detailed_state("早退");
						} else if (LATE) {
							checkDetailed.setCheck_detailed_state("迟到");
						}
						checkManageService.updateState(checkDetailed);
					}

				}
			}

			// 累计迟到3次（不含3次）不满6次按旷工半天计
			if (late > 3) {
				absence += ((int) late / 3) * 0.5;
				
				late = (int) late % 3;
			}

			// 月早退累计超过3次，未满六次按旷工半天计
			if (early > 3) {
				absence += ((int) early / 3) * 0.5;
				early = (int) early % 3;
				
			}

			// 总的
			attendance_need -= leaveNum;
			leaveNumCheck += leaveNum;
			absenceCheck += absence;
			lateCheck += late;
			earlyCheck += early;
			attendanceCheck += attendance;

			staffCheckMonth.setStaff_leave(leaveNum);
			staffCheckMonth.setAbsence(absence);
			staffCheckMonth.setLate(late);
			staffCheckMonth.setEarly(early);
			staffCheckMonth.setAttendance(attendance);
			staffCheckMonth.setAttendance_need(attendance_need);

			if (checkManageService.getStaffCheckMonthByMonth(staffCheckMonth) == null) {
				checkManageService.addStaffCheckMonth(staffCheckMonth);
			} else {
				checkManageService.updateStaffCheckMonth(staffCheckMonth);
			}

		}
		check.setCheck_leave(leaveNumCheck);
		check.setCheck_absence(absenceCheck);
		check.setCheck_attendance(attendanceCheck);
		check.setCheck_early_retreat(earlyCheck);
		check.setCheck_late(lateCheck);

		if (checkManageService.getCheckByMonth(month) == null) {
			checkManageService.addCheck(check);
		} else {
			checkManageService.updateCheck(check);
		}

	}
}
