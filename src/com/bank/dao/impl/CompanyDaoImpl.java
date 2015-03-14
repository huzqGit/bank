package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.Company;
import com.bank.dao.ICompanyDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("companyDao")
public class CompanyDaoImpl extends GenericMyBatisDAOSupport<Company,String> implements ICompanyDao {
	
 
	@Override
	public Company load(String companyId) {
		
		if(companyId!=null && !companyId.equals("")){
			
			Company company=getSqlSession().selectOne("company.selectByPrimaryKey", companyId);
			return company;
		}
		return new Company();
		
	}

	@Override
	public String insert(Company company) {
		
		getSqlSession().insert("company.insert", company);
		return String.valueOf(company.getCompanyId());

	}
	
	@Override
	public void update(Company company){
		
	}

	@Override
	public void delete(String companyId) {
		
	}
	
	@Override
	public List<Company> loadCompanys(Map<String,String> query, int pageIndex,
			int pageSize, String sortField, String sortOrder) {
		
		int start = pageIndex * pageSize, end = start + pageSize;
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("start",start);
		map.put("end",end);
		map.put("sortOrder",sortOrder);
		map.putAll(query);
		List<Company> companys = getSqlSession().selectList("company.loadCompanys",map);
		return companys;
		
	}
}
