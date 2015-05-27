package com.bank.controller.farmer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
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
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Apply;
import com.bank.beans.Dictionary;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerPay;
import com.bank.beans.Loan;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IFarmerPayService;
import com.bank.service.IFarmerService;
import com.bank.service.ILoanService;
import com.bank.utils.ParseDataUtils;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerController   {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerPayService farmerBalanceService;
	@Resource
	private ILoanService loanService;
	
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
	
	@RequestMapping(value = "/loadFarmer", method = RequestMethod.GET)
	public ModelAndView loadFarmer(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception {
		/*查询种类1、按主键查询 2、按姓名查询 3、按身份证查询 4、按姓名和身份证查询*/
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Long farmerId = Long.valueOf(id);
		Farmer farmer = farmerService.findByPK(farmerId);
		List<FarmerMember> members= farmerService.findMemberByFarmer(farmerId);
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerBasicInfoForm");
		view.addObject("farmer", farmer);
		view.addObject("members", members);
		return view;	  
	}
	@RequestMapping(value = "/loadFarmer1", method = RequestMethod.GET)
	public ModelAndView loadFarmer1(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception {
		/*查询种类1、按主键查询 2、按姓名查询 3、按身份证查询 4、按姓名和身份证查询*/
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Long farmerId = Long.valueOf(id);
		Farmer farmer = farmerService.findByPK(farmerId);
		List<FarmerMember> members= farmerService.findMemberByFarmer(farmerId);
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		ModelAndView  view = new ModelAndView("/common/bankBuilding");
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
		Map map = farmerService.loadTotalFarmer(farmer.getId());
		List<FarmerMember> members = (List<FarmerMember>) map.get("members");
		List<FarmerHouse> houses = (List<FarmerHouse>) map.get("houses");
		List<FarmerForest> forests = (List<FarmerForest>) map.get("forests");
		FarmerPay balance = (FarmerPay)map.get("balance");
		List<FarmerIncome> incomes = (List<FarmerIncome>) map.get("incomes");
		FarmerEvaluate evaluate = (FarmerEvaluate) map.get("evaluate");
		List<FarmerCompunish> compunishs = farmerService.findCompunishByFarmer(farmer.getId());
		List<Loan> unBalances = loanService.findUnBalanceByFarmer(farmer.getId());
		List<Loan> badBalances = loanService.findBadBalanceByFarmer(farmer.getId());
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
		if(unBalances.size() == 0){
			unBalances.add(new Loan());
		}
		if(badBalances.size() == 0){
			badBalances.add(new Loan());
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
		view.addObject("unbalances",unBalances);
		view.addObject("badbalances",badBalances);
		return view;	  
	}
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
			List<FarmerMember> members = farmerService.findMemberByFarmer(farmer.getId());
			List<FarmerHouse> houses = farmerService.findHouseByFarmer(farmer.getId());
			List<FarmerForest> forests = farmerService.findForestByFarmer(farmer.getId());
			FarmerPay balance = farmerService.findLatestBalanceByFarmer(farmer.getId());
			List<FarmerIncome> incomes = new ArrayList<FarmerIncome>();
			List<Loan> unBalances = loanService.findUnBalanceByFarmer(farmer.getId());
			List<Loan> badBalances = loanService.findBadBalanceByFarmer(farmer.getId());
			if(balance != null){
				incomes = farmerBalanceService.loadTotalIncome(balance.getId());
			}
			FarmerEvaluate evaluate = farmerService.findEvaluateByFarmer(farmer.getId());
			List<FarmerCompunish> compunishs = farmerService.findCompunishByFarmer(farmer.getId());
			List<FarmerInsured> insureds = farmerService.findInsuredByFarmer(farmer.getId());
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
			if(insureds.size() == 0){
				insureds.add(new FarmerInsured());
			}
			if(unBalances.size() == 0){
				unBalances.add(new Loan());
			}
			if(badBalances.size() == 0){
				badBalances.add(new Loan());
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
			view.addObject("insureds", insureds);
			view.addObject("unbalances",unBalances);
			view.addObject("badbalances",badBalances);
			return view;
			
		}else{
			ModelAndView  view = new ModelAndView("/farmer/farmerQueryOne");
			view.addObject("farmerIdNum", farmerIdNum);
			view.addObject("farmerName", farmerName);
			view.addObject("farmers",farmers);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/loadFarmerThree",method=RequestMethod.POST)
	public ModelAndView loadFarmerThree(HttpServletRequest request, 
			HttpServletResponse response){
		 String organName = request.getParameter("organName");
		 String loanDate1 = request.getParameter("loanDate1");
		 String loanDate2 = request.getParameter("loanDate2");
		 String balance1 = request.getParameter("balance1");
		 String balance2 = request.getParameter("balance2");
		 Map map = new HashMap();
		 map.put("organName", organName);
		 map.put("loanDate1", loanDate1);
		 map.put("loanDate2", loanDate2);
		 map.put("balance1", balance1);
		 map.put("balance2", balance2);
		 List<Loan> loans = loanService.loadSpecialLoan(map);
		 List<Long> farmerIds = new ArrayList<Long>();
		 for(Iterator<Loan> it = loans.iterator();it.hasNext();){
			 Loan loan = it.next();
			 farmerIds.add(loan.getClientId());
		 }
		List<Farmer> farmers = farmerService.findByFarmerIds(farmerIds);
		ModelAndView view = new ModelAndView("/farmer/farmerQueryThree");
		view.addObject("farmers", farmers);
		return view;
	}
	@RequestMapping(value = "/loadFarmerFour", method = RequestMethod.POST)
	public ModelAndView loadFarmerFour(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) throws Exception{
		if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFour");
			view.addObject("msg", "必须输入农户身份证号码!");
			return view;
		}
		List<Farmer> farmers = farmerService.findByIDAndName(farmerIdNum, farmerName);
		if(farmers.size() ==0){
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFour");
			return view;
		}else{
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFour");
			view.addObject("farmerName",farmerName);
			view.addObject("farmerIdNum",farmerIdNum);
			view.addObject("farmers",farmers);
			return view;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/loadFarmerFive",method=RequestMethod.POST)
	public ModelAndView loadFarmerFive(MultipartFile myfile,HttpServletRequest request, 
			HttpServletResponse response){
		//用户名单查询
		 InputStream in;String[][] datas;
		 List<String> farmerNames = new ArrayList<String>();
		 List<Long> farmerIdsByNames = new ArrayList<Long>();
		 try {
			in = myfile.getInputStream();
				datas = ParseDataUtils.getExeclData(in,1);
				farmerNames = new ArrayList<String>();
				for(String[] data:datas){
					farmerNames.add(data[0]);
				}
				List farmersByNames = farmerService.findByNames(farmerNames);
				for(Iterator<Farmer> it = farmersByNames.iterator();it.hasNext();){
					Farmer farmer = it.next();
					farmerIdsByNames.add(farmer.getId());
				}
		 } catch (IOException e) {
			e.printStackTrace();
		  }
		 //贷款信息查询
		 String organName = request.getParameter("organName");
		 String loanDate1 = request.getParameter("loanDate1");
		 String loanDate2 = request.getParameter("loanDate2");
		 String balance1 = request.getParameter("balance1");
		 String balance2 = request.getParameter("balance2");
		 Map map = new HashMap();
		 map.put("organName", organName);
		 map.put("loanDate1", loanDate1);
		 map.put("loanDate2", loanDate2);
		 map.put("balance1", balance1);
		 map.put("balance2", balance2);
		 List<Loan> loans = loanService.loadSpecialLoan(map);
		 //合并查询结果
		 List<Long> farmerIds = new ArrayList<Long>();
		 for(Iterator<Loan> it = loans.iterator();it.hasNext();){
			 Loan loan = it.next();
			 if(farmerNames.size() >0){
				 if(farmerIdsByNames.size() >0){
					 if(farmerIdsByNames.contains(loan.getId())){
						 farmerIds.add(loan.getClientId());
					 }
				 }else{
					 
				 }
			 }else{
				 if(loan.getClientId()!=null){
					 farmerIds.add(loan.getClientId());
				 }
			 }
		 }

		List<Farmer> dbfarmers = farmerService.findByFarmerIds(farmerIds);
		StringBuffer fids = new StringBuffer();
		for(Iterator<Long> it = farmerIds.iterator();it.hasNext();){
			Long fid = it.next();
			fids.append(fid).append(",");
		}
		ModelAndView view = new ModelAndView("/farmer/farmerQueryFive");
		view.addObject("farmers", dbfarmers);
		view.addObject("farmerIds",fids.substring(0, fids.length()-1));
		return view;
	}
	
	@RequestMapping(value = "/loadFarmerReport", method = RequestMethod.GET)
	public ModelAndView loadFarmerReport(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception{
	
			Long  farmerId = Long.valueOf(id);
			Farmer farmer = farmerService.findByPK(farmerId);
			List<FarmerMember> members = farmerService.findMemberByFarmer(farmerId);
			List<Loan> loans = farmerService.findLoanByFarmer(farmerId);
			List<FarmerHouse> houses = farmerService.findHouseByFarmer(farmerId);
			List<FarmerForest> forests = farmerService.findForestByFarmer(farmerId);
			List<FarmerBreed> breeds = farmerService.findBreedByFarmer(farmerId);
			List<FarmerDevice> devices = farmerService.findDeviceByFarmer(farmerId);
			List<FarmerPay> balances = farmerService.findBalanceByFarmer(farmerId);
			FarmerEvaluate evaluate = farmerService.findEvaluateByFarmer(farmerId);
			
			List<FarmerCompunish> compunishs = farmerService.findCompunishByFarmer(farmerId);
			List<FarmerInsured> insureds = farmerService.findInsuredByFarmer(farmerId);
			if(members.size() == 0){
				members.add(new FarmerMember());
			}
			if(loans.size() == 0){
				loans.add(new Loan());
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
			if(compunishs.size() == 0){
				compunishs.add(new FarmerCompunish());
			}
			if(balances.size() == 0){
				balances.add(new FarmerPay());
			}
			if(insureds.size() ==0){
				insureds.add(new FarmerInsured());
			}
			ModelAndView  view = new ModelAndView("/farmer/farmerCreditReport");
			view.addObject("farmer", farmer);
			view.addObject("members", members);
			view.addObject("loans", loans);
			view.addObject("houses", houses);
			view.addObject("forests", forests);
			view.addObject("breeds",breeds);
			view.addObject("devices",devices);
			view.addObject("balances", balances);
			view.addObject("evaluate", evaluate);
			view.addObject("compunishs", compunishs);
			view.addObject("insureds", insureds);
			return view;
	}
	@RequestMapping(value="/queryApply",method=RequestMethod.GET)
	public ModelAndView queryApply(HttpServletRequest request, 
			HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		String userId = user.getUserId();
		List<Apply> applys = farmerService.findApplyByUser(userId);
		ModelAndView view = new ModelAndView("/farmer/offLineDownLoad");
		view.addObject("applys",applys);
		return view;
	}
	@RequestMapping(value="/offlineApply",method=RequestMethod.POST)
	public ModelAndView offLineApply(HttpServletRequest request, 
			HttpServletResponse response){
		String ids = request.getParameter("farmerIds");
		User user = (User)request.getSession().getAttribute("user");
		Apply apply = new Apply();
		apply.setUserId(user.getUserId());
		apply.setUserName(user.getUserName());
		apply.setApplyType("农户信用报告");
		String applyName =new SimpleDateFormat("yyyyMMddHHmmddss").format(new Date())+"农户信用报告";
		apply.setApplyName(applyName);
		apply.setApplyInfo(ids);
		apply.setApplyTime(new Date());
		farmerService.saveAapply(apply);
		ModelAndView view = new ModelAndView("/farmer/farmerQueryFive");
		view.addObject("msg", "申请成功!");
		return view;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offlineDownload",method=RequestMethod.GET)
	public ModelAndView offLineDownload(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String ids = request.getParameter("farmerIds");
		response.setContentType("application/zip"); 
		String fileName = URLEncoder.encode("农户信用报告","UTF-8");
		response.setHeader("Location",fileName);
		response.setHeader("Content-Disposition", "attachment; filename="+fileName+".zip");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ZipOutputStream   zop = new  ZipOutputStream(bout);
		zop.setEncoding("GBK");
		if(!StringUtils.isEmpty(ids)){
			String[] fds = ids.split(",");
			for(String fId:fds){
				Long farmerId = Long.valueOf(fId);
				Map map = farmerService.loadFarmer(farmerId);
				Farmer farmer = (Farmer)map.get("farmer");
				List<FarmerMember> members = (List<FarmerMember>)map.get("members");
				List<FarmerPay> balances = (List<FarmerPay>)map.get("balances");
				List<FarmerHouse> houses = (List<FarmerHouse>)map.get("houses");
				List<FarmerBreed> breeds = (List<FarmerBreed>)map.get("breeds");
				List<FarmerForest> forests =(List<FarmerForest>) map.get("forests");
				List<FarmerDevice> devices = (List<FarmerDevice>) map.get("devices");
				List<Loan> loans = (List<Loan>) map.get("loans");
				List<FarmerCompunish> compunishs = (List<FarmerCompunish>)map.get("compunishs");
				List<FarmerInsured> insureds = (List<FarmerInsured>)map.get("insureds");
				FarmerEvaluate evaluate = (FarmerEvaluate)map.get("evaluate");
				if(balances.size() == 0){
					balances.add(new FarmerPay());
				}
				if(houses.size() == 0){
					houses.add(new FarmerHouse());
				}
				if(breeds.size() == 0){
					breeds.add(new FarmerBreed());
				}
				if(houses.size() == 0){
					houses.add(new FarmerHouse());
				}
				if(devices.size() == 0){
					devices.add(new FarmerDevice());
				}
				if(loans.size() ==0){
					loans.add(new Loan());
				}
				if(evaluate == null){
					evaluate = new FarmerEvaluate();
				}
				String tplPath = "/template/农户信用报告.docx";
				InputStream in =FarmerController.class.getResourceAsStream(tplPath);
				XWPFDocument doc = new XWPFDocument(in);
				List<XWPFTable> tables  = doc.getTables();
				XWPFTable t0 = tables.get(0);
				XWPFTableRow r1 = t0.createRow();
				addTableCell(r1,0,"户主");
				addTableCell(r1,1,farmer.getFarmerName());
				addTableCell(r1,2,Dictionary.translate("sex",String.valueOf(farmer.getSex())));
				addTableCell(r1,3,farmer.getFarmerIdnum());
				addTableCell(r1,4,Dictionary.translate("marrystatus", String.valueOf(farmer.getMarryStatus())));
				addTableCell(r1,5,Dictionary.translate("education", String.valueOf(farmer.getEducation())));
				addTableCell(r1,6,farmer.getPhone());
				addTableCell(r1,7,farmer.getAddress());
				for(Iterator<FarmerMember> it = members.iterator();it.hasNext();){
					FarmerMember member = it.next();
					XWPFTableRow r = t0.createRow();
					addTableCell(r,0,Dictionary.translate("relation",String.valueOf(member.getRelation())));
					addTableCell(r,1,member.getName());
					addTableCell(r,2,Dictionary.translate("sex",String.valueOf(member.getSex())));
					addTableCell(r,3,farmer.getFarmerIdnum());
					addTableCell(r,4,Dictionary.translate("marrystatus",member.getMarryStatus()));
					addTableCell(r,5,Dictionary.translate("education",String.valueOf(member.getEducation())));
					addTableCell(r,6,member.getPhone());
					addTableCell(r,7,member.getAddress());
				}
				XWPFTable t1= tables.get(1);
				for(Iterator<FarmerPay> it = balances.iterator();it.hasNext();){
					FarmerPay balance = it.next();
					XWPFTableRow r = t1.createRow();
					addTableCell(r,0,balance.getYear());
					addTableCell(r,1,String.valueOf(balance.getTotalIncome()));
					addTableCell(r,2,String.valueOf(balance.getTotalPay()));
				}
				XWPFTable t2= tables.get(2);
				for(int i=0;i<houses.size();i++){
					String index=String.valueOf(i+1);
					FarmerHouse house = houses.get(i);
					XWPFTableRow r = t2.createRow();
					addTableCell(r,0,house.getId()==null?"":index);
					addTableCell(r,0,house.getHouseProperty());
					addTableCell(r,1,house.getHouseType());
					addTableCell(r,2,house.getHouseAddress());
					addTableCell(r,3,house.getBuildDate());
					addTableCell(r,4,house.getBuildArea());
				}
				XWPFTable t3= tables.get(3);
				for(int i = 0;i<breeds.size();i++){
					String index = String.valueOf(i+1);
					FarmerBreed breed = breeds.get(i);
					XWPFTableRow r = t3.createRow();
					addTableCell(r,0,breed.getId() ==null?"":index);
					addTableCell(r,0,breed.getVariety());
					addTableCell(r,1,breed.getFloorArea());
					addTableCell(r,2,breed.getOutput());
					addTableCell(r,3,breed.getAssessPrice());
				}
				XWPFTable t4= tables.get(4);
				for(Iterator<FarmerForest> it = forests.iterator();it.hasNext();){
					FarmerForest forest = it.next();
					XWPFTableRow r = t4.createRow();
					addTableCell(r,0,forest.getId() == null?"":"林权");
					addTableCell(r,1,forest.getArea());
					addTableCell(r,2,forest.getStoreNum());
					addTableCell(r,3,forest.getArea());
				}
				XWPFTable t5= tables.get(5);
				for(Iterator<FarmerDevice> it = devices.iterator();it.hasNext();){
					FarmerDevice device = it.next();
					XWPFTableRow r = t5.createRow();
					addTableCell(r,0,device.getId() == null?"":"1");
					addTableCell(r,1,device.getName());
					addTableCell(r,2,device.getBrand());
					addTableCell(r,3,device.getBuyingDate());
					addTableCell(r,4,device.getBuyingPrice());
					addTableCell(r,4,device.getAssessPrice());
				}
				XWPFTable t6=tables.get(6);
				XWPFTable t7=tables.get(7);
				XWPFTable t8=tables.get(8);
				for(int i=0;i<loans.size();i++){
					Loan loan = loans.get(i);
					XWPFTableRow r6 = t6.createRow();
					XWPFTableRow r7 = t7.createRow();
					XWPFTableRow r8 = t8.createRow();
					addTableCell(r6,0,loan.getId() == null?"":"1");
					addTableCell(r6,1,loan.getOrganName());
					addTableCell(r6,2,loan.getBusinessType());
					addTableCell(r6,3,loan.getLoanUse());
					addTableCell(r6,4,"");
					addTableCell(r6,5,loan.getLoanDate());
					addTableCell(r6,6,loan.getLimitDate());
					
					addTableCell(r7,0,loan.getId() == null?"":"1");
					addTableCell(r7,1,loan.getBalance());
					addTableCell(r7,2,loan.getGuaranteeType());
					
					addTableCell(r8,0,loan.getId() == null?"":"1");
					addTableCell(r8,1,loan.getClientName());
					addTableCell(r8,2,loan.getClientNum());
				}
				XWPFTable t9=tables.get(9);
				for(int i = 0;i<compunishs.size();i++){
					 FarmerCompunish compunish  =compunishs.get(0);
					 XWPFTableRow r9 = t9.createRow();
					 addTableCell(r9,0,compunish.getId() == null?"":"1");
					 addTableCell(r9,1,compunish.getOrgan());
					 addTableCell(r9,2,compunish.getDetail());
				}
				XWPFTable t10=tables.get(10);
				for(int i = 0;i<insureds.size();i++){
					 FarmerInsured insured  =insureds.get(0);
					 XWPFTableRow r10 = t10.createRow();
					 addTableCell(r10,0,insured.getId() == null?"":"1");
					 addTableCell(r10,1,insured.getType());
					 addTableCell(r10,2,String.valueOf(insured.getAmount()));
					 String date = new SimpleDateFormat("yyyy-mm-dd").format(insured.getInsureTime());
					 addTableCell(r10,3,date);
				}
				XWPFTable t12=tables.get(12);
				XWPFTableRow r12 = t12.createRow();
				addTableCell(r12,0,Dictionary.translate("evaluate",evaluate.getHarmonyStatus()));
				addTableCell(r12,1,Dictionary.translate("evaluate",evaluate.getRespectStatus()));
				addTableCell(r12,2,Dictionary.translate("evaluate",evaluate.getNeighborStatus()));
				addTableCell(r12,3,Dictionary.translate("yesorno",String.valueOf(evaluate.getLegalStatus())));
				addTableCell(r12,4,Dictionary.translate("evaluate",evaluate.getWelfareStatus()));
				addTableCell(r12,5,Dictionary.translate("yesorno",String.valueOf(evaluate.getHonestStatus())));
				File f = new File(FarmerController.class.getResource("/temp").getPath()
						+"/信用报告/"+farmer.getFarmerName()+".docx");
				OutputStream fout = new FileOutputStream(f);
				doc.write(fout);
				fout.flush();
				fout.close();
				fout = null;
			}
			File f = new File(FarmerController.class.getResource("/temp").getPath()+"/信用报告/");
			File[] files =f.listFiles();
			for(File file:files){
				zop.putNextEntry(new ZipEntry(file.getName()));
				FileInputStream in = new FileInputStream(file);  
				int len;
				while ((len = in.read()) != -1){
					zop.write(len);
				}
				zop.closeEntry();
				in.close();
			}
			zop.close();
			OutputStream out = response.getOutputStream();
			out.write(bout.toByteArray());
			out.flush();
			out.close();
			out = null;
		}
		return null;
	}
	@RequestMapping(value="/queryFarmer",method=RequestMethod.POST)
	public ModelAndView queryFarmer(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, 
			HttpServletResponse response) throws Exception{
		/*查询条件
		
		if(StringUtils.isEmpty(farmerIdNum) && StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后查询!");
			return  view;
		}*/
	    List<Farmer> farmers= farmerService.findByIDAndName(farmerIdNum, farmerName);
	    if(farmers.size()== 0){
	    	ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
	    	view.addObject("farmerName",farmerName);
		    view.addObject("farmerIdNum",farmerIdNum);
			view.addObject("msg", "未找到符合条件的农户信息!");
			return  view;
	    }else{
		    ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
		    view.addObject("farmerName",farmerName);
		    view.addObject("farmerIdNum",farmerIdNum);
		    view.addObject("farmers",farmers);
			return view;
	    }
	}
	@RequestMapping(value="/queryFarmer1",method=RequestMethod.POST)
	public ModelAndView queryFarmer1(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, 
			HttpServletResponse response) throws Exception{
		/*查询条件
		
		if(StringUtils.isEmpty(farmerIdNum) && StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后查询!");
			return  view;
		}*/
	    List<Farmer> farmers= farmerService.findByIDAndName(farmerIdNum, farmerName);
	    if(farmers.size()== 0){
	    	ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView1");
	    	view.addObject("farmerName",farmerName);
		    view.addObject("farmerIdNum",farmerIdNum);
			view.addObject("msg", "未找到符合条件的农户信息!");
			return  view;
	    }else{
		    ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView1");
		    view.addObject("farmerName",farmerName);
		    view.addObject("farmerIdNum",farmerIdNum);
		    view.addObject("farmers",farmers);
			return view;
	    }
	}
	@RequestMapping(value="/typeInFarmer",method=RequestMethod.POST)
	public ModelAndView typeInFarmer(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, 
			HttpServletResponse response) throws Exception{
		//查询条件
		if(StringUtils.isEmpty(farmerIdNum) || StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后录入农户信息!");
			return  view;
		}
	    Farmer farmer= farmerService.findById(farmerIdNum);
	    List<FarmerMember> members = new ArrayList<FarmerMember>();
	    if(farmer == null){
	    	farmer= new Farmer();
	    	farmer.setFarmerName(farmerName);
	    	farmer.setFarmerIdnum(farmerIdNum);
	    }else{
	    	members = farmerService.findMemberByFarmer(farmer.getId());
	    }
	    if(members.size() == 0 ){
	    	members.add(new FarmerMember());
	    }
		ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoForm");
		view.addObject("farmer",farmer);
		view.addObject("members",members);
		return view;
	}
	@RequestMapping(value="/typeInFarmer1",method=RequestMethod.POST)
	public ModelAndView typeInFarmer1(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, 
			HttpServletResponse response) throws Exception{
		//查询条件
		if(StringUtils.isEmpty(farmerIdNum) || StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后录入农户信息!");
			return  view;
		}
	    Farmer farmer= farmerService.findById(farmerIdNum);
	    List<FarmerMember> members = new ArrayList<FarmerMember>();
	    if(farmer == null){
	    	farmer= new Farmer();
	    	farmer.setFarmerName(farmerName);
	    	farmer.setFarmerIdnum(farmerIdNum);
	    	farmerService.save(farmer);
	    }else{
	    	ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "请您填写完农户姓名和身份证号码后录入农户信息!");
			return  view;
	    }
	    if(members.size() == 0 ){
	    	members.add(new FarmerMember());
	    }
		ModelAndView view = new ModelAndView("/common/bankBuilding");
		view.addObject("farmer",farmer);
		view.addObject("members",members);
		return view;
	}
	private void addTableCell(XWPFTableRow row,int index,String value){
		XWPFTableCell c1 = row.getCell(index);	
		c1.setVerticalAlignment(XWPFVertAlign.CENTER);
		XWPFParagraph p1 = c1.addParagraph();
		XWPFRun r1 = p1.insertNewRun(0);
		r1.setText(value);
	}
}
