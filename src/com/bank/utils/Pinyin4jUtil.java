package com.bank.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import net.sourceforge.pinyin4j.PinyinHelper;  
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;  
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;  
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;  
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;  
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;  

public class Pinyin4jUtil {  
    
	/** 
     * 将汉字转换为全拼 
     * @param src 
     * @return String 
     */  
    public static String getPinYin(String src) {  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        // 设置汉字拼音输出的格式  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断能否为汉字字符  
                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中  
                    if(t2==null){
                    	t4 += String.valueOf(t1[i]);
                    }else{
                    	t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后 
                    }
                } else {  
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后  
                    t4 += Character.toString(t1[i]);  
                }  
            }  
        } catch (BadHanyuPinyinOutputFormatCombination e) {  
            e.printStackTrace();  
        }  
        return t4;  
    }  
  
    /** 
     * 提取每个汉字的首字母 
     * @param str 
     * @return String 
     */  
    public static String getPinYinHeadChar(String str) {  
        String convert = "";  
        for (int j = 0; j < str.length(); j++) {  
            char word = str.charAt(j);  
            // 提取汉字的首字母  
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
            if (pinyinArray != null) {  
                convert += pinyinArray[0].charAt(0);  
            } else {  
                convert += word;  
            }  
        }  
        return convert;  
    }  
  
    /** 
     * 将字符串转换成ASCII码 
     * @param cnStr 
     * @return String 
     */  
    public static String getCnASCII(String cnStr) {  
        StringBuffer strBuf = new StringBuffer();  
        byte[] bGBK = cnStr.getBytes();  
        for (int i = 0; i < bGBK.length; i++) {  
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));  
        }  
        return strBuf.toString();  
    }  
  
    /**
     * 给一个字符串，比如ABC， 把所有的组合，即：A, B, C, AB, AC, BC, ABC, 都找出来。   
     * 假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。针对第一个字符，我们有两种选择：
     * 一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；二是不把这个字符放到组合中去，接下
     * 来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现。      	
     * @param chs
     */
    public static void combiantion(char chs[]){  
        if(chs.length == 0) return ;  
        Stack<Character> stack = new Stack<Character>();  
        for(int i = 1; i <= chs.length; i++){  
            combine(chs, 0, i, stack);  
        }  
    }  
    
    /**
     * 从字符数组中第begin个字符开始挑选number个字符加入list中  
     * @author zkongbai
     * @version 1.0
     * @param chs
     * @param begin
     * @param number
     * @param stack
     */
    public static void combine(char []chs, int begin, int number, Stack<Character> stack){  
           if(number == 0){  
            System.out.println(stack.toString());  
            return ;  
           }  
           if(begin == chs.length){  
            return;  
           }  
           stack.push(chs[begin]);  
           combine(chs, begin + 1, number - 1, stack);  
           stack.pop();  
           combine(chs, begin + 1, number, stack);  
    } 
    
    /**
     * 获取分隔的拼音(用于lucene分词)
     * @param str
     * @return
     */
    public static String getSplitPinyin(String str){
    	String pinyin = getPinYin(str);
    	Set<String> set = new HashSet<String>();
    	getPinyinResult(pinyin, set);
    	if(str.length()>=2){
    		getPinyinResult(getPinYinHeadChar(str), set);
    	}
    	StringBuilder sb = new StringBuilder();
    	for (String s : set) {
			sb.append(s+" ");
		}
    	return sb.toString().trim();
    }
    public static void getPinyinResult(String pinyin,Set<String> set){
    	char[] c = pinyin.toCharArray();
    	for(int i=0;i<c.length;i++){
    		String temp = "";
    		for (int j = 0; j <=i; j++) {
    			temp+=c[j];
			}
    		set.add(temp);
    	}
    }
    public static void main(String[] args) {  
        String cnStr = "中国人小名";
        System.out.println(getPinYin(cnStr));  
        System.out.println(getPinYinHeadChar(cnStr));  
        System.out.println(getCnASCII(cnStr));  
        String str = "软件园";
        //combiantion(str.toCharArray()); 
        System.out.println(getSplitPinyin(str));
    }  
}  