package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerIncome extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1786708955576238841L;


    private Long payid;

    private String farmeridnum;

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

    public String getFarmeridnum() {
        return farmeridnum;
    }

    public void setFarmeridnum(String farmeridnum) {
        this.farmeridnum = farmeridnum == null ? null : farmeridnum.trim();
    }

    public String getIncomename() {
        return incomename;
    }

    public void setIncomename(String incomename) {
        this.incomename = incomename == null ? null : incomename.trim();
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
        this.netincome = netincome == null ? null : netincome.trim();
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