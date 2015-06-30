package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import com.bank.beans.FarmerLoan;
import com.bank.beans.FarmerLoanExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.DicExplain;
import com.bank.beans.enums.FarmerNSEnum;
import com.bank.beans.enums.FarmerNYEnum;
import com.bank.beans.enums.FarmerPoorEnum;
import com.bank.beans.enums.LoanNSEnum;
import com.bank.beans.enums.LoanNYEnum;
import com.bank.common.util.JsonUtil;
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

@RequestMapping(value="/saveLoan1",method=RequestMethod.POST)
public ModelAndView saveLoan1(@ModelAttribute(value="loan") FarmerLoan loan,
		HttpServletRequest request,HttpServletResponse response) {
	
	Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
	String organId = organ.getOrganId();
	String organName = organ.getOrganName();
	loan.setRunitid(organId);
	loan.setRunitname(organName);
	try{
		if(loan.getId()==null){
			loanService.save(loan);
		}else{
			loanService.update(loan);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	ModelAndView view = new ModelAndView("/farmer/farmerLoanView1");
	Farmer farmer = null;
	try {
		 farmer = farmerService.findByPK(loan.getFarmerid());
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
@RequestMapping(value="/loadFile",method=RequestMethod.POST)
public ModelAndView loadFile(MultipartFile myfile,HttpServletRequest request, 
		HttpServletResponse response) throws DAOException, CreateException, UpdateException, DataNotFoundException{
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		ModelAndView view = new ModelAndView("/farmer/farmerImportFile");
		//异常输入流及不可解析的文件格式
		try{
			 InputStream in = myfile.getInputStream();
			 data=ParseDataUtils.getExeclData(in,0);
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
			view.addObject("msgs",msgs);
			return view;
		}
		
		if(data.length>0 && data[0].length>0 && data[0][0].indexOf("个人客户信息")>0){
			msgs = importFarmerNS(organId,organName,recorder,recordTime,data);
		}else if("贷款日期".equals(data[0][5])){
			msgs = importLoanNS(organId,organName,recorder,recordTime,data);
		}else if(data[0][0].contains("个人客户基本信息查询")){
			msgs = importFarmerNY(organId,organName,recorder,recordTime,data);
		}else if(data[0][0].contains("个人借款合同查询")){
			msgs = importLoanNY(organId,organName,recorder,recordTime,data);
		}else if("主要致贫原因".equals(data[0][5])){
			msgs = importFarmerPoor(organId,organName,recorder,recordTime,data);
		}else{
			//文件格式可能存在问题，请及时联系管理员
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", "0");
			msg.put("tip", "error");
			msg.put("msg", "文件格式可能存在问题，请及时联系管理员!");
			msgs.add(msg);
		}
		view.addObject("msgs",msgs);
		return view;
}
@RequestMapping(value="/loadFile1",method=RequestMethod.POST)
public ModelAndView loadFile1(MultipartFile myfile,HttpServletRequest request, 
		HttpServletResponse response) throws DAOException, CreateException, UpdateException, DataNotFoundException{
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		ModelAndView view = new ModelAndView("/farmer/farmerImportFile1");
		//异常输入流及不可解析的文件格式
		try{
			 InputStream in = myfile.getInputStream();
			 data=ParseDataUtils.getExeclData(in,0);
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
			view.addObject("msgs",msgs);
			return view;
		}
		
		if(data[0][0].contains("个人客户基本信息查询")){
			for(int row =3;row<data.length;row++){
				Map<String,String> msg = new HashMap<String,String>();
				Farmer farmer = new Farmer();
				String farmerName = data[row][FarmerNYEnum.FARMERNAME.getIndex()];
				if(StringUtils.isEmpty(farmerName)){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "姓名不能为空。");
					continue;
				}
				farmer.setFarmername(farmerName);
				String farmerIdNum = data[row][FarmerNYEnum.IDNUM.getIndex()];
				if(StringUtils.isEmpty(farmerIdNum)){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "证件号码不能为空。");
					continue;
				}
				Farmer dbFarmer = farmerService.findById(farmerIdNum,organId);
				if(dbFarmer != null){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "该用户已经存在、不再导入。");
					continue;
				}
				farmer.setFarmeridnum(farmerIdNum);
				farmer.setRunitid(organId);
				farmer.setRunitname(organName);
				String sex = DicExplain.explain(DicExplain.$SEX,data[row][FarmerNYEnum.SEX.getIndex()]);
				farmer.setSex(Integer.valueOf(sex));
				String education = DicExplain.explain(DicExplain.$EDUCATION,data[row][FarmerNYEnum.EDUCATION.getIndex()]);
				farmer.setEducation(Integer.valueOf(education));
				String marryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,data[row][FarmerNYEnum.MARRYSTATUS.getIndex()]);
				farmer.setMarrystatus(Integer.valueOf(marryStatus));
				farmer.setAddress(data[row][FarmerNYEnum.ADDRESS.getIndex()]);
				farmerService.save(farmer);
				//关联农户信贷信息
				List<FarmerLoan> loans = loanService.findByID("1","0",farmer.getFarmeridnum());
				if(loans == null || loans.size()==0){
				//未匹配信贷信息提示未匹配
					msg.put("row", String.valueOf(row));
					msg.put("tip", "error");
					msg.put("msg", "["+data[row][FarmerNYEnum.FARMERNAME.getIndex()]+"]"
							+ "找到"+loans.size()+"条匹配的信贷信息");
					msgs.add(msg);
				}else{
				//匹配信贷信息提示匹配数量
					for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
						FarmerLoan loan = it.next();
						loan.setFarmerid(farmer.getId());
						loanService.update(loan);
					}
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "["+data[row][FarmerNYEnum.FARMERNAME.getIndex()]+"]"
							+ "找到"+loans.size()+"条匹配的信贷信息");
					msgs.add(msg);
				}	
			}
			
		}else if(data[0][0].contains("个人借款合同查询")){
			for(int row=3;row<data.length;row++){
				Map<String,String> msg = new HashMap<String,String>();
				FarmerLoan loan = new FarmerLoan();
				loan.setClientnum(data[row][LoanNYEnum.CLIENTNUM.getIndex()]);
				String noteNum = data[row][LoanNYEnum.NOTENUM.getIndex()];
				if(StringUtils.isEmpty(noteNum)){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "error");
					msg.put("msg", "申请书编号不能为空！");
					msgs.add(msg);
					continue;
				}
				loan.setNotenum(noteNum);
				FarmerLoan dbloan = loanService.findByNoteNum(noteNum);
				if(dbloan != null){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "该信贷信息已经存在、不再导入！");
					msgs.add(msg);
					continue;
				}
				String compactNum =data[row][LoanNYEnum.COMPACTNUM.getIndex()];
				if(StringUtils.isEmpty(compactNum)){
					//如果合同号为空提示合同号不能为空
					msg.put("row", String.valueOf(row));
					msg.put("tip", "error");
					msg.put("msg", "信贷信息的合同号不能为空！");
					msgs.add(msg);
					continue;
				}
				loan.setCompactnum(compactNum);
				loan.setLoandate(data[row][LoanNYEnum.LOANDATE.getIndex()]);
				loan.setLimitdate(data[row][LoanNYEnum.LIMITDATE.getIndex()]);
				String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][LoanNYEnum.CURRENCY.getIndex()]);
				loan.setCurrency(currency);
				loan.setAmount(data[row][LoanNYEnum.AMOUNT.getIndex()]);
				loan.setBalance(data[row][LoanNYEnum.BALANCE.getIndex()]);
				loan.setClienttype("1");
				loan.setClientname(data[row][LoanNYEnum.CLIENTNAME.getIndex()]);
				String idType = DicExplain.explain(DicExplain.$IDTYPE,data[row][LoanNYEnum.IDTYPE.getIndex()]);
				loan.setIdtype(idType);
				loan.setIdnum(data[row][LoanNYEnum.IDNUM.getIndex()]);
				loan.setGuaranteetype(data[row][LoanNYEnum.GUARANTEETYPE.getIndex()]);
				loan.setOrgancode(data[row][LoanNYEnum.ORGANCODE.getIndex()]);
				loan.setGuaranteetype1(data[row][LoanNYEnum.GUARANTEETYPE1.getIndex()]);
				loan.setRunitid(organId);
				loan.setRunitname(organName);
				Farmer farmer = farmerService.findById(loan.getIdnum(),organId);
				if(farmer == null ){
				//未匹配农户信息提示未匹配
					loanService.findByNoteNum(noteNum);
					try{
						loanService.save(loan);
					}catch(Exception e){
						System.err.println(row);
						System.err.println(loan.getNotenum());
					}
					msg.put("row", String.valueOf(row));
					msg.put("tip", "success");
					msg.put("msg", "导入成功但未匹配农户信息，请稍后导入农户信息！");
					msgs.add(msg);
				}else{
				//匹配农户信息提示匹配数量
					msg.put("row", String.valueOf(row));
					loan.setFarmerid(farmer.getId());
					loanService.save(loan);
					msg.put("tip", "success");	
					msg.put("msg", "导入成功且匹配到相应的农户信息！");
					msgs.add(msg);
				}
			}
		}else{
			//文件格式可能存在问题，请及时联系管理员
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", "0");
			msg.put("tip", "error");
			msg.put("msg", "文件格式可能存在问题，请及时联系管理员!");
			msgs.add(msg);
		}
		view.addObject("msgs",msgs);
		return view;
}
@RequestMapping(value="/importLoan",method=RequestMethod.POST)
public ModelAndView loadLoan(MultipartFile myfile,HttpServletRequest request, 
		HttpServletResponse response) throws DAOException, CreateException{
	
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		String[][] data = null;
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		ModelAndView view = new ModelAndView("/farmer/farmerImportFile");
		//异常输入流及不可解析的文件格式
		try{
			 InputStream in = myfile.getInputStream();
			 data=ParseDataUtils.getExeclData(in,0);
		}catch(IOException e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
			view.addObject("msgs",msgs);
			return view;
		}
		
		 if(!"贷款日期".equals(data[0][5])){
			 return view;
		 }
		for(int row=1;row<data.length;row++){
				Map<String,String> msg = new HashMap<String,String>();
				FarmerLoan loan = new FarmerLoan();
				loan.setClientnum(data[row][LoanNSEnum.CLIENTNUM.getIndex()]);
				String noteNum = data[row][LoanNSEnum.NOTENUM.getIndex()];
				loan.setNotenum(noteNum);
				FarmerLoan dbloan = loanService.findByNoteNum(noteNum);
				if(dbloan != null){
					msg.put("row", String.valueOf(row));
					msg.put("tip", "info");
					msg.put("msg", "该信贷信息已经存在、不再导入！");
					msgs.add(msg);
					continue;
				}
				String compactNum =data[row][LoanNSEnum.COMPACTNUM.getIndex()];
				if(StringUtils.isEmpty(compactNum)){
					//如果合同号为空提示合同号不能为空
					msg.put("row", String.valueOf(row));
					msg.put("tip", "error");
					msg.put("msg", "信贷信息的合同号不能为空！");
					msgs.add(msg);
					continue;
				}
				loan.setCompactnum(compactNum);
				loan.setLoandate(data[row][LoanNSEnum.LOANDATE.getIndex()]);
				loan.setLimitdate(data[row][LoanNSEnum.LIMITDATE.getIndex()]);
				loan.setLimitdate1(data[row][LoanNSEnum.LIMITDATE1.getIndex()]);
				loan.setClientname(data[row][LoanNSEnum.CLIENTNAME.getIndex()]);
				String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][LoanNSEnum.CURRENCY.getIndex()]);
				loan.setCurrency(currency);
				loan.setAmount(data[row][LoanNSEnum.AMOUNT.getIndex()]);
				loan.setBalance(data[row][LoanNSEnum.BALANCE.getIndex()]);
				loan.setOweinterest(data[row][LoanNSEnum.OWEINTEREST.getIndex()]);
				loan.setCurrentrate(data[row][LoanNSEnum.CURRENTRATE.getIndex()]);
				loan.setRatetype(data[row][LoanNSEnum.RATETYPE.getIndex()]);
				String clientType = DicExplain.explain(DicExplain.$CLIENTTYPE,data[row][LoanNSEnum.CLIENTTYPE.getIndex()]);
				loan.setClienttype(clientType);
				String idType = DicExplain.explain(DicExplain.$IDTYPE,data[row][LoanNSEnum.IDTYPE.getIndex()]);
				loan.setIdtype(idType);
				loan.setIdnum(data[row][LoanNSEnum.IDNUM.getIndex()]);
				loan.setPhone(data[row][LoanNSEnum.PHONE.getIndex()]);
				loan.setAddress(data[row][LoanNSEnum.ADDRESS.getIndex()]);
				loan.setLoanuse(data[row][LoanNSEnum.LOANUSE.getIndex()]);
				loan.setGuaranteetype(data[row][LoanNSEnum.GUARANTEETYPE.getIndex()]);
				loan.setGrade(data[row][LoanNSEnum.GRADE.getIndex()]);
				loan.setGrade1(data[row][LoanNSEnum.GRADE1.getIndex()]);
				loan.setSettletype(data[row][LoanNSEnum.SETTLETYPE.getIndex()]);
				loan.setChargeperson(data[row][LoanNSEnum.CHARGEPERSON.getIndex()]);
				loan.setOrgancode(data[row][LoanNSEnum.ORGANCODE.getIndex()]);
				loan.setOrganname(data[row][LoanNSEnum.ORGANNAME.getIndex()]);
				loan.setBusinesstype(data[row][LoanNSEnum.BUSINESSTYPE.getIndex()]);
				loan.setBusinessbody(data[row][LoanNSEnum.BUSINESSBODY.getIndex()]);
				loan.setProvidetype(data[row][LoanNSEnum.PROVIDETYPE.getIndex()]);
				loan.setInvest(data[row][LoanNSEnum.INVEST.getIndex()]);
				loan.setTermtype(data[row][LoanNSEnum.TERMTYPE.getIndex()]);
				loan.setGuaranteetype1(data[row][LoanNSEnum.GUARANTEETYPE1.getIndex()]);
				loan.setFloatscope(data[row][LoanNSEnum.FLOATSCOPE.getIndex()]);
				loan.setAdjusttype(data[row][LoanNSEnum.ADJUSTTYPE.getIndex()]);
				loan.setRuntype(data[row][LoanNSEnum.RUNTYPE.getIndex()]);
				loan.setFrequeency(data[row][LoanNSEnum.FREQUEENCY.getIndex()]);
				loan.setRunitid(organId);
				loan.setRunitname(organName);
				Farmer farmer = farmerService.findById(loan.getIdnum(),organId);
				if(farmer == null ){
				//未匹配农户信息提示未匹配
					loanService.findByNoteNum(noteNum);
					loanService.save(loan);
					msg.put("row", String.valueOf(row));
					msg.put("tip", "success");
					msg.put("msg", "导入成功但未匹配农户信息，请稍后导入农户信息！");
					msgs.add(msg);
				}else{
				//匹配农户信息提示匹配数量
					msg.put("row", String.valueOf(row));
					loan.setFarmerid(farmer.getId());
					loanService.save(loan);
					msg.put("tip", "success");	
					msg.put("msg", "导入成功且匹配到相应的农户信息！");
					msgs.add(msg);
				}
		}
		view.addObject("msgs",msgs);
		return view;
}
public List<Map<String,String>> importFarmerNS(String organId,String organName,
		String recorder,Date recordTime,String[][] data){
	
	List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
	
	for(int row =2;row<data.length;row++){
		Map<String,String> msg = new HashMap<String,String>();
		Farmer farmer = new Farmer();
		farmer.setSourcecode("C3140436000017");
		farmer.setSourcename("新干县农村信用合作联社");
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		farmer.setRecorder(recorder);
		farmer.setRecordtime(recordTime);
		farmer.setFarmertype(0);
		String farmerName = data[row][FarmerNSEnum.FARMERNAME.getIndex()];
		if(StringUtils.isEmpty(farmerName)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "姓名不能为空。");
			continue;
		}
		farmer.setFarmername(farmerName);
		String farmerIdNum = data[row][FarmerNSEnum.IDNUM.getIndex()];
		if(StringUtils.isEmpty(farmerIdNum)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "证件号码不能为空。");
			continue;
		}
		farmer.setFarmeridnum(farmerIdNum);
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		String sex = DicExplain.explain(DicExplain.$SEX,data[row][FarmerNSEnum.SEX.getIndex()]);
		farmer.setSex(Integer.valueOf(sex));
		String education = DicExplain.explain(DicExplain.$EDUCATION,data[row][FarmerNSEnum.EDUCATION.getIndex()]);
		farmer.setEducation(Integer.valueOf(education));
		String marryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,data[row][FarmerNSEnum.MARRYSTATUS.getIndex()]);
		farmer.setMarrystatus(Integer.valueOf(marryStatus));
		farmer.setOccupation(data[row][FarmerNSEnum.OCCUPATION.getIndex()]);
		farmer.setPhone(data[row][FarmerNSEnum.PHONE.getIndex()]);
		farmer.setAddress(data[row][FarmerNSEnum.ADDRESS.getIndex()]);
		Farmer dbFarmer = farmerService.findById(farmerIdNum,"C3140436000017");
		try {
			if(dbFarmer == null){
				farmerService.save(farmer);
			}else{
				farmer.setId(dbFarmer.getId());
				farmerService.updateBySelective(farmer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关联农户信贷信息
		List<FarmerLoan> loans = loanService.findByID("1","0",farmer.getFarmeridnum());
		if(loans == null || loans.size()==0){
		//未匹配信贷信息提示未匹配
			msg.put("row", String.valueOf(row));
			msg.put("tip", "error");
			msg.put("msg", "["+data[row][FarmerNSEnum.FARMERNAME.getIndex()]+"]"
					+ "找到"+loans.size()+"条匹配的信贷信息");
			msgs.add(msg);
		}else{
		//匹配信贷信息提示匹配数量
			for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
				FarmerLoan loan = it.next();
				loan.setFarmerid(farmer.getId());
				try {
					loanService.update(loan);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "["+data[row][FarmerNSEnum.FARMERNAME.getIndex()]+"]"
					+ "找到"+loans.size()+"条匹配的信贷信息");
			msgs.add(msg);
		}	
	}
	return msgs;
}
public List<Map<String,String>> importFarmerPoor(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
	
	List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
	
	for(int row =1;row<data.length;row++){
		
		Map<String,String> msg = new HashMap<String,String>();
		
		Farmer farmer = new Farmer();
		farmer.setSourcecode("JinZhunHuPin");
		farmer.setSourcename("新干县人民政府扶贫办");
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		farmer.setRecorder(recorder);
		farmer.setRecordtime(recordTime);
		farmer.setFarmertype(1);
		String farmerName = data[row][FarmerPoorEnum.FARMERNAME.getIndex()];
		if(StringUtils.isEmpty(farmerName)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "姓名不能为空。");
			continue;
		}
		farmer.setFarmername(farmerName);
		String farmerIdNum = data[row][FarmerPoorEnum.IDNUM.getIndex()];
		if(StringUtils.isEmpty(farmerIdNum)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "证件号码不能为空。");
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
		Farmer dbFarmer = farmerService.findById(farmer.getFarmeridnum(),"JinZhunHuPin");
		try {
			if(dbFarmer == null){
				farmerService.save(farmer);
			}else{
				farmer.setId(dbFarmer.getId());
				farmerService.updateBySelective(farmer);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	return msgs;
	
}
public List<Map<String,String>> importFarmerNY(String organId,String organName,
		String recorder,Date recordTime,String[][] data)
{
	
	List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
	for(int row =3;row<data.length;row++){
		Map<String,String> msg = new HashMap<String,String>();
		Farmer farmer = new Farmer();
		farmer.setSourcecode("C1010336005158");
		farmer.setSourcename("中国农业银行新干县支行");
		farmer.setRunitid(organId);
		farmer.setRunitname(organName);
		farmer.setRecorder(recorder);
		farmer.setRecordtime(recordTime);
		farmer.setFarmertype(0);
		String farmerName = data[row][FarmerNYEnum.FARMERNAME.getIndex()];
		if(StringUtils.isEmpty(farmerName)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "姓名不能为空。");
			continue;
		}
		farmer.setFarmername(farmerName);
		String farmerIdNum = data[row][FarmerNYEnum.IDNUM.getIndex()];
		if(StringUtils.isEmpty(farmerIdNum)){
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "证件号码不能为空。");
			continue;
		}
		farmer.setFarmeridnum(farmerIdNum);
		String sex = DicExplain.explain(DicExplain.$SEX,data[row][FarmerNYEnum.SEX.getIndex()]);
		farmer.setSex(Integer.valueOf(sex));
		String education = DicExplain.explain(DicExplain.$EDUCATION,data[row][FarmerNYEnum.EDUCATION.getIndex()]);
		farmer.setEducation(Integer.valueOf(education));
		String marryStatus = DicExplain.explain(DicExplain.$MARRYSTATUS,data[row][FarmerNYEnum.MARRYSTATUS.getIndex()]);
		farmer.setMarrystatus(Integer.valueOf(marryStatus));
		farmer.setAddress(data[row][FarmerNYEnum.ADDRESS.getIndex()]);
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
			if(dbFarmers == null){
				farmerService.save(farmer);
			}else if(dbFarmers.size() == 1){
				Farmer dbFarmer = dbFarmers.get(0);
				farmer.setId(dbFarmer.getId());
				farmerService.updateBySelective(farmer);
			}else{
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "存在多条记录。");
				continue;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关联农户信贷信息
		List<FarmerLoan> loans = loanService.findByID("1","0",farmer.getFarmeridnum());
		if(loans == null || loans.size()==0){
		//未匹配信贷信息提示未匹配
			msg.put("row", String.valueOf(row));
			msg.put("tip", "error");
			msg.put("msg", "["+data[row][FarmerNYEnum.FARMERNAME.getIndex()]+"]"
					+ "找到"+loans.size()+"条匹配的信贷信息");
			msgs.add(msg);
		}else{
		//匹配信贷信息提示匹配数量
			for(Iterator<FarmerLoan> it = loans.iterator();it.hasNext();){
				FarmerLoan loan = it.next();
				loan.setFarmerid(farmer.getId());
				try {
					loanService.update(loan);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			msg.put("row", String.valueOf(row));
			msg.put("tip", "info");
			msg.put("msg", "["+data[row][FarmerNYEnum.FARMERNAME.getIndex()]+"]"
					+ "找到"+loans.size()+"条匹配的信贷信息");
			msgs.add(msg);
		}	
	}
	return msgs;
		
}
	public List<Map<String,String>> importLoanNS(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=1;row<data.length;row++){
			Map<String,String> msg = new HashMap<String,String>();
			FarmerLoan loan = new FarmerLoan();
			loan.setClientnum(data[row][LoanNSEnum.CLIENTNUM.getIndex()]);
			String noteNum = data[row][LoanNSEnum.NOTENUM.getIndex()];
			loan.setNotenum(noteNum);
			FarmerLoan dbloan = loanService.findByNoteNum(noteNum);
			if(dbloan != null){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "该信贷信息已经存在、不再导入！");
				msgs.add(msg);
				continue;
			}
			String compactNum =data[row][LoanNSEnum.COMPACTNUM.getIndex()];
			if(StringUtils.isEmpty(compactNum)){
				//如果合同号为空提示合同号不能为空
				msg.put("row", String.valueOf(row));
				msg.put("tip", "error");
				msg.put("msg", "信贷信息的合同号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setCompactnum(compactNum);
			loan.setLoandate(data[row][LoanNSEnum.LOANDATE.getIndex()]);
			loan.setLimitdate(data[row][LoanNSEnum.LIMITDATE.getIndex()]);
			loan.setLimitdate1(data[row][LoanNSEnum.LIMITDATE1.getIndex()]);
			loan.setClientname(data[row][LoanNSEnum.CLIENTNAME.getIndex()]);
			String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][LoanNSEnum.CURRENCY.getIndex()]);
			loan.setCurrency(currency);
			loan.setAmount(data[row][LoanNSEnum.AMOUNT.getIndex()]);
			loan.setBalance(data[row][LoanNSEnum.BALANCE.getIndex()]);
			loan.setOweinterest(data[row][LoanNSEnum.OWEINTEREST.getIndex()]);
			loan.setCurrentrate(data[row][LoanNSEnum.CURRENTRATE.getIndex()]);
			loan.setRatetype(data[row][LoanNSEnum.RATETYPE.getIndex()]);
			String clientType = DicExplain.explain(DicExplain.$CLIENTTYPE,data[row][LoanNSEnum.CLIENTTYPE.getIndex()]);
			loan.setClienttype(clientType);
			String idType = DicExplain.explain(DicExplain.$IDTYPE,data[row][LoanNSEnum.IDTYPE.getIndex()]);
			loan.setIdtype(idType);
			loan.setIdnum(data[row][LoanNSEnum.IDNUM.getIndex()]);
			loan.setPhone(data[row][LoanNSEnum.PHONE.getIndex()]);
			loan.setAddress(data[row][LoanNSEnum.ADDRESS.getIndex()]);
			loan.setLoanuse(data[row][LoanNSEnum.LOANUSE.getIndex()]);
			loan.setGuaranteetype(data[row][LoanNSEnum.GUARANTEETYPE.getIndex()]);
			loan.setGrade(data[row][LoanNSEnum.GRADE.getIndex()]);
			loan.setGrade1(data[row][LoanNSEnum.GRADE1.getIndex()]);
			loan.setSettletype(data[row][LoanNSEnum.SETTLETYPE.getIndex()]);
			loan.setChargeperson(data[row][LoanNSEnum.CHARGEPERSON.getIndex()]);
			loan.setOrgancode(data[row][LoanNSEnum.ORGANCODE.getIndex()]);
			loan.setOrganname(data[row][LoanNSEnum.ORGANNAME.getIndex()]);
			loan.setBusinesstype(data[row][LoanNSEnum.BUSINESSTYPE.getIndex()]);
			loan.setBusinessbody(data[row][LoanNSEnum.BUSINESSBODY.getIndex()]);
			loan.setProvidetype(data[row][LoanNSEnum.PROVIDETYPE.getIndex()]);
			loan.setInvest(data[row][LoanNSEnum.INVEST.getIndex()]);
			loan.setTermtype(data[row][LoanNSEnum.TERMTYPE.getIndex()]);
			loan.setGuaranteetype1(data[row][LoanNSEnum.GUARANTEETYPE1.getIndex()]);
			loan.setFloatscope(data[row][LoanNSEnum.FLOATSCOPE.getIndex()]);
			loan.setAdjusttype(data[row][LoanNSEnum.ADJUSTTYPE.getIndex()]);
			loan.setRuntype(data[row][LoanNSEnum.RUNTYPE.getIndex()]);
			loan.setFrequeency(data[row][LoanNSEnum.FREQUEENCY.getIndex()]);
			loan.setRunitid(organId);
			loan.setRunitname(organName);
			Farmer farmer = farmerService.findById(loan.getIdnum(),organId);
			if(farmer == null ){
			//未匹配农户信息提示未匹配
				loanService.findByNoteNum(noteNum);
				try {
					loanService.save(loan);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				msg.put("row", String.valueOf(row));
				msg.put("tip", "success");
				msg.put("msg", "导入成功但未匹配农户信息，请稍后导入农户信息！");
				msgs.add(msg);
			}else{
			//匹配农户信息提示匹配数量
				msg.put("row", String.valueOf(row));
				loan.setFarmerid(farmer.getId());
				try {
					loanService.save(loan);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				msg.put("tip", "success");	
				msg.put("msg", "导入成功且匹配到相应的农户信息！");
				msgs.add(msg);
			}
		}
		return msgs;
	}
	public List<Map<String,String>> importLoanNY(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=3;row<data.length;row++){
			Map<String,String> msg = new HashMap<String,String>();
			FarmerLoan loan = new FarmerLoan();
			loan.setSourcecode("C1010336005158");
			loan.setSourcename("中国农业银行新干县支行");
			loan.setRunitid(organId);
			loan.setRunitname(organName);
			loan.setRecorder(recorder);
			loan.setRecordtime(recordTime);
			loan.setClientnum(data[row][LoanNYEnum.CLIENTNUM.getIndex()]);
			String noteNum = data[row][LoanNYEnum.NOTENUM.getIndex()];
			if(StringUtils.isEmpty(noteNum)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "error");
				msg.put("msg", "申请书编号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setNotenum(noteNum);
			String compactNum =data[row][LoanNYEnum.COMPACTNUM.getIndex()];
			if(StringUtils.isEmpty(compactNum)){
				//如果合同号为空提示合同号不能为空
				msg.put("row", String.valueOf(row));
				msg.put("tip", "error");
				msg.put("msg", "信贷信息的合同号不能为空！");
				msgs.add(msg);
				continue;
			}
			loan.setCompactnum(compactNum);
			loan.setLoandate(data[row][LoanNYEnum.LOANDATE.getIndex()]);
			loan.setLimitdate(data[row][LoanNYEnum.LIMITDATE.getIndex()]);
			String currency =DicExplain.explain(DicExplain.$CURRENCY, data[row][LoanNYEnum.CURRENCY.getIndex()]);
			loan.setCurrency(currency);
			loan.setAmount(data[row][LoanNYEnum.AMOUNT.getIndex()]);
			loan.setBalance(data[row][LoanNYEnum.BALANCE.getIndex()]);
			loan.setClienttype("1");
			loan.setClientname(data[row][LoanNYEnum.CLIENTNAME.getIndex()]);
			String idType = DicExplain.explain(DicExplain.$IDTYPE,data[row][LoanNYEnum.IDTYPE.getIndex()]);
			loan.setIdtype(idType);
			loan.setIdnum(data[row][LoanNYEnum.IDNUM.getIndex()]);
			loan.setGuaranteetype(data[row][LoanNYEnum.GUARANTEETYPE.getIndex()]);
			loan.setOrgancode(data[row][LoanNYEnum.ORGANCODE.getIndex()]);
			loan.setGuaranteetype1(data[row][LoanNYEnum.GUARANTEETYPE1.getIndex()]);
			
			
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fc = fe.createCriteria();
			fc.andFarmeridnumEqualTo(loan.getIdnum());
			fc.andSourcecodeEqualTo("C1010336005158");
			
			FarmerLoanExample le = new FarmerLoanExample();
			FarmerLoanExample.Criteria lc = le.createCriteria();
			lc.andNotenumEqualTo(loan.getNotenum());
			lc.andSourcecodeEqualTo("C1010336005158");
			
			
			List<Farmer> farmers = farmerService.selectByExample(fe);
			List<FarmerLoan> loans = loanService.selectByExample(le);
			if(farmers.size() == 1){
				Farmer farmer = farmers.get(0);
				loan.setFarmerid(farmer.getId());
			}else if(farmers.size()>1){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "success");
				msg.put("msg", "存在多条从中国农业银行新干县支行导入的农户信息");
				msgs.add(msg);
				continue;
			}
			try{
				if(loans.size() == 0){
					loanService.save(loan);
					msg.put("row", String.valueOf(row));
					msg.put("tip", "success");
					msg.put("msg", "导入成功但未匹配农户信息，请稍后导入农户信息！");
					msgs.add(msg);
				}else if(loans.size() == 1){
					loanService.update(loan);
					msg.put("tip", "success");	
					msg.put("msg", "导入成功且匹配到相应的农户信息！");
					msgs.add(msg);
				}else{
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
		return msgs;
	}
}
