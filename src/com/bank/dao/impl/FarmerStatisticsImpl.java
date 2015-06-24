package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bank.dao.IFarmerStatisticsDao;

@Repository("farmerStatisticsDao")
@SuppressWarnings("rawtypes")
public class FarmerStatisticsImpl extends SqlSessionDaoSupport implements IFarmerStatisticsDao {
	
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	@Override
	public List<Map> queryVillages(String dicType) {
		// TODO Auto-generated method stub
		List<Map> lenders = this.getSqlSession().selectList("farmerstatistics.queryVillages",dicType);
		return lenders;
	}
	@Override
	public Integer queryTotalFarmer(String vilage) {
		// TODO Auto-generated method stub
		Integer  total =this.getSqlSession().selectOne("farmerstatistics.queryTotalFarmer",vilage);
		return total;
	}
	@Override
	public Integer queryLendFarmer(String village) {
		// TODO Auto-generated method stub
		Integer  total =this.getSqlSession().selectOne("farmerstatistics.queryLendFarmer",village);
		return total;
	}
	@Override
	public Integer queryBalanceFarmer(String village) {
		// TODO Auto-generated method stub
		Integer  total =this.getSqlSession().selectOne("farmerstatistics.queryBalanceFarmer",village);
		return total;
	}
	@Override
	public Integer queryBadLoanFarmer(String village) {
		// TODO Auto-generated method stub
		Integer  total =this.getSqlSession().selectOne("farmerstatistics.queryBadLoanFarmer",village);
		return total;
	}

	@SuppressWarnings({"unchecked"})
	@Override
	public List<Map> queryBigLender(String village, int no) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("village", village);
		map.put("no", no);
		List<Map> lenders = this.getSqlSession().selectList("farmerstatistics.queryBigLenderByBalance",map);
		return lenders;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> queryBigLenderByAmount(String village, int no) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("village", village);
		map.put("no", no);
		List<Map> lenders = this.getSqlSession().selectList("farmerstatistics.queryBigLenderByAmount",map);
		return lenders;
	}
	
	@Override
	public List<Map> queryIncome(String year) {
		// TODO Auto-generated method stub
		List<Map> incomes = this.getSqlSession().selectList("farmerstatistics.queryIncome",year);
		return incomes;
	}
	@Override
	public List<Map> queryPayment(String year) {
		// TODO Auto-generated method stub
		List<Map> payments =  this.getSqlSession().selectList("farmerstatistics.queryPayment", year);
		return payments;
	}

}
