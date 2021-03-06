package com.bank.controller.economy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.bank.beans.CooperationProfit;
import com.bank.beans.CooperationProfitExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.ICooperationProfitService;
import com.bank.service.ICooperationService;
import com.bank.service.ITMapService;
import com.bank.utils.HttpUtils;
import com.bank.utils.excel.ExcelExplorer;
import com.bank.utils.excel.ImportResult;
import com.bank.utils.excel.importer.ProfitImporter;

@Controller
@RequestMapping("economy/profit")
public class CooperationProfitController {
	
	private static Logger log = LoggerFactory.getLogger(CooperationProfitController.class);
	
	@Resource
	private ICooperationService cooperationService;
	
	@Resource
	private ICooperationProfitService cooperationProfitService;
	
	@Resource(name="profitImporter")
	private ProfitImporter profitImporter;
	
	@Resource(name="tMapService")
	private ITMapService tMapService;
	
//	private List<Map<String, String>> list = new ArrayList<Map<String,String>>();
	public static Map<String,List<Map<String, String>>> uMap = new HashMap<String, List<Map<String,String>>>();
	
	@RequestMapping(value="saveCooperationProfit",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		String formData = request.getParameter("formData");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		Organ organ = (Organ) request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONArray jsa = null;
		JSONObject[] jsons = new JSONObject[1];
		CooperationProfit coo = null;
		if(formData != null && formData.startsWith("[")){
			jsa = JSONArray.parseArray(formatdata);
			jsons = new JSONObject[jsa.size()];
			for(int i = 0;i<jsa.size();i++){
				jsons[i] = jsa.getJSONObject(i);
			}
		}else{
			jsons[0] = JSONObject.parseObject(formatdata);
		}
		for (JSONObject jsb : jsons){
			coo = (CooperationProfit) JSON.toJavaObject(jsb, CooperationProfit.class);
			try{
				if(coo.getId()==null){
					if(coo.getRecodertime() == null)
						coo.setRecodertime(new Date());
					coo.setSourcecode(user.getOrganId());
					tMapService.saveSDTMap(organ.getOrganId(),organ.getOrganName());
					cooperationProfitService.save(coo);
				}else{
					cooperationProfitService.update(coo);
				}
			}catch(Exception e){
				log.error(e.getMessage());
				throw e;
			}
			log.info("保存成功");
			String json = JSON.toJSONString(coo);
			response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	
	
	@RequestMapping(value="findCooperationProfit",method = RequestMethod.POST)
	public CooperationProfit findByPK(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String pk = HttpUtils.getParameter(request,"profitid");
		if(pk != null){
			CooperationProfit entity = cooperationProfitService.findByPK(Long.parseLong(pk));
			String json = JSON.toJSONStringWithDateFormat(entity,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		    response.setContentType("text/html;charset=UTF-8");
		    response.getWriter().write(json);
		}
		return null;
	}
	@RequestMapping(value="loadAllCooperationProfit",method = RequestMethod.POST)
	public void loadAllFarmerCooperation(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		//查询条件
	    String queryStr = HttpUtils.getParameter(request,"queryStr");
	    JSONObject jsonobj = JSON.parseObject(queryStr);
	    Map<String,String> map = new HashMap<String,String>();
	    if(jsonobj != null)
		    for(String s : jsonobj.keySet()){
		    	map.put(s, jsonobj.getString(s));
		    }
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<CooperationProfit> data = cooperationProfitService.getPageingEntities(pageIndex, pageSize, sortField, sortOrder,map);
	    long size = cooperationProfitService.getTotal(map);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", size);
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
//	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	
	@RequestMapping(value="deleteByKey")
	public void deleteByKey(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String id = HttpUtils.getParameter(request, "id");
		response.setContentType("text/html;charset=UTF-8");
		try {
			cooperationProfitService.delete(Long.parseLong(id));
			response.getWriter().write("{\"success\":\"删除成功\"}");
		} catch (Exception e) {
			response.getWriter().write("{\"success\":\"删除失败\"}");
		}
		return;
	}
	
	@RequestMapping("loadFile")
	public ModelAndView loadFile(@RequestParam("mufile") MultipartFile muFile,
			HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView model = new ModelAndView("cooperation/profitInfo/profitImportFile");
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String sourcecode = HttpUtils.getParameter(request, "t");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		try{
			map.put("sourcecode", sourcecode);
			map.put("organ_id", user.getOrganId());
			map.put("recorder", user.getUserName());
			
			InputStream in = muFile.getInputStream();
			ImportResult result = ExcelExplorer.importExcel(profitImporter.setMapValues(map), in);
			List<Map<String, String>> list2 = result.getResult();
			if (list2 != null) {
				String array = JSONArray.toJSONString(list2);
				Map<String,String> msg = new HashMap<String,String>();
				if("[]".equals(array)){
					msg.put("row", "1");
					msg.put("tip", "info");
					msg.put("msg", "操作完成...,");
					list.add(msg);
					model.addObject("msgs",list);
					return model;
				}
				msg.put("row", "1");
				msg.put("tip", "info");
				msg.put("msg", result.getMessage());
				list.add(msg);
				model.addObject("msgs",list);
				model.addObject("importError","importError");
//				this.list = list2;
				uMap.put(user.getOrganId()+"$"+user.getUserId(), list2);
				return model;
			} else {
				Map<String,String> msg = new HashMap<String,String>();
				msg.put("row", "1");
				msg.put("tip", "info");
				msg.put("msg", "无数据");
				list.add(msg);
				model.addObject("msgs",list);
				return model;
			}
		}catch(Exception e){
			Map<String,String> msg = new HashMap<String,String>();
			msg.put("row", String.valueOf(1));
			msg.put("tip", "error");
			msg.put("msg", "不支持的");
			list.add(msg);
			model.addObject("msgs",list);
			return model;
		}
	}
	
	@RequestMapping(value="loadFileResult",method = RequestMethod.POST)
	public void loadFileResult(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		HashMap<String,Object> result = new HashMap<String,Object>();
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));   
	    List<Map<String,String>> pageList = new ArrayList<Map<String,String>>();
	    int l = 0;
	    List<Map<String, String>> list = uMap.get(user.getOrganId()+"$"+user.getUserId());
	    try {
			for(Map<String,String> map : list){
				l = Integer.parseInt(map.get("profitid"));
				if(l>= (pageIndex * pageSize) && l < (pageIndex * pageSize + pageSize))
					pageList.add(map);
			}
		} catch (Exception e) {
		}
	    
        result.put("data", pageList);
        result.put("total", list.size());
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/loadCooperationProfit",method=RequestMethod.POST)
	public ModelAndView loadCooperationProfit(@RequestParam(value="organcode") String organcode,
			@RequestParam(value="pageIndex") int pageIndex,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="sortField") String sortField,
			@RequestParam(value="sortOrder") String sortOrder,
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationProfitExample cpe = new CooperationProfitExample();
		CooperationProfitExample.Criteria cpec = cpe.createCriteria();
		cpec.andOrgancodeEqualTo(organcode);
		
		int totalNumber = cooperationProfitService.countByExample(cpe);
		List<CooperationProfit> profits = cooperationProfitService.selectByExample(cpe);
		Map map = new HashMap();
		map.put("total", totalNumber);
		map.put("data", profits);
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
	@RequestMapping(value="/queryCooperationProfit",method=RequestMethod.GET)
	public ModelAndView queryCooperationProfit(@RequestParam(value="cid") Long cid, 
			HttpServletRequest request,HttpServletResponse response){

		CooperationExample ce = new CooperationExample();
		CooperationExample.Criteria cec = ce.createCriteria();
		cec.andCooperationidEqualTo(cid);
		List<Cooperation> cooperations = cooperationService.selectByExample(ce);
		Cooperation cooperation = null;
		if(cooperations!=null && cooperations.size()>0){
			cooperation = cooperations.get(0);
		}
		ModelAndView view = new ModelAndView("/cooperation/cooperationProfitView");
		view.addObject("cooperation",cooperation);
		return view;
	}
	@RequestMapping(value="/insertCooperationProfit",method=RequestMethod.GET)
	public ModelAndView insertCooperationProfit(@RequestParam(value="cid") Long cid, 
			HttpServletRequest request,HttpServletResponse response){
		
		CooperationExample cde = new CooperationExample();
		CooperationExample.Criteria  cdec = cde.createCriteria();
		cdec.andCooperationidEqualTo(cid);
		List<Cooperation> cooperations = cooperationService.selectByExample(cde);
		Cooperation cooperation = cooperations.get(0);
		ModelAndView view = new ModelAndView("/cooperation/cooperationProfitForm");
		view.addObject("cooperation",cooperation);
		return view;
	}
}
