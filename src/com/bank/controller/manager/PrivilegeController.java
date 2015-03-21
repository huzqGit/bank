package com.bank.controller.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.beans.Privilege;
import com.bank.common.util.JsonUtil;
import com.bank.controller.base.BaseController;
import com.bank.service.IPrivilegeService;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

/**
 * 资源类型的新增、修改、删除等操作
 *
 */
@Controller
@RequestMapping(value = "/privilege")
public class PrivilegeController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(PrivilegeController.class);
	private static String ADD = "add";
	
	@Resource
	private IPrivilegeService privilegeSerivce;
	
	@RequestMapping(value = "/loadPrivileges", method = RequestMethod.POST)
	public Privilege loadPrivileges(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Privilege> data = new ArrayList<Privilege>();
		try {
			data = privilegeSerivce.getAllEntities();
		} catch (DAOException e) {
			log.error("get privileges occurs error . ", e);
		}
	    
	    String json = JSON.toJSONString(data);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Privilege save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		Privilege privilege = (Privilege) JSON.toJavaObject(jsb, Privilege.class);
		String privilegeId = privilege.getId();
		
		if (ADD.equals(actionType)) {//user为空，做新增操作
			try {
				privilegeSerivce.save(privilege);
			} catch (DAOException e) {
				String msg = "Create privilege occurs DAO error";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (CreateException e) {
				String msg = "Create privilege occurs error";
				log.error(msg, e);
				throw new CreateException(msg, e);
			}
		} else {
			try {
				privilegeSerivce.update(privilege);
			} catch (DAOException e) {
				String msg = "update privilege occurs DAO error. ";
				log.error(msg, e);
				throw new DAOException(msg, e);
			} catch (UpdateException e) {
				String msg = "update privilege (pk:" + privilege.getId() + ") occur errors";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			} catch (DataNotFoundException e) {
				String msg = "delete privilege not found (pk:" + privilege.getId() + ")";
				log.error(msg, e);
				throw new UpdateException(msg, e);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(privilegeId + "");
		} catch (IOException e) {
			log.error("", e);
			throw new IOException("", e);
		}
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@RequestParam("privilegeId") String privilegeId) throws Exception {
		try {
			if (StringUtils.isEmpty(privilegeId)) throw new DAOException("主键不能为空!");
			
			privilegeSerivce.delete(privilegeId);
			
		} catch (DAOException e) {
			log.error("", e);
			throw new DAOException("", e);
		} catch (DeleteException e) {
			String msg = "delete privilege occur errors";
			log.error(msg, e);
			throw new DeleteException(msg, e);
		} catch (DataNotFoundException e) {
			String msg = "delete privilege not found (pk:" + privilegeId + ")";
			log.error(msg, e);
			throw new DataNotFoundException(msg, e);
		}
		return true;
	}
	
	@RequestMapping(value = "/savePrivileges", method = RequestMethod.POST)
	@ResponseBody
	public Privilege savePrivileges(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String json = request.getParameter("data");
	    ArrayList rows = (ArrayList)JsonUtil.Decode(json);

	    for(int i=0,l=rows.size(); i<l; i++){
	    	HashMap row = (HashMap)rows.get(i);
	    	Privilege privilege = (Privilege) rows.get(i);
	    	
			String id = row.get("privilegeId") != null ? row.get("privilegeId").toString() : "";
	        String state = row.get("_state") != null ? row.get("_state").toString() : "";
	        
	        if(state.equals("added") || id.equals(""))	//新增：id为空，或_state为added
	        {
	            //row.put("createtime", new Date());
	        	privilegeSerivce.save(privilege);
	        }
	        else if (state.equals("removed") || state.equals("deleted"))
	        {
	            privilegeSerivce.delete(id);
	        }
	        else if (state.equals("modified") || state.equals(""))	//更新：_state为空，或modified
	        {
	        	privilegeSerivce.update(privilege);
	        }
	    }
		return null;
	}
}
