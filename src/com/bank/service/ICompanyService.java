<<<<<<< HEAD
package com.bank.service;

import java.util.List;


import java.util.Map;

import com.bank.beans.Company;

public interface ICompanyService {
	
	public Integer saveCompany(Company company);
	
	public Company getCompanyId(String companyId);
	
	public List<Company> loadAllCompanys(Map<String,String> query, int pageIndex, int pageSize,String sortField, String sortOrder);

}
=======
package com.bank.service;

import java.util.List;


import java.util.Map;

import com.bank.beans.Company;

public interface ICompanyService {
	
	public Integer saveCompany(Company company);
	
	public Company getCompanyId(String companyId);
	
	public List<Company> loadAllCompanys(Map<String,String> query, int pageIndex, int pageSize,String sortField, String sortOrder);

}
>>>>>>> origin/master
