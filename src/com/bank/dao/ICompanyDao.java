package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.Company;
import com.common.dao.GenericDAO;

public interface ICompanyDao extends GenericDAO<Company, String>{
	
	public List<Company> loadCompanys(Map<String,String> query, int pageIndex, 
			int pageSize,String sortField, String sortOrder);
	
	public Company load(String companyId);

	public String insert(Company company);

	public void update(Company company);

	void delete(String companyId);

	
}
