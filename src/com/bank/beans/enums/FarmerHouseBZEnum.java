package com.bank.beans.enums;

public enum FarmerHouseBZEnum {
	FARMERIDNUM("A"),
	HOUSEPROPERTY("B"),
	HOUSETYPE("C"),
	HOUSEADDRESS("D"),
	BUILDDATE("E"),
	BUILDAREA("F"),
	FLOORAREA("G"),
	BUILDPRICE("H"),
	ASSESSPRICE("I");
	
	private String index;
	
	FarmerHouseBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
