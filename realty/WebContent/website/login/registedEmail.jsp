<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
 	String membername=(String)session.getAttribute("membername"); 
 %>
  <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/website/inc/head.inc"%>
</head>
<body class="home">
<%@include file="/website/inc/header.inc"%>
<div id="panel-register">邮箱已注册
<a href="./pwdBack.jsp" >找回密码</a>
<a href="./login.jsp">直接登录</a>
</div>
</body>
</html>