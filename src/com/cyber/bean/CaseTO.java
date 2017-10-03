package com.cyber.bean;

import java.io.File;

public class CaseTO {
	private String casename;
	private int caseid;
	private String casedescription;
	private String casefile;
	private String casestatus;
	private String caseregdate;
	private String agencyname;
	private String agencydescription;
	private String agencyaddress;
	private String agencycontact;
	private int userid;
	private String agentname;
	private String loginid;
	private int casedetailsid;
	private String filtype;
	private String filepath;
	private int caseassignid;
	private File filePath;
	private int agencyid;
	private int agentid;
	private File encriptpath;
	public File getFilePath() {
		return filePath;
	}

	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}

	public int getCaseassignid() {
		return caseassignid;
	}

	public void setCaseassignid(int caseassignid) {
		this.caseassignid = caseassignid;
	}

	public int getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(int agencyid) {
		this.agencyid = agencyid;
	}

	public String getCaseregdate() {
		return caseregdate;
	}

	public void setCaseregdate(String caseregdate) {
		this.caseregdate = caseregdate;
	}

	public int getCaseid() {
		return caseid;
	}

	public void setCaseid(int caseid) {
		this.caseid = caseid;
	}

	public String getCasestatus() {
		return casestatus;
	}

	public void setCasestatus(String casestatus) {
		this.casestatus = casestatus;
	}

	public String getCasefile() {
		return casefile;
	}

	public void setCasefile(String casefile) {
		this.casefile = casefile;
	}

	public String getCasename() {
		return casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getCasedescription() {
		return casedescription;
	}

	public void setCasedescription(String casedescription) {
		this.casedescription = casedescription;
	}

	public String getAgencyname() {
		return agencyname;
	}

	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}

	public String getAgencydescription() {
		return agencydescription;
	}

	public void setAgencydescription(String agencydescription) {
		this.agencydescription = agencydescription;
	}

	public String getAgencyaddress() {
		return agencyaddress;
	}

	public void setAgencyaddress(String agencyaddress) {
		this.agencyaddress = agencyaddress;
	}

	public String getAgencycontact() {
		return agencycontact;
	}

	public void setAgencycontact(String agencycontact) {
		this.agencycontact = agencycontact;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getFiltype() {
		return filtype;
	}

	public void setFiltype(String filtype) {
		this.filtype = filtype;
	}

	public int getCasedetailsid() {
		return casedetailsid;
	}

	public void setCasedetailsid(int casedetailsid) {
		this.casedetailsid = casedetailsid;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public File getEncriptpath() {
		return encriptpath;
	}

	public void setEncriptpath(File encriptpath) {
		this.encriptpath = encriptpath;
	}

}
