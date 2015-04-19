package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.CompanyCapital;
import com.bank.dao.ICompanyCapitalDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;

@Repository("companyCapitalDao")
public class CompanyCapitalDaoImpl extends GenericMyBatisDAOSupport<CompanyCapital,Long> 
	implements ICompanyCapitalDao {

	public Long saveCapital(CompanyCapital entity){
		if(entity.getCapitalId()!=null){
			
		}else{
			getSqlSession().insert("", entity);
		}
		return entity.getCapitalId();
	}
	
	@Override
	public CompanyCapital getCompanyCapitalById(Long capitalId) {
		
		CompanyCapital companyCapital=getSqlSession()
				.selectOne("companyCapital.selectByPrimaryKey",capitalId);
		return companyCapital;
	}

	@Override
	public List<CompanyCapital> loadAllCompanys(Map<String, String> query,
			int pageIndex, int pageSize,String sortField, String sortOrder) {
		int start = pageIndex * pageSize, end = start + pageSize;
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("_ibatis_start",start);
		map.put("_ibatis_end",end);
		map.put("_ibatis_sortOrder",sortOrder);
		map.putAll(query);
		List<CompanyCapital> capitals = getSqlSession().selectList("companycapital.pagingLoad",map);
		return capitals;
	}
	

}
