package com.bank.beans.enums;

public enum FarmerNSEnum {
	FARMERNAME("D"),
	IDTYPE("E"),
	IDNUM("F"),
	SEX("G"),
	FARMERTYPE("H"),
	MARRYSTATUS("I"),
	EDUCATION("J"),
	OCCUPATION("K"),
	PHONE("O"),
	ADDRESS("T");
	private String index;
	
	FarmerNSEnum(String index){
		this.index = index;
	}
	public int getIndex(){
		   return ExcelMapper.getInstance().parseCode(this.index);
	}
	public static String[] validHead(){
		String[] heads ={"序号","登记日期","客户号","	客户名称","证件类型","证件号码","性别","客户类型","婚姻状况","最高学历","职业","行业分类",
				"本行信用等级","红黑名单","手机号码1","手机号码2","管辖客户经理","签约标志","签约手机号","居住地址"};
		return heads;
	}
}
