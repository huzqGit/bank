package com.bank.beans;

import java.util.Date;

import com.common.bean.BaseEntity;

public class CompanyEmployee extends BaseEntity<Long> {

	private Integer employeeId;
	private String companyName;
	private String organCode;
	private String creditCode;
	private String name;
	private Integer sex;
	private Date birthday;
	private Integer category;//高管类别
	private String idType;//证件类别
	private String idNumber;//证件号码
	private Integer post;//职务
	private Date postTime;//
	private Integer degree;//最高学历
	private Integer stockAmount;//持有公司股票
	private String skill;//技能资格
	private Date skillwinTime;//技能资格取得时间
	private String  parttimeJob;//社会兼职
	private String workResume;//工作简历
	private String award;//
	private String othercompanyName;//在其他企业投资或任职的企业名称
	private String otherregisterCode;//在其他企业投资或任职的企业工商登记注册号
	private String otherPost;//在其投资或任职的其他企业所担任的职务
	private Integer otherinvestAmount;//在其投资或任职的其他企业的投资额
	private String recorder;//记录人
	private Date recordTime;//记录时间
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Date getSkillwinTime() {
		return skillwinTime;
	}

	public void setSkillwinTime(Date skillwinTime) {
		this.skillwinTime = skillwinTime;
	}

	public String getParttimeJob() {
		return parttimeJob;
	}

	public void setParttimeJob(String parttimeJob) {
		this.parttimeJob = parttimeJob;
	}

	public String getWorkResume() {
		return workResume;
	}

	public void setWorkResume(String workResume) {
		this.workResume = workResume;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getOthercompanyName() {
		return othercompanyName;
	}

	public void setOthercompanyName(String othercompanyName) {
		this.othercompanyName = othercompanyName;
	}

	public String getOtherregisterCode() {
		return otherregisterCode;
	}

	public void setOtherregisterCode(String otherregisterCode) {
		this.otherregisterCode = otherregisterCode;
	}

	public String getOtherPost() {
		return otherPost;
	}

	public void setOtherPost(String otherPost) {
		this.otherPost = otherPost;
	}

	public Integer getOtherinvestAmount() {
		return otherinvestAmount;
	}

	public void setOtherinvestAmount(Integer otherinvestAmount) {
		this.otherinvestAmount = otherinvestAmount;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}

}
