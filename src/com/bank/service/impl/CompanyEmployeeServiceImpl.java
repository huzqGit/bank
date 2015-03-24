package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.CompanyEmployee;
import com.bank.dao.ICompanyEmployeeDao;
import com.bank.service.ICompanyEmployeeService;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("companyEmployeeService")
public class CompanyEmployeeServiceImpl extends
		GenericServiceImpl<CompanyEmployee, Long> implements
		ICompanyEmployeeService {
	
	@Resource
	private ICompanyEmployeeDao companyEmployeeDao;
	
	@Override
	public Integer saveCompanyEmployee(CompanyEmployee employee) {
		
		Integer employeeId;
		employeeId= companyEmployeeDao.saveCompanyEmployee(employee);
		return employeeId;
		
	}
	
	@Override
	public CompanyEmployee getEmployeeById(String employeeId) {
		CompanyEmployee companyEmployee;
		if(employeeId!= null && !employeeId.equals("")){
			Long companyEmployeeId=Long.valueOf(employeeId);
			companyEmployee= companyEmployeeDao.getCompanyEmployeeById(companyEmployeeId);
		}else{
			companyEmployee=new CompanyEmployee();
		}
		return companyEmployee;
	}


	@Override
	public List<CompanyEmployee> loadAllCompanyEmployees(Map<String, String> query,
			int pageIndex, int pageSize, String sortField, String sortOrder) {
		List<CompanyEmployee> companyEmployee=companyEmployeeDao.loadCompanyEmployees(query, pageIndex, pageSize, sortField, sortOrder);
		return companyEmployee;
	}

	@Override
	public GenericDAO<CompanyEmployee, Long> getGenericDAO() {
		return companyEmployeeDao
				;
	}

}
