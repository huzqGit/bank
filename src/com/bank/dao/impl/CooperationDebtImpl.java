package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.beans.CooperationDebt;
import com.bank.beans.CooperationDebtExample;
import com.bank.dao.ICooperationDebtDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationDebtDao")
public class CooperationDebtImpl extends GenericMyBatisDAOSupport<CooperationDebt,Long> implements ICooperationDebtDao {
	
	private static Logger log = LoggerFactory.getLogger(CooperationDebtImpl.class);
	
	@Override
	public void save(CooperationDebt entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperationDebt.save", entity);
	}

	@Override
	public void update(CooperationDebt entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperationDebt.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cooperationDebt.delete", pk);
	}

	@Override
	public CooperationDebt findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperationDebt.findByPK", pk);
	}

	@Override
	public List<CooperationDebt> getAllEntities() throws DAOException {
		return null;
	}

	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperationDebt.getTotal",map);
	}
	
	@Override
	public Long getUnitId(Map<String,Object> map){
		try {
			return getSqlSession().selectOne("cooperationDebt.getUnitId",map);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public int countByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("cooperationdebt.countByExample",example);
		return num;
	}

	@Override
	public int deleteByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().update("cooperationdebt.deleteByExample",example);
		return  num;
	}

	@Override
	public int insert(CooperationDebt record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperationdebt.insert", record);
		return num;
	}

	@Override
	public int insertSelective(CooperationDebt record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperationdebt.insertSelective",record);
		return num;
	}

	@Override
	public List<CooperationDebt> selectByExample(CooperationDebtExample example) {
		// TODO Auto-generated method stub
		List<CooperationDebt> debts = this.getSqlSession().selectList("cooperationdebt.selectByExample",example);
		return debts;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExampleSelective(CooperationDebt record,
			CooperationDebtExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperationdebt.updateByExampleSelective", map);
		return num;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateByExample(CooperationDebt record,
			CooperationDebtExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperationdebt.updateByExampleSelective", map);
		return num;
	}

}
