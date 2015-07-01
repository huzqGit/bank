package com.bank.beans.enums;

public enum LoanNYEnum {

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
	   PHONE(17);
	
	   private int index; 
	   
	   public static final int $CLIENTTYPE = 1;//客户类型
	   public static final int $IDTYPE = 2;//证件类型
	   
	   LoanNYEnum(int index){
		   this.index=index;
	   }
	   public int getIndex(){
		   return this.index;
	   }
	   /**
	    * 
	    * @param type
	    * @param value
	    * @return -99翻译失败
	    */
	   public static Integer explain(int type,String value){
		   if(LoanNSEnum.$CLIENTTYPE == type){
			   if("其它自然人客户".equals(value)){
				   return 1;
			   }else{
				   return -99;//翻译失败
			   }
		   }else if(LoanNSEnum.$IDTYPE == type){
			   if("公民身份证".equals(value)){
				   return 0;
			   }else{
				   return -99;//
			   }
			   
		   }else{
			   return -99;
		   }
	   }
}
