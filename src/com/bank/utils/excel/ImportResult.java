package com.bank.utils.excel;

import java.util.List;
import java.util.Map;

public class ImportResult {

	String message;
	boolean isError;
	List<Map<String, String>> list;

	public ImportResult(String message, List<Map<String, String>> list) {
		this.list = list;
		this.message = message;
		this.isError = false;
	}

	public ImportResult(String errorMessage) {
		this.isError = true;
		this.message = errorMessage;
	}

	public boolean isError() {
		return isError;
	}

	public String getMessage() {
		return message;
	}

	public List<Map<String, String>> getResult() {
		return list;
	}
}
