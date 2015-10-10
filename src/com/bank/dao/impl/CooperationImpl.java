package com.bank.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.bank.dao.ICooperationDao;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("cooperationDao")
public class CooperationImpl extends GenericMyBatisDAOSupport<Cooperation,Long> implements ICooperationDao {
	
	private static Logger log = LoggerFactory.getLogger(CooperationImpl.class);
	
	@Override
	public void save(Cooperation entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cooperation.save", entity);
	}

	@Override
	public void update(Cooperation entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cooperation.update", entity);
	}

	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cooperation.delete", pk);
	}

	@Override
	public Cooperation findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cooperation.findByPK", pk);
	}

	@Override
	public List<Cooperation> getAllEntities() throws DAOException {
		return null;
	}
	public long getTotal(Map<String,String> map){
		return getSqlSession().selectOne("cooperation.getTotal",map);
	}
	
	public List<Map<String,Object>> getCooperationTree(Map<String,Object> map){
		List<Map<String,Object>> list = getSqlSession().selectList("cooperation.getCooperationTree", map);
		Map<String,Object> pMap = new HashMap<String, Object>();
		pMap.put("name", "合作社名称");
		pMap.put("id", "pn");
		pMap.put("expanded", true);
		list.add(pMap);
		return list;
	}
	
	@Override
	public Long getUnitId(Map<String,Object> map){
		try {
			return getSqlSession().selectOne("cooperation.getUnitId",map);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public int countByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().selectOne("cooperation.countByExample",example);
		return num;
	}

	@Override
	public int deleteByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().update("cooperation.deleteByExample",example);
		return  num;
	}

	@Override
	public int insert(Cooperation record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperation.insert", record);
		return num;
	}

	@Override
	public int insertSelective(Cooperation record) {
		// TODO Auto-generated method stub
		int num = this.getSqlSession().insert("cooperation.insertSelective",record);
		return num;
	}

	@Override
	public List<Cooperation> selectByExample(CooperationExample example) {
		// TODO Auto-generated method stub
		List<Cooperation> cooperations = this.getSqlSession().selectList("cooperation.selectByExample",example);
		return cooperations;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int updateByExampleSelective(Cooperation record,
			CooperationExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperation.updateByExampleSelective", map);
		return num;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int updateByExample(Cooperation record, CooperationExample example) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("record", record);
		map.put("example", example);
		int num = this.getSqlSession().update("cooperation.updateByExampleSelective", map);
		return num;
	}
	
}
