package com.bank.beans.enums;

public enum FarmerPrivateLendingEnum {
	FARMERIDNUM("A"),
	AMOUNT("B"),
	RATE("C"),
	LENDINGTIME("D"),
	LIMITTIME("E");
	private String index;
	
	FarmerPrivateLendingEnum(String index){
		this.index = index;
	}
	
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}

}
