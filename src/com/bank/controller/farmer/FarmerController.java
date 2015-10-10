package com.bank.controller.farmer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Apply;
import com.bank.beans.Dictionary;
import com.bank.beans.Evaluate;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerBreedExample;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerCompunishExample;
import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerEvaluateExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.bank.beans.FarmerLoanExample;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerPayExample;
import com.bank.beans.FarmerPrivateLending;
import com.bank.beans.FarmerPrivateLendingExample;
import com.bank.beans.FarmerTotal;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.DicExplain;
import com.bank.beans.enums.FarmerBZEnum;
import com.bank.beans.enums.FarmerNSEnum;
import com.bank.beans.enums.FarmerNYEnum;
import com.bank.beans.enums.FarmerPoorEnum;
import com.bank.service.IFarmerBreedService;
import com.bank.service.IFarmerCompunishService;
import com.bank.service.IFarmerCreditService;
import com.bank.service.IFarmerDeviceService;
import com.bank.service.IFarmerEvaluateService;
import com.bank.service.IFarmerForestService;
import com.bank.service.IFarmerHouseService;
import com.bank.service.IFarmerInsuredService;
import com.bank.service.IFarmerMemberService;
import com.bank.service.IFarmerPayService;
import com.bank.service.IFarmerPrivateLendingService;
import com.bank.service.IFarmerService;
import com.bank.service.IFarmerLoanService;
import com.bank.utils.ParseDataUtils;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerController   {
	
	@Resource
	private IFarmerService farmerService;
	@Resource
	private IFarmerMemberService memberService;
	@Resource
	private IFarmerHouseService houseService;
	@Resource
	private IFarmerForestService forestService;
	@Resource
	private IFarmerBreedService breedService;
	@Resource
	private IFarmerDeviceService deviceService;
	@Resource
	private IFarmerPayService balanceService;
	@Resource
	private IFarmerLoanService loanService;
	@Resource
	private IFarmerPrivateLendingService lendingService;
	@Resource
	private IFarmerInsuredService insuredService;
	@Resource
	private IFarmerCreditService creditService;
	@Resource
	private IFarmerEvaluateService evaluateService;
	@Resource
	private IFarmerCompunishService compunishService;
	
	private Log log = LogFactory.getLog(FarmerController.class);
	
	@RequestMapping(value = "/saveFarmer1",method = RequestMethod.POST)
	public ModelAndView saveFarmer1(@ModelAttribute(value="farmer") Farmer farmer,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(farmer.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				farmer.setSourcecode(organ.getOrganNo());
				farmer.setSourcename(organ.getOrganName());
				farmer.setRunitid(organ.getOrganId());
				farmer.setRunitname(organ.getOrganName());
				farmerService.save(farmer);
			}else{
				farmerService.updateBySelective(farmer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerForm");
		view.addObject("farmer", farmer);
		return view;
		
	}
	@RequestMapping(value = "/loadFarmer", method = RequestMethod.GET)
	public ModelAndView loadFarmer(@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception {
		/*閺屻儴顕楃粔宥囪1閵嗕焦瀵滄稉濠氭暛閺屻儴顕� 2閵嗕焦瀵滄慨鎾虫倳閺屻儴顕� 3閵嗕焦瀵滈煬顐″敜鐠囦焦鐓＄拠锟� 4閵嗕焦瀵滄慨鎾虫倳閸滃矁闊╂禒鍊熺槈閺屻儴顕�*/
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
			HttpServletResponse response){
		/*閺屻儴顕楃粔宥囪1閵嗕焦瀵滄稉濠氭暛閺屻儴顕� 2閵嗕焦瀵滄慨鎾虫倳閺屻儴顕� 3閵嗕焦瀵滈煬顐″敜鐠囦焦鐓＄拠锟� 4閵嗕焦瀵滄慨鎾虫倳閸滃矁闊╂禒鍊熺槈閺屻儴顕�*/
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Long farmerId = Long.valueOf(id);
		Farmer farmer = null;
		List<FarmerMember> members = null;
		try {
			farmer = farmerService.findByPK(farmerId);
			members= farmerService.findMemberByFarmer(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(members.size() == 0){
			members = new ArrayList<FarmerMember>();
			members.add(new FarmerMember());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerForm");
		view.addObject("farmer", farmer);
		view.addObject("members", members);
		return view;	  
	}
	@RequestMapping(value = "/loadPoorFarmer", method = RequestMethod.GET)
	public ModelAndView loadPoorFarmer(@RequestParam(value="id") Long id,
			HttpServletResponse response){
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerPoorForm");
		view.addObject("farmer", farmer);
		return view;	  
	}
	@RequestMapping(value = "/loadFarmerTotal", method = RequestMethod.GET)
	public ModelAndView loadFarmerTotal(@RequestParam(value="farmeridnum") String farmerIdNum,
			HttpServletResponse response) {
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fc = fe.createCriteria();
		fc.andFarmeridnumEqualTo(farmerIdNum);
		List<Farmer> farmers =farmerService.selectByExample(fe);
		
		FarmerMemberExample ee = new FarmerMemberExample();
		FarmerMemberExample.Criteria ec = ee.createCriteria();
		ec.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerMember> members = memberService.selectByExample(ee);
		
		FarmerLoanExample le = new FarmerLoanExample();
		FarmerLoanExample.Criteria lc = le.createCriteria();
		lc.andIdnumEqualTo(farmerIdNum);
		List<FarmerLoan> loans = loanService.selectByExample(le);

		FarmerPrivateLendingExample fple = new FarmerPrivateLendingExample();
		FarmerPrivateLendingExample.Criteria fplec = fple.createCriteria();
		fplec.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerPrivateLending> privatelendings = lendingService.selectByExample(fple);
		
		FarmerHouseExample he = new FarmerHouseExample();
		FarmerHouseExample.Criteria hc = he.createCriteria();
		hc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerHouse> houses =  houseService.selectByExample(he);
		
		FarmerForestExample ffe = new FarmerForestExample();
		FarmerForestExample.Criteria ffc = ffe.createCriteria();
		ffc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerForest> forests = forestService.selectByExample(ffe);
		
		FarmerBreedExample be = new FarmerBreedExample();
		FarmerBreedExample.Criteria bc = be.createCriteria();
		bc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerBreed> breeds = breedService.selectByExample(be);
		
		FarmerDeviceExample de = new FarmerDeviceExample();
		FarmerDeviceExample.Criteria dc = de.createCriteria();
		dc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerDevice> devices = deviceService.selectByExample(de);
	
		FarmerPayExample pe = new FarmerPayExample();
		FarmerPayExample.Criteria pc = pe.createCriteria();
		pc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerPay> balances = balanceService.selectByExample(pe);
		
		FarmerCompunishExample ce = new FarmerCompunishExample();
		FarmerCompunishExample.Criteria cc = ce.createCriteria();
		cc.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerCompunish> compunishs = compunishService.selectByExample(ce);
		
		FarmerInsuredExample ie = new FarmerInsuredExample();
		FarmerInsuredExample.Criteria ic = ie.createCriteria();
		ic.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerInsured> insureds = insuredService.selectByExample(ie);
		
		FarmerEvaluateExample fee = new FarmerEvaluateExample();
		FarmerEvaluateExample.Criteria fec = fee.createCriteria();
		fec.andFarmeridnumEqualTo(farmerIdNum);
		List<FarmerEvaluate> evaluates = evaluateService.selectByExample(fee);
		
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		if(loans.size() == 0){
			loans.add(new FarmerLoan());
		}
		if(privatelendings.size()==0){
			privatelendings.add(new FarmerPrivateLending());
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
		if(evaluates.size() == 0){
			evaluates.add(new FarmerEvaluate());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
		view.addObject("farmers", farmers);
		view.addObject("members", members);
		view.addObject("loans", loans);
		view.addObject("privatelendings",privatelendings);
		view.addObject("houses", houses);
		view.addObject("forests", forests);
		view.addObject("breeds",breeds);
		view.addObject("devices",devices);
		view.addObject("balances", balances);
		view.addObject("evaluates", evaluates);
		view.addObject("compunishs", compunishs);
		view.addObject("insureds", insureds);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/queryFarmerOne",method=RequestMethod.POST)
	public ModelAndView queryFarmerOne(@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		String farmerName = request.getParameter("farmerName");
		String farmerIdNum= request.getParameter("farmerIdNum");
		farmerName = StringUtils.isEmpty(farmerName)?null:farmerName;
		farmerIdNum = StringUtils.isEmpty(farmerIdNum)?null:farmerIdNum;
		Map paramMap = new HashMap();
		paramMap.put("farmername", farmerName);
		paramMap.put("farmeridnum",  farmerIdNum);
		int totalNumber = 0; 
		List<Farmer> farmers = null;
		try {
			totalNumber = farmerService.findTotalNumber(paramMap);
			farmers = farmerService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", farmers);
	    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	@RequestMapping(value="/loadFarmerTwo",method=RequestMethod.POST)
	public ModelAndView loadFarmerTwo(MultipartFile myfile,HttpServletRequest request, 
			HttpServletResponse response){
		try {
			InputStream in=myfile.getInputStream();
			String[][] datas= null;
			 if( myfile.getOriginalFilename().endsWith(".xls")){
				 datas = ParseDataUtils.readXls(in, 0);
			 }else{
				 datas = ParseDataUtils.readXlsx(in, 0);
			 }
			List<String> farmerNames = new ArrayList<String>();
			for(String[] data:datas){
				farmerNames.add(data[0]);
			}
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria  fc = fe.createCriteria();
			fc.andFarmernameIn(farmerNames);
			List<Farmer> farmers = farmerService.selectSignalByExample(fe);
			ModelAndView view = new ModelAndView("/farmer/farmerQueryTwo");
			view.addObject("farmers",farmers);
			return view;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadFarmerTwoTotal", method = RequestMethod.GET)
	public ModelAndView loadFarmerTwoTotal(@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) {
		FarmerTotal total = farmerService.getFarmerTotal(farmerIdNum);
		List<Farmer> farmers = total.getFarmers();
		List<FarmerMember> members = total.getMembers();
		List<FarmerLoan> loans = total.getLoans();
		List<FarmerHouse> houses = total.getHouses();
		List<FarmerForest> forests = total.getForests();
		List<FarmerBreed> breeds = total.getBreeds();
		List<FarmerDevice> devices = total.getDevices();
		List<FarmerCompunish> compunishs = total.getCompunishs();
		List<FarmerPay> balances = total.getBalances();
		List<FarmerInsured> insureds = total.getInsureds();
		List<FarmerEvaluate> evaluates = total.getEvaluates();
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		if(loans.size() == 0){
			loans.add(new FarmerLoan());
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
		if(evaluates.size() == 0){
			evaluates.add(new FarmerEvaluate());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
		view.addObject("farmers", farmers);
		view.addObject("members", members);
		view.addObject("loans", loans);
		view.addObject("houses", houses);
		view.addObject("forests", forests);
		view.addObject("breeds",breeds);
		view.addObject("devices",devices);
		view.addObject("balances", balances);
		view.addObject("evaluates", evaluates);
		view.addObject("compunishs", compunishs);
		view.addObject("insureds", insureds);
		return view;	  
	}
	@RequestMapping(value="/loadFarmerThree",method=RequestMethod.POST)
	public ModelAndView loadFarmerThree(HttpServletRequest request, 
			HttpServletResponse response){
	     int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
	     int pageSize = Integer.valueOf(request.getParameter("pageSize"));        
	     String sortField = request.getParameter("sortField");
	     String sortOrder = request.getParameter("sortOrder");
		 String organName = request.getParameter("organName");
		 String loanDate1 = request.getParameter("loanDate1");
		 String loanDate2 = request.getParameter("loanDate2");
		 String amount1 = request.getParameter("amount1");
		 String amount2 = request.getParameter("amount2");
		 String balance1 = request.getParameter("balance1");
		 String balance2 = request.getParameter("balance2");
		
		 if(StringUtils.isEmpty(organName) && StringUtils.isEmpty(loanDate1) 
				 && StringUtils.isEmpty(loanDate2) && StringUtils.isEmpty(balance1)
				 && StringUtils.isEmpty(loanDate2)){
			 return null;
			 
		 }
		 FarmerLoanExample le = new FarmerLoanExample();
		 FarmerLoanExample.Criteria lc = le.createCriteria();
		 if(!StringUtils.isEmpty(organName)){
			 lc.andOrgannameLike(organName);
		 }
		 if(!StringUtils.isEmpty(loanDate1)){
			 lc.andLoandateGreaterThanOrEqualTo(loanDate1);
		 }
		 if(!StringUtils.isEmpty(loanDate2)){
			 lc.andLoandateLessThanOrEqualTo(loanDate2);
		 }
		 if(!StringUtils.isEmpty(amount1)){
			 lc.andAmountGreaterThanOrEqualTo(amount1);
		 }
		 if(!StringUtils.isEmpty(amount2)){
			 lc.andAmountLessThanOrEqualTo(amount2);
		 }
		 if(!StringUtils.isEmpty(balance1)){
			 lc.andAmountGreaterThanOrEqualTo(balance1);
		 }
		 if(!StringUtils.isEmpty(balance2)){
			 lc.andAmountLessThanOrEqualTo(balance2);
		 }
		 List<FarmerLoan> loans = loanService.selectByExample(le);
		 List<Long> farmerIds = new ArrayList<Long>();
		 for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
			 FarmerLoan loan = it.next();
			 farmerIds.add(loan.getFarmerid());
		 }
		 FarmerExample fe = new FarmerExample();
		 FarmerExample.Criteria fc = fe.createCriteria();
		 fc.andFarmeridIn(farmerIds);
		List<Farmer> farmers = farmerService.selectSignalByExample(fe);
		String json = JSON.toJSONStringWithDateFormat(farmers,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.write(json);
		writer.flush();
		return null;
	}
	@RequestMapping(value = "/loadFarmerThreeTotal", method = RequestMethod.GET)
	public ModelAndView loadFarmerThreeTotal(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) {
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fc = fe.createCriteria();
		fc.andFarmernameEqualTo(farmerName);
		fc.andFarmeridnumEqualTo(farmerIdNum);
		List<Farmer> farmers =farmerService.selectByExample(fe);
		List<Long> farmerIds = new ArrayList<Long>(farmers.size());
		if(farmers.size() == 0){
			ModelAndView view =  new ModelAndView("/farmer/farmerQueryThree");
			view.addObject("msg", "閺堫亝澹橀崚鏉垮爱闁板秶娈戦崘婊勫煕娣団剝浼�!閹劌褰叉禒銉ュ煂閵嗘劕鍟橀幋鏋拷锟�-閵嗘劖鏆熼幑顕�鍣伴梿鍡愶拷锟�-閵嗘劕鐔�閺堫兛淇婇幁顖橈拷鎴災侀崸妞捐厬瑜版洖鍙嗛崘婊勫煕娣団剝浼呴崥搴″晙瑜版洖鍙嗛崘婊勫煕閻ㄥ嫯绁禍褌淇婇幁锟�!");
			return view;
		}
		for(Farmer farmer:farmers){
			farmerIds.add(farmer.getId());
		}
		FarmerMemberExample ee = new FarmerMemberExample();
		FarmerMemberExample.Criteria ec = ee.createCriteria();
		ec.andFarmeridIn(farmerIds);
		List<FarmerMember> members = memberService.selectByExample(ee);
		
		FarmerLoanExample le = new FarmerLoanExample();
		FarmerLoanExample.Criteria lc = le.createCriteria();
		lc.andFarmeridIn(farmerIds);
		List<FarmerLoan> loans = loanService.selectByExample(le);

		FarmerHouseExample he = new FarmerHouseExample();
		FarmerHouseExample.Criteria hc = he.createCriteria();
		hc.andFarmeridIn(farmerIds);
		List<FarmerHouse> houses =  houseService.selectByExample(he);
		
		FarmerForestExample ffe = new FarmerForestExample();
		FarmerForestExample.Criteria ffc = ffe.createCriteria();
		ffc.andFarmeridIn(farmerIds);
		List<FarmerForest> forests = forestService.selectByExample(ffe);
		
		FarmerBreedExample be = new FarmerBreedExample();
		FarmerBreedExample.Criteria bc = be.createCriteria();
		bc.andFarmeridIn(farmerIds);
		List<FarmerBreed> breeds = breedService.selectByExample(be);
		
		FarmerDeviceExample de = new FarmerDeviceExample();
		FarmerDeviceExample.Criteria dc = de.createCriteria();
		dc.andFarmeridIn(farmerIds);
		List<FarmerDevice> devices = deviceService.selectByExample(de);
	
		FarmerPayExample pe = new FarmerPayExample();
		FarmerPayExample.Criteria pc = pe.createCriteria();
		pc.andFarmeridIn(farmerIds);
		List<FarmerPay> balances = balanceService.selectByExample(pe);
		
		FarmerCompunishExample ce = new FarmerCompunishExample();
		FarmerCompunishExample.Criteria cc = ce.createCriteria();
		cc.andFarmeridIn(farmerIds);
		List<FarmerCompunish> compunishs = compunishService.selectByExample(ce);
		
		FarmerInsuredExample ie = new FarmerInsuredExample();
		FarmerInsuredExample.Criteria ic = ie.createCriteria();
		ic.andFarmeridIn(farmerIds);
		List<FarmerInsured> insureds = insuredService.selectByExample(ie);
		
		FarmerEvaluateExample fee = new FarmerEvaluateExample();
		FarmerEvaluateExample.Criteria fec = fee.createCriteria();
		fec.andFarmeridIn(farmerIds);
		List<FarmerEvaluate> evaluates = evaluateService.selectByExample(fee);
		
		if(members.size() == 0){
			members.add(new FarmerMember());
		}
		if(loans.size() == 0){
			loans.add(new FarmerLoan());
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
		if(evaluates.size() == 0){
			evaluates.add(new FarmerEvaluate());
		}
		ModelAndView  view = new ModelAndView("/farmer/farmerTotalInfo");
		view.addObject("farmers", farmers);
		view.addObject("members", members);
		view.addObject("loans", loans);
		view.addObject("houses", houses);
		view.addObject("forests", forests);
		view.addObject("breeds",breeds);
		view.addObject("devices",devices);
		view.addObject("balances", balances);
		view.addObject("evaluates", evaluates);
		view.addObject("compunishs", compunishs);
		view.addObject("insureds", insureds);
		return view;	  
	}
	@RequestMapping(value="/loadFarmerFive",method=RequestMethod.POST)
	public ModelAndView loadFarmerFive(@RequestParam(value="farmeridnum") String farmeridnum,
			HttpServletRequest request,HttpServletResponse response){
		
		User user = (User)request.getSession().getAttribute("user");
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fc = fe.createCriteria();
		fc.andFarmeridnumEqualTo(farmeridnum);
		List<Farmer> dbfarmers = farmerService.selectByExample(fe);
		if(dbfarmers.size() == 0){
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFive");
			view.addObject("msg", "没有找到匹配的农户信息!");
			return view;
		}else{
			String farmerids = null;
			for(Farmer farmer:dbfarmers){
				farmerids = farmer.getId()+",";
			}
			Apply apply = new Apply();
			apply.setUserId(user.getUserId());
			apply.setUserName(user.getUserName());
			apply.setApplyType("CreditReport");
			String applyName =new SimpleDateFormat("yyyyMMddHHmmddss").format(new Date())+"信用报告";
			apply.setApplyName(applyName);
			apply.setApplyInfo(farmerids);
			apply.setApplyTime(new Date());
			farmerService.saveAapply(apply);
			ModelAndView view = new ModelAndView("/farmer/farmerQueryFive");
			view.addObject("msg", "申请成功,您可以一天后下载信用报告!");
			return view;
		}
	}
	
	@RequestMapping(value = "/loadFarmerFour", method = RequestMethod.POST)
	public ModelAndView loadFarmerFour(@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response){
		
			List<Date> birthDate = new ArrayList<Date>();
			List<Integer> sex = new ArrayList<Integer>();
			List<Integer> laborNum = new ArrayList<Integer>();
			List<String> marryStatuies = new ArrayList<String>();
		    List<Double> totalIncomes = new ArrayList<Double>();
			List<Double> totalPays = new ArrayList<Double>();
			List<String> loanStatus = new ArrayList<String>();
			List<Integer> commandStatus = new ArrayList<Integer>();
			List<String> evaluateStatus = new ArrayList<String>();
			List<String> creditStatus = new ArrayList<String>();
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(farmerIdNum);
			List<Farmer> farmers = farmerService.selectByExample(fe);
			for(Farmer farmer:farmers){
				birthDate.add(farmer.getBirthdate());
				sex.add(farmer.getSex());
				laborNum.add(farmer.getLabornum());
				marryStatuies.add(farmer.getMarrystatus());
			}
			FarmerMemberExample ee = new FarmerMemberExample();
			FarmerMemberExample.Criteria ec = ee.createCriteria();
			ec.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerMember> members = memberService.selectByExample(ee);
			
			FarmerLoanExample le = new FarmerLoanExample();
			FarmerLoanExample.Criteria lc = le.createCriteria();
			lc.andIdnumEqualTo(farmerIdNum);
			List<FarmerLoan> loans = loanService.selectByExample(le);
			for(FarmerLoan loan:loans){
				loanStatus.add(loan.getGrade());
			}
			FarmerHouseExample he = new FarmerHouseExample();
			FarmerHouseExample.Criteria hc = he.createCriteria();
			hc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerHouse> houses =  houseService.selectByExample(he);
			
			FarmerForestExample ffe = new FarmerForestExample();
			FarmerForestExample.Criteria ffc = ffe.createCriteria();
			ffc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerForest> forests = forestService.selectByExample(ffe);
			
			FarmerBreedExample be = new FarmerBreedExample();
			FarmerBreedExample.Criteria bc = be.createCriteria();
			bc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerBreed> breeds = breedService.selectByExample(be);
			
			FarmerDeviceExample de = new FarmerDeviceExample();
			FarmerDeviceExample.Criteria dc = de.createCriteria();
			dc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerDevice> devices = deviceService.selectByExample(de);
		
			FarmerPayExample pe = new FarmerPayExample();
			FarmerPayExample.Criteria pc = pe.createCriteria();
			pc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerPay> balances = balanceService.selectByExample(pe);
			List<FarmerPay> leatestBalances = balanceService.findLatestByFarmer(farmerIdNum);
			for(FarmerPay balance:leatestBalances){
				totalIncomes.add(balance.getTotalincome());
				totalPays.add(balance.getTotalpay());
			}
			FarmerCompunishExample ce = new FarmerCompunishExample();
			FarmerCompunishExample.Criteria cc = ce.createCriteria();
			cc.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerCompunish> compunishs = compunishService.selectByExample(ce);
			cc.andTypeEqualTo(1);
			List<FarmerCompunish> commands = compunishService.selectByExample(ce);
			for(FarmerCompunish command :commands){
				commandStatus.add(command.getCompunishlevel());
			}
			FarmerInsuredExample ie = new FarmerInsuredExample();
			FarmerInsuredExample.Criteria ic = ie.createCriteria();
			ic.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerInsured> insureds = insuredService.selectByExample(ie);
			
			FarmerCreditExample fce = new FarmerCreditExample();
			FarmerCreditExample.Criteria fcec = fce.createCriteria();
			fcec.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerCredit> credits = creditService.selectByExample(fce);
			for(FarmerCredit credit:credits){
				creditStatus.add(credit.getAssessrank());
			}
			FarmerEvaluateExample fee = new FarmerEvaluateExample();
			FarmerEvaluateExample.Criteria fec = fee.createCriteria();
			fec.andFarmeridnumEqualTo(farmerIdNum);
			List<FarmerEvaluate> evaluates = evaluateService.selectByExample(fee);
			for(FarmerEvaluate evaluate:evaluates){
				evaluateStatus.add(evaluate.getPersonality());
			}
			if(members.size() == 0){
				members.add(new FarmerMember());
			}
			if(loans.size() == 0){
				loans.add(new FarmerLoan());
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
			if(credits.size() == 0){
				credits.add(new FarmerCredit());
			}
			if(evaluates.size() == 0){
				evaluates.add(new FarmerEvaluate());
			}
			Evaluate evaluate = new Evaluate(birthDate,sex,laborNum,marryStatuies,totalIncomes,totalPays,loanStatus,commandStatus,evaluateStatus,creditStatus);
			String level = evaluate.cacluate1();
			int score = evaluate.cacluate();
			ModelAndView  view = new ModelAndView("/farmer/farmerCreditReport");
			view.addObject("farmers", farmers);
			view.addObject("members", members);
			view.addObject("loans", loans);
			view.addObject("houses", houses);
			view.addObject("forests", forests);
			view.addObject("breeds",breeds);
			view.addObject("devices",devices);
			view.addObject("balances", balances);
			view.addObject("evaluates", evaluates);
			view.addObject("compunishs", compunishs);
			view.addObject("insureds", insureds);
			view.addObject("credits",credits);
			view.addObject("score",score);
			view.addObject("level",level);
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
		apply.setApplyType("閸愭粍鍩涙穱锛勬暏閹躲儱鎲�");
		String applyName =new SimpleDateFormat("yyyyMMddHHmmddss").format(new Date())+"閸愭粍鍩涙穱锛勬暏閹躲儱鎲�";
		apply.setApplyName(applyName);
		apply.setApplyInfo(ids);
		apply.setApplyTime(new Date());
		farmerService.saveAapply(apply);
		ModelAndView view = new ModelAndView("/farmer/farmerQueryFive");
		view.addObject("msg", "閻㈠疇顕幋鎰!");
		return view;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/offlineDownload",method=RequestMethod.GET)
	public ModelAndView offLineDownload(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		SimpleDateFormat yf = new SimpleDateFormat("yyyy");
		String ids = request.getParameter("farmerIds");
		String fileName = "";
		response.setContentType("application/zip"); 
		response.setCharacterEncoding("GBK");
		response.setHeader("Location",fileName);
		response.setHeader("Content-Disposition", "attachment; filename="+fileName+".zip");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ZipOutputStream   zop = new  ZipOutputStream(bout);
		zop.setEncoding("GBK");
		String tempFile = UUID.randomUUID().toString();
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
				List<FarmerLoan> loans = (List<FarmerLoan>) map.get("loans");
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
					loans.add(new FarmerLoan());
				}
				if(evaluate == null){
					evaluate = new FarmerEvaluate();
				}
				String tplPath = "/template/CreditReport.docx";
				InputStream in =FarmerController.class.getResourceAsStream(tplPath);
				XWPFDocument doc = new XWPFDocument(in);
				List<XWPFTable> tables  = doc.getTables();
				XWPFTable t0 = tables.get(0);
				XWPFTableRow r1 = t0.createRow();
				addTableCell(r1,0,"户主");
				addTableCell(r1,1,farmer.getFarmername());
				addTableCell(r1,2,Dictionary.translate("sex",String.valueOf(farmer.getSex())));
				addTableCell(r1,3,farmer.getFarmeridnum());
				addTableCell(r1,4,Dictionary.translate("marrystatus", String.valueOf(farmer.getMarrystatus())));
				addTableCell(r1,5,Dictionary.translate("education", String.valueOf(farmer.getEducation())));
				addTableCell(r1,6,farmer.getPhone());
				addTableCell(r1,7,farmer.getAddress());
				for(Iterator<FarmerMember> it = members.iterator();it.hasNext();){
					FarmerMember member = it.next();
					XWPFTableRow r = t0.createRow();
					addTableCell(r,0,Dictionary.translate("relation",String.valueOf(member.getRelation())));
					addTableCell(r,1,member.getName());
					addTableCell(r,2,Dictionary.translate("sex",String.valueOf(member.getSex())));
					addTableCell(r,3,farmer.getFarmeridnum());
					addTableCell(r,4,Dictionary.translate("marrystatus",member.getMarrystatus()));
					addTableCell(r,5,Dictionary.translate("education",String.valueOf(member.getEducation())));
					addTableCell(r,6,member.getPhone());
					addTableCell(r,7,member.getAddress());
				}
				XWPFTable t1= tables.get(1);
				for(Iterator<FarmerPay> it = balances.iterator();it.hasNext();){
					FarmerPay balance = it.next();
					XWPFTableRow r = t1.createRow();
					addTableCell(r,0,balance.getYear() == null?null:yf.format(balance.getYear()));
					addTableCell(r,1,balance.getTotalincome()==null?null:String.valueOf(balance.getTotalincome()));
					addTableCell(r,2,balance.getTotalpay()==null?null:String.valueOf(balance.getTotalpay()));
				}
				XWPFTable t2= tables.get(2);
				for(int i=0;i<houses.size();i++){
					String index=String.valueOf(i+1);
					FarmerHouse house = houses.get(i);
					XWPFTableRow r = t2.createRow();
					addTableCell(r,0,house.getId()==null?"":index);
					addTableCell(r,0,house.getHouseproperty());
					addTableCell(r,1,house.getHousetype());
					addTableCell(r,2,house.getHouseaddress());
					addTableCell(r,3,house.getBuilddate());
					addTableCell(r,4,house.getBuildarea());
				}
				XWPFTable t3= tables.get(3);
				for(int i = 0;i<breeds.size();i++){
					String index = String.valueOf(i+1);
					FarmerBreed breed = breeds.get(i);
					XWPFTableRow r = t3.createRow();
					addTableCell(r,0,breed.getId() ==null?"":index);
					addTableCell(r,0,breed.getVariety());
					addTableCell(r,1,breed.getFloorarea());
					addTableCell(r,2,breed.getOutput());
					addTableCell(r,3,String.valueOf(breed.getAssessprice()));
				}
				XWPFTable t4= tables.get(4);
				for(Iterator<FarmerForest> it = forests.iterator();it.hasNext();){
					FarmerForest forest = it.next();
					XWPFTableRow r = t4.createRow();
					addTableCell(r,0,"林权");
					addTableCell(r,1,forest.getArea());
					addTableCell(r,2,forest.getStorenum());
					addTableCell(r,3,forest.getArea());
				}
				XWPFTable t5= tables.get(5);
				for(Iterator<FarmerDevice> it = devices.iterator();it.hasNext();){
					FarmerDevice device = it.next();
					XWPFTableRow r = t5.createRow();
					addTableCell(r,0,device.getId() == null?"":"1");
					addTableCell(r,1,device.getName());
					addTableCell(r,2,device.getBrand());
					addTableCell(r,3,device.getBuyingdate());
					addTableCell(r,4,device.getBuyingprice());
					addTableCell(r,4,device.getAssessprice());
				}
				XWPFTable t6=tables.get(6);
				for(int i=0;i<loans.size();i++){
					FarmerLoan loan = loans.get(i);
					XWPFTableRow r6 = t6.createRow();
					addTableCell(r6,0,loan.getId() == null?"":"1");
					addTableCell(r6,1,loan.getOrganname());
					addTableCell(r6,2,loan.getBusinesstype());
					addTableCell(r6,3,loan.getLoanuse());
					addTableCell(r6,4,loan.getAmount());
					addTableCell(r6,5,null);
					addTableCell(r6,6,loan.getLoandate());
					addTableCell(r6,7,loan.getLimitdate());
					addTableCell(r6,7,loan.getBalance());
				}
				XWPFTable t7=tables.get(7);
				for(int i = 0;i<compunishs.size();i++){
					 FarmerCompunish compunish  =compunishs.get(0);
					 XWPFTableRow r7 = t7.createRow();
					 addTableCell(r7,0,compunish.getId() == null?"":"1");
					 addTableCell(r7,1,compunish.getOrgan());
					 addTableCell(r7,2,compunish.getDetail());
					 addTableCell(r7,3,compunish.getSourcename());
				}
				XWPFTable t8=tables.get(8);
				for(int i = 0;i<insureds.size();i++){
					 FarmerInsured insured  =insureds.get(0);
					 XWPFTableRow r8 = t8.createRow();
					 addTableCell(r8,0,insured.getId() == null?"":"1");
					 addTableCell(r8,1,String.valueOf(insured.getType()));
					 addTableCell(r8,2,String.valueOf(insured.getAmount()));
					 String date = new SimpleDateFormat("yyyy-mm-dd").format(insured.getInsuretime());
					 addTableCell(r8,3,date);
					 addTableCell(r8,4,insured.getSourcename());
				}
				XWPFTable t12=tables.get(9);
				XWPFTableRow r12 = t12.createRow();
				addTableCell(r12,0,Dictionary.translate("evaluate",evaluate.getHarmonystatus()));
				addTableCell(r12,1,Dictionary.translate("evaluate",evaluate.getRespectstatus()));
				addTableCell(r12,2,Dictionary.translate("evaluate",evaluate.getNeighborstatus()));
				addTableCell(r12,3,Dictionary.translate("yesorno",String.valueOf(evaluate.getLegalstatus())));
				addTableCell(r12,4,Dictionary.translate("evaluate",evaluate.getWelfarestatus()));
				addTableCell(r12,5,Dictionary.translate("yesorno",String.valueOf(evaluate.getHoneststatus())));
				String path = FarmerController.class.getResource("/temp").getPath()+tempFile;
				File f = new File(path);
				f.mkdir();
				File f1 = new File(path+"/CreditReport.docx");
				OutputStream fout = new FileOutputStream(f1);
				doc.write(fout);
				fout.flush();
				fout.close();
				fout = null;
			}
			File f = new File(FarmerController.class.getResource("/temp").getPath()+tempFile);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/queryFarmer",method=RequestMethod.POST)
	public ModelAndView queryFarmer(@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		String farmerName = request.getParameter("farmerName");
		String farmerIdNum= request.getParameter("farmerIdNum");
		farmerName = StringUtils.isEmpty(farmerName)?null:farmerName;
		farmerIdNum = StringUtils.isEmpty(farmerIdNum)?null:farmerIdNum;
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		Map paramMap = new HashMap();
		paramMap.put("runitid", organId);
		paramMap.put("farmertype", 0);
		paramMap.put("farmername", farmerName);
		paramMap.put("farmeridnum",  farmerIdNum);
		int totalNumber = 0; 
		List<Farmer> farmers = null;
		try {
			totalNumber = farmerService.findTotalNumber(paramMap);
			farmers = farmerService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", farmers);
	    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/queryPoorFarmer",method=RequestMethod.POST)
	public ModelAndView queryPoorFarmer(@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
	    String farmerIdNum = request.getParameter("farmerIdNum");
		String farmerName = request.getParameter("farmerName");
		farmerIdNum = StringUtils.isEmpty(farmerIdNum)?null:farmerIdNum;
		farmerName = StringUtils.isEmpty(farmerName)?null:farmerName;
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		Map paramMap = new HashMap();
		paramMap.put("runitid", organId);
		paramMap.put("farmertype", 1);
		paramMap.put("farmeridnum",farmerIdNum);
		paramMap.put("farmername", farmerName);
		int totalNumber = 0; 
		List<Farmer> farmers = null;
		try { 
			totalNumber= farmerService.findTotalNumber(paramMap);
			farmers = farmerService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", farmers);
	    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	@RequestMapping(value="/typeInFarmer",method=RequestMethod.POST)
	public ModelAndView typeInFarmer(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum, HttpServletRequest request,
			HttpServletResponse response){
		if(StringUtils.isEmpty(farmerIdNum) || StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			return  view;
		}
		Organ organ =(Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
	    Farmer farmer= farmerService.findById(farmerIdNum,organId);
	    if(farmer != null){
	    	String farmerId  = String.valueOf(farmer.getId());
	    	return loadFarmer1(farmerId,response);
	    }
	    try {
	    	Farmer farmer1 = new Farmer();
	    	farmer1.setFarmeridnum(farmerIdNum);
	    	farmer1.setFarmername(farmerName);
	    	farmer1.setRunitid(organ.getOrganId());
	    	farmer1.setRunitname(organ.getOrganName());
	    	farmer1.setSourcecode(organ.getOrganNo());
	    	farmer1.setSourcename(organ.getOrganName());
			farmerService.save(farmer1);
			 List<FarmerMember> members = new ArrayList<FarmerMember>();
			 members.add(new FarmerMember());
			ModelAndView view = new ModelAndView("/farmer/farmerForm");
			view.addObject("farmer",farmer1);
			return view;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			return  view;
		}
	    
	}
	@RequestMapping(value="/typeInFarmerPoor",method=RequestMethod.POST)
	public ModelAndView typeInFarmerPoor(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,  HttpServletRequest request,
			HttpServletResponse response){
		if(StringUtils.isEmpty(farmerIdNum) || StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerPoorView");
			return  view;
		}
		Organ organ =(Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
	    Farmer farmer= farmerService.findById(farmerIdNum,organId);
	    if(farmer != null){
	    	String farmerId  = String.valueOf(farmer.getId());
	    	return loadFarmer1(farmerId,response);
	    }
	    try {
	    	Farmer farmer1 = new Farmer();
	    	farmer1.setFarmertype(1);
	    	farmer1.setFarmeridnum(farmerIdNum);
	    	farmer1.setFarmername(farmerName);
	    	farmer1.setRunitid(organ.getOrganId());
	    	farmer1.setRunitname(organ.getOrganName());
	    	farmer1.setSourcecode(organ.getOrganNo());
	    	farmer1.setSourcename(organ.getOrganName());
			farmerService.save(farmer1);
			 List<FarmerMember> members = new ArrayList<FarmerMember>();
			 members.add(new FarmerMember());
			ModelAndView view = new ModelAndView("/farmer/farmerPoorForm");
			view.addObject("farmer",farmer1);
			return view;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ModelAndView view = new ModelAndView("/farmer/farmerPoorView");
			return  view;
		}
	    
	}
	private void addTableCell(XWPFTableRow row,int index,String value){
		XWPFTableCell c1 = row.getCell(index);	
		c1.setVerticalAlignment(XWPFVertAlign.CENTER);
		XWPFParagraph p1 = c1.addParagraph();
		XWPFRun r1 = p1.insertNewRun(0);
		r1.setText(value);
	}
	@RequestMapping(value="/importFarmer",method=RequestMethod.POST)
	public ModelAndView importFarmer(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
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
			msgs = importFarmerBZ(organId,organName,recorder,recordTime,data);
		}else if("C3140436000017".equals(sourcecode)){
			msgs = importFarmerNS(organId,organName,recorder,recordTime,data);
		}else if("C1010336005158".equals(sourcecode)){
			msgs = importFarmerNY(organId,organName,recorder,recordTime,data);
		}else if("XGXRMZFFPB".equals(sourcecode)){
			msgs = importFarmerPoor(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] datas){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=1;row<datas.length;row++){
			Farmer farmer  = new  Farmer();
			farmer.setSourcecode("TYCJ");
			farmer.setSourcename("统一采集小组");
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			String farmerName = datas[row][FarmerBZEnum.FARMERNAME.getIndex()];
			farmer.setFarmername(farmerName);
			if(StringUtils.isEmpty(farmerName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"姓名不能为空。");
				continue;
			}
			String farmerIdNum = datas[row][FarmerBZEnum.IDNUM.getIndex()];
			farmer.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行证件号码不能为空。");
				continue;
			}
			String sex = datas[row][FarmerBZEnum.SEX.getIndex()];
			if(StringUtils.isEmpty(sex)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"性别不能为空。");
				continue;
			}else if(DicExplain.explain(DicExplain.$SEX,sex).equals(DicExplain.ERRORCODE)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行性别类型不正确");
				continue;
			}else{
				farmer.setSex(Integer.valueOf(DicExplain.explain(DicExplain.$SEX,sex)));
			}		
			String birth = datas[row][FarmerBZEnum.BIRTHDARY.getIndex()];
			if(StringUtils.isEmpty(birth)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行出生日期不能为空");
				continue;
			}else{
				try {
					farmer.setBirthdate(format.parse(birth));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"行出生日期格式不对");
					continue;
				}
			}
			String marrryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,datas[row][FarmerBZEnum.MARRYSTATUS.getIndex()]);
			farmer.setMarrystatus(marrryStatus);
			farmer.setPhone(datas[row][FarmerBZEnum.PHONE.getIndex()]);
			farmer.setVillages(datas[row][FarmerBZEnum.VILLAGES.getIndex()]);
			String education = DicExplain.explain(DicExplain.$EDUCATION, datas[row][FarmerBZEnum.EDUCATION.getIndex()]);
			farmer.setEducation(Integer.valueOf(education));
			String familyNum = datas[row][FarmerBZEnum.FAMILYNUM.getIndex()];
			farmer.setFamilynum(Integer.valueOf(familyNum));
			String laborNum = datas[row][FarmerBZEnum.LABORNUM.getIndex()];
			farmer.setLabornum(Integer.valueOf(laborNum));
			String postCode = datas[row][FarmerBZEnum.POSTCODE.getIndex()];
			if(!StringUtils.isEmpty(postCode)){
				try{
					farmer.setPostcode(Integer.valueOf(postCode));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"邮政编码不能为字符");
					continue;
				}
			}
			farmer.setAddress(datas[row][FarmerBZEnum.ADDRESS.getIndex()]);
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fec = fe.createCriteria();
			fec.andFarmeridnumEqualTo(farmerIdNum);
			fec.andSourcecodeEqualTo("TYCJ");
			List<Farmer> farmers = farmerService.selectByExample(fe);
			try{
				if(farmers.size()==0){
					farmerService.save(farmer);
				}else if(farmers.size() ==1){
					farmerService.update(farmer);
				}
			}catch(Exception e){
				log.error(e.getMessage());
			}
		}
		return msgs;
		
	}
	private List<Map<String,String>> importFarmerNS(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =2;row<data.length;row++){
			Farmer farmer = new Farmer();
			farmer.setSourcecode("C3140436000017");
			farmer.setSourcename("新干县农村信用合作联社");
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			farmer.setFarmertype(0);
			String farmerName = data[row][FarmerNSEnum.FARMERNAME.getIndex()];
			farmer.setFarmername(farmerName);
			if(StringUtils.isEmpty(farmerName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行姓名不能为空。");
				msgs.add(msg);
				continue;
			}
			if(farmerName.length()>10){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行姓名太长");
				msgs.add(msg);
				continue;
			}
			String farmerIdNum = data[row][FarmerNSEnum.IDNUM.getIndex()];
			farmer.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号码不能为空。");
				msgs.add(msg);
				continue;
			}
			String sex = data[row][FarmerNSEnum.SEX.getIndex()];
			if(StringUtils.isEmpty(sex)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"性别不能为空。");
				msgs.add(msg);
			}else{
				farmer.setSex(Integer.valueOf(DicExplain.explain(DicExplain.$SEX,sex)));
			}
			String education = data[row][FarmerNSEnum.EDUCATION.getIndex()];
			if(!StringUtils.isEmpty(education)){
				education = DicExplain.explain(DicExplain.$EDUCATION,education);
				if(education.equals(DicExplain.ERRORCODE)){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"无法转义的学历类型");
					msgs.add(msg);
					continue;
				}else{
					farmer.setEducation(Integer.valueOf(education));
				}
			}
			String marryStatus = data[row][FarmerNSEnum.MARRYSTATUS.getIndex()];
			if(!StringUtils.isEmpty(marryStatus)){
				marryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,marryStatus);
				if(marryStatus.equals(DicExplain.ERRORCODE)){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"无法转义的婚姻状况类型");
					msgs.add(msg);
					continue;
				}else{
					farmer.setMarrystatus(marryStatus);
				}
				
			}
			farmer.setOccupation(data[row][FarmerNSEnum.OCCUPATION.getIndex()]);
			farmer.setPhone(data[row][FarmerNSEnum.PHONE.getIndex()]);
			String address = data[row][FarmerNSEnum.ADDRESS.getIndex()];
			farmer.setAddress(address);
			String village = DicExplain.explain(DicExplain.$VILLAGE, address);
			farmer.setVillages(village);
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(farmer.getFarmeridnum());
			fc.andSourcecodeEqualTo(farmer.getSourcecode());
			List<Farmer> dbFarmers = farmerService.selectByExample(fe);
			try {
				if(dbFarmers.size() == 0){
					farmerService.save(farmer);
				}else if(dbFarmers.size() ==1 ){
					Farmer dbFarmer = dbFarmers.get(0);
					farmer.setId(dbFarmer.getId());
					farmerService.updateBySelective(farmer);
				}
			} catch (Exception e) {
				log.error("第"+row+"行"+e.getMessage());
			}
			FarmerLoanExample le = new FarmerLoanExample();
			FarmerLoanExample.Criteria lc= le.createCriteria();
			lc.andIdnumEqualTo(farmer.getFarmeridnum());
			lc.andSourcecodeEqualTo("C3140436000017");
			List<FarmerLoan> loans = loanService.selectByExample(le);
			if(loans.size()>0){
				for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
					FarmerLoan loan = it.next();
					loan.setFarmerid(farmer.getId());
					try {
						loanService.update(loan);
					} catch (Exception e) {
						log.error("第"+row+"行"+e.getMessage());
					}
				}
			}	
		}
		return msgs;
	}
	private List<Map<String,String>> importFarmerNY(String organId,String organName,
			String recorder,Date recordTime,String[][] data)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =3;row<data.length;row++){
			Farmer farmer = new Farmer();
			farmer.setSourcecode("C1010336005158");
			farmer.setSourcename("中国农业银行新干县支行");
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			farmer.setFarmertype(0);
			String farmerName = data[row][FarmerNYEnum.FARMERNAME.getIndex()];
			farmer.setFarmername(farmerName);
			if(StringUtils.isEmpty(farmerName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("tip", "info");
				msg.put("msg", "姓名不能为空。");
				msgs.add(msg);
				continue;
			}
			String farmerIdNum = data[row][FarmerNYEnum.IDNUM.getIndex()];
			farmer.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行证件号码不能为空。");
				msgs.add(msg);
				continue;
			}
			
			String sex = data[row][FarmerNYEnum.SEX.getIndex()];
			if(!StringUtils.isEmpty(sex)){
				sex = DicExplain.explain(DicExplain.$SEX,sex);
				if(sex.equals(DicExplain.ERRORCODE)){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "第"+row+"无法转义的性别类型");
					msgs.add(msg);
					continue;
				}else{
					farmer.setSex(Integer.valueOf(sex));
				}
			}
			
			String birthDate = data[row][FarmerNYEnum.BIRTHDATE.getIndex()];
			if(!StringUtils.isEmpty(birthDate)){
				try{
					farmer.setBirthdate(format.parse(birthDate));
				}catch(Exception e){
					Map<String,String> msg = new HashMap<String,String>();
					msg.put("msg", "出生日期必须为时间格式，如：2015-06-12");
					msgs.add(msg);
					continue;
				}
			}
			String education = DicExplain.explain(DicExplain.$EDUCATION,data[row][FarmerNYEnum.EDUCATION.getIndex()]);
			farmer.setEducation(Integer.valueOf(education));
			String marryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,data[row][FarmerNYEnum.MARRYSTATUS.getIndex()]);
			farmer.setMarrystatus(marryStatus);
			String address =data[row][FarmerNYEnum.ADDRESS.getIndex()];
			farmer.setAddress(address);
			String village = DicExplain.explain(DicExplain.$VILLAGE, address);
			farmer.setVillages(village);
			String postCodeStr = data[row][FarmerNYEnum.POSTCODE.getIndex()];
			Integer postCode = null;
			try{
				postCode = StringUtils.isEmpty(postCodeStr)?null:Integer.valueOf(postCodeStr);
			}catch(NumberFormatException e){
			}
			farmer.setPostcode(postCode);
			FarmerExample example = new FarmerExample();
			FarmerExample.Criteria criteria = example.createCriteria();
			criteria.andFarmeridnumEqualTo(farmer.getFarmeridnum());
			criteria.andSourcecodeEqualTo("C1010336005158");
			List<Farmer> dbFarmers = farmerService.selectByExample(example);
			try {
				if(dbFarmers == null||dbFarmers.size() ==0){
					farmerService.save(farmer);
				}else if(dbFarmers.size() == 1){
					Farmer dbFarmer = dbFarmers.get(0);
					farmer.setId(dbFarmer.getId());
					farmerService.updateBySelective(farmer);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			FarmerLoanExample fle = new FarmerLoanExample();
			FarmerLoanExample.Criteria flec = fle.createCriteria();
			flec.andIdnumEqualTo(farmer.getFarmeridnum());
			flec.andSourcecodeEqualTo("C1010336005158");
			List<FarmerLoan> loans = loanService.selectByExample(fle);
			if(loans.size() >0){
				for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
					FarmerLoan loan = it.next();
					loan.setFarmerid(farmer.getId());
					try {
						loanService.update(loan);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				}
			}	
		}
		return msgs;
			
	}
	private List<Map<String,String>> importFarmerPoor(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
	
	List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
	
	for(int row =1;row<data.length;row++){
		Farmer farmer = new Farmer();
		farmer.setSourcecode("XGXRMZFFPB");
		farmer.setSourcename("新干县人民政府扶贫办");
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		farmer.setRecorder(recorder);
		farmer.setRecordtime(recordTime);
		farmer.setFarmertype(1);
		String farmerName = data[row][FarmerPoorEnum.FARMERNAME.getIndex()];
		if(StringUtils.isEmpty(farmerName)){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("tip", "info");
			msg.put("msg", "姓名不能为空。");
			msgs.add(msg);
			continue;
		}
		farmer.setFarmername(farmerName);
		String farmerIdNum = data[row][FarmerPoorEnum.IDNUM.getIndex()];
		if(StringUtils.isEmpty(farmerIdNum)){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("tip", "info");
			msg.put("msg", "证件号码不能为空。");
			msgs.add(msg);
			continue;
		}
		farmer.setFarmeridnum(farmerIdNum);
		String familyNumStr = data[row][FarmerPoorEnum.FAMILYNUM.getIndex()];
		int familyNum = StringUtils.isEmpty(familyNumStr)?0:Integer.valueOf(familyNumStr);
		farmer.setFamilynum(familyNum);
		String averageStr = data[row][FarmerPoorEnum.AVERAGEINCOME.getIndex()];
		double average = StringUtils.isEmpty(averageStr)?0:Double.valueOf(averageStr);
		double netIncome = familyNum*average;
		farmer.setNetincome(netIncome);
		String phone = data[row][FarmerPoorEnum.PHONE.getIndex()];
		farmer.setPhone(phone);
		String bank = data[row][FarmerPoorEnum.BANK.getIndex()];
		farmer.setBank(bank);
		String account = data[row][FarmerPoorEnum.ACCOUNT.getIndex()];
		farmer.setAccount(account);
		String province = data[row][FarmerPoorEnum.PROVINCE.getIndex()];
		String city = data[row][FarmerPoorEnum.CITY.getIndex()];
		String country = data[row][FarmerPoorEnum.COUNTRY.getIndex()];
		String town= data[row][FarmerPoorEnum.TOWN.getIndex()];
		String group = data[row][FarmerPoorEnum.GROUP.getIndex()];
		String address = province+city+country+town+group;
		farmer.setAddress(address);
		String village = DicExplain.explain(DicExplain.$VILLAGE, address);
		farmer.setVillages(village);
		Farmer dbFarmer = farmerService.findById(farmer.getFarmeridnum(),"XGXRMZFFPB");
		try {
			if(dbFarmer == null){
				farmerService.save(farmer);
			}else{
				farmer.setId(dbFarmer.getId());
				farmerService.updateBySelective(farmer);
			}
		} catch (Exception e){
			log.error(e.getMessage());
		}
	}
	return msgs;
	
}

}
