<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%
String buildingaroundId=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingaroundId);
BuildingAction build=new BuildingAction();
List<Building> buildList=build.buildingList();
int id=0;
for(int j=0;j<buildList.size();j++){
	if(buildList.get(j).getBuildingId()==buildingId){
		{
			id=j;
			 break;
			}
	}
}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<form id="form1" name="form1" method="post"  action="">
  <table width="663" height="312" cellpadding=0 cellspacing=0 align="center">
    <tr>
      <td width="289" height="30" >供水：
        <span><%=buildList.get(id).getWaterSupply()%> </span></td>
      <td width="358" height="30">供暖：
         <span><%=buildList.get(id).getHeatSupply()%></span></td>
    </tr>
    <tr>
      <td height="30">供电：
        <span><%=buildList.get(id).getElectricitySupply()%></span></td>
      <td height="30">燃气：
        <span><%=buildList.get(id).getGas()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">通讯设备：
     <span><%=buildList.get(id).getCommunications()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">电梯服务：
         <span><%=buildList.get(id).getElevato()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">安全管理：
         <span><%=buildList.get(id).getSecurity()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">卫生服务：
       <span><%=buildList.get(id).getHygienism()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">小区入口：
         <span><%=buildList.get(id).getCommunityEnter()%></span></td>
    </tr>
    <tr>
      <td height="30" colspan="2">停车位：
          <span><%=buildList.get(id).getParking()%></span></td>
    </tr>

  </table>

</form>
</body>
</html>