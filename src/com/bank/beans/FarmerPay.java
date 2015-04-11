package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class FarmerPay extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3464766790870019558L;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
	//生产支出
	private String productPay;
	//生活支出
	private String livingPay;
	//医疗支出
	private String medicalPay;
	//教育支出
	private String educatePay;
	//参保支出
	private String insuredPay;
	//其他支出
	private String otherPay;
	//家庭年度总支出合计
	private String totalPay;
	//记录人
	private String recorder;
	//记录时间
	private Date recordTime;
	
	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}


	public String getFarmerIdNum() {
		return farmerIdNum;
	}

	public void setFarmerIdNum(String farmerIdNum) {
		this.farmerIdNum = farmerIdNum;
	}

	public String getProductPay() {
		return productPay;
	}

	public void setProductPay(String productPay) {
		this.productPay = productPay;
	}

	public String getLivingPay() {
		return livingPay;
	}

	public void setLivingPay(String livingPay) {
		this.livingPay = livingPay;
	}

	public String getMedicalPay() {
		return medicalPay;
	}

	public void setMedicalPay(String medicalPay) {
		this.medicalPay = medicalPay;
	}

	public String getEducatePay() {
		return educatePay;
	}

	public void setEducatePay(String educatePay) {
		this.educatePay = educatePay;
	}

	public String getInsuredPay() {
		return insuredPay;
	}

	public void setInsuredPay(String insuredPay) {
		this.insuredPay = insuredPay;
	}

	public String getOtherPay() {
		return otherPay;
	}

	public void setOtherPay(String otherPay) {
		this.otherPay = otherPay;
	}

	public String getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(String totalPay) {
		this.totalPay = totalPay;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
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
