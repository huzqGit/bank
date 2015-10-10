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
import com.bank.beans.FarmerForest;
import com.bank.beans.FarmerForestExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.FarmerForestBZEnum;
import com.bank.service.IFarmerForestService;
import com.bank.service.IFarmerService;
import com.bank.utils.ParseDataUtils;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerForestController {
	
	@Resource
	private IFarmerService farmerService;
	
	@Resource
	private IFarmerForestService farmerForestService;
	
	@RequestMapping(value = "/saveForest1",method = RequestMethod.POST)
	public ModelAndView saveForest(@ModelAttribute(value="forest") FarmerForest forest,
			HttpServletRequest request,HttpServletResponse response){
		try{
			if(forest.getId() ==null){
				Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
				forest.setRunitid(organ.getOrganId());
				forest.setRunitname(organ.getOrganName());
				forest.setSourcecode(organ.getOrganNo());
				forest.setSourcename(organ.getOrganName());
				farmerForestService.save(forest);
			}else{
				farmerForestService.update(forest);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		FarmerExample fe = new FarmerExample();
		FarmerExample.Criteria fec = fe.createCriteria();
		fec.andFarmeridnumEqualTo(forest.getFarmeridnum());
		fec.andRunitidEqualTo(forest.getRunitid());
		List<Farmer> farmers = farmerService.selectByExample(fe);
		if(farmers.size() == 1){
			ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
			view.addObject("farmer",farmers.get(0));
			return view;
		}else{
			return null;
		}
	}
	@RequestMapping(value="/queryForest",method=RequestMethod.GET)
	public ModelAndView queryForest(@RequestParam(value="fid") String fid, 
			HttpServletRequest request,HttpServletResponse response){
		
		Long farmerId = Long.valueOf(fid);
		ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/deleteForest",method=RequestMethod.GET)
	public ModelAndView deleteForest(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		String fid = request.getParameter("fid");
		Long forestId = Long.valueOf(id);
		Long farmerId = Long.valueOf(fid);
		try {
			farmerForestService.delete(forestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Farmer farmer = null;
		try {
			farmer = farmerService.findByPK(farmerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestView1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/editForest",method=RequestMethod.GET)
	public ModelAndView editForest(@RequestParam(value="id") Long id,@RequestParam(value="fid") Long fid,
			HttpServletRequest request,HttpServletResponse response){
		Farmer farmer = null;
		FarmerForest forest = null;
		try {
			farmer = farmerService.findByPK(fid);
			forest = farmerForestService.findByPK(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestForm1");
		view.addObject("farmer",farmer);
		view.addObject("forest",forest);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/loadForest", method = RequestMethod.POST)
	public ModelAndView loadForest(@RequestParam(value="farmeridnum") String farmeridnum,
			@RequestParam(value="runitid") String runitid, 
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		FarmerForestExample ffe = new FarmerForestExample();
		FarmerForestExample.Criteria ffec= ffe.createCriteria();
		ffec.andFarmeridnumEqualTo(farmeridnum);
		ffec.andRunitidEqualTo(runitid);
		int totalNumber =  farmerForestService.countByExample(ffe);
		
		Map paramMap = new HashMap();
		paramMap.put("farmeridnum", farmeridnum);
		paramMap.put("runitid", runitid);
		List<FarmerForest> houses = null;
		try {
			houses = farmerForestService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder, paramMap);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Map map = new HashMap();		
		map.put("total", totalNumber);
		map.put("data", houses);
		String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
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
	
	@RequestMapping(value="/typeInForest",method=RequestMethod.GET)
	public ModelAndView typeInForest(@RequestParam(value="fid") String fid, 
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
		ModelAndView view = new ModelAndView("/farmer/farmerForestForm1");
		view.addObject("farmer",farmer);
		return view;
	}
	@RequestMapping(value="/importFarmerForest",method=RequestMethod.POST)
	public ModelAndView importFarmerForest(@RequestParam(value="sourcecode") String sourcecode,MultipartFile myfile,
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
			msgs = importFarmerForestBZ(organId,organName,recorder,recordTime,data);
		}
		ModelAndView view = new ModelAndView("/farmer/farmerForestImporter");
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importFarmerForestBZ(String organId,String organName,
			String recorder,Date recordTime,String[][] data){
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		for(int row = 1;row<data.length;row++){
			FarmerForest forest = new FarmerForest();
			forest.setSourcecode("TYCJ");
			forest.setSourcename("统一采集");
			forest.setRunitid(organId);
			forest.setRunitname(organName);
			forest.setRecorder(recorder);
			forest.setRecordtime(recordTime);
			String farmerIdNum = data[row][FarmerForestBZEnum.FARMERIDNUM.getIndex()];
			forest.setFarmeridnum(farmerIdNum);
			if(StringUtils.isEmpty(farmerIdNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行身份证号不能为空。");
				msgs.add(msg);
				continue;
			}
			String cardNum = data[row][FarmerForestBZEnum.CARDNUM.getIndex()];
			String wordNum = data[row][FarmerForestBZEnum.WORDNUM.getIndex()];
			String owner = data[row][FarmerForestBZEnum.OWNER.getIndex()];
			String useType = data[row][FarmerForestBZEnum.USETYPE.getIndex()];
			String area = data[row][FarmerForestBZEnum.AREA.getIndex()];
			forest.setArea(area);
			if(StringUtils.isEmpty(area)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行占地面积不能为空。");
				msgs.add(msg);
				continue;
			}
			String storeNum = data[row][FarmerForestBZEnum.STORENUM.getIndex()];
			forest.setStorenum(storeNum);
			if(StringUtils.isEmpty(storeNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"行蓄积量不能为空。");
				msgs.add(msg);
				continue;
			}
			String timeLimit = data[row][FarmerForestBZEnum.TIMELIMIT.getIndex()];
			forest.setTimelimit(timeLimit);
			if(StringUtils.isEmpty(storeNum)){
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("msg", "第"+row+"使用权期限不能为空。");
				msgs.add(msg);
				continue;
			}
			FarmerForestExample ffe = new FarmerForestExample();
			FarmerForestExample.Criteria ffec = ffe.createCriteria();
			ffec.andFarmeridnumEqualTo(farmerIdNum);
			ffec.andCardnumEqualTo(cardNum);
			ffec.andWordnumEqualTo(wordNum);
			ffec.andOwnerEqualTo(owner);
			ffec.andUsetypeEqualTo(useType);
			ffec.andAreaEqualTo(area);
			ffec.andStorenumEqualTo(storeNum);
			ffec.andTimelimitEqualTo(timeLimit);
			ffec.andSourcecodeEqualTo("TYCJ");
			List<FarmerForest> forests = farmerForestService.selectByExample(ffe);
			if(forests.size() ==0){
				try {
					farmerForestService.save(forest);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
