package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerMember extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1550305454462009720L;
	
    private Long farmerid;

    private String name;

    private String relation;

    private String idnum;

    private Integer education;

    private String marrystatus;

    private String occupation;

    private String job;

    private Integer sex;

    private String phone;

    private String address;

    private String healthstate;

    private Integer labourstate;

    private Integer usingmedical;

    private Integer usinginuse;

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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getMarrystatus() {
		return marrystatus;
	}

	public void setMarrystatus(String marrystatus) {
		this.marrystatus = marrystatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHealthstate() {
		return healthstate;
	}

	public void setHealthstate(String healthstate) {
		this.healthstate = healthstate;
	}

	public Integer getLabourstate() {
		return labourstate;
	}

	public void setLabourstate(Integer labourstate) {
		this.labourstate = labourstate;
	}

	public Integer getUsingmedical() {
		return usingmedical;
	}

	public void setUsingmedical(Integer usingmedical) {
		this.usingmedical = usingmedical;
	}

	public Integer getUsinginuse() {
		return usinginuse;
	}

	public void setUsinginuse(Integer usinginuse) {
		this.usinginuse = usinginuse;
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
