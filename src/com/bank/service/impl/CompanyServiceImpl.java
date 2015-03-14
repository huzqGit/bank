package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Company;
import com.bank.dao.ICompanyDao;
import com.bank.service.ICompanyService;

@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {
	
	@Resource
	private ICompanyDao companyDao;
	
	@Override
	public Integer saveCompany(Company company) {
		if(company.getCompanyId()==null){
			companyDao.insert(company);
		}else{
			companyDao.update(company);
		}
		return company.getCompanyId();
	}
	
	@Override
	public Company getCompanyId(String companyId) {
		
		Company company=companyDao.load(companyId);
		return company;
	}

	@Override
	public List<Company> loadAllCompanys(Map<String,String> query, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		
		List<Company> companys=companyDao.loadCompanys(query, pageIndex, pageSize, sortField, sortOrder);
		return companys;
	}

	
}
