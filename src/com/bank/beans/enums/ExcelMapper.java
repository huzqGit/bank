package com.bank.beans.enums;

public class ExcelMapper {
	
	private volatile static ExcelMapper instance = null;

	  public static ExcelMapper getInstance() {
	    if (instance == null) {
	      synchronized (ExcelMapper.class) {
	        if(instance == null) {
	          instance = new ExcelMapper();
	        }
	      }
	    }
	    return instance;
	  }

	  private ExcelMapper() {

	  } 
	  
	  public  int parseCode(String code){
		int num =0;
		char[] codes = code.toUpperCase().toCharArray();
		for(int i=0;i<codes.length;i++){
			char c = codes[i];
			int n = getNum(c);
			num= num+(codes.length-1-i)*26*n;
			if(i==codes.length-1){
				num=num+n;
			}
			
		}
		return num-1;
	  }
	  private  int getNum(char c){
		switch(c){
			case 'A':return 1;
			case 'B' : return 2;
			case 'C' : return 3;
			case 'D' : return 4;
			case 'E' : return 5;
			case 'F' : return 6;
			case 'G' : return 7;
			case 'H' : return 8;
			case 'I' : return 9;
			case 'J' : return 10;
			case 'K' : return 11;
			case 'L' : return 12;
			case 'M' : return 13;
			case 'N' : return 14;
			case 'O' : return 15;
			case 'P' : return 16;
			case 'Q' : return 17;
			case 'R' : return 18;
			case 'S' : return 19;
			case 'T' : return 20;
			case 'U' : return 21;
			case 'V' : return 22;
			case 'W' : return 23;
			case 'X' : return 24;
			case 'Y' : return 25;
			case 'Z' : return 26;
			default  : return 0;
		}
		
	}
}
