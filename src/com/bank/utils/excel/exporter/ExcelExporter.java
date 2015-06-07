package com.bank.utils.excel.exporter;

import java.util.List;
import java.util.Map;

public abstract class ExcelExporter<T> {
	String[] labels;
	List<?> exportList;
	boolean isExportErrorList;
	String templateFileUrl;
	
	public ExcelExporter(){
		
	}

	public ExcelExporter(String[] labels, List<T> normalList, String templateFileUrl) {
		this.labels = labels;
		isExportErrorList = false;
		exportList = normalList;
		this.templateFileUrl = templateFileUrl;
	}

	public ExcelExporter(String[] labels, List<Map<String, String>> errorList, String templateFileUrl, int zeroFit) {
		this.labels = labels;
		isExportErrorList = true;
		exportList = errorList;
		this.templateFileUrl = templateFileUrl;
	}

	public final String[] getLabels() {
		return labels;
	}

	public int size() {
		return exportList.size();
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> convert(int pos) {
		return isExportErrorList ? (Map<String, String>) exportList.get(pos) : convert((T) exportList.get(pos));
	}

	protected abstract Map<String, String> convert(T t);

	protected final void put(Map<String, String> map, int indexOfLabels, String value) {
		map.put(labels[indexOfLabels], value);
	}

	public final String getTemplateUrl() {
		return templateFileUrl;
	}

}
