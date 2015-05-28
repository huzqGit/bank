package com.bank.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bank.utils.HttpUtils;
import com.common.exception.JSPNotFoundException;
import com.common.exception.MismatchException;

@Controller
@RequestMapping("common")
public class CommonController {
	private static Logger log = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * 新增表单
	 * @author zkongbai
	 * @date 2015年5月27日  下午1:02:58
	 * @version 1.0
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addForm")
	public ModelAndView addForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		String redirectJsp = null;
		try {
			redirectJsp = HttpUtils.getParameter(request, "dest");//dest为需要跳转的jsp路径
			if(redirectJsp.endsWith(".jsp"))
				redirectJsp = redirectJsp.replace(".jsp", "");
		} catch (Exception e) {
			log.error("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
			throw new JSPNotFoundException("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
		}
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		try{
			if(keys !=null && values != null){
				key = keys.split(";");
				value = values.split(";");
				for(int i=0;i<key.length;i++){
					view.addObject(key[i], value[i]);
				}
			}
		}catch(Exception e){
			log.error("sys_key与sys_value参数不匹配\t"+e.getMessage());
			throw new MismatchException("sys_key与sys_value参数不匹配\t"+e.getMessage());
		}
		log.info("当前访问页面为:\t"+redirectJsp+".jsp");
		view.addObject("display","display:display");
		return view;
	}
	/**
	 * 编辑表单
	 * @author zkongbai
	 * @date 2015年5月27日  下午1:03:18
	 * @version 1.0
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="editForm")
	public ModelAndView editForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		String redirectJsp = null;
		try {
			redirectJsp = HttpUtils.getParameter(request, "dest");//dest为需要跳转的jsp路径
			if(redirectJsp.endsWith(".jsp"))
				redirectJsp = redirectJsp.replace(".jsp", "");
		} catch (Exception e) {
			log.error("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
			throw new JSPNotFoundException("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
		}
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		try{
			if(keys !=null && values != null){
				key = keys.split(";");
				value = values.split(";");
				for(int i=0;i<key.length;i++){
					view.addObject(key[i], value[i]);
				}
			}
		}catch(Exception e){
			log.error("sys_key与sys_value参数不匹配\t"+e.getMessage());
			throw new MismatchException("sys_key与sys_value参数不匹配\t"+e.getMessage());
		}
		log.info("当前访问页面为:\t"+redirectJsp+".jsp");
		view.addObject("display","display:display");
		return view;
	}
	/**
	 * 查阅表单
	 * @author zkongbai
	 * @date 2015年5月27日  下午1:03:40
	 * @version 1.0
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="viewForm")
	public ModelAndView viewForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		String redirectJsp = null;
		try {
			redirectJsp = HttpUtils.getParameter(request, "dest");//dest为需要跳转的jsp路径
			if(redirectJsp.endsWith(".jsp"))
				redirectJsp = redirectJsp.replace(".jsp", "");
		} catch (Exception e) {
			log.error("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
			throw new JSPNotFoundException("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
		}
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		try{
			if(keys !=null && values != null){
				key = keys.split(";");
				value = values.split(";");
				for(int i=0;i<key.length;i++){
					view.addObject(key[i], value[i]);
				}
			}
		}catch(Exception e){
			log.error("sys_key与sys_value参数不匹配\t"+e.getMessage());
			throw new MismatchException("sys_key与sys_value参数不匹配\t"+e.getMessage());
		}
		log.info("当前访问页面为:\t"+redirectJsp+".jsp");
		view.addObject("display","display:none");
		return view;
	}
	
	/**
	 * 查看视图
	 * @author zkongbai
	 * @date 2015年5月27日  下午1:03:50
	 * @version 1.0
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="viewView")
	public ModelAndView viewView(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		String keys = HttpUtils.getParameter(request, "sys_key");
		String values = HttpUtils.getParameter(request, "sys_value");
		String redirectJsp = null;
		try {
			redirectJsp = HttpUtils.getParameter(request, "dest");//dest为需要跳转的jsp路径
			if(redirectJsp.endsWith(".jsp"))
				redirectJsp = redirectJsp.replace(".jsp", "");
		} catch (Exception e) {
			log.error("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
			throw new JSPNotFoundException("jsp页面没找到:"+redirectJsp+"\t"+e.getMessage());
		}
		ModelAndView view = new ModelAndView(redirectJsp);
		String[] key = null;
		String[] value = null;
		try{
			if(keys !=null && values != null){
				key = keys.split(";");
				value = values.split(";");
				for(int i=0;i<key.length;i++){
					view.addObject(key[i], value[i]);
				}
			}
		}catch(Exception e){
			log.error("sys_key与sys_value参数不匹配\t"+e.getMessage());
			throw new MismatchException("sys_key与sys_value参数不匹配\t"+e.getMessage());
		}
		log.info("当前访问页面为:\t"+redirectJsp+".jsp");
		return view;
	}

}
