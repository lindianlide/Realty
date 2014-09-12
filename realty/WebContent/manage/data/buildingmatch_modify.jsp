<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%
String buildingId1=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingId1);
BuildingAction buildingaction=new BuildingAction();
List<Building> buildList=buildingaction.buildingList();
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
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=9&buildingId=<%=buildingId%>">
  <table width="663" height="312" cellpadding=0 cellspacing=0 align="center">
    <tr>
      <td width="289" height="30" >供水：
        <input name="waterSupply" type="text" size="20"  value="<%=buildList.get(id).getWaterSupply()%>" /></td>
      <td width="358" height="30">供暖：
        <input name="heatSupply" type="text" size="20"  value="<%=buildList.get(id).getHeatSupply()%>"/></td>
    </tr>
    <tr>
      <td height="30">供电：
        <input name="electricitySupply" type="text" size="20"  value="<%=buildList.get(id).getElectricitySupply()%>"/></td>
      <td height="30">燃气：
        <input name="gas" type="text" size="20"  value="<%=buildList.get(id).getGas()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">通讯设备：
      <input name="communications" type="text" size="50"  value="<%=buildList.get(id).getCommunications()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">电梯服务：
        <input name="elevato" type="text" size="50"  value="<%=buildList.get(id).getElevato()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">安全管理：
        <input name="security" type="text" size="50"  value="<%=buildList.get(id).getSecurity()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">卫生服务：
        <input name="hygienism" type="text" size="50"  value="<%=buildList.get(id).getHygienism()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">小区入口：
        <input name="communityEnter" type="text" size="50"  value="<%=buildList.get(id).getCommunityEnter()%>"/></td>
    </tr>
    <tr>
      <td height="30" colspan="2">停车位：
        <input name="parking" type="text" size="50"  value="<%=buildList.get(id).getParking()%>"/></td>
    </tr>
    <tr>
      <td height="40"><div align="center">
        <input type="submit" name="Submit" value="保存" />
      </div></td>
      <td height="30">
        <div align="center">
          <input type="reset" name="Submit2" value="重置" />
        </div></td>
    </tr>
  </table>
</form>
</body>
</html>