package com.bank.beans.enums;

public enum FarmerBreedBZEnum {
	
	FARMERNAME("A"),
	FARMERIDNUM("B"),
	VARIETY("C"),
	OUTPUT("D"),
	FLOORAREA("E"),
	OUTPUTVALUE("F"),
	ASSESSPRICE("G");
	
	private String index;
	
	FarmerBreedBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
