<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<base href="<%=basePath%>">
  
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>The Login Page</title>
	<meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-ocontrol" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1, keyword2, keyword3">
    <meta http-equiv="description" content="The Login Page">
    <!-- 
    	<link rel="stylesheet" type="text/css" href="styles.css">
     -->
</head>

<body>
	<form action="loginAction.action" method="post">
		<table>
		    <tr>
		        <td>Username:<input type="text" name="username"/></td>
		        <td><input type="submit" value="Login to Chat Room" /></td>
		    </tr>
		</table>
	</form>
</body>
</html>