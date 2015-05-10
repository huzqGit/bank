package com.bank.beans;

import com.common.bean.BaseEntity;

public class FarmerForest extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8668764238248835128L;
	//农户身份证号
	private Long farmerId;
	//林权证编号
	private String cardNum;
	//林权字号
	private String wordNum;
	//林权使用人
	private String user;
	//使用权种类
	private Integer useType;
	//面积
	private String area;
	//蓄积量
	private String storeNum;
	//使用权期限
	private String timeLimit;
	//当前评估价格
	private String assessPrice;

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getWordNum() {
		return wordNum;
	}

	public void setWordNum(String wordNum) {
		this.wordNum = wordNum;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getUseType() {
		return useType;
	}

	public void setUseType(Integer useType) {
		this.useType = useType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getAssessPrice() {
		return assessPrice;
	}

	public void setAssessPrice(String assessPrice) {
		this.assessPrice = assessPrice;
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
