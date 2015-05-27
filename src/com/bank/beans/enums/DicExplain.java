package com.bank.beans.enums;

public class DicExplain {
	
	public static final int $IDTYPE = 1;//证件类型
	public static final int $SEX = 2;
	public static final int $EDUCATION =3;
	public static final int $MARRYSTATUS = 4;
	public static final int $CLIENTTYPE = 5;
	public static final int $CURRENCY = 6;//币种
	
	public static String explain(int name,String value){	
		if(DicExplain.$SEX == name){
			if(value != null && value.contains("男")){
				return "1";
			}else if(value != null && value.contains("女")){
				return "2";
			}else{
				return "9";
			}
		}else if (DicExplain.$EDUCATION == name){
			if(value != null && value.contains("研究生" )){
				return "1";
			}else if(value != null && value.contains("本科")){
				return "2";
			}else if(value != null && value.contains("高中")){
				return "5";
			}else if(value != null && value.contains("初中")){
				return "6";
			}else if(value != null && value.contains("小学")){
				return "7";
			}else{
				return "9";
			}
		}else if(DicExplain.$MARRYSTATUS == name){
			if("已婚".equals(value)){
				return "1";
			}else if("离异".equals(value)){
				return "2";
			}else if("未婚".equals(value)){
				return "3";
			}else{
				return "9";
			}
		}else if(DicExplain.$CLIENTTYPE == name){
			//【1】表示农户【2】表示企业【3】表示经济合作组织 【9】未知
			if("农户".equals(value)){
				return "1";
			}else if("个体工商户".equals(value)){
				return "1";
			}else if("其它自然人客户".equals(value)){
				return "1";
			}else if("企业".equals(value)){
				return "2";
			}else if("其它经济组织（含农村经济组织）".equals(value)){
				return "3";
			}else{
				return "9";
			}
		}else if(DicExplain.$IDTYPE== name){
			if("公民身份证".equals(value)){
				return "0";
			}else if("营业执照".equals(value)){
				return "9";
			}else{
				return "X";
			}
		}else if(DicExplain.$CURRENCY == name ){
				if("人民币".equals(value)){
					return "01";
				}else{
					return "-99";
				}
		}else {
				return "-99";
		}
	 }
}
