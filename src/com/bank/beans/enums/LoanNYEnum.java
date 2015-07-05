package com.bank.beans.enums;

public enum LoanNYEnum{

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
/**
	   CLIENTNUM(2),
	   FARMERNAME(3),
	   NOTENUM(12),
	   COMPACTNUM(13),
	   LOANDATE(10),
	   LIMITDATE(19),
	   CURRENCY(6),
	   AMOUNT(9),
	   BALANCE(11),
	   CLIENTNAME(3),
	   IDTYPE(15),
	   IDNUM(16),
	   GUARANTEETYPE(7),
	   ORGANCODE(0),
	   GUARANTEETYPE1(7),
	   PHONE(17);**/
	   private String index; 
	   
	   public static final int $CLIENTTYPE = 1;//客户类型
	   public static final int $IDTYPE = 2;//证件类型
	   
	   LoanNYEnum(String index){
		   this.index=index;
	   }
	   public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	   }
}
