package com.bank.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Dictionary {
	
	private static Map<String,Properties> dic = new HashMap<String,Properties>();
	private static Properties sex = new Properties();
	private static Properties relation = new Properties();
	private static Properties education = new Properties();
	private static Properties marrystatus = new Properties();
	private static Properties politicstatus = new Properties();
	private static Properties housetype = new Properties();
	private static Properties houseproperties = new Properties();
	private static Properties yesorno = new Properties();
	private static Properties evaluate = new Properties();
	private static Properties insure = new Properties();
	
	
	static{
		sex.put("1", "男性");
		sex.put("2", "女性");
		sex.put("9", "未知性别");
		
		relation.put("1", "配偶");
		relation.put("2", "父子");
		relation.put("3", "父女");
		relation.put("4", "母子");
		relation.put("5", "母女");
		
		education.put("1", "研究生");
		education.put("2", "大学本科");
		education.put("3", "大学专科和专科学校");
		education.put("4", "中等专业学校或中等技术学校");
		education.put("5", "高中");
		education.put("6", "初中");
		education.put("7", "小学");
		education.put("9", "其他");
		
		marrystatus.put("1","已婚");
		marrystatus.put("2","离异/丧偶无子女");
		marrystatus.put("3","离异/丧偶有子女");
		marrystatus.put("4","未婚");
		marrystatus.put("9","未知");
		
		politicstatus.put("1", "中共党员");
		politicstatus.put("2", "民主党派");
		politicstatus.put("3", "其他");
		
		housetype.put("1", "钢混结构");
		housetype.put("2", "砖混结构");
		housetype.put("3", "砖木结构");
		housetype.put("4", "茅土结构");
		housetype.put("9", "其他");
		
		yesorno.put("0", "否");
		yesorno.put("1", "是");
		
		evaluate.put("1", "好");
		evaluate.put("2", "较好");
		evaluate.put("3", "一般");
		evaluate.put("4", "差");
		evaluate.put("5", "很差");
		evaluate.put("9", "其他");
		
		insure.put("1", "人寿");
		insure.put("2", "财产");
		insure.put("3", "医疗");
		insure.put("4", "农业保险");
		insure.put("5", "社会保险险种");
		insure.put("9", "其他");
		houseproperties.put("1", "房屋");
		houseproperties.put("2", "商品房");
		houseproperties.put("3", "房改房");
		houseproperties.put("4", "存量房");
		houseproperties.put("5", "集资房");
		houseproperties.put("6", "微利房");
		houseproperties.put("7", "平价房");
		houseproperties.put("8", "解困房");
		houseproperties.put("9", "再上市房");
		houseproperties.put("10", "廉租住房");
		houseproperties.put("11", "花园式住房");
		houseproperties.put("12", "经济适用住房");
		houseproperties.put("13",  "公寓式住房");

		dic.put("sex",sex);
		dic.put("relation", relation);
		dic.put("education", education);
		dic.put("marrystatus", marrystatus);
		dic.put("politicstatus",politicstatus);
		dic.put("housetype",housetype);
		dic.put("yesorno",yesorno);
		dic.put("evaluate", evaluate);
		dic.put("insure", insure);
		dic.put("houseproperties",houseproperties);
	}
	public static String translate(String name,String value){
		Properties prop = dic.get(name);
		if(value == null){
			return "";
		}else if(prop == null){
			return "";
		}else{
			return prop.getProperty(value);
		}
	}
}
