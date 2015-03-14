package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class Company extends BaseEntity<Integer> {
	private Integer companyId;//主键
	private String companyName;//企业名称
	private Integer companyCategory;//行业分类
	private Integer companyFeature;//企业特征
	private Integer companyNature;//企业性质
	private String mailingAddress;//企业通信地址
	private String registerAddress;//企业注册地址
	private Date registerDate;//企业注册登记日期
	private Integer registerType;//企业登记注册类型
	private Integer postCode;//邮政编码
	private String telephone;//联系电话
	private String fax;//传真号码
	private String email;//电子邮箱
	private Integer employees;//从业人数
	private String products;//主要产品
	private String businessScope;//经营范围
	private String businessLocation;//经营场所
	private Integer locationArea;//经营场所面积
	private String depositBank;//基本户开户行
	private String organCode;//组织机构代码
	private String creditCode;//机构信用代码
	private String loancardCode;//贷款卡编码
	private Integer regionalism;//行政区划
	private String taxIdentifer;//税务识别码
	private String localIdentifer;//地区识别码
	private String businessCode;//工商登记注册号
	private String businessIssuer;//工商登记注册号发证机关
	private Date businesslicenceEnd;//营业执照到期日
	private Date businesschkDate;//工商登记注册号上次年检时间
	private String localtaxCode;//地税登记证号码
	private String localtaxIssuer;//地税登记证发证机关
	private Date localtaxEnd;//地税登记证到期日
	private String chinataxCode;//国税登记证号码
	private String chinataxIssuer;//国税登记证发证机关
	private Date chinataxEnd;//国税登记证到期日 
	private String recorder;//记录人
	private Date recordTime ;//记录时间
	
	
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(Integer companyCategory) {
		this.companyCategory = companyCategory;
	}

	public Integer getCompanyFeature() {
		return companyFeature;
	}

	public void setCompanyFeature(Integer companyFeature) {
		this.companyFeature = companyFeature;
	}

	public Integer getCompanyNature() {
		return companyNature;
	}

	public void setCompanyNature(Integer companyNature) {
		this.companyNature = companyNature;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getRegisterAddress() {
		return registerAddress;
	}

	public void setRegisterAddress(String registerAddress) {
		this.registerAddress = registerAddress;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getBusinessLocation() {
		return businessLocation;
	}

	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}

	public Integer getLocationArea() {
		return locationArea;
	}

	public void setLocationArea(Integer locationArea) {
		this.locationArea = locationArea;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getLoancardCode() {
		return loancardCode;
	}

	public void setLoancardCode(String loancardCode) {
		this.loancardCode = loancardCode;
	}

	public Integer getRegionalism() {
		return regionalism;
	}

	public void setRegionalism(Integer regionalism) {
		this.regionalism = regionalism;
	}

	public String getTaxIdentifer() {
		return taxIdentifer;
	}

	public void setTaxIdentifer(String taxIdentifer) {
		this.taxIdentifer = taxIdentifer;
	}

	public String getLocalIdentifer() {
		return localIdentifer;
	}

	public void setLocalIdentifer(String localIdentifer) {
		this.localIdentifer = localIdentifer;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessIssuer() {
		return businessIssuer;
	}

	public void setBusinessIssuer(String businessIssuer) {
		this.businessIssuer = businessIssuer;
	}

	public Date getBusinesslicenceEnd() {
		return businesslicenceEnd;
	}

	public void setBusinesslicenceEnd(Date businesslicenceEnd) {
		this.businesslicenceEnd = businesslicenceEnd;
	}

	public Date getBusinesschkDate() {
		return businesschkDate;
	}

	public void setBusinesschkDate(Date businesschkDate) {
		this.businesschkDate = businesschkDate;
	}
	public String getChinataxCode() {
		return chinataxCode;
	}

	public String getLocaltaxCode() {
		return localtaxCode;
	}

	public void setLocaltaxCode(String localtaxCode) {
		this.localtaxCode = localtaxCode;
	}

	public String getLocaltaxIssuer() {
		return localtaxIssuer;
	}

	public void setLocaltaxIssuer(String localtaxIssuer) {
		this.localtaxIssuer = localtaxIssuer;
	}

	public Date getLocaltaxEnd() {
		return localtaxEnd;
	}

	public void setLocaltaxEnd(Date localtaxEnd) {
		this.localtaxEnd = localtaxEnd;
	}



	
	public void setChinataxCode(String chinataxCode) {
		this.chinataxCode = chinataxCode;
	}

	public String getChinataxIssuer() {
		return chinataxIssuer;
	}

	public void setChinataxIssuer(String chinataxIssuer) {
		this.chinataxIssuer = chinataxIssuer;
	}

	public Date getChinataxEnd() {
		return chinataxEnd;
	}

	public void setChinataxEnd(Date chinataxEnd) {
		this.chinataxEnd = chinataxEnd;
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
