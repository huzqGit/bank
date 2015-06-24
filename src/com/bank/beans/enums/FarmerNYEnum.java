package com.bank.beans.enums;

public enum FarmerNYEnum {
	FARMERNAME(1),
	IDTYPE(9),
	IDNUM(11),
	SEX(18),
	FARMERTYPE(7),
	MARRYSTATUS(20),
	EDUCATION(21),
	ADDRESS(25),
	POSTCODE(26);
	private int index;
	public static final int $SEX = 1;
	public static final int $EDUCATION = 2;
	public static final int $MARRYSTATUS = 3;
	FarmerNYEnum(int index){
		this.index = index;
	}
	public int getIndex(){
		return this.index;
	};
	public static int explain(int name,String value){
		if(FarmerNYEnum.$SEX == name){
			if("男".equals(value)){
				return 1;
			}else if("女".equals(value)){
				return 2;
			}else{
				return 9;
			}
		}else if (FarmerNYEnum.$EDUCATION == name){
			if("本科".equals(value)){
				return 2;
			}else{
				return 9;
			}
		}else if(FarmerNYEnum.$MARRYSTATUS == name){
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
