package com.bank.beans.enums;

public enum FarmerNYEnum {
	FARMERNAME("B"),
	IDTYPE("J"),
	IDNUM("L"),
	SEX("S"),
	BIRTHDATE("T"),
	FARMERTYPE("O"),
	MARRYSTATUS("U"),
	EDUCATION("V"),
	ADDRESS("Z"),
	POSTCODE("AA");
	private String index;
	FarmerNYEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
