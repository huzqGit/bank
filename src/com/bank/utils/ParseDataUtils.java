package com.bank.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseDataUtils {
	private static Logger log = LoggerFactory.getLogger(ParseDataUtils.class);
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
	public static final String EMPTY = "";
	public static final String POINT = ".";
	public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
	public static final String PROCESSING = "Processing...";

	public static String[][] getExeclData(String path, int ignoreRows)
			throws FileNotFoundException, IOException {

		if (path == null || EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path, ignoreRows);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path, ignoreRows);
				}
			} else {
				log.info(path + NOT_EXCEL_FILE);
			}
		}

		return null;
	}

	private static String[][] readXls(String path, int ignoreRows) throws IOException {
		InputStream is = null;
		POIFSFileSystem fs = null;
		BufferedInputStream ins = null;
		String[][] retVal = null;
		try {
			is = new FileInputStream(path);
			ins = new BufferedInputStream(is);
			// 打开HSSFWorkbook
			fs = new POIFSFileSystem(ins);
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fs);
			
			HSSFCell cell = null;
			HSSFRow row = null;
			HSSFSheet st = null;
			retVal = common(ignoreRows, cell, row, st, hssfWorkbook);
			
		} finally {
			if (is != null) {
				is.close();
				is = null;
			}
			if (fs != null) {
				fs = null;
			}
			if (ins != null) {
				ins.close();
				ins = null;
			}
		}
		
		return retVal;
	}
	
	private static String[][] readXlsx(String path, int ignoreRows) throws IOException {
		InputStream is = null;
		String[][] retVal = null;
//		POIFSFileSystem fs = null;
//		BufferedInputStream ins = null;
		
		try {
			is = new FileInputStream(path);
			XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
			
			XSSFCell cell = null;
			XSSFRow row = null;
			XSSFSheet st = null;
			retVal = common(ignoreRows, cell, row, st, hssfWorkbook);
			
		} finally {
			if (is != null) {
				is.close();
				is = null;
			}
		}
		
		return retVal;
	}
	
	private static String[][] common (int ignoreRows, Cell cell, Row row, Sheet st, Workbook wb) {
		int rowSize = 0;
		List<String[]> result = new ArrayList<String[]>();
		
		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

			st = wb.getSheetAt(sheetIndex);

			// 第一行为标题，不取

			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {

				row = st.getRow(rowIndex);

				if (row == null) {

					continue;

				}

				int tempRowSize = row.getLastCellNum() + 1;

				if (tempRowSize > rowSize) {

					rowSize = tempRowSize;

				}

				String[] values = new String[rowSize];

				Arrays.fill(values, "");

				boolean hasValue = false;

				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";

					cell = row.getCell(columnIndex);

					if (cell != null) {

						// 注意：一定要设成这个，否则可能会出现乱码

						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);

						switch (cell.getCellType()) {

						case HSSFCell.CELL_TYPE_STRING:

							value = cell.getStringCellValue();

							break;

						case HSSFCell.CELL_TYPE_NUMERIC:

							if (HSSFDateUtil.isCellDateFormatted(cell)) {

								Date date = cell.getDateCellValue();

								if (date != null) {

									value = new SimpleDateFormat("yyyy-MM-dd")

									.format(date);

								} else {

									value = "";

								}

							} else {

								value = new DecimalFormat("0").format(cell

								.getNumericCellValue());

							}

							break;

						case HSSFCell.CELL_TYPE_FORMULA:

							// 导入时如果为公式生成的数据则无值

							if (!cell.getStringCellValue().equals("")) {

								value = cell.getStringCellValue();

							} else {

								value = cell.getNumericCellValue() + "";

							}

							break;

						case HSSFCell.CELL_TYPE_BLANK:

							break;

						case HSSFCell.CELL_TYPE_ERROR:

							value = "";

							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:

							value = (cell.getBooleanCellValue() == true ? "Y"

							: "N");

							break;

						default:

							value = "";

						}

					}

					if (columnIndex == 0 && value.trim().equals("")) {

						break;

					}

					values[columnIndex] = rightTrim(value);

					hasValue = true;

				}

				if (hasValue) {

					result.add(values);

				}

			}

		}

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {

			returnArray[i] = (String[]) result.get(i);

		}
		
		return returnArray;
	}

	public static String[][] getExeclData(File file, int ignoreRows)
			throws FileNotFoundException, IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				file));
		return getExeclData(in, ignoreRows);
	}

	/**
	 * Parse Excel Data
	 */
	public static String[][] getExeclData(InputStream inputStream,
			int ignoreRows) throws FileNotFoundException, IOException {

		List<String[]> result = new ArrayList<String[]>();

		int rowSize = 0;

		BufferedInputStream in = new BufferedInputStream(inputStream);

		// 打开HSSFWorkbook

		POIFSFileSystem fs = new POIFSFileSystem(in);

		HSSFWorkbook wb = new HSSFWorkbook(fs);

		HSSFCell cell = null;

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

			HSSFSheet st = wb.getSheetAt(sheetIndex);

			// 第一行为标题，不取

			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {

				HSSFRow row = st.getRow(rowIndex);

				if (row == null) {

					continue;

				}

				int tempRowSize = row.getLastCellNum() + 1;

				if (tempRowSize > rowSize) {

					rowSize = tempRowSize;

				}

				String[] values = new String[rowSize];

				Arrays.fill(values, "");

				boolean hasValue = false;

				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";

					cell = row.getCell(columnIndex);

					if (cell != null) {

						// 注意：一定要设成这个，否则可能会出现乱码

						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);

						switch (cell.getCellType()) {

						case HSSFCell.CELL_TYPE_STRING:

							value = cell.getStringCellValue();

							break;

						case HSSFCell.CELL_TYPE_NUMERIC:

							if (HSSFDateUtil.isCellDateFormatted(cell)) {

								Date date = cell.getDateCellValue();

								if (date != null) {

									value = new SimpleDateFormat("yyyy-MM-dd")

									.format(date);

								} else {

									value = "";

								}

							} else {

								value = new DecimalFormat("0").format(cell

								.getNumericCellValue());

							}

							break;

						case HSSFCell.CELL_TYPE_FORMULA:

							// 导入时如果为公式生成的数据则无值

							if (!cell.getStringCellValue().equals("")) {

								value = cell.getStringCellValue();

							} else {

								value = cell.getNumericCellValue() + "";

							}

							break;

						case HSSFCell.CELL_TYPE_BLANK:

							break;

						case HSSFCell.CELL_TYPE_ERROR:

							value = "";

							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:

							value = (cell.getBooleanCellValue() == true ? "Y"

							: "N");

							break;

						default:

							value = "";

						}

					}

					if (columnIndex == 0 && value.trim().equals("")) {

						break;

					}

					values[columnIndex] = rightTrim(value);

					hasValue = true;

				}

				if (hasValue) {

					result.add(values);

				}

			}

		}

		in.close();

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {

			returnArray[i] = (String[]) result.get(i);

		}

		return returnArray;

	}

	public static List<String[]> getTxtData(File file, String split)
			throws Exception {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		List<String[]> txtDatas = new ArrayList();
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String line = "";
			String[] arrs = null;
			while ((line = br.readLine()) != null) {
				arrs = line.replaceAll("\\t", ",").split(",");
				txtDatas.add(arrs);
				System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]);
			}
		} finally {
			if (br != null) {
				br.close();
				br = null;
			}
			if (isr != null) {
				isr.close();
				isr = null;
			}
			if (fis != null) {
				fis.close();
				fis = null;
			}
		}

		return txtDatas;
	}

	/**
	 * 去掉字符串右边的空格
	 * 
	 * @param str
	 *            要处理的字符串
	 * @return 处理后的字符串
	 */
	public static String rightTrim(String str) {

		if (str == null) {

			return "";

		}

		int length = str.length();

		for (int i = length - 1; i >= 0; i--) {

			if (str.charAt(i) != 0x20) {

				break;

			}

			length--;

		}

		return str.substring(0, length);

	}
	
	public static String getPostfix(String path) {
		if (path == null || EMPTY.equals(path.trim())) {
			return EMPTY;
		}
		if (path.contains(POINT)) {
			return path.substring(path.lastIndexOf(POINT) + 1,
					path.length());
		}
		return EMPTY;
	}

}
