package com.bank.beans.enums;

public enum FarmerCreditBZEnum {

	FARMERIDNUM("A"),
	ASSESSDATE("B"),
	ASSESSRANK("C"),
	ASSESSORGAN("D"),
	TIMELIMIT("E");
	
	private String index ;
	FarmerCreditBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
