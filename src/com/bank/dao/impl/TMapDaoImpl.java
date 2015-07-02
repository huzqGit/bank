package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.bank.dao.ITMapDao;
import com.bank.vo.TMap;
import com.common.dao.impl.GenericMyBatisDAOSupport;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@Repository("tMapDao")
public class TMapDaoImpl extends GenericMyBatisDAOSupport<TMap,Long> implements ITMapDao {

	@Override
	public void save(TMap entity) throws DAOException,
			CreateException {
		this.getSqlSession().insert("cTMap.save", entity);
	}

	@Override
	public void update(TMap entity) throws DAOException,
			UpdateException {
		this.getSqlSession().update("cTMap.update", entity);
	}


	@Override
	public List<Map<String, Object>> getMapTree(Map<String, Object> map) {
		List<Map<String,Object>> list = getSqlSession().selectList("cTMap.getMapTree", map);
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		list2.addAll(list);		//list2 = list;//这段话会抛异常,因为list与list2指向同一个
		Set<String> filter = new TreeSet<String>();
		Map<String,Object> pMap = null;
		String v = null;
		
		for(Map<String,Object> imap : list){
			pMap = new HashMap<String, Object>();
			v = String.valueOf(imap.get("pid"));
			pMap.put("id",v);
			pMap.put("text",v.toUpperCase());
			if("novalue".equalsIgnoreCase(v))
				pMap.put("expanded", false);
			else
				pMap.put("expanded", true);
			if(!filter.contains(v)){
				filter.add(v);
				list2.add(pMap);
			}
		}
		return list2;
	}
	
	@Override
	public void delete(Long pk) throws DAOException, DeleteException{
		this.getSqlSession().update("cTMap.delete", pk);
	}

	@Override
	public TMap findByPK(Long pk) throws DAOException,
			DataNotFoundException {
		return getSqlSession().selectOne("cTMap.findByPK", pk);
	}

	@Override
	public Long geMapId(TMap tmap) {
		return getSqlSession().selectOne("cTMap.geMapId", tmap);
	}

	
 
}
