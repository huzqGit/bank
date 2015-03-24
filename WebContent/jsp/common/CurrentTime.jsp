<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>   
<%@ page import="java.text.SimpleDateFormat"%>
<% 
	String currentTime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	request.setAttribute("currentTime", currentTime);
%>