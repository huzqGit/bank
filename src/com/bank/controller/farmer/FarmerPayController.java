package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerPayExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FamerBalanceBZEnum;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerIncomeService;
import com.bank.service.IFarmerPayService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

@SuppressWarnings("unused")
@Controller
@RequestMapping(value = "/farmer")
public class FarmerPayController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerPayService farmerPayService;
	
	@Resource
	private IFarmerIncomeService farmerIncomeService;
	
	@RequestMapping(value="/saveBalance1",method=RequestMethod.POST)
	public ModelAndView saveBalance1(@ModelAttribute(value="balance") FarmerPay balance,
			HttpServletRequest request,HttpServletResponse response)  {
		try {
			if(balance.getId()==null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
				
				balance.setSourcecode(organ.getOrganNo());
				balance.setSourcename(organ.getOrganName());
				balance.setRunitid(organ.getOrganId());
				balance.setRunitname(organ.getOrganName());
				balance.setRecorder(user.getUserId());
				balance.setRecordtime(new Date());
				
				FarmerPayExample fbe = new FarmerPayExample();
				FarmerPayExample.Criteria fbec = fbe.createCriteria();
				fbec.andFarmeridnumEqualTo(balance.getFarmeridnum());
				fbec.andSourcecodeEqualTo(organ.getOrganNo());
				fbec.andYearEqualTo(balance.getYear());
				List<FarmerPay> balances = farmerPayService.selectByExample(fbe);
				if(balances.size() == 0){
					farmerPayService.save(balance);
				}
			}else{
				String delIncomes = request.getParameter("deleteIncome");
				if(!StringUtils.isEmpty(delIncomes)){
					String[] incomes = delIncomes.split(",");
					List<Long> incomeIds = new ArrayList<Long>(incomes.length);
					for(String income:incomes){
						incomeIds.add(Long.valueOf(income));
					}
					farmerPayService.deleteIncomes(incomeIds);
				}
				farmerPayService.update(balance);
			}
		} catch (Exception e) {
					// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<FarmerIncome> incomes = balance.getIncomes();
		for(FarmerIncome income : incomes){
			income.setPayid(balance.getId());
			try{
				if(income.getId()==null){
					farmerIncomeService.save(income);
				}else{
					farmerIncomeService.update(income);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(balance.getFarmeridnum());
		fec.andRunitidEqualTo(balance.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
	}
	@RequestMapping(value="/editBalance",method=RequestMethod.GET)
	public ModelAndView editBalance(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
			HttpServletRequest request,HttpServletResponse response){
		
		Long balanceId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		FarmerPay balance = null;
		List<FarmerIncome> incomes = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			balance = farmerPayService.findByPK(balanceId);
			incomes = farmerPayService.loadTotalIncome(balanceId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm1");
		view.addObject("farmer",farmer);
		view.addObject("balance",balance);
		view.addObject("incomes",incomes);
		return view;
	}
	@RequestMapping(value="/deleteBalance",method=RequestMethod.GET)
	public ModelAndView deleteBalance(@RequestParam(value="id") Long id,
			HttpServletRequest request,HttpServletResponse response){
		
		FarmerPayExample fpe = new FarmerPayExample();
		FarmerPayExample.Criteria fpec = fpe.createCriteria();
		fpec.andPayidEqualTo(id);
		List<FarmerPay> balances = farmerPayService.selectByExample(fpe);
		if(balances.size() == 1){
			try {
				farmerPayService.delete(id);
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				FarmerExample fe = new FarmerExample();
				FarmerExample.Criteria fec = fe.createCriteria();
				fec.andFarmeridnumEqualTo(balances.get(0).getFarmeridnum());
				fec.andRunitidEqualTo(organ.getOrganId());
				List<Farmer> farmers = farmerService.selectByExample(fe);
				if(farmers.size() == 1){
					ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
					view.addObject("farmer",farmers.get(0));
					return view;
				}else{
					return null;
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		}else{
			return null;
		}
	}
	@RequestMapping(value="/queryBalance",method=RequestMethod.GET)
	public ModelAndView queryBalance(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceView");
		Farmer farmer = null;
		try {
			 farmer = farmerService.findByPK(farmerId);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value = "/loadBalance", method = RequestMethod.GET)
	public ModelAndView loadBalance(@RequestParam(value="id",required=true) String id, 
			HttpServletResponse response) throws Exception {
		if(!StringUtils.isEmpty(id)){
			Long payId=Long.valueOf(id);
			FarmerPay balance = farmerPayService.findByPK(payId);
			Farmer farmer = farmerService.findByPK(balance.getFarmerid());
			List<FarmerIncome> incomes = farmerPayService.loadTotalIncome(payId);
			if(incomes.size() ==0 ){
				incomes.add(new FarmerIncome());
			}
			ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm");
			view.addObject("farmer", farmer);
			view.addObject("balance", balance);
			view.addObject("incomes", incomes);
			return view;
		}
		return null;
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/loadBalance1", method = RequestMethod.POST)
	public ModelAndView loadBalance1(@RequestParam(value="farmeridnum") String farmeridnum, 
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		FarmerPayExample fpe = new FarmerPayExample();
		FarmerPayExample.Criteria fpec = fpe.createCriteria();
		fpec.andFarmeridnumEqualTo(farmeridnum);
		fpec.andRunitidEqualTo(runitid);
		int totalNumber = farmerPayService.countByExample(fpe);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerPay> balances = null;
		try {
			balances = farmerPayService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map= new HashMap();
		map.put("total", totalNumber);
		map.put("data", balances);
	    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter writer = null;
	    try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@RequestMapping(value="/typeinBalance1",method=RequestMethod.GET)
	public ModelAndView TypeinBalance1(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<FarmerIncome> incomes =new ArrayList<FarmerIncome>();
		incomes.add(new FarmerIncome());
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceForm1");
		view.addObject("farmer",farmer);
		view.addObject("incomes",incomes);
		return view;
	}
	
	@RequestMapping(value="/loadAllPay",method=RequestMethod.POST)
	public ModelAndView loadAllCompany(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		//查询条件
		String farmerName = request.getParameter("farmerName");
	    String farmerIdNum=request.getParameter("farmerIdNum");
	    String recorder=request.getParameter("recorder");
	    String recordTimeBegin=request.getParameter("recordTimeBegin");
	    String recordTimeEnd=request.getParameter("recordTimeEnd");
	    
	    Map<String,String> query = new HashMap<String,String>();
	    query.put("farmerName", farmerName);
	    query.put("farmerIdNum", farmerIdNum);
	    query.put("recorder", recorder);
	    query.put("recordTimeBegin", recordTimeBegin);
	    query.put("recordTimeEnd", recordTimeEnd);
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    List<FarmerPay> data = farmerPayService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, query);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	@RequestMapping(value="/importFarmerBalance",method=RequestMethod.POST)
	public ModelAndView importFarmerBalance(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		try{
			 InputStream in = myfile.getInputStream();
			 if( myfile.getOriginalFilename().endsWith(".xls")){
				 data = ParseDataUtils.readXls(in, 0);
			 }else{
				 data = ParseDataUtils.readXlsx(in, 0);
			 }
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
		}
		if("TYCJ".equals(sourcecode)){
			msgs = importFarmerBalanceBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerBalanceImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerBalanceBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			FarmerPay balance = new FarmerPay();
			balance.setSourcecode("TYCJ");
			balance.setSourcename("统一采集小组");
			balance.setRunitid(organId);
			balance.setRunitname(organName);
			balance.setRecorder(recorder);
			balance.setRecordtime(recordTime);
			String year = data[row][FamerBalanceBZEnum.YEAR.getIndex()];
			if(StringUtils.isEmpty(year)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行年份不能为空");
				msgs.add(msg);
				continue;
			}else{
				try{
					balance.setYear(format.parse(year));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行年份格式不正确");
					msgs.add(msg);
					continue;
				}
			}
			String farmerIdNum = data[row][FamerBalanceBZEnum.FARMERIDNUM.getIndex()];
			balance.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号码不能为空。");
				msgs.add(msg);
				continue;
			}
			String farmingIncome = data[row][FamerBalanceBZEnum.FARMINGINCOME.getIndex()];
			if(!StringUtils.isEmpty(farmingIncome)){
				try{
					balance.setFarmingincome(Double.valueOf(farmingIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行主要农作物年度净收入合计必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String avocationIncome = data[row][FamerBalanceBZEnum.AVOCATIONINCOME.getIndex()];
			if(!StringUtils.isEmpty(avocationIncome)){
				try{
					balance.setAvocationincome(Double.valueOf(avocationIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行家庭林、牧、副、渔业收入年度净收入合计必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String  businessIncome = data[row][FamerBalanceBZEnum.BUSINESSINCOME.getIndex()];
			if(!StringUtils.isEmpty(businessIncome)){
				try{
					balance.setBusinessincome(Double.valueOf(businessIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行家庭工商业收入年度净收入必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String workIncome = data[row][FamerBalanceBZEnum.WORKINCOME.getIndex()];
			if(StringUtils.isEmpty(workIncome)){
				try{
					balance.setWorkincome(Double.valueOf(workIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行外出务工收入必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String otherIncome = data[row][FamerBalanceBZEnum.OTHERINCOME.getIndex()];
			if(StringUtils.isEmpty(otherIncome)){
				try{
					balance.setOtherincome(Double.valueOf(otherIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"其他收入年度净收入入必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String totalIncome = data[row][FamerBalanceBZEnum.TOTALINCOME.getIndex()];
			if(StringUtils.isEmpty(totalIncome)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"家庭年度总收入合计不能为空");
				msgs.add(msg);
				continue;
			}else{
				try{
					balance.setTotalincome(Double.valueOf(totalIncome));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"家庭年度总收入合计必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String productPay = data[row][FamerBalanceBZEnum.TOTALPAY.getIndex()];
			if(!StringUtils.isEmpty(productPay)){
				try{
					balance.setProductpay(Double.valueOf(productPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"生产支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String livingPay = data[row][FamerBalanceBZEnum.LIVINGPAY.getIndex()];
			if(!StringUtils.isEmpty(livingPay)){
				try{
					balance.setLivingpay(Double.valueOf(livingPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"生活支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String medicalPay = data[row][FamerBalanceBZEnum.MEDICALPAY.getIndex()];
			if(!StringUtils.isEmpty(medicalPay)){
				try{
					balance.setMedicalpay(Double.valueOf(medicalPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"医疗支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String educatePay = data[row][FamerBalanceBZEnum.EDUCATEPAY.getIndex()];
			if(!StringUtils.isEmpty(educatePay)){
				try{
					balance.setEducatepay(Double.valueOf(educatePay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"教育支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String insuredPay = data[row][FamerBalanceBZEnum.INSUREDPAY.getIndex()];
			if(!StringUtils.isEmpty(insuredPay)){
				try{
					balance.setInsuredpay(Double.valueOf(insuredPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"参保支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String otherPay = data[row][FamerBalanceBZEnum.OTHERPAY.getIndex()];
			if(!StringUtils.isEmpty(otherPay)){
				try{
					balance.setOtherpay(Double.valueOf(otherPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"其他支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			String totalPay = data[row][FamerBalanceBZEnum.TOTALPAY.getIndex()];
			if(StringUtils.isEmpty(totalPay)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"总支出不能为空");
				msgs.add(msg);
				continue;
			}else{
				try{
					balance.setTotalpay(Double.valueOf(totalPay));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"总支出必须为数字类型");
					msgs.add(msg);
					continue;
				}
			}
			FarmerPayExample fpe = new FarmerPayExample();
			FarmerPayExample.Criteria fpec = fpe.createCriteria();
			fpec.andYearEqualTo(balance.getYear());
			fpec.andFarmeridnumEqualTo(balance.getFarmeridnum());
			fpec.andSourcecodeEqualTo("TYCJ");
			List<FarmerPay> balances = farmerPayService.selectByExample(fpe);
			try{
				if(balances.size() ==0){
					farmerPayService.save(balance);
				}else if(balances.size() == 1){
					balance.setId(balances.get(0).getId());
					farmerPayService.update(balance);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return msgs;
	}
	
	
}
