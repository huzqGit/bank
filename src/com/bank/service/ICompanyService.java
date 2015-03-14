package com.bank.service;

import java.util.List;


import java.util.Map;

import com.bank.beans.Company;
import com.bank.beans.Menu;
import com.common.service.GenericService;

public interface ICompanyService extends GenericService<Menu, Long> {
	
	public Integer saveCompany(Company company);
	
	public Company getCompanyId(String companyId);
	
	public List<Company> loadAllCompanys(Map<String,String> query, int pageIndex, int pageSize,String sortField, String sortOrder);

}
