<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
 	String membername=(String)session.getAttribute("membername"); 
    
 %>
   
 <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/realty/css/style1.css" />
</head>
<body>
<div class="wrapper">
    <form id="form1" name="form1" action="WebLogin" method="post" >
    <div class="loginBox">
	        <div class="loginBoxCenter">
	            <p><label for="username">用户名：</label></p>
	            <p><input type="text" id="membername" name="membername" class="loginInput" autofocus="autofocus" required="required" autocomplete="off" placeholder="请输入电子邮箱" value="" /></p>
	            <p><label for="password">密码：</label><a class="forgetLink" href="/realty/website/login/pwdBack.jsp">忘记密码?</a></p>
	            <p><input type="password" id="memberpwd" name="memberpwd" class="loginInput" required="required" placeholder="请输入密码" value="" /></p>
	        </div>
	        <div class="loginBoxButtons">
	           <!-- <input id="remember" type="checkbox" name="remember" /> -->
	            <label for="remember">记住登录状态</label>
	            <button class="loginBtn">登录</button>
	        </div> 
	    </div>
	    </form>
	</div>
</body>
</html>