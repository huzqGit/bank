package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.CompanyEmployee;
import com.bank.dao.ICompanyEmployeeDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("companyEmployeeDao")
public class CompanyEmployeeDaoImpl extends
		GenericMyBatisDAOSupport<CompanyEmployee, Long> implements
		ICompanyEmployeeDao {

	@Override
	public Integer saveCompanyEmployee(CompanyEmployee employee) {
		 getSqlSession().insert("companyEmployee.save", employee);
		 return employee.getEmployeeId();
	}
	
	@Override
	public CompanyEmployee getCompanyEmployeeById(Long employeeId) {
		
		CompanyEmployee companyEmployee=getSqlSession().
				selectOne("companyEmployee.selectByPrimaryKey",employeeId);
		return companyEmployee;
	}

	@Override
	public List<CompanyEmployee> loadCompanyEmployees(Map<String, String> query,
			int pageIndex, int pageSize, String sortField, String sortOrder) {
		
		int start = pageIndex * pageSize, end = start + pageSize;
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.putAll(query);
		List<CompanyEmployee> companys = getSqlSession().selectList("companyEmployee.loadEmployees",map);
		return companys;
	}


}
