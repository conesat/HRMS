package com.nncq.sunmoon.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Datetool {
	/**
	 * 日期相加减天数
	 * 
	 * @param date        如果为Null，则为当前时间
	 * @param days        加减天数
	 * @param includeTime 是否包括时分秒,true表示包含
	 * @return
	 * @throws ParseException
	 */
	public static Date dateAdd(Date date, int days) throws ParseException {
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.parse(sdf.format(date));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date strringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int compareToToDay(String string1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long longstr2 = Long.valueOf(sdf.format(new Date()).replaceAll("[-\\s:]", ""));
		long longstr1 = Long.valueOf(string1.replaceAll("[-\\s:]", ""));
		if (longstr1 < longstr2) {
			return -1;
		} else if (longstr1 > longstr2) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int compareDayToDay(String d1,String d2) {
		Date date1=strringToDate(d1);
		Date date2=strringToDate(d2);
		if (date1.getTime()>date2.getTime()) {
			return 1;
		}else if (date1.getTime()<date2.getTime()) {
			return -1;
		}else {
			return 0;
		}
	}

	/**
	 * 通过Date类获取
	 */
	public static String getTimeNowThroughDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	public static String getHHmmssNowThroughDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(date);
	}

	public static String getDateNowThroughDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static String getYearNow() {
		Calendar cal = Calendar.getInstance();
		return Integer.toString(cal.get(Calendar.YEAR));
	}

	public static String getMothNow() {
		Calendar cal = Calendar.getInstance();
		return Integer.toString(cal.get(Calendar.MONTH) + 1);
	}

	public static String getDayNow() {
		Calendar cal = Calendar.getInstance();
		return Integer.toString(cal.get(Calendar.DATE));
	}

	/**
	 * 获取日期与当前日期间隔分钟
	 * 
	 * @return
	 */
	public static long getMinOfDateToDate(String date) {
		// 按照传入的格式生成一个simpledateformate对象
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr1 = sdf.format(new Date());
			long date1 = sdf.parse(timeStr1).getTime();
			long date2 = sdf.parse(date).getTime();
			return (date1 - date2) / 1000 / 60;
		} catch (Exception exception) {
			return -1;
		}
	}
	
	/**
	 * 获取两个日期间隔分钟
	 * 
	 * @return
	 */
	public static long getMinOfDateToDate(String d1,String d2) {
		// 按照传入的格式生成一个simpledateformate对象
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			long date1 = sdf.parse(d1).getTime();
			
			long date2 = sdf.parse(d2).getTime();
			return (date1 - date2) / 1000 / 60;
		} catch (Exception exception) {
			return -1;
		}
	}

	public static int getTimeBetweenDate(String date) {
		int day = 0;
		long bet = new Date().getTime() - strringToDate(date).getTime();
		day = (int) (bet / 1000 / 60 / 60 / 24);
		return day;
	}

	/**
	 * 获取月份最后一天
	 * 
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(String year, String month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// 设置月份
		cal.set(Calendar.MONTH, Integer.parseInt(month)- 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		return Integer.toString(cal.get(Calendar.DATE));
	}

	/**
	 * 取得两个时间段的时间间隔 return t2 与t1的间隔天数 throws ParseException 如果输入的日期格式不是0000-00-00
	 * 格式抛出异常
	 */
	public static int getBetweenDays(String t1, String t2) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int betweenDays = 0;
		Date d1 = format.parse(t1);
		Date d2 = format.parse(t2);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		// 保证第二个时间一定大于第一个时间
		if (c1.after(c2)) {
			c1 = c2;
			c2.setTime(d1);
		}
		int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		betweenDays = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < betweenYears; i++) {
			int tmp = countDays(c1.get(Calendar.YEAR));
			betweenDays += countDays(c1.get(Calendar.YEAR));
			c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
		}
		return betweenDays;
	}

	public static int countDays(int year) {
		int n = 0;
		for (int i = 1; i <= 12; i++) {
			n += countDays(i, year);
		}
		return n;
	}

	public static int countDays(int month, int year) {
		int count = -1;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			count = 30;
			break;
		case 2:
			if (year % 4 == 0)
				count = 29;
			else
				count = 28;
			if ((year % 100 == 0) & (year % 400 != 0))
				count = 28;
		}
		return count;
	}

}
