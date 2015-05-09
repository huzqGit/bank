package com.bank.beans.enums;
/*
 * 
 * 农商银行EXCEL字段映射类
 */
public enum LoanNSEnum {
	
	   CLIENTNUM(0),
	   NOTENUM(1),
	   COMPACTNUM(2),
	   LOANDATE(5),
	   LIMITDATE(6),
	   LIMITDATE1(7),
	   CURRENCY(8),
	   AMOUNT(9),
	   BALANCE(10),
	   OWEINTEREST(11),
	   CURRENTRATE(12),
	   RATETYPE(13),
	   CLIENTNAME(4),
	   CLIENTTYPE(14),
	   PHONE(64),
	   ADDRESS(66),
	   IDTYPE(15),
	   IDNUM(16),
	   LOANUSE(18),
	   GUARANTEETYPE(19),
	   GRADE(20),
	   GRADE1(21),
	   SETTLETYPE(22),
	   CHARGEPERSON(25),
	   ORGANCODE(31),
	   ORGANNAME(32),
	   BUSINESSTYPE(36),
	   BUSINESSBODY(37),
	   PROVIDETYPE(38),
	   INVEST(39),
	   TERMTYPE(40),
	   GUARANTEETYPE1(41),
	   FLOATSCOPE(45),
	   ADJUSTTYPE(46),
	   RUNTYPE(47),
	   FREQUEENCY(48);
	
	   private int index; 
	   
	   public static final int $CLIENTTYPE = 1;//客户类型
	   public static final int $IDTYPE = 2;//证件类型
	   
	   LoanNSEnum(int index){
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
