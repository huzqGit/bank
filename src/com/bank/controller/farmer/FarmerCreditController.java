package com.bank.controller.farmer;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;
import com.bank.beans.FarmerExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerCreditBZEnum;
import com.bank.beans.enums.FarmerMemberBZEnum;
import com.bank.service.IFarmerCreditService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerCreditController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerCreditService farmerCreditService;
	
	@RequestMapping(value = "/saveCredit",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(value="credit") FarmerCredit credit,
			HttpServletRequest request,HttpServletResponse response){
		if(credit.getCreditid() == null){
			Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			credit.setSourcecode(organ.getOrganNo());
			credit.setSourcename(organ.getOrganName());
			credit.setRunitid(organ.getOrganId());
			credit.setRunitname(organ.getOrganName());
			farmerCreditService.insert(credit);
		}else{
			FarmerCreditExample fe  = new FarmerCreditExample();
			FarmerCreditExample.Criteria fc = fe.createCriteria();
			fc.andCreditidEqualTo(credit.getCreditid());
			farmerCreditService.updateByExample(credit, fe);
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(credit.getFarmeridnum());
		fec.andRunitidEqualTo(credit.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerCreditView");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}	
	}
	
	@RequestMapping(value = "/loadCredit", method = RequestMethod.POST)
	public ModelAndView loadCredit(@RequestParam(value="id",required=true) Long id, 
		HttpServletResponse response) throws Exception {
		FarmerCreditExample fe = new FarmerCreditExample();
		FarmerCreditExample.Criteria fc = fe.createCriteria();
		fc.andCreditidEqualTo(id);
		farmerCreditService.selectByExample(fe);
		return null;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/loadAllCredit",method=RequestMethod.POST)
	public ModelAndView loadAllCredit(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
	    
		FarmerCreditExample fce = new FarmerCreditExample();
		FarmerCreditExample.Criteria fcec = fce.createCriteria();
		fcec.andFarmeridnumEqualTo(farmeridnum);
		fcec.andRunitidEqualTo(runitid);
		int totalNumber = farmerCreditService.countByExample(fce);
		
	    Map paramMap = new HashMap();
	    paramMap.put("farmeridnum", farmeridnum);
	    paramMap.put("runitid", runitid);
	   
	    List<FarmerCredit> credits =farmerCreditService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);

	    HashMap map = new HashMap();
	    map.put("data",credits );
        map.put("total", totalNumber);
        
	    String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter writer;
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
	@RequestMapping(value="/insertCredit",method=RequestMethod.GET)
	public ModelAndView insertMember(@RequestParam(value="fid") Long fid, 
			HttpServletRequest request,HttpServletResponse response){

		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(fid);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCreditForm");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteCredit",method=RequestMethod.GET)
	public ModelAndView deleteCredit(@RequestParam(value="id") Long id,
			HttpServletRequest request,HttpServletResponse response)
	{

		FarmerCreditExample fce = new FarmerCreditExample();
		FarmerCreditExample.Criteria fcec = fce.createCriteria();
		fcec.andCreditidEqualTo(id);
		List<FarmerCredit> credits = farmerCreditService.selectByExample(fce);
		if(credits.size() == 1){
			farmerCreditService.deleteByExample(fce);
			Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
			FarmerExample fe = new FarmerExample();
			FarmerExample.Criteria fec = fe.createCriteria();
			fec.andFarmeridnumEqualTo(credits.get(0).getFarmeridnum());
			fec.andRunitidEqualTo(organ.getOrganId());
			List<Farmer> farmers = farmerService.selectByExample(fe);
			if(farmers.size() == 1){
				ModelAndView view = new ModelAndView("/farmer/farmerCreditView");
				view.addObject("farmer",farmers.get(0));
				return view;
			}else{
				return null;
			}	
		}else{
			return null;
		}
		
	}
	@RequestMapping(value="/editCredit",method=RequestMethod.GET)
	public ModelAndView editCredit(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id") Long id,
			@RequestParam(value="fid") Long fid)
	{
		Farmer farmer = null;
		FarmerCredit credit = null;
		try {
			farmer = farmerService.findByPK(fid);
			FarmerCreditExample fe = new FarmerCreditExample();
			FarmerCreditExample.Criteria fc = fe.createCriteria();
			fc.andCreditidEqualTo(id);
			List<FarmerCredit> credits = farmerCreditService.selectByExample(fe);
			credit = credits.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCreditForm");
		view.addObject("farmer",farmer);
		view.addObject("credit",credit);
		return view;
	}
	@RequestMapping(value="/queryCredit",method=RequestMethod.GET)
	public ModelAndView queryCredit(@RequestParam(value="fid") 	Long fid, 
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView("/farmer/farmerCreditView");
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/importFarmerCredit",method=RequestMethod.POST)
	public ModelAndView importFarmerCredit(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = null;
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
			msgs = importFarmerCreditBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCreditImorter");
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerCreditBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row = 1;row<data.length;row++){
			FarmerCredit credit = new FarmerCredit();
			String farmerIdNum = data[row][FarmerCreditBZEnum.FARMERIDNUM.getIndex()];
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号码不能为空。");
				msgs.add(msg);
				continue;
			}
			Date assessDate = null;
			try{
				assessDate = format.parse(data[row][FarmerCreditBZEnum.ASSESSDATE.getIndex()]);
				credit.setAssessdate(assessDate);
			}catch(Exception e){
				e.printStackTrace();
			}
			String  assessOran= data[row][FarmerCreditBZEnum.ASSESSORGAN.getIndex()];
			credit.setAssessorgan(assessOran);
			if(StringUtils.isEmpty(assessOran)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行评价部门不能为空。");
				msgs.add(msg);
				continue;
			}
			
			String assessRank = data[row][FarmerCreditBZEnum.ASSESSRANK.getIndex()];
			credit.setAssessrank(assessRank);
			if(StringUtils.isEmpty(assessRank)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行姓名不能为空。");
				msgs.add(msg);
				continue;
			}
			
			String timeLimit = data[row][FarmerCreditBZEnum.TIMELIMIT.getIndex()];
			credit.setTimelimit(timeLimit);
			if(StringUtils.isEmpty(assessRank)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行姓名不能为空。");
				msgs.add(msg);
				continue;
			}
			FarmerCreditExample fce = new FarmerCreditExample();
			FarmerCreditExample.Criteria fcec = fce.createCriteria();
			fcec.andFarmeridnumEqualTo(farmerIdNum);
			fcec.andAssessorganEqualTo(assessOran);
			fcec.andAssessrankEqualTo(assessRank);
			fcec.andTimelimitEqualTo(timeLimit);
			List<FarmerCredit> credits = farmerCreditService.selectByExample(fce);
			if(credits.size() == 0){
				farmerCreditService.insert(credit);
			}
			
		}
		return  msgs;
	}
	
}
