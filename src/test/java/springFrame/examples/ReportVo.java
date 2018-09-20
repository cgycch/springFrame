package springFrame.examples;

public class ReportVo {
	
	private String reportGroup;
	private String addr;
	private String frequency;
	private String calFrequency;
	private String value;
	 
	
	public ReportVo(String reportGroup, String addr, String frequency, String calFrequency, String value) {
		super();
		this.reportGroup = reportGroup;
		this.addr = addr;
		this.frequency = frequency;
		this.calFrequency = calFrequency;
		this.value = value;
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
	public String getCalFrequency() {
		return calFrequency;
	}
	public void setCalFrequency(String calFrequency) {
		this.calFrequency = calFrequency;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
