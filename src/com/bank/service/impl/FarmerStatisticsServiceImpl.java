package com.bank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bank.dao.IFarmerStatisticsDao;
import com.bank.service.IFarmerStatisticsService;

@Service("farmerStatisticsService")
public class FarmerStatisticsServiceImpl implements IFarmerStatisticsService {
	
	@Resource
	private IFarmerStatisticsDao farmerStatisticsDao;
	

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String,String>> queryFarmerNum() {
		// TODO Auto-generated method stub
		List<Map> villages = farmerStatisticsDao.queryVillages("villages");
		List<Map<String,String>> list = new ArrayList<Map<String,String>>(villages.size()+1);
		Integer total = farmerStatisticsDao.queryTotalFarmer(null);
		Integer  loan = farmerStatisticsDao.queryLendFarmer(null);
		Integer balance = farmerStatisticsDao.queryBalanceFarmer(null);
		Integer badloan = farmerStatisticsDao.queryBadLoanFarmer(null);
		for(Map map:villages){
			String village = (String)map.get("DICVALUE");
			Integer  totalNum = farmerStatisticsDao.queryTotalFarmer(village);
			Integer  loanNum = farmerStatisticsDao.queryLendFarmer(village);
			Integer  balanceNum = farmerStatisticsDao.queryBalanceFarmer(village);
			Integer badloanNum = farmerStatisticsDao.queryBadLoanFarmer(village);
			Map<String,String>  temp= new HashMap<String,String>();
			temp.put("village", village); 
			temp.put("totalNum", String.valueOf(totalNum));
			temp.put("loanNum", String.valueOf(loanNum));
			temp.put("balanceNum",String.valueOf(balanceNum));
			temp.put("badloanNum",String.valueOf(badloanNum));
			list.add(temp);
		}
		Map<String,String> all = new HashMap<String,String>();
		all.put("village", "全县合计");
		all.put("totalNum", String.valueOf(total));
		all.put("loanNum", String.valueOf(loan));
		all.put("balanceNum",String.valueOf(balance));
		all.put("badloanNum",String.valueOf(badloan));
		list.add(all);
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryBigLender(String village,String type, int no) {
		// TODO Auto-generated method stub
		List<Map>  lenders = null;
		if("1".equals(type)){
			lenders = farmerStatisticsDao.queryBigLender(village, no);
		}else if("2".equals(type)){
			lenders = farmerStatisticsDao.queryBigLenderByAmount(village, no);
		}
	
		return lenders;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryIncome(String year) {
		// TODO Auto-generated method stub
		List<Map> incomes = farmerStatisticsDao.queryIncome(year);
		return incomes;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryPayment(String year) {
		// TODO Auto-generated method stub
		List<Map> payments = farmerStatisticsDao.queryPayment(year);
		return payments;
	}

	
}
