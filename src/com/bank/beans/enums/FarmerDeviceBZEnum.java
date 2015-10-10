package com.bank.beans.enums;

public enum FarmerDeviceBZEnum {
	FARMERIDNUM("A"),
	NAME("B"),
	BRAND("C"),
	BUYINGPRICE("D"),
	BUYINGDATE("E"),
	ASSESSPRICE("F");
	
	private String index;
	
	FarmerDeviceBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
