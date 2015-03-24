package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CompanyCapital;
import com.bank.dao.ICompanyCapitalDao;
import com.bank.service.ICompanyCapitalService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;
@Service("companyCapitalService")
public class CompanyCapitalServiceImpl extends GenericServiceImpl<CompanyCapital,Long>
	implements ICompanyCapitalService {

	@Resource
	private ICompanyCapitalDao companyCapitalDao;

	@Override
	public GenericDAO<CompanyCapital, Long> getGenericDAO() {
	
		return companyCapitalDao;
	}

	@Override
	public Long saveCapital(CompanyCapital entity) {
	
		return companyCapitalDao.saveCapital(entity);
	}
	
	@Override
	public CompanyCapital getCompanyCapitalById(String capitalId) {
		CompanyCapital capital;
		if(capitalId!=null && !capitalId.equals("")){
			Long companyCapitalId=Long.valueOf(capitalId);
			capital=companyCapitalDao.getCompanyCapitalById(companyCapitalId);
		}else{
			capital=new CompanyCapital();
		}
		return capital;
	}

	@Override
	public List<CompanyCapital> loadAllCompanyCapital(
			Map<String, String> query, int pageIndex, int pageSize,
			String sortField, String sortOrder) {
		
		List<CompanyCapital> capitals=companyCapitalDao.loadAllCompanys(query, 
				pageIndex, pageSize, sortField, sortOrder);
		return capitals;
	}
	
	
}
