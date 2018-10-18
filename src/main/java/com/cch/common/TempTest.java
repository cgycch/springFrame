package com.cch.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TempTest {
	public static final String pattern = "yyyy-MM-dd";

	public static void main(String[] args) throws ParseException {
		test();
		
	}
	public static void test() throws ParseException {
		//1query list
		List<BeanOne> list = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			BeanOne bean = new BeanOne();
			bean.setGroup("cch");
			bean.setFrequency("Weekly");
			bean.setFrequencyValue("Monday");
			bean.setIsUser(true);
			bean.setLastDeliverDate(parseDate("2018-10-18", pattern));
			bean.setLastSetFreq("");
			bean.setLastSetFreqValue("");
			list.add(bean);
		}
		//2process
		list.forEach(item->{
			try {
				process(item);
			} catch (ParseException e) {
				System.err.println("error "+e.getMessage());
			}
		});
		//3return
		System.out.println("end");
	}

	private static void process(BeanOne item) throws ParseException {
		String frequency = null;
		String frequencyValue = null;
		if(item.isUser) {
			frequency = item.getFrequency();
			frequencyValue = item.getFrequencyValue();
		}else {
			frequency = item.getLastSetFreq();
			frequencyValue = item.getLastSetFreqValue();
		}
		Date date = getNextScheduleDeliverDate(frequency, frequencyValue);
		System.out.println(date);
		
	}
	private static Date getNextScheduleDeliverDate(String frequency, String frequencyValue) throws ParseException {
		Date date = null;
		if(frequency.equalsIgnoreCase("Daily")) {
			date = getNextDate();
		}else if(frequency.equalsIgnoreCase("Weekly")) {
			date = getNextWeeklySchedule(frequencyValue);
		}else if(frequency.equalsIgnoreCase("Monthly")) {
			date = getNextMonthLySchedule(frequencyValue);
		}else if(frequency.equalsIgnoreCase("Quarterly")) {
			date = getNextQuarterlySchedule(frequencyValue);
		}else if(frequency.equalsIgnoreCase("annually")) {
			date = getNextAnnuallySchedule(frequencyValue);
		}
		return date;
	}

	private static Date getNextAnnuallySchedule(String frequencyValue) throws ParseException {
		// 01-01
		String curDay = formatDate(new Date(), "MM-dd");
		if(curDay.compareTo(frequencyValue) > 0) {
			frequencyValue = "2019-" + frequencyValue;
		}else {
			frequencyValue = "2018-" + frequencyValue;
		}
		return adjustToWorkDay(frequencyValue)[0];
	}
	private static Date getNextQuarterlySchedule(String frequencyValue) throws ParseException {
		//"01-01,04-01,07-01,08-01";
		String temp = null;
		String curDay = formatDate(new Date(), "MM-dd");
		String[] array = frequencyValue.split(",");
		Arrays.sort(array);
		for (String day : array) {
			if(curDay.compareTo(day) < 0) {
				temp = day;
				break;
			}
		}
		if(temp == null) {
			temp = "2019-"+array[0];
		}
		return adjustToWorkDay(temp)[0];
	}
	private static Date getNextMonthLySchedule(String frequencyValue) throws ParseException {
		frequencyValue = "2018-10-" + frequencyValue;
		return getNearMonth(frequencyValue);
	}
	//ok
	private static Date getNearMonth(String source) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(adjustToWorkDay(source)[0]);
		long num = System.currentTimeMillis() - calendar.getTimeInMillis();
		if(num > 0) {
			calendar.setTime(parseDate(source, pattern));
			calendar.add(Calendar.MONTH, 1);
		}
		String[] array = new String[] {formatDate(calendar.getTime(),pattern)};
		return adjustToWorkDay(array)[0];
	}
	private static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	//ok
	private static Date[] adjustToWorkDay(String... sourceAry) throws ParseException {
		Date[] array = null;
		if(sourceAry==null) {
			array =  new Date[0];
		}
		array = new Date[sourceAry.length];
		Calendar calendar = Calendar.getInstance();
		int i = 0;
		for (String dateStr : sourceAry) {
			calendar.setTime(parseDate(dateStr, pattern));
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			if(week==Calendar.SATURDAY) {
				calendar.add(Calendar.DAY_OF_WEEK, 2);
			}else if(week==Calendar.SUNDAY) {
				calendar.add(Calendar.DAY_OF_WEEK, 1);
			}
			array[i++] = calendar.getTime();
		}
		return array;
	}
	private static Date getNextWeeklySchedule(String frequencyValue) {
		return getNearWeek(frequencyValue);
	}
	//ok
	private static Date getNearWeek(String week) {
		week = week.toUpperCase();
		int day = Calendar.MONDAY;
		switch (week) {
		case "SUNDAY":
			day = Calendar.SUNDAY+7;
			break;
		case "MONDAY":
			day = Calendar.MONDAY;
			break;
		case "TUESDAY":
			day = Calendar.TUESDAY;
			break;
		case "WEDNESDAY":
			day = Calendar.WEDNESDAY;
			break;
		case "THURSDAY":
			day = Calendar.THURSDAY;
			break;
		case "FRIDAY":
			day = Calendar.FRIDAY;
			break;
		case "SATURDAY":
			day = Calendar.SATURDAY;
			break;
		default:
			break;
		}
		Calendar calendar = Calendar.getInstance();
		int curDay = calendar.get(Calendar.DAY_OF_WEEK);
		if(curDay == 0) {
			curDay += 7;
		}
		int num = day - curDay;
		if(num > 0) {
			calendar.add(Calendar.DAY_OF_WEEK, num);
		}else {
			calendar.add(Calendar.DAY_OF_WEEK, (num + 7));
		}
		return calendar.getTime();
	}
	private static Date getNextDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	
	
	//===============date util======================
	public static Date getZeroTimeOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static int getDistanceOfDays(Date date1, Date date2) {
		long zeroDate1 = getZeroTimeOfDate(date1).getTime();
		long zeroDate2 = getZeroTimeOfDate(date2).getTime();
		return (int) ((zeroDate2 - zeroDate1) / (1000 * 3600 * 24));
	}

	public static Date parseDate(String source, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(source);
	}
	 static class BeanOne{
		private String group;
		private String frequency;
		private String frequencyValue;
		private String lastSetFreq;
		private String lastSetFreqValue;
		private Date lastDeliverDate;
		private boolean isUser;
		
		public String getGroup() {
			return group;
		}
		public void setGroup(String group) {
			this.group = group;
		}
		public String getFrequency() {
			return frequency;
		}
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		public String getFrequencyValue() {
			return frequencyValue;
		}
		public void setFrequencyValue(String frequencyValue) {
			this.frequencyValue = frequencyValue;
		}
		public String getLastSetFreq() {
			return lastSetFreq;
		}
		public void setLastSetFreq(String lastSetFreq) {
			this.lastSetFreq = lastSetFreq;
		}
		public String getLastSetFreqValue() {
			return lastSetFreqValue;
		}
		public void setLastSetFreqValue(String lastSetFreqValue) {
			this.lastSetFreqValue = lastSetFreqValue;
		}
		public Date getLastDeliverDate() {
			return lastDeliverDate;
		}
		public void setLastDeliverDate(Date lastDeliverDate) {
			this.lastDeliverDate = lastDeliverDate;
		}
		public boolean getIsUser() {
			return isUser;
		}
		public void setIsUser(boolean isUser) {
			this.isUser = isUser;
		}
		
	}

}
