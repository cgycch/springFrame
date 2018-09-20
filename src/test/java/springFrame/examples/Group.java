package springFrame.examples;

import java.util.Date;

public class Group {
	private String reportGroup;
	private String addr;
	private String frequency;
	private String value;
	private String lastFrequency;
	private String mailKey;
	private boolean isUserFreq;
	private Date lastDeliverDate;
	
	public Group() {
		super();
	}
	public Group(String reportGroup, String addr, String frequency, String value, String lastFrequency,
			boolean isUserFreq) {
		super();
		this.reportGroup = reportGroup;
		this.addr = addr;
		this.frequency = frequency;
		this.value = value;
		this.lastFrequency = lastFrequency;
		this.isUserFreq = isUserFreq;
	}
	public String getReportGroup() {
		return reportGroup;
	}
	public void setReportGroup(String reportGroup) {
		this.reportGroup = reportGroup;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLastFrequency() {
		return lastFrequency;
	}
	public void setLastFrequency(String lastFrequency) {
		this.lastFrequency = lastFrequency;
	}
	public boolean isUserFreq() {
		return isUserFreq;
	}
	public void setUserFreq(boolean isUserFreq) {
		this.isUserFreq = isUserFreq;
	}
	public String getMailKey() {
		return mailKey;
	}
	public void setMailKey(String mailKey) {
		this.mailKey = mailKey;
	}
	public Date getLastDeliverDate() {
		return lastDeliverDate;
	}
	public void setLastDeliverDate(Date lastDeliverDate) {
		this.lastDeliverDate = lastDeliverDate;
	}
	
	
}
