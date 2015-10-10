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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Farmer;
import com.bank.beans.FarmerExample;
import com.bank.beans.FarmerMember;
import com.bank.beans.FarmerMemberExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.DicExplain;
import com.bank.beans.enums.FarmerMemberBZEnum;
import com.bank.service.IFarmerMemberService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
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
				member.setSourcecode(organ.getOrganNo());
				member.setSourcename(organ.getOrganName());
				member.setRunitid(organ.getOrganId());
				member.setRunitname(organ.getOrganName());
				farmerMemberService.save(member);
			}else{
				farmerMemberService.update(member);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(member.getFarmeridnum());
		fec.andRunitidEqualTo(member.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerMemberView");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
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
	@RequestMapping(value="/importFarmerMember",method=RequestMethod.POST)
	public ModelAndView importFarmerMember(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
			HttpServletRequest request,HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute("unit");
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String recorder = user.getUserId();
		Date recordTime = new Date();
		//List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
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
		}
		if("TYCJ".equals(sourcecode)){
			importFarmerBZ(organId,organName,recorder,recordTime,data);
		}
		return null;
		
	}
	private List<Map<String,String>> importFarmerBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] datas){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row=1;row<datas.length;row++){
			Map<String,String> msg = new HashMap<String,String>();
			FarmerMember member = new FarmerMember();
			member.setSourcecode("TYCJ");
			member.setSourcename("统一采集小组");
			member.setRunitid(organId);
			member.setRunitname(organName);
			member.setRecorder(recorder);
			member.setRecordtime(new Date());
			String name = datas[row][FarmerMemberBZEnum.NAME.getIndex()];
			if(StringUtils.isEmpty(name)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "姓名不能为空。");
				continue;
			}
			member.setName(name);
			String idNum = datas[row][FarmerMemberBZEnum.IDNUM.getIndex()];
			if(StringUtils.isEmpty(idNum)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "姓名不能为空。");
				continue;
			}
			member.setIdnum(idNum);
			String farmerIdNum = datas[row][FarmerMemberBZEnum.FARMERIDNUM.getIndex()];
			if(StringUtils.isEmpty(farmerIdNum)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "姓名不能为空。");
				continue;
			}
			member.setFarmeridnum(farmerIdNum);
			String relation = DicExplain.explain(DicExplain.$RELATION,datas[row][FarmerMemberBZEnum.RELATION.getIndex()]);
			if(StringUtils.isEmpty(relation)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "姓名不能为空。");
				continue;
			}
			member.setRelation(relation);
			String education = DicExplain.explain(DicExplain.$EDUCATION, datas[row][FarmerMemberBZEnum.EDUCATION.getIndex()]);
			if(StringUtils.isEmpty(education)){
				member.setEducation(Integer.valueOf(education));
			}
			String sex = DicExplain.explain(DicExplain.$SEX,datas[row][FarmerMemberBZEnum.SEX.getIndex()]);
			if(!StringUtils.isEmpty(sex)){
				member.setSex(Integer.valueOf(sex));
			}
			String marryStatus = datas[row][FarmerMemberBZEnum.MARRYSTATUS.getIndex()];
			member.setMarrystatus(marryStatus);
			String occupation = datas[row][FarmerMemberBZEnum.OCCUPATION.getIndex()];
			member.setOccupation(occupation);
			String job = datas[row][FarmerMemberBZEnum.JOB.getIndex()];
			member.setJob(job);
			String  phone = datas[row][FarmerMemberBZEnum.PHONE.getIndex()];
			member.setPhone(phone);
			String address = datas[row][FarmerMemberBZEnum.ADDRESS.getIndex()];
			member.setAddress(address);
			FarmerMemberExample fme = new FarmerMemberExample();
			FarmerMemberExample.Criteria fmec = fme.createCriteria();
			fmec.andIdnumEqualTo(idNum);
			fmec.andSourcecodeEqualTo("TYCJ");
			List<FarmerMember> members = farmerMemberService.selectByExample(fme);
			try{
				if(members.size() == 0){
					farmerMemberService.save(member);
				}else if(members.size() == 1){
					member.setId(members.get(0).getId());
					farmerMemberService.update(member);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return msgs;
	}
}
