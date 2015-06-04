package com.bank.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bank.beans.FarmerCooperationDebt;
import com.bank.dao.ICooperationDebtDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationDebtDao")
public class CooperationDebtImpl extends GenericMyBatisDAOSupport<FarmerCooperationDebt,Long> implements ICooperationDebtDao {

	@Override
	public void save(FarmerCooperationDebt entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperationDebt.save", entity);
	}

	@Override
	public void update(FarmerCooperationDebt entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperationDebt.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cooperationDebt.delete", pk);
	}

	@Override
	public FarmerCooperationDebt findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperationDebt.findByPK", pk);
	}

	@Override
	public List<FarmerCooperationDebt> getAllEntities() throws DAOException {
		return null;
	}

	@Override
	public List<FarmerCooperationDebt> getPageingEntities(int pageIndex,
			int pageSize, String sortField, String sortOrder,Map map)
			throws DAOException {
		int start = pageIndex * pageSize, end = start + pageSize;
		if (!"desc".equals(sortOrder))
			sortOrder = "asc";
		map.put("start", start);
		map.put("end", end);
		map.put("sortOrder", sortOrder);
		map.put("sortField", sortField);
		return getSqlSession().selectList("cooperationDebt.getPageingEntities", map);
	}
	
	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperationDebt.getTotal",map);
	}

}
