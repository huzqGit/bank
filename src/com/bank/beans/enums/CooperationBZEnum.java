package com.bank.beans.enums;

public enum CooperationBZEnum {
	COOPERATIONNAME("A"),
	BUSINESSLICENCE("B"),
	ORGANCODE("C"),
	TAXCODE("D"),
	REGISTERADDRESS("E"),
	MAILADDRESS("F"),
	REGISTERDATE("G"),
	REGISTERCAPITAL("H"),
	REALCAPITAL("I"),
	LEGALPERSON("J"),
	IDNUM("K"),
	PHONE("L"),
	MEMBERS("M"),
	BUSINESSCOPE("N"),
	BUSINESSAREA("O"),
	FARMERS("P"),
	CONNECTIONBASE("Q");
	
	private String index;
	
	CooperationBZEnum(String index){
		this.index = index;
	}
	
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
