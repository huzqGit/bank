package com.bank.beans;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerHouse extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3527327656335653102L;
	
	private Long farmerid;

    private String houseproperty;

    private String housetype;

    private String houseaddress;

    private String buildarea;

    private String builddate;

    private String buildprice;

    private String floorarea;

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

	public String getHouseproperty() {
		return houseproperty;
	}

	public void setHouseproperty(String houseproperty) {
		this.houseproperty = houseproperty;
	}

	public String getHousetype() {
		return housetype;
	}

	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}

	public String getHouseaddress() {
		return houseaddress;
	}

	public void setHouseaddress(String houseaddress) {
		this.houseaddress = houseaddress;
	}

	public String getBuildarea() {
		return buildarea;
	}

	public void setBuildarea(String buildarea) {
		this.buildarea = buildarea;
	}

	public String getBuilddate() {
		return builddate;
	}

	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}

	public String getBuildprice() {
		return buildprice;
	}

	public void setBuildprice(String buildprice) {
		this.buildprice = buildprice;
	}

	public String getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(String floorarea) {
		this.floorarea = floorarea;
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
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		return 0;
	}


}
