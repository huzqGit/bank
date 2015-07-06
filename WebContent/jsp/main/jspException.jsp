<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglibsCommon.jspf"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:directive.page
	import="org.apache.log4j.Logger" />
	
<jsp:directive.page
	import="com.common.exception.CommitException,com.common.exception.DAOException" />	
	
<%@ page contentType="text/html; charset=utf-8"%>
<%@page isErrorPage="true"%>
<%
String root=request.getContextPath();
if (!(exception instanceof DAOException)
			&& !(exception instanceof CommitException) {
		exception = new JSPException(exception);
}
%>
<html>
	<head>
		<title>操作失败</title>
		
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<table width="440" height="216" border="0" align="center"
			cellpadding="0" cellspacing="0" id="Table_01">
			
			
			<tr>
	
				<td >
					<div align="center">
						<%=exception.getMessage()%>
					</div>
				</td>

			</tr>
		</table>
	</body>

</html>
