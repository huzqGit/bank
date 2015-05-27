package com.bank.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {
	
	public static String getParameter(HttpServletRequest request,String args){
		String result = request.getParameter(args);
		if(result==null || "".equals(result) || "null".equals(result))
			return null;
		return result;
	}
}
