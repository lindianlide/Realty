<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,java.util.List;"%>
 <% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>    
<%
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);
String locationphoto ="land_location";
LandAction landaction=new LandAction();
List locationList=landaction.landPhoto(landId, locationphoto);
int locationsize=locationList.size();
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
      <th height="30" align="center">宗地位置图 </th>
         </tr>
      <tr>
      <td>
       <%
      if(locationsize!=0)
      for(int k=0;k<locationsize;k++)
      {
      %>
      <img style="width:200px;height:250px;" src="picupload/land/<%=(String)locationList.get(k)%>"/>&emsp;
      <%}
      %>  </td>
    </tr>
    </table>
</body>
</html>