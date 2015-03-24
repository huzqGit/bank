package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.beans.CompanyCapital;
import com.common.dao.GenericDAO;

public interface ICompanyCapitalDao extends GenericDAO<CompanyCapital, Long>{
	
	public Long saveCapital(CompanyCapital entity);
	public CompanyCapital getCompanyCapitalById(Long capitalId);
	public List<CompanyCapital> loadAllCompanys(Map<String,String> query, 
			int pageIndex, int pageSize,String sortField, String sortOrder);
}
