package com.bank.beans.enums;

public enum FarmerCompunishBZEnum {
	
	FARMERNAME("A"),
	FARMERIDNUM("B"),
	TYPE("C"),
	ORGAN("D"),
	OCCURTIME("E"),
	COMPUNISHLEVEL("F"),
	DETAIL("G");
	
	private String index;
	
	FarmerCompunishBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
