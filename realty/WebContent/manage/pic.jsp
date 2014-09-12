<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*"%>
<%
BuildingAction BD=new BuildingAction();
List<Building> BDList=BD.buildingList();
System.out.println(BDList.get(8).getLocationphoto());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="<%=BDList.get(8).getLocationphoto()%>">
</body>
</html>