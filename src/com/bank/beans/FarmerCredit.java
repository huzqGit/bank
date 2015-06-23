package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerCredit extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 447074825679634280L;
	
	private Long farmerid;
	
	private String farmername;

    private String farmeridnum;

    private Date assessdate;

    private String assessrank;

    private String assessorgan;

    private String timelimit;

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

	public String getFarmername() {
		return farmername;
	}

	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}

	public String getFarmeridnum() {
		return farmeridnum;
	}

	public void setFarmeridnum(String farmeridnum) {
		this.farmeridnum = farmeridnum;
	}

	public Date getAssessdate() {
		return assessdate;
	}

	public void setAssessdate(Date assessdate) {
		this.assessdate = assessdate;
	}

	public String getAssessrank() {
		return assessrank;
	}

	public void setAssessrank(String assessrank) {
		this.assessrank = assessrank;
	}

	public String getAssessorgan() {
		return assessorgan;
	}

	public void setAssessorgan(String assessorgan) {
		this.assessorgan = assessorgan;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
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
