package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerEvaluate extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808936993388416975L;
	
		private Long farmerid;

	    private String personality;

	    private String harmonystatus;

	    private String respectstatus;

	    private String neighborstatus;

	    private Integer legalstatus;

	    private String welfarestatus;

	    private Integer honeststatus;

	    private String otherstatus;

	    private String sourcecode;

	    private String sourcename;

	    private String runitid;

	    private String runitname;

	    private String recorder;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date recordtime;
	
	    public Long getFarmerid() {
			return farmerid;
		}

		public void setFarmerid(Long farmerid) {
			this.farmerid = farmerid;
		}

		public String getPersonality() {
			return personality;
		}

		public void setPersonality(String personality) {
			this.personality = personality;
		}

		public String getHarmonystatus() {
			return harmonystatus;
		}

		public void setHarmonystatus(String harmonystatus) {
			this.harmonystatus = harmonystatus;
		}

		public String getRespectstatus() {
			return respectstatus;
		}

		public void setRespectstatus(String respectstatus) {
			this.respectstatus = respectstatus;
		}

		public String getNeighborstatus() {
			return neighborstatus;
		}

		public void setNeighborstatus(String neighborstatus) {
			this.neighborstatus = neighborstatus;
		}

		public Integer getLegalstatus() {
			return legalstatus;
		}

		public void setLegalstatus(Integer legalstatus) {
			this.legalstatus = legalstatus;
		}

		public String getWelfarestatus() {
			return welfarestatus;
		}

		public void setWelfarestatus(String welfarestatus) {
			this.welfarestatus = welfarestatus;
		}

		public Integer getHoneststatus() {
			return honeststatus;
		}

		public void setHoneststatus(Integer honeststatus) {
			this.honeststatus = honeststatus;
		}

		public String getOtherstatus() {
			return otherstatus;
		}

		public void setOtherstatus(String otherstatus) {
			this.otherstatus = otherstatus;
		}

		public String getSourcecode() {
			return sourcecode;
		}

		public void setSourcecode(String sourcecode) {
			this.sourcecode = sourcecode;
		}

		public String getSourcename() {
			return sourcename;
		}

		public void setSourcename(String sourcename) {
			this.sourcename = sourcename;
		}

		public String getRunitid() {
			return runitid;
		}

		public void setRunitid(String runitid) {
			this.runitid = runitid;
		}

		public String getRunitname() {
			return runitname;
		}

		public void setRunitname(String runitname) {
			this.runitname = runitname;
		}

		public String getRecorder() {
			return recorder;
		}

		public void setRecorder(String recorder) {
			this.recorder = recorder;
		}

		public Date getRecordtime() {
			return recordtime;
		}

		public void setRecordtime(Date recordtime) {
			this.recordtime = recordtime;
		}

	@Override
	public boolean equalsIfIdNull(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}

}
