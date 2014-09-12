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
      <meta charset="utf-8">
      <title>Pixma Responsive HTML5/CSS3 Template | FIFO THEMES</title>
      <meta name="description" content="Pixma Responsive HTML5/CSS3 Template from FIFOTHEMES.COM">
      <meta name="author" content="FIFOTHEMES.COM">
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Library CSS -->
      <link rel="stylesheet" href="/realty/css/bootstrap.css"> 
       <link rel="stylesheet" href="/realty/css/font-awesome.css"> 
      <link rel="stylesheet" href="/realty/css/superfish.css" media="screen"> 
      <link rel="stylesheet" href="/realty/css/index.css"> 
      <!-- Theme CSS -->
     <link rel="stylesheet" href="/realty/css/style.css">
      <!-- Responsive CSS -->
       <link rel="stylesheet" href="/realty/css/theme-responsive.css">
      <!-- Favicons -->
      
      <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
      <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <script src="/realty/js/website/respond.min.js"></script>
      <![endif]-->
      
      
   
   </head>
<body>

恭喜您，从现在起，您就是本站的一员了。<br/>    
    <%-- 下面是您的昵称：<br/>    
    ${registerName }  --%> 
</body>
</html>