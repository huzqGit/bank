package com.bank.beans;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerIncome extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001805087077814968L;
	
		private Long payid;

	    private String incomename;

	    private Integer incometype;

	    private String netincome;

	    private String sourcecode;

	    private String sourcename;

	    private String runitid;

	    private String runitname;

	    private String recorder;
	    
	    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date recordtime;

	    public Long getPayid() {
			return payid;
		}

		public void setPayid(Long payid) {
			this.payid = payid;
		}

		public String getIncomename() {
			return incomename;
		}

		public void setIncomename(String incomename) {
			this.incomename = incomename;
		}

		public Integer getIncometype() {
			return incometype;
		}

		public void setIncometype(Integer incometype) {
			this.incometype = incometype;
		}

		public String getNetincome() {
			return netincome;
		}

		public void setNetincome(String netincome) {
			this.netincome = netincome;
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
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}

}
