package com.bank.utils.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bank.utils.excel.exporter.ExcelExporter;
import com.bank.utils.excel.importer.ExcelImporter;

public class ExcelExplorer {

	public static ImportResult importExcel(ExcelImporter<?> importer, InputStream in) throws IOException{
		Sheet sheet = null;
		try {
//			sheet = new HSSFWorkbook(in).getSheetAt(0);
			sheet = WorkbookFactory.create(in).getSheetAt(0);
		} catch (Exception e) {
				e.printStackTrace();
				throw new IOException("解析文件错误,请确认上传的excel格式是否正确");
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		List<String> labels = new ArrayList<String>();

		Row row;
		Cell cell;

		boolean isLabelsInit = false;

		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			if (row == null || row.getZeroHeight()) { // 隐藏行
				continue;
			}

			if (!isLabelsInit) {
				for (int j = 0;; j++) {
					cell = row.getCell(j);
					if (cell == null || cell.getStringCellValue() == null || "".equals(cell.getStringCellValue())) {
						break;
					}
					labels.add(cell.getStringCellValue().trim());
				}
				isLabelsInit = true;
				continue;
			}

			map = new HashMap<String, String>(labels.size() + 1);
			boolean isToAdd = false;
			for (int j = 0; j < row.getLastCellNum() && j < labels.size(); j++) {
				cell = row.getCell(j);
				String value = "";
				if (cell != null) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					value = cell.getStringCellValue().trim();
				}
				if (!"".equals(value)) {
					isToAdd = true;
				}
				map.put(labels.get(j), value);
			}
			if (isToAdd) {
				list.add(map);
			}
		}
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return importer.save(list);
	}

	public static void exportExcel(ExcelExporter<?> exporter, OutputStream out) throws FileNotFoundException, IOException {
		Workbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(exporter.getTemplateUrl()));
		} catch (Exception e) {
			try {
				workbook = new XSSFWorkbook(new FileInputStream(exporter.getTemplateUrl()));
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new IOException("解析文件错误,请确认上传的excel格式是否正确");
			}
			
		}
		String[] labels = exporter.getLabels();

		Sheet sheet = workbook.getSheetAt(0);
		int firstIndex = 0;
		for (;; firstIndex++) {
			Row row = sheet.getRow(firstIndex);
			if (row != null && row.getZeroHeight()) { // 隐藏行
				continue;
			}
			break;
		}
		firstIndex++;
		
		for (int i = 0, size = exporter.size(); i < size; i++) {
			Map<String, String> map = exporter.convert(i);
			Row row = sheet.createRow(i + firstIndex);
			for (int j = 0; j < labels.length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(map.get(labels[j]));
			}
		}
		workbook.write(out);
	}
	
	public static void exportExcelWithFirstLine(ExcelExporter<?> exporter, OutputStream out) throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(exporter.getTemplateUrl()));
		String[] labels = exporter.getLabels();

		HSSFSheet sheet = workbook.getSheetAt(0);
		int firstIndex = 0;
		for (;; firstIndex++) {
			HSSFRow row = sheet.getRow(firstIndex);
			if (row != null && row.getZeroHeight()) { // 隐藏行
				continue;
			}
			break;
		}
		
		//为首先设置行色
		HSSFRow row1 = sheet.createRow(firstIndex);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.LIME.index);
		
		HSSFFont font = workbook.createFont();  
		font.setFontName("黑体");  
		font.setFontHeightInPoints((short) 12);//设置字体大小  
		style.setFont(font);//选择需要用到的字体格式  
		
		for (int i = 0; i < labels.length; i++) {
			HSSFCell cell = row1.createCell(i);
			cell.setCellStyle(style); // cell 是 HSSFCell 对象
			cell.setCellValue(labels[i]);
		}
		firstIndex++;
		
		for (int i = 0, size = exporter.size(); i < size; i++) {
			Map<String, String> map = exporter.convert(i);
			HSSFRow row = sheet.createRow(i + firstIndex);
			for (int j = 0; j < labels.length; j++) {
				HSSFCell cell = row.createCell(j);
				cell.setCellValue(map.get(labels[j]));
			}
		}
		workbook.write(out);
	}
}
