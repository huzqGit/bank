package com.bank.beans.enums;

public enum FamerBalanceBZEnum {
	FARMERIDNUM("A"),
	YEAR("B"),
	FARMINGINCOME("C"),
	AVOCATIONINCOME("D"),
	BUSINESSINCOME("E"),
	WORKINCOME("F"),
	OTHERINCOME("G"),
	PRODUCTPAY("H"),
	LIVINGPAY("I"),
	MEDICALPAY("J"),
	EDUCATEPAY("K"),
	INSUREDPAY("L"),
	OTHERPAY("M"),
    TOTALINCOME("N"),
    TOTALPAY("O");
	private String index;
	FamerBalanceBZEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
}
