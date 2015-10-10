package com.bank.beans.enums;

public enum FarmerBZEnum {
	FARMERNAME("A"),
	IDNUM("B"),
	SEX("C"),
	BIRTHDARY("D"),
	MARRYSTATUS("E"),
	PHONE("F"),
	VILLAGES("G"),
	EDUCATION("H"),
	FAMILYNUM("I"),
	LABORNUM("J"),
	POLITICSTATUS("K"),
	POSTCODE("L"),
	ADDRESS("M");
	private String index;
	FarmerBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
