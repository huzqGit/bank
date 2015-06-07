package com.bank.utils.excel.importer;

import java.util.List;
import java.util.Map;

import com.bank.utils.excel.ImportResult;

public abstract class ExcelImporter<T> {
	
	public ExcelImporter(){
	}

	String[] labels;

	public ExcelImporter(String[] labels) {
		this.labels = labels;
	}

	public final String[] getLabels() {
		return labels;
	}

	protected abstract T convert(Map<String, String> map) throws Exception;

	/**
	 * 保存并返回错误列表
	 * 
	 * @return
	 */
	public abstract ImportResult save(List<Map<String,String>> saveList);

}
