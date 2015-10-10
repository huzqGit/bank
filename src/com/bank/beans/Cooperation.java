package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class Cooperation extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6173585119855983528L;


    private String cooperationname;

    private String organcode;

    private String taxcode;

    private String businesslicence;

    private String registeraddress;

    private String mailaddress;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerdate;

    private String registercapital;

    private String realcapital;

    private String legalperson;

    private String idnum;

    private String phone;

    private Integer members;

    private String businesscope;

    private Integer businessarea;

    private Integer farmers;

    private String connectionbase;

    private String runitid;

    private String runitname;

    private String recorder;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordtime;

    private String sourcecode;

    private String sourcename;


    public String getCooperationname() {
        return cooperationname;
    }

    public void setCooperationname(String cooperationname) {
        this.cooperationname = cooperationname == null ? null : cooperationname.trim();
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode == null ? null : organcode.trim();
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode == null ? null : taxcode.trim();
    }

    public String getBusinesslicence() {
        return businesslicence;
    }

    public void setBusinesslicence(String businesslicence) {
        this.businesslicence = businesslicence == null ? null : businesslicence.trim();
    }

    public String getRegisteraddress() {
        return registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress == null ? null : registeraddress.trim();
    }

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress == null ? null : mailaddress.trim();
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getRegistercapital() {
        return registercapital;
    }

    public void setRegistercapital(String registercapital) {
        this.registercapital = registercapital == null ? null : registercapital.trim();
    }

    public String getRealcapital() {
        return realcapital;
    }

    public void setRealcapital(String realcapital) {
        this.realcapital = realcapital == null ? null : realcapital.trim();
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum == null ? null : idnum.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getBusinesscope() {
        return businesscope;
    }

    public void setBusinesscope(String businesscope) {
        this.businesscope = businesscope == null ? null : businesscope.trim();
    }

    public Integer getBusinessarea() {
        return businessarea;
    }

    public void setBusinessarea(Integer businessarea) {
        this.businessarea = businessarea;
    }

    public Integer getFarmers() {
        return farmers;
    }

    public void setFarmers(Integer farmers) {
        this.farmers = farmers;
    }

    public String getConnectionbase() {
        return connectionbase;
    }

    public void setConnectionbase(String connectionbase) {
        this.connectionbase = connectionbase == null ? null : connectionbase.trim();
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