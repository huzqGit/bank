package com.bank.beans.enums;

public enum CooperationNSEnum {
	
	COOPERATIONNAME("C"),
	BUSINESSLICENCE("E"),
	CLINETTYPE("F"),
	LEGALPERSON("G"),
	IDNUM("H"),
	REGISTERDATE("J"),
	PHONE("K"),
	PHONE1("L"),
	REGISTERADDRESS("P");
	private String index;
	
	CooperationNSEnum(String  index){
		this.index = index;
	}
	
	public int getIndex(){
		 return ExcelMapper.getInstance().parseCode(this.index);
	}
}
