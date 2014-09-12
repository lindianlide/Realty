<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,java.util.List;"%>
 <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>    
<%
String buildingIds=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingIds);

BuildingAction buildingaction=new BuildingAction();

String locationPhoto="building_locationphoto";

List buildingpList=buildingaction.buildingPhoto(buildingId,locationPhoto);
int buildingsize=buildingpList.size();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
<table>
   <tr>
      <th height="30" align="center">楼盘位置图：</th>
   </tr>
   <tr>
      <td>
	       <%
      if(buildingsize!=0)
      for(int k=0;k<buildingsize;k++)
      {
      %>
      <img style="width:200px;height:250px;" src="/realty/picupload/building/<%=(String)buildingpList.get(k)%>"/>
      <%}
      %> 
      </td>
    </tr>
    </table>
</body>
</html>