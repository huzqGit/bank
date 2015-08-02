package com.bank.controller.farmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerCredit;
import com.bank.beans.FarmerCreditExample;
import com.bank.beans.Organ;
import com.bank.service.IFarmerCreditService;
import com.bank.service.IFarmerService;
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
			credit.setRunitid(organ.getOrganId());
			credit.setRunitname(organ.getOrganName());
			credit.setSourcecode(organ.getOrganNo());
			credit.setSourcename(organ.getOrganName());
			farmerCreditService.insert(credit);
		}else{
			FarmerCreditExample fe  = new FarmerCreditExample();
			FarmerCreditExample.Criteria fc = fe.createCriteria();
			fc.andCreditidEqualTo(credit.getCreditid());
			farmerCreditService.updateByExample(credit, fe);
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(credit.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCreditView");
		view.addObject("farmer",farmer);
		return view;
		
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
	    map.put("data", totalNumber);
        map.put("total", credits);
        
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
	public ModelAndView deleteCredit(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request,HttpServletResponse response)
	{

		try {
			FarmerCreditExample fe = new FarmerCreditExample();
			FarmerCreditExample.Criteria fc = fe.createCriteria();
			fc.andCreditidEqualTo(fid);
			farmerCreditService.deleteByExample(fe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerCreditView");
		view.addObject("farmer",farmer);
		return view;
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
	
}
