package com.bank.utils;

import java.io.UnsupportedEncodingException;

/**
 * 
 */
public class Base64Utils {

	/**
	 * 加密【 传参String 】
	 * @author zkongbai
	 * @date 2015年5月6日  下午4:54:10
	 * @version 1.0
	 * @param s
	 * @return
	 */
	public synchronized static String encode(String s) {
		if (s == null)
			return null;
		return encodeByByte(s.getBytes());
	}
	
	public synchronized static String encodeByCharSet(String s,String charSet) {
		if (s == null)
			return null;
		byte[] b = new byte[0];
		try {
			b = s.getBytes(charSet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
//		System.out.println(s+"\t"+encodeByByte(b));
		return encodeByByte(b);
	}

	/**
	 * 加密【 传参byte[] 】
	 * @author zkongbai
	 * @date 2015年5月6日  下午5:16:00
	 * @version 1.0
	 * @param s
	 * @return
	 */
	public synchronized static String encodeByByte(byte[] s) {
		if (s == null)
			return null;
		return new sun.misc.BASE64Encoder().encode(s);
	}

	/**
	 * 解密【 传参String 】
	 * @author zkongbai
	 * @date 2015年5月6日  下午5:26:09
	 * @version 1.0
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public synchronized static byte[] decodeToByte(String s) throws java.io.IOException {
		if (s == null)
			return null;
		return new sun.misc.BASE64Decoder().decodeBuffer(s);
	}
	
	/**
	 * 解密【 传参String 】
	 * @author zkongbai
	 * @date 2015年5月6日  下午4:55:39
	 * @version 1.0
	 * @param s
	 * @return
	 */
	public synchronized static String decode(String s){
		if (s == null)
			return null;
		try {
			return new String(decodeToByte(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(encodeByCharSet("cooperation/debtInfo/debtInfoView","utf-8"));
		System.out.println(decode("56aP5bu65aSn5Yy6"));
	}
}
