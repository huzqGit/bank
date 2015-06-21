<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>   
<%@ page import="com.bank.beans.User" %>
<%@ page import=" com.bank.Constants" %>
<%@ page import="java.text.SimpleDateFormat"%>
<% 
	User user = (User)request.getSession().getAttribute(Constants.SESSION_AUTH_USER);
	String userId = user.getUserId();
	String currentTime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	request.setAttribute("recorder", userId);
	request.setAttribute("currentTime", currentTime);
%>