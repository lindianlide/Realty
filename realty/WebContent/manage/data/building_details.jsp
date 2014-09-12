<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.ArrayList"%>
<%
String buildingId1=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingId1);
%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加管理员</title>
<base href="<%=basePath%>">

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/tab.js"></script>
<link href="css/tab.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
</head>
<body style="scrollbar-base-color:red">
<form id="form2" name="form2" method="post" >
<div id="container" style="container_style">
<div id="li_area" class="li_area_style">
    <ul id="ul_area" class="ul_area_style">
        <li class="listli">详细信息</li>
        <li >周边信息</li>
        <li >分栋情况</li>    
        <li >配套设施</li>    
    </ul>
</div>
<div id="tab_area" class="tab_area_style">
     <iframe name="buildingone" id="buildingone"  class="content_area" src="manage/data/building_detail.jsp?buildingId=<%=buildingId %>" frameborder="0" >
    </iframe>
   <iframe  name="buildingtwo" id="buildingtwo" src="manage/data/buildingaround_detail.jsp?buildingId=<%=buildingId %>" frameborder="0" >
    </iframe>
   <iframe  name="buildingthree" id="buildingthree" src="manage/data/buildingfloor_list.jsp?buildingId=<%=buildingId %>" frameborder="0" >
    </iframe> 
     <iframe  name="buildingfour" id="buildingfour" src="manage/data/buildingmatch_detail.jsp?buildingId=<%=buildingId %>" frameborder="0" >
    </iframe>
</div>
</div>
</form>
</body>
</html>
