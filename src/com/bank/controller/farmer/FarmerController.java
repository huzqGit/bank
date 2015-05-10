package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerPay;
import com.bank.beans.Loan;
import com.bank.beans.enums.LoanNSEnum;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerController   {
	
	@Resource
	private IFarmerService farmerService;
	
	@RequestMapping(value = "/saveFarmer",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		String basicData = request.getParameter("farmer");
		String memberData=request.getParameter("member");
		if(StringUtils.isEmpty(basicData)){
			return null;
		}
		//這裡做了時間格式的處理
		Object basicJsonData = JsonUtil.Decode(basicData);
		basicData = JSON.toJSONStringWithDateFormat(basicJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject basic = JSONObject.parseObject(basicData);
		Farmer farmer = (Farmer) JSON.toJavaObject(basic, Farmer.class);
		//农户家庭成员情况
		Object memberJsonData = JsonUtil.Decode(memberData);
		memberData = JSON.toJSONStringWithDateFormat(memberJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		List<FarmerMember> members = (List<FarmerMember>) JSON.parseArray(memberData, FarmerMember.class);
		@SuppressWarnings("rawtypes")
		Map farmerInfo = farmerService.saveFarmer(farmer, members);
		String json = JSON.toJSONString(farmerInfo);
		System.out.println(json);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loadFarmer", method = RequestMethod.GET)
	public ModelAndView loadFarmer(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("rawtypes")
		Map map = null;
		/*查询种类1、按主键查询 2、按姓名查询 3、按身份证查询 4、按姓名和身份证查询*/
		if(StringUtils.isEmpty(id)){
			return null;
		}
		if(!StringUtils.isEmpty(id)){
			map = farmerService.loadFarmer(Long.valueOf(id));
		}
		Farmer farmer = (Farmer) map.get("farmer");
		List<FarmerMember> members = (List<FarmerMember>) map.get("members");
		ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
		view.addObject("farmer", farmer);
		view.addObject("members", members);
		return view;	  
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/loadFarmerTotal", method = RequestMethod.GET)
	public ModelAndView loadFarmerTotal(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception {
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Farmer farmer = farmerService.findByPK(Long.valueOf(id));
		Map map = farmerService.loadFarmer(farmer.getId());
		List<FarmerMember> members = (List<FarmerMember>) map.get("members");
		List<FarmerHouse> houses = (List<FarmerHouse>) map.get("houses");
		List<FarmerForest> forests = (List<FarmerForest>) map.get("forests");
		FarmerPay balance = (FarmerPay)map.get("balance");
		List<FarmerIncome> incomes = (List<FarmerIncome>) map.get("incomes");
		FarmerEvaluate evaluate = (FarmerEvaluate) map.get("evaluate");
		List<FarmerCompunish> compunishs = (List<FarmerCompunish>) map.get("compunishs");
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		if(houses.size() ==0){
			houses.add(new FarmerHouse());
		}
		if(forests.size() == 0){
			forests.add(new FarmerForest());
		}
		if(incomes.size() == 0){
			incomes.add(new FarmerIncome());
		}
		if(compunishs.size() == 0){
			compunishs.add(new FarmerCompunish());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
		view.addObject("farmer", farmer);
		view.addObject("members", members);
		view.addObject("houses", houses);
		view.addObject("forests", forests);
		view.addObject("balance", balance);
		view.addObject("incomes", incomes);
		view.addObject("evaluate", evaluate);
		view.addObject("compunishs", compunishs);
		return view;	  
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/loadFarmerOne", method = RequestMethod.POST)
	public ModelAndView loadFarmerOne(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) throws Exception {
		
		/*查询种类1、按主键查询 2、按姓名查询 3、按身份证查询 4、按姓名和身份证查询*/
		if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			ModelAndView  view = new ModelAndView("/farmer/farmerQueryOne");
			view.addObject("msg","请填写查询条件!");
			return view;
		}
		List<Farmer> farmers =farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() == 0){
			ModelAndView view =  new ModelAndView();
			view.addObject("msg", "未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
			return view;
		}else if(farmers.size()==1){
			Farmer farmer =farmers.get(0);
			Map map = farmerService.loadFarmer(farmer.getId());
			List<FarmerMember> members = (List<FarmerMember>) map.get("members");
			List<FarmerHouse> houses = (List<FarmerHouse>) map.get("houses");
			List<FarmerForest> forests = (List<FarmerForest>) map.get("forests");
			FarmerPay balance = (FarmerPay)map.get("balance");
			List<FarmerIncome> incomes = (List<FarmerIncome>) map.get("incomes");
			FarmerEvaluate evaluate = (FarmerEvaluate) map.get("evaluate");
			List<FarmerCompunish> compunishs = (List<FarmerCompunish>) map.get("compunishs");
			if(members.size() == 0){
				members.add(new FarmerMember());
			}
			if(houses.size() ==0){
				houses.add(new FarmerHouse());
			}
			if(forests.size() == 0){
				forests.add(new FarmerForest());
			}
			if(incomes.size() == 0){
				incomes.add(new FarmerIncome());
			}
			if(compunishs.size() == 0){
				compunishs.add(new FarmerCompunish());
			}
			ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
			view.addObject("farmer", farmer);
			view.addObject("members", members);
			view.addObject("houses", houses);
			view.addObject("forests", forests);
			view.addObject("balance", balance);
			view.addObject("incomes", incomes);
			view.addObject("evaluate", evaluate);
			view.addObject("compunishs", compunishs);
			return view;
			
		}else{
			ModelAndView  view = new ModelAndView("/farmer/farmerQueryOne");
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("farmerName", farmerName);
			return view;
		}  
	}
	@RequestMapping(value="/loadFarmerTwo",method=RequestMethod.POST)
	public ModelAndView loadFarmerTwo(MultipartFile myfile,HttpServletRequest request, 
			HttpServletResponse response){
		try {
			InputStream in=myfile.getInputStream();
			String[][] datas=ParseDataUtils.getExeclData(in,1);
			List<String> farmerNames = new ArrayList<String>();
			for(String[] data:datas){
				farmerNames.add(data[0]);
			}
			if(farmerNames.size()>0){
				List<Farmer> farmers = farmerService.findByNames(farmerNames);
				ModelAndView view = new ModelAndView("/farmer/farmerQueryTwo");
				view.addObject("farmers",farmers);
				return view;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/loadFarmerThree",method=RequestMethod.POST)
	public ModelAndView loadFarmerThree(MultipartFile myfile,HttpServletRequest request, 
			HttpServletResponse response){
		try {
			InputStream in=myfile.getInputStream();
			String[][] datas=ParseDataUtils.getExeclData(in,1);
			StringBuffer buf = new StringBuffer();
			for(String[] data:datas){
				buf.append("'").append(data[0]).append("'").append(",");
			}
			String farmers = buf.substring(0, buf.length()-1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadFarmerFour", method = RequestMethod.POST)
	public ModelAndView loadFarmerReport(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) throws Exception{
		if(StringUtils.isEmpty(farmerIdNum)){
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFour");
			view.addObject("msg", "必须输入农户身份证号码!");
			return view;
		}
		List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() ==0){
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFour");
			return view;
		}else if(farmers.size()==1){
			Farmer farmer = farmers.get(0);
			Map map = farmerService.loadFarmer(farmer.getId());
			List<FarmerMember> members = (List<FarmerMember>) map.get("members");
			List<FarmerHouse> houses = (List<FarmerHouse>) map.get("houses");
			List<FarmerForest> forests = (List<FarmerForest>) map.get("forests");
			List<FarmerBreed> breeds =(List<FarmerBreed>)map.get("breeds");
			List<FarmerDevice> devices =(List<FarmerDevice>)map.get("devices");
			FarmerPay balance = (FarmerPay)map.get("balance");
			List<FarmerIncome> incomes = (List<FarmerIncome>) map.get("incomes");
			FarmerEvaluate evaluate = (FarmerEvaluate) map.get("evaluate");
			List<FarmerCompunish> compunishs = (List<FarmerCompunish>) map.get("compunishs");
			if(members.size() == 0){
				members.add(new FarmerMember());
			}
			if(houses.size() ==0){
				houses.add(new FarmerHouse());
			}
			if(forests.size() == 0){
				forests.add(new FarmerForest());
			}
			if(breeds.size() == 0){
				breeds.add(new FarmerBreed());
			}
			if(devices.size() == 0){
				devices.add(new FarmerDevice());
			}
			if(incomes.size() == 0){
				incomes.add(new FarmerIncome());
			}
			if(compunishs.size() == 0){
				compunishs.add(new FarmerCompunish());
			}
			ModelAndView  view = new ModelAndView("/farmer/farmerCreditReport");
			view.addObject("farmer", farmer);
			view.addObject("members", members);
			view.addObject("houses", houses);
			view.addObject("forests", forests);
			view.addObject("breeds",breeds);
			view.addObject("devices",devices);
			view.addObject("balance", balance);
			view.addObject("incomes", incomes);
			view.addObject("evaluate", evaluate);
			view.addObject("compunishs", compunishs);
			return view;
		}else{
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/typeInFarmer",method=RequestMethod.POST)
	public ModelAndView typeInFarmer(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, 
			HttpServletResponse response) throws Exception{
		//查询条件
		if(StringUtils.isEmpty(farmerIdNum) && StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后录入资产信息!");
			return  view;
		}
	    List<Farmer> farmers= farmerService.findByIDAndName(farmerIdNum, farmerName);
	    if(farmers.size()== 0){
	    	if(StringUtils.isEmpty(farmerName) || StringUtils.isEmpty(farmerIdNum)){
	    		ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
		    	view.addObject("farmerIdNum", farmerIdNum);
		    	view.addObject("farmerName",farmerName);
		    	view.addObject("msg","未找到相应的农户信息!您可以填写好姓名和身份证号码后录入新的农户信息");
				return view;
	    	}else{
	    		Farmer farmer= new Farmer();
	    		farmer.setFarmerName(farmerName);
	    		farmer.setFarmerIdnum(farmerIdNum);
	    		List<FarmerMember> members = new ArrayList<FarmerMember>();
				members.add(new FarmerMember());
	    		ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoForm");
				view.addObject("farmer", farmer);
				view.addObject("members", members);
				return view;
	    	}
	    }else if(farmers.size()== 1){
			Farmer farmer = farmers.get(0);
    		Map map = farmerService.loadFarmer(farmer.getId());
    		List<FarmerMember>  members = (List<FarmerMember>) map.get("members");
    		if(members.size() ==0){
    			members.add(new FarmerMember());
    		}
    		ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoForm");
			view.addObject("farmer", farmer);
			view.addObject("members", members);
			return view;
	    }else{
		    ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
		    view.addObject("farmers",farmers);
			return view;
	    }
	}
	@RequestMapping(value="/loadFile",method=RequestMethod.POST)
	public ModelAndView loadFile(MultipartFile myfile,HttpServletRequest request, 
			HttpServletResponse response){
		try {

			InputStream in=myfile.getInputStream();
			String[][] data=ParseDataUtils.getExeclData(in,1);

			List<Loan> loans = new ArrayList<Loan>();
			for(int row=0;row>data.length;row++){
				 Loan loan = new Loan();
				 loan.setClientNum(data[row][LoanNSEnum.CLIENTNUM.getIndex()]);
				 loan.setNoteNum(data[row][LoanNSEnum.NOTENUM.getIndex()]);
				 loan.setCompactNum(data[row][LoanNSEnum.COMPACTNUM.getIndex()]);
				 loan.setLoanDate(data[row][LoanNSEnum.LOANDATE.getIndex()]);
				 loan.setLimitDate(data[row][LoanNSEnum.LIMITDATE.getIndex()]);
				 loan.setLimitDate1(data[row][LoanNSEnum.LIMITDATE1.getIndex()]);
				 loan.setClientName(data[row][LoanNSEnum.CLIENTNAME.getIndex()]);
				 loan.setCurrency(data[row][LoanNSEnum.CURRENCY.getIndex()]);
				 loan.setAmount(data[row][LoanNSEnum.AMOUNT.getIndex()]);
				 loan.setBalance(data[row][LoanNSEnum.BALANCE.getIndex()]);
				 loan.setOweInterest(data[row][LoanNSEnum.OWEINTEREST.getIndex()]);
				 loan.setCurrentRate(data[row][LoanNSEnum.CURRENTRATE.getIndex()]);
				 loan.setRateType(data[row][LoanNSEnum.RATETYPE.getIndex()]);
				 loan.setClientType(data[row][LoanNSEnum.CLIENTTYPE.getIndex()]);
				 loan.setIdType(data[row][LoanNSEnum.IDTYPE.getIndex()]);
				 loan.setIdNum(data[row][LoanNSEnum.IDNUM.getIndex()]);
				 loan.setPhone(data[row][LoanNSEnum.PHONE.getIndex()]);
				 loan.setAddress(data[row][LoanNSEnum.ADDRESS.getIndex()]);
				 loan.setLoanUse(data[row][LoanNSEnum.LOANUSE.getIndex()]);
				 loan.setGuaranteeType(data[row][LoanNSEnum.GUARANTEETYPE.getIndex()]);
				 loan.setGrade(data[row][LoanNSEnum.GRADE.getIndex()]);
				 loan.setGrade1(data[row][LoanNSEnum.GRADE1.getIndex()]);
				 loan.setSettleType(data[row][LoanNSEnum.SETTLETYPE.getIndex()]);
				 loan.setChargePerson(data[row][LoanNSEnum.CHARGEPERSON.getIndex()]);
				 loan.setOrganCode(data[row][LoanNSEnum.ORGANCODE.getIndex()]);
				 loan.setOrganName(data[row][LoanNSEnum.ORGANNAME.getIndex()]);
				 loan.setBusinessType(data[row][LoanNSEnum.BUSINESSTYPE.getIndex()]);
				 loan.setBusinessBody(data[row][LoanNSEnum.BUSINESSBODY.getIndex()]);
				 loan.setProvideType(data[row][LoanNSEnum.PROVIDETYPE.getIndex()]);
				 loan.setInvest(data[row][LoanNSEnum.INVEST.getIndex()]);
				 loan.setTermTYpe(data[row][LoanNSEnum.TERMTYPE.getIndex()]);
				 loan.setGuaranteeType1(data[row][LoanNSEnum.GUARANTEETYPE1.getIndex()]);
				 loan.setFloatScope(data[row][LoanNSEnum.FLOATSCOPE.getIndex()]);
				 loan.setAdjustType(data[row][LoanNSEnum.ADJUSTTYPE.getIndex()]);
				 loan.setRunType(data[row][LoanNSEnum.RUNTYPE.getIndex()]);
				 loan.setFrequeency(data[row][LoanNSEnum.FREQUEENCY.getIndex()]);
				 loans.add(loan);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
