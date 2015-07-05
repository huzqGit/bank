package com.bank.controller.farmer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Apply;
import com.bank.beans.Dictionary;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerBreed;
import com.bank.beans.FarmerBreedExample;
import com.bank.beans.FarmerCompunish;
import com.bank.beans.FarmerCompunishExample;
import com.bank.beans.FarmerDevice;
import com.bank.beans.FarmerDeviceExample;
import com.bank.beans.FarmerEvaluate;
import com.bank.beans.FarmerEvaluateExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.bank.beans.FarmerHouse;
import com.bank.beans.FarmerHouseExample;
import com.bank.beans.FarmerIncome;
import com.bank.beans.FarmerInsured;
import com.bank.beans.FarmerInsuredExample;
import com.bank.beans.FarmerLoanExample;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.bank.beans.FarmerPay;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerPayExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.service.IFarmerBreedService;
import com.bank.service.IFarmerCompunishService;
import com.bank.service.IFarmerDeviceService;
import com.bank.service.IFarmerEvaluateService;
import com.bank.service.IFarmerForestService;
import com.bank.service.IFarmerHouseService;
import com.bank.service.IFarmerInsuredService;
import com.bank.service.IFarmerMemberService;
import com.bank.service.IFarmerPayService;
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
	private IFarmerInsuredService insuredService;
	@Resource
	private IFarmerEvaluateService evaluateService;
	@Resource
	private IFarmerCompunishService compunishService;
	
	@RequestMapping(value = "/saveFarmer1",method = RequestMethod.POST)
	public ModelAndView saveFarmer1(@ModelAttribute(value="farmer") Farmer farmer,
			HttpServletRequest request,HttpServletResponse response){
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		String delMembers = request.getParameter("deleteMember");
		if(!StringUtils.isEmpty(delMembers)){
			String[] members = delMembers.split(",");
			List<Long> mermberIds = new ArrayList<Long>(members.length);
			for(String member:members){
				mermberIds.add(Long.valueOf(member));
			}
			farmerService.deleteMembers(mermberIds);
		}
		try{
			if(farmer.getId() == null){
				farmerService.save(farmer);
			}else{
				farmerService.update(farmer);
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
		ModelAndView  view = new ModelAndView("/farmer/farmerPoorDetailView");
		view.addObject("farmer", farmer);
		return view;	  
	}
	@RequestMapping(value = "/loadFarmerOne", method = RequestMethod.POST)
	public ModelAndView loadFarmerOne(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) {
		/*閺屻儴顕楃粔宥囪1閵嗕焦瀵滄稉濠氭暛閺屻儴顕� 2閵嗕焦瀵滄慨鎾虫倳閺屻儴顕� 3閵嗕焦瀵滈煬顐″敜鐠囦焦鐓＄拠锟� 4閵嗕焦瀵滄慨鎾虫倳閸滃矁闊╂禒鍊熺槈閺屻儴顕�*/
		if(StringUtils.isEmpty(farmerName) && StringUtils.isEmpty(farmerIdNum)){
			ModelAndView  view = new ModelAndView("/farmer/farmerQueryOne");
			view.addObject("msg","鐠囧嘲锝為崘娆愮叀鐠囥垺娼禒锟�!");
			return view;
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fc = fe.createCriteria();
		fc.andFarmernameEqualTo(farmerName);
		fc.andFarmeridnumEqualTo(farmerIdNum);
		List<Farmer> farmers =farmerService.selectByExample(fe);
		List<Long> farmerIds = new ArrayList<Long>(farmers.size());
		if(farmers.size() == 0){
			ModelAndView view =  new ModelAndView("/farmer/farmerQueryOne");
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
	public ModelAndView loadFarmerTwoTotal(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,
			HttpServletResponse response) {
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fc = fe.createCriteria();
		fc.andFarmernameEqualTo(farmerName);
		fc.andFarmeridnumEqualTo(farmerIdNum);
		List<Farmer> farmers =farmerService.selectByExample(fe);
		List<Long> farmerIds = new ArrayList<Long>(farmers.size());
		if(farmers.size() == 0){
			ModelAndView view =  new ModelAndView("/farmer/farmerQueryTwo");
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(farmerIdNum);
		
			List<Farmer> farmers = farmerService.selectByExample(fe);
			List<Long> farmerIds = new ArrayList<Long>(farmers.size());
			if(farmers.size() == 0){
				return null;
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
		response.setContentType("application/zip"); 
		String fileName = URLEncoder.encode("閸愭粍鍩涙穱锛勬暏閹躲儱鎲�","UTF-8");
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
				String tplPath = "/template/閸愭粍鍩涙穱锛勬暏閹躲儱鎲�.docx";
				InputStream in =FarmerController.class.getResourceAsStream(tplPath);
				XWPFDocument doc = new XWPFDocument(in);
				List<XWPFTable> tables  = doc.getTables();
				XWPFTable t0 = tables.get(0);
				XWPFTableRow r1 = t0.createRow();
				addTableCell(r1,0,"閹磋渹瀵�");
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
					addTableCell(r,0,yf.format(balance.getYear()));
					addTableCell(r,1,String.valueOf(balance.getTotalincome()));
					addTableCell(r,2,String.valueOf(balance.getTotalpay()));
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
					addTableCell(r,0,forest.getId() == null?"":"閺嬫娼�");
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
				XWPFTable t7=tables.get(7);
				XWPFTable t8=tables.get(8);
				for(int i=0;i<loans.size();i++){
					FarmerLoan loan = loans.get(i);
					XWPFTableRow r6 = t6.createRow();
					XWPFTableRow r7 = t7.createRow();
					XWPFTableRow r8 = t8.createRow();
					addTableCell(r6,0,loan.getId() == null?"":"1");
					addTableCell(r6,1,loan.getOrganname());
					addTableCell(r6,2,loan.getBusinesstype());
					addTableCell(r6,3,loan.getLoanuse());
					addTableCell(r6,4,"");
					addTableCell(r6,5,loan.getLoandate());
					addTableCell(r6,6,loan.getLimitdate());
					
					addTableCell(r7,0,loan.getId() == null?"":"1");
					addTableCell(r7,1,loan.getBalance());
					addTableCell(r7,2,loan.getGuaranteetype());
					
					addTableCell(r8,0,loan.getId() == null?"":"1");
					addTableCell(r8,1,loan.getClientname());
					addTableCell(r8,2,loan.getClientnum());
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
					 addTableCell(r10,1,String.valueOf(insured.getType()));
					 addTableCell(r10,2,String.valueOf(insured.getAmount()));
					 String date = new SimpleDateFormat("yyyy-mm-dd").format(insured.getInsuretime());
					 addTableCell(r10,3,date);
				}
				XWPFTable t12=tables.get(12);
				XWPFTableRow r12 = t12.createRow();
				addTableCell(r12,0,Dictionary.translate("evaluate",evaluate.getHarmonystatus()));
				addTableCell(r12,1,Dictionary.translate("evaluate",evaluate.getRespectstatus()));
				addTableCell(r12,2,Dictionary.translate("evaluate",evaluate.getNeighborstatus()));
				addTableCell(r12,3,Dictionary.translate("yesorno",String.valueOf(evaluate.getLegalstatus())));
				addTableCell(r12,4,Dictionary.translate("evaluate",evaluate.getWelfarestatus()));
				addTableCell(r12,5,Dictionary.translate("yesorno",String.valueOf(evaluate.getHoneststatus())));
				File f = new File(FarmerController.class.getResource("/temp").getPath()
						+"/娣囷紕鏁ら幎銉ユ啞/"+farmer.getFarmername()+".docx");
				OutputStream fout = new FileOutputStream(f);
				doc.write(fout);
				fout.flush();
				fout.close();
				fout = null;
			}
			File f = new File(FarmerController.class.getResource("/temp").getPath()+"/娣囷紕鏁ら幎銉ユ啞/");
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
	    
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		Map paramMap = new HashMap();
		paramMap.put("runitid", organId);
		paramMap.put("farmertype", 1);
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
	@RequestMapping(value="/queryFarmer1",method=RequestMethod.POST)
	public ModelAndView queryFarmer1(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		/*閺屻儴顕楅弶鈥叉
		
		if(StringUtils.isEmpty(farmerIdNum) && StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "鐠囬攱鍋嶆繅顐㈠晸鐎瑰苯鍟橀幋宄邦潣閸氬秴鎷伴煬顐″敜鐠囦礁褰块惍浣告倵閺屻儴顕�!");
			return  view;
		}*/
	    String pageIndex = request.getParameter("pageIndex");
	    String pageSize = request.getParameter("pageSize");        
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    String farmerIdNum = request.getParameter("farmerIdNum");
		String farmerName = request.getParameter("farmerName");
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		List<Farmer> farmers= farmerService.findPagingByIDAndName(pageIndex, pageSize, sortField, sortOrder,
				farmerIdNum, farmerName, organId);
	    if(farmers.size()== 0){
	    	ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView1");
	    	view.addObject("farmerName",farmerName);
		    view.addObject("farmerIdNum",farmerIdNum);
			view.addObject("msg", "閺堫亝澹橀崚鎵儊閸氬牊娼禒鍓佹畱閸愭粍鍩涙穱鈩冧紖!");
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
			@RequestParam(value="farmerIdNum") String farmerIdNum, HttpServletRequest request,
			HttpServletResponse response){
		//閺屻儴顕楅弶鈥叉
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
	@RequestMapping(value="/typeInFarmer1",method=RequestMethod.POST)
	public ModelAndView typeInFarmer1(@RequestParam(value="farmerName") String farmerName,
			@RequestParam(value="farmerIdNum") String farmerIdNum,  HttpServletRequest request,
			HttpServletResponse response){
		//閺屻儴顕楅弶鈥叉
		if(StringUtils.isEmpty(farmerIdNum) || StringUtils.isEmpty(farmerName)){
			ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "鐠囬攱鍋嶆繅顐㈠晸鐎瑰苯鍟橀幋宄邦潣閸氬秴鎷伴煬顐″敜鐠囦礁褰块惍浣告倵瑜版洖鍙嗛崘婊勫煕娣団剝浼�!");
			return  view;
		}
		Organ organ =(Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
	    Farmer farmer= farmerService.findById(farmerIdNum,organId);
	    List<FarmerMember> members = new ArrayList<FarmerMember>();
	    if(farmer == null){
	    	farmer= new Farmer();
	    	farmer.setFarmername(farmerName);
	    	farmer.setFarmeridnum(farmerIdNum);
	    	try {
				farmerService.save(farmer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else{
	    	ModelAndView view = new ModelAndView("/farmer/farmerBasicInfoView");
			view.addObject("msg", "鐠囬攱鍋嶆繅顐㈠晸鐎瑰苯鍟橀幋宄邦潣閸氬秴鎷伴煬顐″敜鐠囦礁褰块惍浣告倵瑜版洖鍙嗛崘婊勫煕娣団剝浼�!");
			return  view;
	    }
	    if(members.size() == 0 ){
	    	members.add(new FarmerMember());
	    }
		ModelAndView view = new ModelAndView("/farmer/farmerForm");
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
