package com.bank.beans.enums;

public enum FarmerLoanNYEnum{

	   CLIENTNUM("C"),
	   COMPACTNUM("N"),
	   FARMERNAME("D"),
	   NOTENUM("N"),
	   LOANDATE("O"),
	   LIMITDATE("T"),
	   CURRENCY("G"),
	   AMOUNT("J"),
	   BALANCE("L"),
	   CLIENTNAME("D"),
	   IDTYPE("P"),
	   IDNUM("Q"),
	   GUARANTEETYPE("H"),
	   GUARANTEETYPE1("H"),
	   ORGANCODE("A"),
	   PHONE("R");
	   private String index; 
	   
	   public static final int $CLIENTTYPE = 1;//客户类型
	   public static final int $IDTYPE = 2;//证件类型
	   
	   FarmerLoanNYEnum(String index){
		   this.index=index;
	   }
	   public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	   }
}
