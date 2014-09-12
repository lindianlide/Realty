<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.WebsiteAction,java.util.List,com.realty.base.model.*,java.text.SimpleDateFormat;" %>
    
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>  
<%

String news_id1=(String)request.getParameter("news_id");
int news_id=Integer.parseInt(news_id1);
String newscategoryId1=(String)request.getParameter("newscategoryId");
int newscategoryId=Integer.parseInt(newscategoryId1);
WebsiteAction website=new WebsiteAction();
List<News> list=website.newsList(newscategoryId);
int j=0;
for(int i=0;i<list.size();i++){
	if(list.get(i).getNewsId()==news_id)	
	{ j=i;
	  break;
		}	
}
String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(list.get(j).getDate());
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
#Layer1 {
	position:absolute;
	width:928px;
	height:445px;
	z-index:1;
}
#Layer2 {
	text-align:center;
	position:absolute;
	width:495px;
	height:43px;
	z-index:1;
	left: 230px;
	top: -1px;
}
#Layer3 {
	position:absolute;
	width:817px;
	height:342px;
	z-index:2;
	left: 62px;
	top: 83px;
}
#Layer4 {
	text-align:center;
	position:absolute;
	width:493px;
	height:32px;
	z-index:3;
	top: 48px;
	left: 232px;
}
-->
</style>
</head>
<body>
<div id="Layer1">
  <div id="Layer2"> 
  <h4><%=list.get(j).getTitle() %>
  </h4>
  </div>
  <div id="Layer3">
  <%=list.get(j).getContents() %>
  </div>
  <div id="Layer4">
  浏览次数： <%=list.get(j).getBrowses()%>&emsp;日期：<%=datetime%>
  </div>
</div>
</body>
</html>