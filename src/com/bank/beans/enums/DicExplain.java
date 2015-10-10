package com.bank.beans.enums;

public class DicExplain {
	
	public static final int $IDTYPE = 1;//证件类型
	public static final int $SEX = 2;
	public static final int $EDUCATION =3;
	public static final int $MARRYSTATUS = 4;
	public static final int $CLIENTTYPE = 5;
	public static final int $CURRENCY = 6;//币种
	public static final int $RELATION=7;
	public static final int $VILLAGE=8;
	public static final int $GUARANTEETYPE = 9;
	public static final int $GRADE=10;
	public static final int $COMPUNISHTYPE= 11;
	public static final int $BREEDTYPE = 12;
	public static final String ERRORCODE = "-9999";
	
	public static String explain(int name,String value){	
		if(DicExplain.$SEX == name){
			if(value == null){
				return "";
			}
			if(value.contains("男")){
				return "1";
			}else if(value.contains("女")){
				return "2";
			}else{
				return "-9999";
			}
		}else if (DicExplain.$EDUCATION == name){
			if(value == null){
				return "";
			}else if(value.contains("研究生" )){
				return "1";
			}else if(value.contains("本科") || value.contains("大学")){
				return "2";
			}else if(value.contains("专科")|| value.contains("技工")){
				return "3";
			}else if(value.contains("中专")||value.contains("中技")){
				return "4";
			}else if(value.contains("高中")){
				return "5";
			}else if(value.contains("初中")){
				return "6";
			}else if(value.contains("小学")){
				return "7";
			}else{
				return "9";
			}
		}else if(DicExplain.$MARRYSTATUS == name){
			if(value == null){
				return "";
			}if(value.contains("已婚")){
				return "1";
			}else if(value.contains("离异") || value.contains("离婚")){
				return "2";
			}else if(value.contains("未婚")){
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
				return ERRORCODE;
			}
		}else if(DicExplain.$IDTYPE== name){
			if("公民身份证".equals(value)){
				return "0";
			}else if("居民身份证".equals(value)){
				return "0";
			}else if("临时居民身份证".equals(value)){
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
					return ERRORCODE;
				}
		}else if(DicExplain.$VILLAGE == name){
				if(value == null || value.trim().equals("")){
					return "";
				}else if(value.contains("金")){
					return "金川镇";
				}else if(value.contains("大洋洲")){
					return "大洋洲镇";
				}else if(value.contains("三湖")){
					return "三湖镇";
				}else if(value.contains("七琴")){
					return "七琴镇";
				}else if(value.contains("麦斜")){
					return "麦斜镇";
				}else if(value.contains("溧江")){
					return "溧江乡";
				}else if(value.contains("桃溪")){
					return "桃溪乡";
				}else if(value.contains("城上")){
					return "城上乡";
				}else if(value.contains("潭丘")){
					return "潭丘乡";
				}else if(value.contains("神政桥")){
					return "神政桥乡";
				}else if(value.contains("沂江")){
					return "沂江乡";
				}else if(value.contains("界埠")){
					return "界埠乡";
				}else if(value.contains("荷浦")){
					return "荷浦乡";
				}else{
					return "";
				}
		}else if(DicExplain.$GUARANTEETYPE == name){
			if(value.contains("分保")|| value.contains("联保") ||value.contains("担保") ||value.contains("保证")){
				return "2";
			}else if(value.contains("信用")){
				return "1";
			}else if(value.contains("抵押")){
				return "3";
			}else if(value.contains("质押")){
				return "4";
			}else if(value.contains("留置定金")){
				return "5";
			}else{
				return "9";
			}
		}else if(DicExplain.$GRADE == name){
			if(value == null){
				return "";
			}else if(value.equals("正常")){
				return "1";
			}else if(value.contains("关注")){
				return "2";
			}else if(value.contains("次级")){
				return "3";
			}else if(value.contains("可疑")){
				return "4";
			}else if(value.contains("损失")){
				return "5";
			}else{
				return ERRORCODE;
			}
		}else if(DicExplain.$COMPUNISHTYPE == name){
			if(value == null){
				return "";
			}else if(value.contains("表彰")){
				return "1";
			}else if(value.contains("处罚")){
				return "2";
			}else {
				return "";
			}
		}else if(DicExplain.$BREEDTYPE == name){
			if(value == null){
				return "";
			}else if(value.equals("粮食作物")){
				return "1";
			}else if(value.equals("蔬菜作物")){
				return "2";
			}else if(value.equals("经济作物")){
				return "3";
			}else if(value.equals("其他种植业")){
				return "9 ";
			}else if(value.equals("畜牧类")){
				return "101";
			}else if(value.equals("禽类")){
				return "102";
			}else if(value.equals("水产类")){
				return "103";
			}else if(value.equals("昆虫类")){
				return "104";
			}else if(value.equals("其他养殖业")){
				return "109";
			}else{
				return "";
			}
		}else{
			return  ERRORCODE;
		}
	 }
}
