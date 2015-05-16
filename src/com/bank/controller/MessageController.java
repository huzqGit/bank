package com.bank.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bank.Constants;
import com.bank.beans.Message;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IMessageService;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;

/**
 * 处理用户的新增、修改、删除等操作
 * @author Huzq
 *
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	@Resource
	private IMessageService messageSerivce;
	
	@RequestMapping(value = "/loadMessage", method = RequestMethod.POST)
	public Message loadMessage(@RequestParam(value="messageId",required=true) String messageId, HttpServletResponse response) throws Exception {
		Message message = messageSerivce.loadMessage(messageId);
		String json = JsonUtil.Encode(message);
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	public Message saveMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String formData = request.getParameter("formData");
		String actionType = request.getParameter("actionType");
		//這裡做了時間格式的處理
		Object decodeJsonData = JsonUtil.Decode(formData);
		String formatdata = JSON.toJSONStringWithDateFormat(decodeJsonData, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
		JSONObject jsb = JSONObject.parseObject(formatdata);
		Message message = (Message) JSON.toJavaObject(jsb, Message.class);
		String messageId = message.getMessageId();
		if ("add".equals(actionType)) {//message为空，做新增操作
			message.setPublishDate(new Date());
			User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
			if (user != null) {
				message.setUserId(user.getUserId());
				message.setUserName(user.getUserName());
			}
			messageId = messageSerivce.saveMessage(message);
		} else {//messageId不为空，做更新操作
			messageSerivce.updateMessage(message);
		}
		response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(messageId);
		return null;
	}
	
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public boolean deleteMessage(@RequestParam("messageId") String messageId){
		try {
			messageSerivce.delete(messageId);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (DeleteException e) {
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@RequestMapping(value = "/loadAllMessages", method = RequestMethod.POST)
	public Message loadAllMessages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询条件
	    String key = request.getParameter("key");
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    
	    List<Message> data = messageSerivce.loadAllMessages(key, pageIndex, pageSize, sortField, sortOrder);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
        
	    String json = JSON.toJSONString(result);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
}
