package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;
import com.bank.dao.IFarmerCreditDao;

@Repository("farmerCreditDao")
public class FarmerCreditDaoImpl extends SqlSessionDaoSupport implements IFarmerCreditDao {
	
	private static String namespace="farmercredit";
	
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public int countByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne(namespace+".countByExample", example);
		return num;
	}

	@Override
	public int deleteByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().delete(namespace+".deleteByExample",example);
		return num;
	}

	@Override
	public int insert(FarmerCredit record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert(namespace+".insert", record);
		return num;
	}

	@Override
	public int insertSelective(FarmerCredit record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert(namespace+".insertSelective", record);
		return num;
	}

	@Override
	public List<FarmerCredit> selectByExample(FarmerCreditExample example) {
		// TODO Auto-generated method stub
		List<FarmerCredit> credits = this.getSqlSession().selectList(namespace+".selectByExample",example);
		return credits;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExampleSelective(FarmerCredit record,
			FarmerCreditExample example) {
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne(namespace+".updateByExampleSelective");
		return num;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExample(FarmerCredit record, FarmerCreditExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update(namespace+".updateByExample", map);
		return num;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<FarmerCredit> getPageingEntities(int pageIndex, int pageSize,
			String sortField, String sortOrder, Map paramMap) {
		// TODO Auto-generated method stub
		int start = pageIndex * pageSize, end = start + pageSize;
		if ("DESC".equals(sortOrder) == false) sortOrder = "ASC";
		paramMap.put("start", start);
		paramMap.put("end", end);
		paramMap.put("sortField", sortField);
		paramMap.put("sortOrder", sortOrder);
		List<FarmerCredit> credits = this.getSqlSession().selectList(namespace+".pageing",paramMap);
		return credits;
	}

}
