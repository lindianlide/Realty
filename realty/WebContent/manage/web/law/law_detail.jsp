<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.WebsiteAction,java.util.List,com.realty.base.model.*,java.text.SimpleDateFormat;" %>
    
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>  
<%

String law_id1=(String)request.getParameter("law_id");
int law_id=Integer.parseInt(law_id1);
String lawcategoryId1=(String)request.getParameter("lawcategoryId");
int lawcategoryId=Integer.parseInt(lawcategoryId1);
WebsiteAction website=new WebsiteAction();
List<Law> list=website.lawList(lawcategoryId);
int j=0;
for(int i=0;i<list.size();i++){
	if(list.get(i).getLawId()==law_id)	
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
  <h4><%=list.get(j).getName() %>
  </h4>
  </div>
  <div id="Layer3">
  <%=list.get(j).getContents() %>
  </div>
  <div id="Layer4">
  浏览次数： <%=list.get(j).getNumber()%>&emsp;日期：<%=datetime%>
  </div>
</div>
</body>
</html>