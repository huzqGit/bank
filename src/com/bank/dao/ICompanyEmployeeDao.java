package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.CompanyEmployee;
import com.common.dao.GenericDAO;

public interface ICompanyEmployeeDao extends GenericDAO<CompanyEmployee, Long> {
	
	public Integer saveCompanyEmployee(CompanyEmployee entity);
	public List<CompanyEmployee> loadCompanyEmployees(Map<String,String> query, int pageIndex, 
			int pageSize,String sortField, String sortOrder);
	public CompanyEmployee getCompanyEmployeeById(Long employeeId);
}
