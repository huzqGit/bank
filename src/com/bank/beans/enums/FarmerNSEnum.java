package com.bank.beans.enums;

public enum FarmerNSEnum {
	FARMERNAME(3),
	IDTYPE(4),
	IDNUM(5),
	SEX(6),
	FARMERTYPE(7),
	MARRYSTATUS(8),
	EDUCATION(9),
	OCCUPATION(10),
	PHONE(14),
	ADDRESS(19);
	private int index;
	public static final int $SEX = 1;
	public static final int $EDUCATION = 2;
	public static final int $MARRYSTATUS = 3;
	FarmerNSEnum(int index){
		this.index = index;
	}
	public int getIndex(){
		return this.index;
	};
	public static int explain(int name,String value){
		if(FarmerNSEnum.$SEX == name){
			if("男".equals(value)){
				return 1;
			}else if("女".equals(value)){
				return 2;
			}else{
				return 9;
			}
		}else if (FarmerNSEnum.$EDUCATION == name){
			if("本科".equals(value)){
				return 2;
			}else{
				return 9;
			}
		}else if(FarmerNSEnum.$MARRYSTATUS == name){
			if("已婚".equals(value)){
				return 1;
			}else if("未婚".equals(value)){
				return 3;
			}else{
				return 9;
			}
		}else{
			return -99;
		}
	}
}
