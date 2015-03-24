package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.beans.CompanyCapital;
import com.common.service.GenericService;

public interface ICompanyCapitalService extends GenericService<CompanyCapital,Long>{
	public Long saveCapital(CompanyCapital entity) ;
	public CompanyCapital getCompanyCapitalById(String capitalId);
	public List<CompanyCapital> loadAllCompanyCapital(Map<String,String> query,
			int pageIndex, int pageSize,String sortField, String sortOrder);
}
