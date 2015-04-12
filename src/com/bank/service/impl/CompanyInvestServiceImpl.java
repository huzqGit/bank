package com.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CompanyInvest;
import com.bank.dao.ICompanyInvestDao;
import com.bank.service.ICompanyInvestService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("companyInvestService")
public class CompanyInvestServiceImpl extends GenericServiceImpl<CompanyInvest, Long> 
	implements ICompanyInvestService{
	
	@Resource
	private ICompanyInvestDao comapnyInvestDao;

	@Override
	public GenericDAO<CompanyInvest, Long> getGenericDAO() {
		
		return this.comapnyInvestDao;
	}

}
