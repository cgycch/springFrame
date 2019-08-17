package springFrame.examples;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import java.util.TimeZone;



public class MyDemoTest {
	
	@Test
	public void Test() {
		
		//数据获取
		Map<String,List<ReportVo>> voMap = getVoMap();
		Map<String,Group> groupMap = getGroupMap();
		
		//temp map for use
		Map<String,String> upGroupMap = new HashMap<>();
		Map<String,String> fileMap = new HashMap<>();
		
		//文件生成
		String outputPath = "D://outPut";
		String sendPath = outputPath+"//send";
		String storePath = outputPath+"//store";
		for (Entry<String, List<ReportVo>> entry : voMap.entrySet()) {
			String group  = entry.getKey();
			ReportVo vo = entry.getValue().get(0);
			String mailkey = groupMap.get(group).getMailKey();
			//检查频率是否需要send
			boolean needSend = checkFrequency(vo, groupMap, upGroupMap);
			//分目录存放
			if(needSend){
				String filePath = genereateFile(sendPath, entry.getValue(),mailkey).getAbsolutePath();
				fileMap.put(group, filePath);
			}else {
				genereateFile(storePath,entry.getValue(), mailkey);
			}
		}
		//文件发送
		for (Entry<String, String> entry : fileMap.entrySet()) {
			String reportGroup = entry.getKey();
			String filePath = entry.getValue();
			Group group = groupMap.get(reportGroup);
			boolean status = sendMail(group,filePath);
			//group更新
			if(status) {
				updateGroup(group,upGroupMap);
			}
		}
		//附件压缩发送
		String targetFileName = null;
		boolean zipStatus = fileZipProcess(outputPath,targetFileName);
		if(zipStatus) {
			//zip attach mail
			sendMail(null, targetFileName);
		}else {
			//err mail
			sendMail(null, targetFileName);
		}
		
	}
	private boolean fileZipProcess(String outputPath, String targetFileName) {
		return false;
	}
	//更新用户组发送信息部分
	private void updateGroup(Group group, Map<String, String> upGroupMap) {
		// TODO Auto-generated method stub
		
	}
	//发送文件
	private boolean sendMail(Group group, String filePath) {
		// TODO Auto-generated method stub
		return false;
	}
	//检查是否需要发送
	private boolean checkFrequency(ReportVo vo, Map<String,Group> groupList, Map<String, String> upMap) {
		String reportGroup = vo.getReportGroup();
		Group group = groupList.get(reportGroup);
		//1获取frequency
		String LastFrequency = group.getLastFrequency();
		String curFrequency = null;
		String frequencyValue = null;
		if(group.isUserFreq()) {
			curFrequency = group.getFrequency();
			frequencyValue = group.getValue();
		}else {
			curFrequency = vo.getCalFrequency();
			frequencyValue = vo.getValue();//NA or has DEFAULT SETTING
		}
		//2比较并更正
		int result = Compare(curFrequency,LastFrequency);
		if(result <= 0) {
			curFrequency = LastFrequency;//取高频率
		}else {
			//需要更新group 中的frequency
			upMap.put(reportGroup, curFrequency);
		}
		//3判定是否满足发送条件
		if(curFrequency.equals("daily")) {
			return true;
		}
		if(curFrequency.equals("weekly")) {
			if(frequencyValue.equals(getDayOfWeeek())) {
				return true;
			}
		}else if(curFrequency.equals("monthly")){
			if(frequencyValue.equals(getDayOfMonth())) {
				return true;
			}
			//月份补发处理
			processLessOnWeekend(group, frequencyValue);
		}else if(curFrequency.equals("quarterly")) {
			if(frequencyValue.equals(getDayOfMonth())) {
				return true;
			}
			//季度补发处理
		}else {
			//annually
		}
		//push upMap
		
		return false;
	}
	//月份频率周末遗失补发处理
	protected boolean processLessOnWeekend(Group group,String frequencyValue){
		//最近发送日期是否当月
		Date lastDeliverDate = group.getLastDeliverDate();
		if(isCurMonth(lastDeliverDate)) {
			return false;
		}
		//处理需要补发的情况（比如1号是周末，那么临近的周一需要发送）
		if(checkIsWeekend(frequencyValue)) {
			Date date = getNearlyWorkDay(frequencyValue);
			if(isToday(date)) {
				return true;
			}
		}
		return false;
	}
	//是否今天
	private boolean isToday(Date date) {
		// TODO Auto-generated method stub
		return false;
	}
	private Date getNearlyWorkDay(String frequencyValue) {
		// TODO Auto-generated method stub
		return null;
	}
	//检查是否为周末
	private boolean checkIsWeekend(String frequencyValue) {
		// TODO Auto-generated method stub
		return false;
	}
	//获取当月的第几天
	private String getDayOfMonth() {
		// TODO Auto-generated method stub
		return null;
	}
	//是否当月
	private boolean isCurMonth(Date lastDeliverDate) {
		// TODO Auto-generated method stub
		return false;
	}
	//获取今天星期几
	private String getDayOfWeeek() {
		// TODO Auto-generated method stub
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getDefault());//todo
		int idx = calendar.get(Calendar.DAY_OF_WEEK)-1;
		final String dayNames[] = { "Sun", "Mon", "Tues", "Wed", "Thur", "Fri","Sat" }; 
		return dayNames[idx];
	}
	//频率比较
	private int Compare(String curFrequency, String lastFrequency) {
		// TODO Auto-generated method stub
		return 0;
	}
	//文件生成
	private File genereateFile(String sendPath, List<ReportVo> dataList, String mailKey) {
		return new File(sendPath + "//" + dataList.get(0).getReportGroup() + ".xlsx");
	}
	//获取报表数据map
	private Map<String, List<ReportVo>> getVoMap() {
		List<ReportVo> dataList = new ArrayList<>();
		ReportVo vo = new ReportVo("AA", "addr", "MONTHLY", "", "1");
		dataList.add(vo);
		Map<String, List<ReportVo>>  map = new HashMap<>();
		map.put(vo.getReportGroup(), dataList);
		return map;
	}
	//获取分组信息
	private Map<String,Group> getGroupMap() {
		Group group = new Group("AA", "addr", "MONTHLY", "1", "MONTHLY", true);
		Map<String, Group>  map = new HashMap<>();
		map.put(group.getReportGroup(), group);
		return map;
	}
	
	public static void main(String[] args) {
		MyDemoTest demo = new MyDemoTest();
		System.out.println(demo.getDayOfWeeek());
	}

}
