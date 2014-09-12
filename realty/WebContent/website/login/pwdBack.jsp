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
<div id="panel-register">
     <form id=form2 name="form2" method="post" action="MemberAdd?flag=2"  >
     <table>
     	<tr>
		<td>
		用户名：
		</td>
		<td>
		<input id="membername" type="text" name="membername" >
		<tr>
		<td>
		注册邮箱：
		</td>
		<td>
		<input id="email" type="text" name="email">
   		<input type="submit" value="提交" name="tect6">
   		<input type="reset" value="重置" name="text7">
     </table>
     </form>
     </div>
	</div>
</body>
</html>