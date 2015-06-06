package com.bank.beans;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class FarmerPay implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3464766790870019558L;
	private Long id;
	private Long farmerId;
	private String year;
	//农户姓名
	private String farmerName;
	//农户身份证号
	private String farmerIdNum;
   	private Double farmingIncome;
    private Double avocationIncome;
   	private Double businessIncome;
    private Double otherIncome;
    private Double totalIncome;
	//生产支出
	private Double productPay;
	//生活支出
	private Double livingPay;
	//医疗支出
	private Double medicalPay;
	//教育支出
	private Double educatePay;
	//参保支出
	private Double insuredPay;
	//其他支出
	private Double otherPay;
	//家庭年度总支出合计
	private Double totalPay;
	private List<FarmerIncome> incomes;
	//记录人
	private String recorder;
	//记录时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date recordTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

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

	public Double getFarmingIncome() {
		return farmingIncome;
	}

	public void setFarmingIncome(Double farmingIncome) {
		this.farmingIncome = farmingIncome;
	}

	public Double getAvocationIncome() {
		return avocationIncome;
	}

	public void setAvocationIncome(Double avocationIncome) {
		this.avocationIncome = avocationIncome;
	}

	public Double getBusinessIncome() {
		return businessIncome;
	}

	public void setBusinessIncome(Double businessIncome) {
		this.businessIncome = businessIncome;
	}

	public Double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(Double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Double getProductPay() {
		return productPay;
	}

	public void setProductPay(Double productPay) {
		this.productPay = productPay;
	}

	public Double getLivingPay() {
		return livingPay;
	}

	public void setLivingPay(Double livingPay) {
		this.livingPay = livingPay;
	}

	public Double getMedicalPay() {
		return medicalPay;
	}

	public void setMedicalPay(Double medicalPay) {
		this.medicalPay = medicalPay;
	}

	public Double getEducatePay() {
		return educatePay;
	}

	public void setEducatePay(Double educatePay) {
		this.educatePay = educatePay;
	}

	public Double getInsuredPay() {
		return insuredPay;
	}

	public void setInsuredPay(Double insuredPay) {
		this.insuredPay = insuredPay;
	}

	public Double getOtherPay() {
		return otherPay;
	}

	public void setOtherPay(Double otherPay) {
		this.otherPay = otherPay;
	}

	public Double getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(Double totalPay) {
		this.totalPay = totalPay;
	}

	public List<FarmerIncome> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<FarmerIncome> incomes) {
		this.incomes = incomes;
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

}
