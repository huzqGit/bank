package com.bank.beans.enums;

public enum FarmerLoanYZEnum {

	LOANTYPE("A"),
	ORGANNAME("C"),
	FARMERNAME("D"),
	PHONE("E"),
	ADDRESS("F"),
	AMOUNT("H"),
	BALANCE("I"),
	LOANDATE("J"),
	LIMITDATE("K"),
	GRADE("M"),
	NOTENUM("W"),
	FARMERIDNUM("Z"),
	GUARANTEETYPE("AG"),
	;
	
	private String index;
	
	FarmerLoanYZEnum(String index){
		this.index = index;
	}
	
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
