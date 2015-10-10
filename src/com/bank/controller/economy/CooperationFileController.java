package com.bank.controller.economy;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bank.Constants;
import com.bank.beans.Cooperation;
import com.bank.beans.CooperationExample;
import com.bank.beans.Organ;
import com.bank.beans.User;
import com.bank.beans.enums.CooperationNSEnum;
import com.bank.service.ICooperationService;
import com.bank.service.ICooperationService1;
import com.bank.utils.ParseDataUtils;

@Controller
@RequestMapping("economy")
public class CooperationFileController {
	
	@Resource
	private ICooperationService cooperationService;
	
	@RequestMapping(value="/importCooperationFile",method=RequestMethod.POST)
	public ModelAndView loadFile1(@RequestParam(value="sourcecode") String sourcecode, MultipartFile myfile,
			HttpServletRequest request, HttpServletResponse response){
		String[][] data = null;
		Organ organ = (Organ)request.getSession().getAttribute(Constants.SESSION_CURRENT_UNIT);
		User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		String organId = organ.getOrganId();
		String organName = organ.getOrganName();
		String recorder = user.getUserId();
		Date recordTime = new Date();
		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		ModelAndView view = new ModelAndView(); 
		String fileName = myfile.getOriginalFilename();
		if(!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls")){
			return view;
		}
		InputStream in = null;
		try {
			in = myfile.getInputStream();
			if( myfile.getOriginalFilename().endsWith(".xls")){
				 data = ParseDataUtils.readXls(in, 0);
			 }else{
				 data = ParseDataUtils.readXlsx(in, 0);
			 }
			if(sourcecode.equals("C3140436000017")){
				msgs = importCooperationNS(organId,organName,recorder,recordTime,data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view.addObject("msgs",msgs);
		return view;
	}
	private List<Map<String,String>> importCooperationNS(String organId,String organName,
			String recorder,Date recordTime,String[][] data){

		List<Map<String,String>> msgs = new ArrayList<Map<String,String>>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int row =2;row<data.length;row++){
			String clientType = data[row][CooperationNSEnum.CLINETTYPE.getIndex()];
			if(!clientType.contains("经济组织")){
				continue;
			}
			Map<String,String> msg = new HashMap<String,String>();
			Cooperation cooperation = new Cooperation();
			cooperation.setSourcecode("C3140436000017");
			cooperation.setSourcename("新干县农村信用合作联社");
			cooperation.setRunitid(organId);
			cooperation.setRunitname(organName);
			cooperation.setRecorder(recorder);
			cooperation.setRecordtime(recordTime);
			String cooperationName = data[row][CooperationNSEnum.COOPERATIONNAME.getIndex()];
			if(StringUtils.isEmpty(cooperationName)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "经济合作组织名称不能为空。");
				continue;
			}
			cooperation.setCooperationname(cooperationName);
			String businessLicence = data[row][CooperationNSEnum.BUSINESSLICENCE.getIndex()];
			if(StringUtils.isEmpty(businessLicence)){
				msg.put("row", String.valueOf(row));
				msg.put("tip", "info");
				msg.put("msg", "营业执照不能为空。");
				continue;
			}
			cooperation.setBusinesslicence(businessLicence);
			String legalPerson = data[row][CooperationNSEnum.LEGALPERSON.getIndex()];
			cooperation.setLegalperson(legalPerson);
			String idNum = data[row][CooperationNSEnum.IDNUM.getIndex()];
			cooperation.setIdnum(idNum);
			String registerDate = data[row][CooperationNSEnum.REGISTERDATE.getIndex()];
			if(!StringUtils.isEmpty(registerDate)){
				Date date;
				try {
					date = format.parse(registerDate);
					cooperation.setRegisterdate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			String phone = data[row][CooperationNSEnum.PHONE.getIndex()];
			String phone1 = data[row][CooperationNSEnum.PHONE1.getIndex()];
			String fullPhone = phone+"   "+phone1;
			cooperation.setPhone(fullPhone);
			String registerAddress = data[row][CooperationNSEnum.REGISTERADDRESS.getIndex()];
			cooperation.setRegisteraddress(registerAddress);
			CooperationExample ce = new CooperationExample();
			CooperationExample.Criteria cc = ce.createCriteria();
			cc.andSourcecodeEqualTo(cooperation.getSourcecode());
			cc.andBusinesslicenceEqualTo(cooperation.getBusinesslicence());

			List<Cooperation> cooperations = cooperationService.selectByExample(ce);
			if(cooperations == null || cooperations.size() == 0){
				cooperationService.insert(cooperation);
			}else if(cooperations.size() == 1){
				Cooperation dbCooperation = cooperations.get(0);
				cooperation.setId(dbCooperation.getId());
				CooperationExample ce1 = new CooperationExample();
				CooperationExample.Criteria cc1 = ce1.createCriteria();
				cc1.andCooperationidEqualTo(dbCooperation.getId());
				cooperationService.updateByExampleSelective(cooperation, ce1);
			}
		}
		return msgs;
	}


}
