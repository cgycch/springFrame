package com.cch.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailBean implements Cloneable{
	
	@Value("${mail.host}")
	private String host;
	
	@Value("${mail.port}")
	private int port;
	
	@Value("${mail.from}")
	private String from;
	
	@Value("${mail.to:default}")
	private String to;
	
	@Value("${mail.cc:default}")
	private String cc;
	
	@Value("${mail.bcc:default}")
	private String bcc;
	
	@Value("#{user.getALiasName()}")
	private String attach;
	
	@Value("#{user.userName}")
	private String userName;
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	@Override
	public String toString() {
		return "MailBean [host=" + host + ", port=" + port + ", from=" + from + ", to=" + to + ", cc=" + cc + ", bcc="
				+ bcc + ", attach=" + attach + ", userName=" + userName + "]";
	}
	
}
