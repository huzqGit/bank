package com.bank.beans.enums;

public enum FarmerForestBZEnum {
	 FARMERIDNUM("A"),
	 CARDNUM("B"),
	 WORDNUM("C"),
	 OWNER("D"),
	 USETYPE("E"),
	 AREA("F"),
	 STORENUM("G"),
	 TIMELIMIT("H"),
	 ASSESSPRICE("I");
	 private String index;
	 FarmerForestBZEnum(String index){
		 this.index = index;
	 }
	 public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
