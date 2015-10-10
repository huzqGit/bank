package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.beans.CooperationProfit;
import com.bank.beans.CooperationProfitExample;
import com.bank.dao.ICooperationProfitDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationProfitDao")
public class CooperationProfitImpl extends GenericMyBatisDAOSupport<CooperationProfit,Long> implements ICooperationProfitDao {
	
	private static Logger log = LoggerFactory.getLogger(CooperationProfitImpl.class);
	
	@Override
	public void save(CooperationProfit entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperationProfit.save", entity);
	}

	@Override
	public void update(CooperationProfit entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperationProfit.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cooperationProfit.delete", pk);
	}

	@Override
	public CooperationProfit findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperationProfit.findByPK", pk);
	}

	@Override
	public List<CooperationProfit> getAllEntities() throws DAOException {
		return null;
	}


	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperationProfit.getTotal",map);
	}
	
	@Override
	public Long getUnitId(Map<String,Object> map){
		try {
			return getSqlSession().selectOne("cooperationProfit.getUnitId",map);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public int countByExample(CooperationProfitExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("cooperationprofit.countByExample",example);
		return num;
	}

	@Override
	public int deleteByExample(CooperationProfitExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().update("cooperationprofit.deleteByExample",example);
		return  num;
	}

	@Override
	public int insert(CooperationProfit record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperationprofit.insert", record);
		return num;
	}

	@Override
	public int insertSelective(CooperationProfit record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperationprofit.insertSelective",record);
		return num;
	}

	@Override
	public List<CooperationProfit> selectByExample(
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		List<CooperationProfit> cooperations = this.getSqlSession().selectList("cooperationprofit.selectByExample",example);
		return cooperations;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExampleSelective(CooperationProfit record,
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperationProfit.updateByExampleSelective", map);
		return num;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExample(CooperationProfit record,
			CooperationProfitExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperationProfit.updateByExampleSelective", map);
		return num;
	}
	

}
