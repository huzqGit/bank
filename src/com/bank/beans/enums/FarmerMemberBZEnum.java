package com.bank.beans.enums;

public enum FarmerMemberBZEnum {
	NAME("A"),
	IDNUM("B"),
	FARMERIDNUM("C"),
	RELATION("D"),
	EDUCATION("E"),
	SEX("F"),
	MARRYSTATUS("G"),
	OCCUPATION("H"),
	JOB("I"),
	PHONE("J"),
	ADDRESS("K");
	
	private String index;
	
	FarmerMemberBZEnum(String index){
		this.index = index;
	}
	
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}

}
