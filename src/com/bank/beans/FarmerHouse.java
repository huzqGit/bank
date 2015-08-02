package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerHouse extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4025907896329889146L;

    private Long farmerid;

    private String farmeridnum;

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

    public String getFarmeridnum() {
        return farmeridnum;
    }

    public void setFarmeridnum(String farmeridnum) {
        this.farmeridnum = farmeridnum == null ? null : farmeridnum.trim();
    }

    public String getHouseproperty() {
        return houseproperty;
    }

    public void setHouseproperty(String houseproperty) {
        this.houseproperty = houseproperty == null ? null : houseproperty.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public String getHouseaddress() {
        return houseaddress;
    }

    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress == null ? null : houseaddress.trim();
    }

    public String getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(String buildarea) {
        this.buildarea = buildarea == null ? null : buildarea.trim();
    }

    public String getBuilddate() {
        return builddate;
    }

    public void setBuilddate(String builddate) {
        this.builddate = builddate == null ? null : builddate.trim();
    }

    public String getBuildprice() {
        return buildprice;
    }

    public void setBuildprice(String buildprice) {
        this.buildprice = buildprice == null ? null : buildprice.trim();
    }

    public String getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(String floorarea) {
        this.floorarea = floorarea == null ? null : floorarea.trim();
    }

    public String getAssessprice() {
        return assessprice;
    }

    public void setAssessprice(String assessprice) {
        this.assessprice = assessprice == null ? null : assessprice.trim();
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode == null ? null : sourcecode.trim();
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename == null ? null : sourcename.trim();
    }

    public String getRunitid() {
        return runitid;
    }

    public void setRunitid(String runitid) {
        this.runitid = runitid == null ? null : runitid.trim();
    }

    public String getRunitname() {
        return runitname;
    }

    public void setRunitname(String runitname) {
        this.runitname = runitname == null ? null : runitname.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
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