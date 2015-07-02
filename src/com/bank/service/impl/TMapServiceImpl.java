package com.bank.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bank.dao.ITMapDao;
import com.bank.service.ITMapService;
import com.bank.utils.Pinyin4jUtil;
import com.bank.vo.TMap;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.service.impl.GenericServiceImpl;

@Service("tMapService")
public class TMapServiceImpl  extends GenericServiceImpl<TMap, Long>  implements ITMapService {
	
	private static Logger log = LoggerFactory.getLogger(TMapServiceImpl.class);
	
	@Resource(name="tMapDao")
	private ITMapDao tMapDao;
	
	public List<Map<String,Object>> getMapTree(Map<String,Object> paramMap){
		return tMapDao.getMapTree(paramMap);
	}

	@Override
	public GenericDAO<TMap, Long> getGenericDAO() {
		return this.tMapDao;
	}

	@Override
	public void save(TMap entity) throws DAOException, CreateException {
		tMapDao.save(entity);
	}
	
	/**
	 * 根据TMap对象获取改对象的主键,不存在时返回空
	 * @author zkongbai
	 * @date 2015年6月29日  上午9:34:44
	 * @version 1.0
	 * @return
	 */
	public Long geMapId(TMap tmap){
		return tMapDao.geMapId(tmap);
	}
	
	/**
	 * 保存手动新增的TMAP
	 * @author zkongbai
	 * @date 2015年6月29日  上午9:26:33
	 * @version 1.0
	 * @throws CreateException 
	 * @throws DAOException 
	 */
	public void saveSDTMap(String mapkey,String mapValue) throws DAOException, CreateException{
		TMap tmap = new TMap();
		tmap.setMaptypes("sourcecode_sourcename_sd");
		tmap.setMapkey(mapkey);
		tmap.setMapvalue(mapValue);
		Long mapid = null;
		try {
			mapid = this.geMapId(tmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(mapid == null){
			String mapValue_py = Pinyin4jUtil.getPinYinHeadChar(mapValue);
			tmap.setMapvalue_py(mapValue_py);
			tmap.setRemarks("数据来源");
			this.save(tmap);
		}else{
			log.info("t_map映射表已包含该数据来源");
		}
	}
	

}
