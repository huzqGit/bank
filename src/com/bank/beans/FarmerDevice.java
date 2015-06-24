package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerDevice extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7469892461259102070L;
	
	 	private Long farmerid;

	    private String name;

	    private String brand;

	    private String buyingprice;

	    private String buyingdate;

	    private String assessprice;

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getBuyingprice() {
			return buyingprice;
		}

		public void setBuyingprice(String buyingprice) {
			this.buyingprice = buyingprice;
		}

		public String getBuyingdate() {
			return buyingdate;
		}

		public void setBuyingdate(String buyingdate) {
			this.buyingdate = buyingdate;
		}

		public String getAssessprice() {
			return assessprice;
		}

		public void setAssessprice(String assessprice) {
			this.assessprice = assessprice;
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
