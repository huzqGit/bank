package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import com.bank.beans.Message;
import com.bank.beans.MessageExample;
import com.bank.beans.MessageReader;
import com.bank.beans.User;
import com.bank.common.util.JsonUtil;
import com.bank.service.IMessageService;

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
	public Message loadMessage(@RequestParam(value="messageid",required=true) Long messageId, 
			HttpServletResponse response)
	{
		MessageExample me = new MessageExample();
		MessageExample.Criteria mc = me.createCriteria();
		mc.andMessageidEqualTo(messageId);
		List<Message> messages = messageSerivce.selectByExample(me);
		Message message = messages.get(0);
		String json = JsonUtil.Encode(message);
		response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	public ModelAndView saveMessage(@ModelAttribute(value="message") Message message,
			HttpServletRequest request, HttpServletResponse response) 
	{
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
		if(message.getMessageid() == null){
			message.setUserid(user.getUserId());
			message.setUsername(user.getUserName());
			messageSerivce.insert(message);
		}else{
			MessageExample me = new MessageExample();
			MessageExample.Criteria mc = me.createCriteria();
			mc.andMessageidEqualTo(message.getMessageid());
			messageSerivce.updateByExampleSelective(message,me);
		}
		ModelAndView view = new ModelAndView("/common/bankPublishView");
		return view;
	}
	@RequestMapping(value = "/editMessage", method = RequestMethod.GET)
	public ModelAndView editMessage(@RequestParam(value="messageid") Long messageId,
			HttpServletRequest request, HttpServletResponse response) 
	{
		MessageExample me = new MessageExample();
	    MessageExample.Criteria mc = me.createCriteria();
	    mc.andMessageidEqualTo(messageId);
		List<Message> messages = messageSerivce.selectByExample(me);
		if(messages.size() !=1){
			ModelAndView view = new ModelAndView("/common/bankPublishView");
			return view;
		}else{
			ModelAndView view = new ModelAndView("/common/bankPublishForm");
			Message message = messages.get(0);
			view.addObject("message",message);
			return view;
		}
	}
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public ModelAndView deleteMessage(@RequestParam("messageid") Long messageId,
			HttpServletResponse response){
		int num =0;
		try {
			MessageExample me = new MessageExample();
		    MessageExample.Criteria mc = me.createCriteria();
		    mc.andMessageidEqualTo(messageId);
			num = messageSerivce.deleteByExample(me);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(num);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	    
	    List<Message> data = messageSerivce.loadAllMessages(null,key, pageIndex, pageSize, sortField, sortOrder);
	    
	    HashMap result = new HashMap();
        result.put("data", data);
        result.put("total", data.size());
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    response.getWriter().write(json);
		return null;
	}
	@RequestMapping(value = "/loadAllMessagesByUser", method = RequestMethod.POST)
	public Message loadAllMessagesByUser(HttpServletRequest request, HttpServletResponse response){
		//查询条件
	    String key = request.getParameter("key");
	    //分页
	    int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
	    int pageSize = Integer.parseInt(request.getParameter("pageSize"));        
	    //字段排序
	    String sortField = request.getParameter("sortField");
	    String sortOrder = request.getParameter("sortOrder");
	    User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	    List<Message> data = messageSerivce.loadAllMessages(user.getUserId(),key, pageIndex, pageSize, sortField, sortOrder);
	    
	    HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", data);
        result.put("total", data.size());
	    String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	    response.setContentType("text/html;charset=UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/loadIndexPage", method = RequestMethod.GET)
	public ModelAndView loadIndexPage(HttpServletRequest request, HttpServletResponse response){
	    User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	    List<Message> messages = messageSerivce.loadAllMessages(user.getUserId(),null, 0,
	    		7, "publishDate", "asc");
	    ModelAndView view = new ModelAndView("/main/tool/index");
	    view.addObject("messages",messages);
		return view;
	}
	@RequestMapping(value = "/readMessage", method = RequestMethod.GET)
	public ModelAndView readMessage(@RequestParam("messageid") Long messageId,
			HttpServletRequest request, HttpServletResponse response){
		User user = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_USER);

		MessageReader reader = new MessageReader();
		reader.setMessageid(messageId);
		reader.setUserid(user.getUserId());
		reader.setUsername(user.getUserName());
		reader.setReadtime(new Date());
		messageSerivce.insertMessageReader(reader);
		MessageExample me = new MessageExample();
		MessageExample.Criteria mc = me.createCriteria();
		mc.andMessageidEqualTo(messageId);
		List<Message> messages = messageSerivce.selectByExample(me);
		ModelAndView view = new ModelAndView("/common/messageReport");
		if(messages.size() !=0){
			Message message = messages.get(0);
			view.addObject("message",message);
		}
		return view;
	}
}
