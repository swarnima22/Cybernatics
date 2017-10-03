package com.cyber.bean;

public class MailsTO {
	private String mailid;
	private int empid;
	private String mailsub;
	private String mailbody;
	private int frommailid;
	private int messageid;
	private int tomailid;
	private String maildate;
	private String loginid;
	private String emploginid;
	private String requesttype;
	private String mailbox;
	
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	public String getEmploginid() {
		return emploginid;
	}
	public void setEmploginid(String emploginid) {
		this.emploginid = emploginid;
	}
	public int getFrommailid() {
		return frommailid;
	}
	public void setFrommailid(int frommailid) {
		this.frommailid = frommailid;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getMailsub() {
		return mailsub;
	}
	public void setMailsub(String mailsub) {
		this.mailsub = mailsub;
	}
	public String getMailbody() {
		return mailbody;
	}
	public void setMailbody(String mailbody) {
		this.mailbody = mailbody;
	}


	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public String getMaildate() {
		return maildate;
	}
	public void setMaildate(String maildate) {
		this.maildate = maildate;
	}
	public int getTomailid() {
		return tomailid;
	}
	public void setTomailid(int tomailid) {
		this.tomailid = tomailid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}
