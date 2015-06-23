package com.bank.beans;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;


public class FarmerPay extends BaseEntity<Long>  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3464766790870019558L;
	
	private Long farmerid;
	
	@DateTimeFormat(pattern = "yyyy")
    private Date year;

    private Double farmingincome;

    private Double avocationincome;

    private Double businessincome;

    private Double workincome;

    private Double otherincome;

    private Double totalincome;

    private Double productpay;

    private Double livingpay;

    private Double medicalpay;

    private Double educatepay;

    private Double insuredpay;

    private Double otherpay;

    private Double totalpay;

    private String sourcecode;
 
    private String sourcename;

    private String runitid;

    private String runitname;

    private String recorder;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordtime;
    
    private List<FarmerIncome> incomes;

	public Long getFarmerid() {
		return farmerid;
	}

	public void setFarmerid(Long farmerid) {
		this.farmerid = farmerid;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Double getFarmingincome() {
		return farmingincome;
	}

	public void setFarmingincome(Double farmingincome) {
		this.farmingincome = farmingincome;
	}

	public Double getAvocationincome() {
		return avocationincome;
	}

	public void setAvocationincome(Double avocationincome) {
		this.avocationincome = avocationincome;
	}

	public Double getBusinessincome() {
		return businessincome;
	}

	public void setBusinessincome(Double businessincome) {
		this.businessincome = businessincome;
	}

	public Double getWorkincome() {
		return workincome;
	}

	public void setWorkincome(Double workincome) {
		this.workincome = workincome;
	}

	public Double getOtherincome() {
		return otherincome;
	}

	public void setOtherincome(Double otherincome) {
		this.otherincome = otherincome;
	}

	public Double getTotalincome() {
		return totalincome;
	}

	public void setTotalincome(Double totalincome) {
		this.totalincome = totalincome;
	}

	public Double getProductpay() {
		return productpay;
	}

	public void setProductpay(Double productpay) {
		this.productpay = productpay;
	}

	public Double getLivingpay() {
		return livingpay;
	}

	public void setLivingpay(Double livingpay) {
		this.livingpay = livingpay;
	}

	public Double getMedicalpay() {
		return medicalpay;
	}

	public void setMedicalpay(Double medicalpay) {
		this.medicalpay = medicalpay;
	}

	public Double getEducatepay() {
		return educatepay;
	}

	public void setEducatepay(Double educatepay) {
		this.educatepay = educatepay;
	}

	public Double getInsuredpay() {
		return insuredpay;
	}

	public void setInsuredpay(Double insuredpay) {
		this.insuredpay = insuredpay;
	}

	public Double getOtherpay() {
		return otherpay;
	}

	public void setOtherpay(Double otherpay) {
		this.otherpay = otherpay;
	}

	public Double getTotalpay() {
		return totalpay;
	}

	public void setTotalpay(Double totalpay) {
		this.totalpay = totalpay;
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

	
	public List<FarmerIncome> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<FarmerIncome> incomes) {
		this.incomes = incomes;
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
