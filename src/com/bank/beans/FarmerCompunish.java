package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerCompunish extends BaseEntity<Long>{
	
    private Long farmerid;

    private String organ;

    private String detail;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date occurtime;

    private Integer type;

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

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getOccurtime() {
		return occurtime;
	}

	public void setOccurtime(Date occurtime) {
		this.occurtime = occurtime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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