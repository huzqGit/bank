package com.bank.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String format(Date date,String format){
		if(date !=null){
			SimpleDateFormat aformat = new SimpleDateFormat(format);
			return aformat.format(date);
		}else{
			return "";
		}
	}
}
