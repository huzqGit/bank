package com.bank.beans.enums;

public enum FarmerInsuredBZEnum {
	FARMERIDNUM("A"),
	TYPE("B"),
	AMOUNT("C"),
	INSUREDTIME("D"),
	LIMITTIME("E");
	
	private String index;
	FarmerInsuredBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
