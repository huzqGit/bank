package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FarmerCredit {
    private Long creditid;

    private Long farmerid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public Long getCreditid() {
        return creditid;
    }

    public void setCreditid(Long creditid) {
        this.creditid = creditid;
    }

    public Long getFarmerid() {
        return farmerid;
    }

    public void setFarmerid(Long farmerid) {
        this.farmerid = farmerid;
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
        this.assessrank = assessrank == null ? null : assessrank.trim();
    }

    public String getAssessorgan() {
        return assessorgan;
    }

    public void setAssessorgan(String assessorgan) {
        this.assessorgan = assessorgan == null ? null : assessorgan.trim();
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit == null ? null : timelimit.trim();
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
}