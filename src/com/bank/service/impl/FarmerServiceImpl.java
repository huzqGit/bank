package com.bank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;





import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.beans.Farmer;
import com.bank.beans.FarmerMember;
import com.bank.dao.IFarmerDao;
import com.bank.dao.IFarmerMemberDao;
import com.bank.service.IFarmerService;
import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;
import com.common.service.impl.GenericServiceImpl;

@Service("farmerService")
public class FarmerServiceImpl extends GenericServiceImpl<Farmer, Long> 
	implements IFarmerService{
	
	@Resource
	private IFarmerDao farmerDao;
	@Resource
	private IFarmerMemberDao farmerMemberDao;

	@Override
	public GenericDAO<Farmer, Long> getGenericDAO() {
		
		return this.farmerDao;
	}

	@Override
	public Map saveFarmer(Farmer farmer, List<FarmerMember> members) {
		Map map = new HashMap();
		try {
			if(farmer.getId()==null){
				Farmer dbFarmer=farmerDao.findByID(farmer.getFarmerIdnum());
				if(dbFarmer!=null){
					farmerDao.update(farmer);
				}else{
					farmerDao.save(farmer);
				}
			}else{
				farmerDao.update(farmer);
			}
			List list = new ArrayList<FarmerMember>();
			for(Iterator<FarmerMember> it =members.iterator();it.hasNext();){
				FarmerMember member=it.next();
				member.setFarmerId(String.valueOf(farmer.getId()));
				if(member.getId()==null){
					farmerMemberDao.save(member);
				}else{
					farmerMemberDao.update(member);
				}
				list.add(member);
			}
			map.put("farmer", farmer);
			map.put("member", list);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		} catch (UpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
