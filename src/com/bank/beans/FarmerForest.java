package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class FarmerForest extends BaseEntity<Long>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7182190192847773625L;


    private Long farmerid;

    private String farmeridnum;

    private String cardnum;

    private String wordnum;

    private String owner;

    private String usetype;

    private String area;

    private String storenum;

    private String timelimit;

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

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public String getWordnum() {
        return wordnum;
    }

    public void setWordnum(String wordnum) {
        this.wordnum = wordnum == null ? null : wordnum.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype == null ? null : usetype.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStorenum() {
        return storenum;
    }

    public void setStorenum(String storenum) {
        this.storenum = storenum == null ? null : storenum.trim();
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit == null ? null : timelimit.trim();
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