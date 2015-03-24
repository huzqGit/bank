package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.CompanyEmployee;
import com.common.service.GenericService;

public interface ICompanyEmployeeService extends
		GenericService<CompanyEmployee, Long> {
	
	public Integer saveCompanyEmployee(CompanyEmployee employee);
	public CompanyEmployee getEmployeeById(String employeeId);
	public List<CompanyEmployee> loadAllCompanyEmployees(Map<String,String> query, 
			int pageIndex, int pageSize,String sortField, String sortOrder);
}
