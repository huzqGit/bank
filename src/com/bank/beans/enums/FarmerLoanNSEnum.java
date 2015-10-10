package com.bank.beans.enums;
/*
 * 
 * 农商银行EXCEL字段映射类
 */
public enum FarmerLoanNSEnum {
		
	   CLIENTNUM("A"),
	   NOTENUM("B"),
	   COMPACTNUM("C"),
	   NAME("E"),
	   LOANDATE("F"),
	   LIMITDATE("G"),
	   CURRENCY("H"),
	   AMOUNT("I"),
	   BALANCE("J"),
	   OWEINTEREST("K"),
	   CURRENTRATE("L"),
	   RATETYPE("M"),
	   CLIENTNAME("E"),
	   IDNUM("N"),
	   LOANUSE("O"),
	   GUARANTEETYPE("P"),
	   GRADE("Q"),
	   SETTLETYPE("R"),
	   CHARGEPERSON("T"),
	   ORGANNAME("V");
	   
	   private String index; 
	   
	   FarmerLoanNSEnum(String index){
		   this.index=index;
	   }
	   public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	   }
	   public static String[] validHead(){
		  String[] head = {"客户号","借据号","合同号","申请编号","客户名称","贷款日期","到期日期","币种","贷款金额	贷款余额","结欠利息","当前利率","利率类型",
				  "证件号码","贷款用途","担保方式分类","贷款五级分类形态","结息方式","产品","管理责任人名称","机构号","	机构名称","法人机构","当前状态",
				  "业务条线","所属片区","经营主体","申请机构","	营销柜员"};
	   return head;
	   }
}
