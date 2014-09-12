<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%
String buildingId1=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingId1);
String buildintroId1=request.getParameter("buildintroId");
int buildintroId=Integer.parseInt(buildintroId1);
BuildingAction build=new BuildingAction();
List<BuildingIntro> buildList=build.buildingintroList();
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
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=5&buildintroId=<%=buildintroId%>&buildingId=<%=buildingId%>">
  <table width="663" height="462" cellpadding=0 cellspacing=0 align="center">
    <tr>
      <td width="289" height="30" >楼盘名：
        <input name="buildingName" type="text" size="20" value="<%=buildList.get(id).getBuildingName()%>" /></td>
      <td width="358" height="30">楼盘地址：
      <input name="address" type="text" size="20" value="<%=buildList.get(id).getAddress()%>" /></td>
    </tr>
    <tr>
      <td height="30">楼盘东：
        <input name="buildingEast" type="text" size="20" value="<%=buildList.get(id).getBuildingEast()%>" /></td>
      <td height="30">楼盘西：
      <input name="buildingWest" type="text" size="20" value="<%=buildList.get(id).getBuildingWest()%>" /></td>
    </tr>
    <tr>
      <td height="30">楼盘南：
      <input name="buildingSouth" type="text" size="20" value="<%=buildList.get(id).getBuildingSouth()%>"/></td>
      <td height="30">楼盘北：
        <input name="buildingNorth" type="text" size="20" value="<%=buildList.get(id).getBuildingNorth()%>" /></td>
    </tr>
    <tr>
      <td height="30">所处土地等级：
      <input name="landLevel" type="text" size="20" value="<%=buildList.get(id).getLandLevel()%>"/></td>
      <td height="30">周边居住小区：
      <input name="neighborhood" type="text" size="20" value="<%=buildList.get(id).getNeighborhood()%>" /></td>
    </tr>
    <tr>
      <td height="30">楼盘基本情况：
      <input name="buildingInfor" type="text" size="20" value="<%=buildList.get(id).getBuildingInfor()%>" /></td>
      <td height="30">邻近道路类型：
      <input name="nearRoad" type="text" size="20" value="<%=buildList.get(id).getNearRoad()%>" /></td>
    </tr>
    <tr>
      <td height="30">公共交通：
        <input name="publicTransport" type="text" size="20" value="<%=buildList.get(id).getPublicTransport()%>" /></td>
      <td height="30">商业设施：
        <input name="commercialFacility" type="text" size="20" value="<%=buildList.get(id).getCommercialFacility()%>" /></td>
    </tr>
    <tr>
      <td height="30">金融机构：
        <input name="financingNstitution" type="text" size="20" value="<%=buildList.get(id).getFinancingNstitution()%>" /></td>
      <td height="30">学校：
      <input name="school" type="text" size="20" value="<%=buildList.get(id).getSchool()%>" /></td>
    </tr>
    <tr>
      <td height="30">医疗：
        <input name="hospital" type="text" size="20" value="<%=buildList.get(id).getHospital()%>" /></td>
      <td height="30">其他：
        <input name="other" type="text" size="20" value="<%=buildList.get(id).getOther()%>" /></td>
    </tr>
    <tr>
      <td height="30">小区内部设施：
      <input name="internalFacility" type="text" size="20" value="<%=buildList.get(id).getInternalFacility()%>" /></td>
      <td height="30">水、电设施：
      <input name="propertyManagement" type="text" size="20" value="<%=buildList.get(id).getElectricityFacility()%>" /></td>
    </tr> 
    <tr>
      <td height="30">停车场所配备：
      <input name="parkFacility" type="text" size="20" value="<%=buildList.get(id).getParkFacility()%>" /></td>
      <td height="30">物业管理：
      <input name="propertyManagement" type="text" size="20" value="<%=buildList.get(id).getPropertyManagement()%>" /></td>
    </tr>
    <tr>
      <td height="30">小区环境：
      <input name="environment" type="text" size="20" value="<%=buildList.get(id).getEnvironment()%>" /></td>
      <td height="30">信息采集时间：
      <input name="collectTime" type="text" size="20" value="<%=buildList.get(id).getCollectTime()%>" /></td>
    </tr>
    <tr>
      <td height="30">信息录入人：
        <input name="entryName" type="text" size="15" value="<%=buildList.get(id).getEntryName()%>" /></td>
     <td height="30">  录入时间：
      <input name="entryTime" type="text" size="20" value="<%=buildList.get(id).getEntryTime()%>"/></td>
    </tr>
    <tr>
      <!-- <td height="30">提交人：
      <input name="auditName" type="text" size="20" value="<%=buildList.get(id).getBuildingName()%>" />提交时间：
      <input name="auditTime" type="text" size="20" value="<%=buildList.get(id).getBuildingName()%>" /> -->
    <td height="30" colspan="2">   状态标记：
      <select name="status" size="1">
       <option value="0">录入</option>
        <option value="1">提交</option>
      </select></td>
    </tr>
    <tr>
      <td height="30" colspan="2">备注：
      <input name="remarks" type="text" size="50" value="<%=buildList.get(id).getRemarks()%>"/></td>
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
  <div id="l-map"></div>
</form>
</body>
</html>