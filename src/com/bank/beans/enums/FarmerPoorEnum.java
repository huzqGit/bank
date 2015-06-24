package com.bank.beans.enums;

public enum FarmerPoorEnum {
	//name of farmer
	FARMERNAME(0),
	//identity card of farmer 
	IDNUM(1),
	//number of families
	FAMILYNUM(2),
	AVERAGEINCOME(3),
	POORTYPE(4),
	POORREASON(5),
	PHONE(7),
	BANK(8),
	ACCOUNT(9),
	STANARD(10),
	PROVINCE(11),
	CITY(12),
	COUNTRY(13),
	TOWN(14),
	VILLAGE(15),
	GROUP(16);
	private int index;
	FarmerPoorEnum(int index){
		this.index = index;
	}
	public int getIndex(){
		return this.index;
	}
}
