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
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.bank.beans.Organ;
import com.bank.service.IFarmerMemberService;
import com.bank.service.IFarmerService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerMemberController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerMemberService farmerMemberService;
	
	@RequestMapping(value = "/saveMember",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute(value="member") FarmerMember member,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(member.getId() == null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				String organno = organ.getOrganNo();
				String organId = organ.getOrganId();
				String organName = organ.getOrganName();
				member.setSourcecode(organno);
				member.setRunitid(organId);
				member.setRunitname(organName);
				farmerMemberService.save(member);
			}else{
				farmerMemberService.update(member);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(member.getFarmerid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerMemberView");
		view.addObject("farmer",farmer);
		return view;
		
	}
	@RequestMapping(value="/queryMember",method=RequestMethod.GET)
	public ModelAndView queryMember(@RequestParam(value="fid") 	Long fid, 
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView("/farmer/farmerMemberView");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadMember", method = RequestMethod.POST)
	public ModelAndView loadMember(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response) {
		
			int totalNumber = 0;
			List<FarmerMember> members = null;
			try {
				FarmerMemberExample fm =  new FarmerMemberExample();
				FarmerMemberExample.Criteria fmc = fm.createCriteria();
				fmc.andFarmeridnumEqualTo(farmeridnum);
				fmc.andRunitidEqualTo(runitid);
				totalNumber = farmerMemberService.countByExample(fm);
				Map paramMap = new HashMap();
				paramMap.put("farmeridnum", farmeridnum);
				paramMap.put("runitid", runitid);
				members = farmerMemberService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Map map = new HashMap();
			map.put("total", totalNumber);
			map.put("data", members);
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
	@RequestMapping(value="/insertMember",method=RequestMethod.GET)
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
		ModelAndView view = new ModelAndView("/farmer/farmerMemberForm");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteMember",method=RequestMethod.GET)
	public ModelAndView deleteMember(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request,HttpServletResponse response)
	{

		try {
			farmerMemberService.delete(id);
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
		ModelAndView view = new ModelAndView("/farmer/farmerMemberView");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editMember",method=RequestMethod.GET)
	public ModelAndView editMember(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="id") Long id,
			@RequestParam(value="fid") Long fid)
	{
		Farmer farmer = null;
		FarmerMember member = null;
		try {
			farmer = farmerService.findByPK(fid);
			member = farmerMemberService.findByPK(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerMemberForm");
		view.addObject("farmer",farmer);
		view.addObject("member",member);
		return view;
	}
}
