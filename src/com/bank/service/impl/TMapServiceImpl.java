package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.dao.ITMapDao;
import com.bank.service.ITMapService;
import com.bank.vo.TMap;
import com.common.dao.GenericDAO;
import com.common.service.impl.GenericServiceImpl;

@Service("tMapService")
public class TMapServiceImpl  extends GenericServiceImpl<TMap, Long>  implements ITMapService {
	
	@Resource(name="tMapDao")
	private ITMapDao tMapDao;
	
	public List<Map<String,Object>> getMapTree(Map<String,Object> paramMap){
		return tMapDao.getMapTree(paramMap);
	}

	@Override
	public GenericDAO<TMap, Long> getGenericDAO() {
		return this.tMapDao;
	}
	

}
