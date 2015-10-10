package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.DicExplain;
import com.bank.beans.enums.FarmerLoanYZEnum;
import com.bank.beans.enums.FarmerLoanNSEnum;
import com.bank.beans.enums.FarmerLoanNYEnum;
import com.bank.service.IFarmerService;
import com.bank.service.IFarmerLoanService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.UpdateException;

@Controller
@RequestMapping(value = "/loan")
public class FarmerLoanController {
	
@Resource
private IFarmerService farmerService;

@Resource
private IFarmerLoanService loanService;

private Log log = LogFactory.getLog(FarmerLoanController.class);

@RequestMapping(value="/saveLoan1",method=RequestMethod.POST)
public ModelAndView saveLoan1(@ModelAttribute(value="loan") FarmerLoan loan,
		HttpServletRequest request,HttpServletResponse response) {
	
	User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
	try{
		if(loan.getId()==null){
			loan.setSourcecode(organ.getOrganNo());
			loan.setSourcename(organ.getOrganName());
			loan.setRunitid(organ.getOrganId());
			loan.setRunitname(organ.getOrganName());
			loan.setRecorder(user.getUserId());
			loan.setRecordtime(new Date());
			loanService.save(loan);
			log.info(user.getUserName()+"新增贷款,主键"+loan.getId());
		}else{
			loanService.update(loan);
			log.info(user.getUserName()+"修改贷款,主键"+loan.getId());
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	FarmerExample fe = new FarmerExample();
	FarmerExample.Criteria fec = fe.createCriteria();
	fec.andFarmeridnumEqualTo(loan.getIdnum());
	fec.andRunitidEqualTo(loan.getRunitid());
	List<Farmer> farmers = farmerService.selectByExample(fe);
	if(farmers.size() == 1){
		ModelAndView view = new ModelAndView("/farmer/farmerLoanView1");
		view.addObject("farmer",farmers.get(0));
		return view;
	}else{
		return null;
	}
}
@RequestMapping(value="/deleteLoan",method=RequestMethod.GET)
public ModelAndView deleteLoan(HttpServletRequest request,HttpServletResponse response){
	
	String id = request.getParameter("id");
	String fid = request.getParameter("fid");
	Long loanId = Long.valueOf(id);
	Long farmerId = Long.valueOf(fid);
	try {
		loanService.delete(loanId);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
	ModelAndView view = new ModelAndView("/farmer/farmerLoanView1");
	view.addObject("farmer",farmer);
	return view;
}
@RequestMapping(value="/editLoan",method=RequestMethod.GET)
public ModelAndView editLoan(@RequestParam(value="id") String id,@RequestParam(value="fid") String fid,
		HttpServletRequest request,HttpServletResponse response){
	
	Long houseId = Long.valueOf(id);
	Long farmerId = Long.valueOf(fid);
	Farmer farmer = null;
	FarmerLoan loan = null;
	try {
		farmer = farmerService.findByPK(farmerId);
		loan = loanService.findByPK(houseId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ModelAndView view = new ModelAndView("/farmer/farmerLoanForm1");
	view.addObject("farmer",farmer);
	view.addObject("loan",loan);
	return view;
}
@RequestMapping(value="/queryLoan1",method=RequestMethod.GET)
public ModelAndView queryLoan1(@RequestParam(value="fid") String fid, 
		HttpServletRequest request,HttpServletResponse response){
	
	Long farmerId = Long.valueOf(fid);
	ModelAndView view = new ModelAndView("/farmer/farmerLoanView1");
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
@RequestMapping(value="/loadLoan",method=RequestMethod.GET)
public ModelAndView loadLoan(@RequestParam(value="id") String id,
		HttpServletResponse response) throws DAOException, DataNotFoundException{
	if(StringUtils.isEmpty(id)){
		ModelAndView view = new ModelAndView("/farmer/farmerLoanView");
		return view;
	}
	Long loanId = Long.valueOf(id);
	FarmerLoan loan = loanService.findByPK(loanId);
	Long farmerId = loan.getFarmerid();
	Farmer farmer = farmerService.findByPK(farmerId);
	ModelAndView view = new ModelAndView("/farmer/farmerLoanForm");
	view.addObject("farmer", farmer);
	view.addObject("loan",loan);
	return view;
}
@SuppressWarnings({ "unchecked", "rawtypes" })
@RequestMapping(value="/loadLoan1",method=RequestMethod.POST)
public ModelAndView loadLoan1(@RequestParam(value="fid") Long fid, 
		@RequestParam(value="pageIndex") int pageIndex,
		@RequestParam(value="pageSize") int pageSize,
		@RequestParam(value="sortField") String sortField,
		@RequestParam(value="sortOrder") String sortOrder,
		HttpServletRequest request,HttpServletResponse response){
	int totalNumber = loanService.findTotalNumberByFarmerId(fid);
	List<FarmerLoan> loans =loanService.findByPaging(pageIndex, pageSize, sortField, sortOrder, fid);
    Map map = new HashMap();
    map.put("total", totalNumber);
    map.put("data", loans);
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
@RequestMapping(value="/typeInLoan",method=RequestMethod.POST)
public ModelAndView typeinLoan(@RequestParam(value="farmerName") String farmerName, 
		@RequestParam(value="farmerIdNum") String farmerIdNum, HttpServletRequest request,
		HttpServletResponse response){
	
	if(StringUtils.isEmpty(farmerIdNum)){
		ModelAndView view = new ModelAndView("/farmer/farmerLoanView");
		return view;
	}
	Organ organ =(Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
	String organId = organ.getOrganId();
	Farmer farmer = farmerService.findById(farmerIdNum,organId);
	//不存在客户信息需要先录入客户信息
	if(farmer == null){
		ModelAndView  view = new ModelAndView("/farmer/farmerLoanForm");
		view.addObject("error","未找到匹配的农户信息!您可以到【农户】-【数据采集】-【基本信息】模块中录入农户信息后再录入农户的资产信息!");
		return view;
	}else{
		ModelAndView view = new ModelAndView("/farmer/farmerLoanForm");
		view.addObject("farmer",farmer);
		return view;
	}
}
@RequestMapping(value="/typeInLoan1",method=RequestMethod.GET)
public ModelAndView typeinLoan1(@RequestParam(value="fid") String fid, 
		HttpServletRequest request,HttpServletResponse response){
	
	Long farmerId = Long.valueOf(fid);
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
	ModelAndView view = new ModelAndView("/farmer/farmerLoanForm1");
	view.addObject("farmer",farmer);
	return view;
}
@RequestMapping(value="/importFarmerLoan",method=RequestMethod.POST)
public ModelAndView importFarmerLoan(@RequestParam(value="sourcecode") String sourcecode,
		MultipartFile myfile,HttpServletRequest request, 
		HttpServletResponse response) throws DAOException, CreateException, UpdateException, DataNotFoundException{
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		ModelAndView view = new ModelAndView("/farmer/farmerLoanImporter");
		//异常输入流及不可解析的文件格式
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
			view.addObject("msgs",msgs);
			return view;
		}
		if("C3140436000017".equals(sourcecode)){
			msgs = importLoanNS(organId,organName,recorder,recordTime,data);
		}else if("C1010336005158".equals(sourcecode)){
			msgs = importLoanNY(organId,organName,recorder,recordTime,data);
		}else if("C1040336010165".equals(sourcecode)){
			msgs = importLoanYZ(organId,organName,recorder,recordTime,data);
		}
		view.addObject("msgs",msgs);
		return view;
}
private List<Map<String,String>> importLoanNS(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=1;row<data.length;row++){
			FarmerLoan loan = new FarmerLoan();
			loan.setSourcecode("C3140436000017");
			loan.setSourcename("新干县农村信用合作联社");
			loan.setRunitid(organId);
			loan.setRunitname(organName);
			loan.setRecorder(recorder);
			loan.setRecordtime(recordTime);
			loan.setClientnum(data[row][FarmerLoanNSEnum.CLIENTNUM.getIndex()]);
			String noteNum = data[row][FarmerLoanNSEnum.NOTENUM.getIndex()];
			loan.setNotenum(noteNum);
			if(StringUtils.isEmpty(noteNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行拮据号不能为空！");
				msgs.add(msg);
				continue;
			}
			String compactNum =data[row][FarmerLoanNSEnum.COMPACTNUM.getIndex()];
			loan.setCompactnum(compactNum);
			if(StringUtils.isEmpty(compactNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行合同号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setOrganname("新干县农村信用合作联社");
			loan.setLoandate(data[row][FarmerLoanNSEnum.LOANDATE.getIndex()]);
			loan.setLimitdate(data[row][FarmerLoanNSEnum.LIMITDATE.getIndex()]);
			loan.setClientname(data[row][FarmerLoanNSEnum.CLIENTNAME.getIndex()]);
			String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][FarmerLoanNSEnum.CURRENCY.getIndex()]);
			loan.setCurrency(currency);
			loan.setAmount(data[row][FarmerLoanNSEnum.AMOUNT.getIndex()]);
			loan.setBalance(data[row][FarmerLoanNSEnum.BALANCE.getIndex()]);
			loan.setOweinterest(data[row][FarmerLoanNSEnum.OWEINTEREST.getIndex()]);
			loan.setCurrentrate(data[row][FarmerLoanNSEnum.CURRENTRATE.getIndex()]);
			loan.setRatetype(data[row][FarmerLoanNSEnum.RATETYPE.getIndex()]);
			loan.setIdnum(data[row][FarmerLoanNSEnum.IDNUM.getIndex()]);
			loan.setLoanuse(data[row][FarmerLoanNSEnum.LOANUSE.getIndex()]);
			String guaranteetype =data[row][FarmerLoanNSEnum.GUARANTEETYPE.getIndex()];
			guaranteetype = DicExplain.explain(DicExplain.$GUARANTEETYPE,guaranteetype);
			loan.setGuaranteetype(guaranteetype);
			loan.setGrade(data[row][FarmerLoanNSEnum.GRADE.getIndex()]);
			loan.setSettletype(data[row][FarmerLoanNSEnum.SETTLETYPE.getIndex()]);
			loan.setChargeperson(data[row][FarmerLoanNSEnum.CHARGEPERSON.getIndex()]);
			loan.setOrganname(data[row][FarmerLoanNSEnum.ORGANNAME.getIndex()]);
		
			Farmer farmer = new Farmer();
			farmer.setFarmertype(0);
			farmer.setFarmername(data[row][FarmerLoanNSEnum.NAME.getIndex()]);
			farmer.setFarmeridnum(data[row][FarmerLoanNSEnum.IDNUM.getIndex()]);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setSourcecode("C3140436000017");
			farmer.setSourcename("新干县农村信用合作联社");
			
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(farmer.getFarmeridnum());
			fc.andSourcecodeEqualTo(farmer.getSourcecode());
			List<Farmer> dbFarmers = farmerService.selectByExample(fe);
			try{
				if(dbFarmers.size() == 0){
					farmerService.save(farmer);
				}else if(dbFarmers.size() ==1){
					Farmer dbFarmer = dbFarmers.get(0);
					farmer.setId(dbFarmer.getId());
					farmerService.updateBySelective(farmer);
				}else if(dbFarmers.size() >1){
					continue;
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行保存是出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
			FarmerLoanExample le = new FarmerLoanExample();
			FarmerLoanExample.Criteria lc= le.createCriteria();
			lc.andNotenumEqualTo(noteNum);
			lc.andSourcecodeEqualTo("C3140436000017");
			List<FarmerLoan> loans = loanService.selectByExample(le);
			try{
				if(loans.size() == 0){
					loan.setFarmerid(farmer.getId());
					loanService.save(loan);
				}else{
					loan.setId(loans.get(0).getId());
					loanService.update(loan);
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行保存是出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
		}
		return msgs;
	}
	private List<Map<String,String>> importLoanNY(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=3;row<data.length;row++){
			FarmerLoan loan = new FarmerLoan();
			loan.setSourcecode("C1010336005158");
			loan.setSourcename("中国农业银行新干县支行");
			loan.setRunitid(organId);
			loan.setRunitname(organName);
			loan.setRecorder(recorder);
			loan.setRecordtime(recordTime);
			String farmerIdNum = data[row][FarmerLoanNYEnum.IDNUM.getIndex()];
			String farmerName = data[row][FarmerLoanNYEnum.FARMERNAME.getIndex()];
			loan.setClientnum(data[row][FarmerLoanNYEnum.CLIENTNUM.getIndex()]);
			String noteNum = data[row][FarmerLoanNYEnum.NOTENUM.getIndex()];
			loan.setNotenum(noteNum);
			if(StringUtils.isEmpty(noteNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行申请书编号不能为空！");
				msgs.add(msg);
				continue;
			}
			
			String compactNum =data[row][FarmerLoanNYEnum.COMPACTNUM.getIndex()];
			loan.setCompactnum(compactNum);
			if(StringUtils.isEmpty(compactNum)){
				//如果合同号为空提示合同号不能为空
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行合同号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setOrganname("中国农业银行新干县支行");
			loan.setLoandate(data[row][FarmerLoanNYEnum.LOANDATE.getIndex()]);
			loan.setLimitdate(data[row][FarmerLoanNYEnum.LIMITDATE.getIndex()]);
			String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][FarmerLoanNYEnum.CURRENCY.getIndex()]);
			loan.setCurrency(currency);
			loan.setAmount(data[row][FarmerLoanNYEnum.AMOUNT.getIndex()]);
			loan.setBalance(data[row][FarmerLoanNYEnum.BALANCE.getIndex()]);
			loan.setClienttype("1");
			loan.setClientname(data[row][FarmerLoanNYEnum.CLIENTNAME.getIndex()]);
			String idType = DicExplain.explain(DicExplain.$IDTYPE,data[row][FarmerLoanNYEnum.IDTYPE.getIndex()]);
			loan.setIdtype(idType);
			loan.setIdnum(farmerIdNum);
			String guaranteetype = data[row][FarmerLoanNYEnum.GUARANTEETYPE.getIndex()];
			guaranteetype = DicExplain.explain(DicExplain.$GUARANTEETYPE, guaranteetype);
			loan.setGuaranteetype(guaranteetype);
			loan.setOrgancode(data[row][FarmerLoanNYEnum.ORGANCODE.getIndex()]);
			loan.setGuaranteetype1(data[row][FarmerLoanNYEnum.GUARANTEETYPE1.getIndex()]);
			Farmer farmer = new Farmer();
			farmer.setFarmertype(0);
			farmer.setFarmeridnum(farmerIdNum);
			farmer.setFarmername(farmerName);
			farmer.setPhone(data[row][FarmerLoanNYEnum.PHONE.getIndex()]);
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			farmer.setSourcecode("C1010336005158");
			farmer.setSourcename("中国农业银行新干县支行");
			
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(loan.getIdnum());
			fc.andSourcecodeEqualTo("C1010336005158");
			List<Farmer> dbfarmers = farmerService.selectByExample(fe);
			try{
				if(dbfarmers.size() == 0){
					farmerService.save(farmer);
				}else if(dbfarmers.size() == 1){
					Farmer dbFarmer = dbfarmers.get(0);
					farmer.setId(dbFarmer.getId());
					farmerService.updateBySelective(farmer);
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行保存时出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
			FarmerLoanExample le = new FarmerLoanExample();
			FarmerLoanExample.Criteria lc = le.createCriteria();
			lc.andNotenumEqualTo(loan.getNotenum());
			lc.andSourcecodeEqualTo("C1010336005158");
			List<FarmerLoan> loans = loanService.selectByExample(le);
			try{
				if(loans.size() == 0){
					loan.setFarmerid(farmer.getId());
					loanService.save(loan);
				}else{
					loan.setId(loans.get(0).getId());
					loanService.update(loan);
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行保存时出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
		
		}
		return msgs;
	}
	private List<Map<String,String>> importLoanYZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row =1;row<data.length;row++){
			Farmer farmer = new Farmer();
			farmer.setSourcecode("C1040336010165");
			farmer.setSourcename("中国邮政储蓄银行新干县支行");
			farmer.setRunitid(organId);
			farmer.setRunitname(organName);
			farmer.setRecorder(recorder);
			farmer.setRecordtime(recordTime);
			farmer.setFarmertype(0);
			FarmerLoan loan = new FarmerLoan();
			loan.setSourcecode("C1040336010165");
			loan.setSourcename("中国邮政储蓄银行新干县支行");
			loan.setRunitid(organId);
			loan.setRunitname(organName);
			loan.setRecorder(recorder);
			loan.setRecordtime(recordTime);
			String farmerName = data[row][FarmerLoanYZEnum.FARMERNAME.getIndex()];
			farmer.setFarmername(farmerName);
			loan.setClientname(farmerName);
			if(StringUtils.isEmpty(farmerName)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行农户姓名不能为空！");
				msgs.add(msg);
				continue;
			}
			String farmerIdNum = data[row][FarmerLoanYZEnum.FARMERIDNUM.getIndex()];
			farmer.setFarmeridnum(farmerIdNum);
			loan.setIdnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"身份证号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setOrganname("中国邮政储蓄银行新干县支行");
			String phone = data[row][FarmerLoanYZEnum.PHONE.getIndex()];
			farmer.setPhone(phone);
			String address = data[row][FarmerLoanYZEnum.ADDRESS.getIndex()];
			farmer.setAddress(address);
			String village = DicExplain.explain(DicExplain.$VILLAGE, address);
			farmer.setVillages(village);
			String noteNum = data[row][FarmerLoanYZEnum.NOTENUM.getIndex()];
			loan.setNotenum(noteNum);
			if(StringUtils.isEmpty(noteNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"拮据号不能为空！");
				msgs.add(msg);
				continue;
			}
			String amount = data[row][FarmerLoanYZEnum.AMOUNT.getIndex()];
			loan.setAmount(amount);
			if(StringUtils.isEmpty(amount)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"贷款金额不能为空！");
				msgs.add(msg);
				continue;
			}
			String balance = data[row][FarmerLoanYZEnum.BALANCE.getIndex()];
			loan.setBalance(balance);
			if(StringUtils.isEmpty(balance)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"贷款余额不能为空！");
				msgs.add(msg);
				continue;
			}
			String loanDate = data[row][FarmerLoanYZEnum.LOANDATE.getIndex()];
			loan.setLoandate(loanDate);
			if(StringUtils.isEmpty(balance)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"贷款日期不能为空！");
				msgs.add(msg);
				continue;
			}
			String limitDate = data[row][FarmerLoanYZEnum.LIMITDATE.getIndex()];
			loan.setLimitdate(limitDate);
			if(StringUtils.isEmpty(balance)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"到期日期不能为空！");
				msgs.add(msg);
				continue;
			}
			String grade = data[row][FarmerLoanYZEnum.GRADE.getIndex()];
			loan.setGrade(grade);
			if(StringUtils.isEmpty(grade)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"五级分类不能为空！");
				msgs.add(msg);
				continue;
			}
			String guaranteetype = data[row][FarmerLoanYZEnum.GUARANTEETYPE.getIndex()];
			guaranteetype = DicExplain.explain(DicExplain.$GUARANTEETYPE, guaranteetype);
			loan.setGuaranteetype(guaranteetype);
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fec = fe.createCriteria();
			fec.andFarmeridnumEqualTo(farmerIdNum);
			fec.andSourcecodeEqualTo("C1040336010165");
			List<Farmer> farmers = farmerService.selectByExample(fe);
			try{
				if(farmers.size() == 0){
					farmerService.save(farmer);
				}else{
					farmer.setId(farmers.get(0).getId());
					farmerService.update(farmer);
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"保存是出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
			loan.setFarmerid(farmer.getId());
			FarmerLoanExample fle = new FarmerLoanExample();
			FarmerLoanExample.Criteria flec = fle.createCriteria();
			flec.andNotenumEqualTo(noteNum);
			flec.andSourcecodeEqualTo("C1040336010165");
			List<FarmerLoan> loans = loanService.selectByExample(fle);
			try{
				if(loans.size() == 0){
					loanService.save(loan);
				}else{
					loan.setId(loans.get(0).getId());
					loanService.update(loan);
				}
			}catch(Exception e){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"保存是出错");
				msgs.add(msg);
				log.error(e.getMessage());
				continue;
			}
		}
		return msgs;
	}
}
