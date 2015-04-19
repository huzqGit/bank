package com.bank.utils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		
//		File file = new File("F:\\demo.txt");
//		
//		ParseDataUtils.getTxtData(file, " ");
		
		File file = new File("F:\\个人客户信息0415.xls");

	       String[][] result = ParseDataUtils.getExeclData(file, 2);

	       int rowLength = result.length;

	       for(int i=0;i<rowLength;i++) {

	           for(int j=0;j<result[i].length;j++) {

	              System.out.print(result[i][j]+"\t\t");

	           }

	           System.out.println();

	       }
	}
	
	

}
