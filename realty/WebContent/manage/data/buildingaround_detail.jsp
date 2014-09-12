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
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=5&buildingId=<%=buildingId%>">
  <table width="663" height="462" cellpadding=0 cellspacing=0 align="center">
    <tr>
      <td width="289" height="30" >楼盘名：
          <span><%=buildList.get(id).getBuildingName()%></span>
      <td width="358" height="30">楼盘地址：
      <%=buildList.get(id).getAddress()%></td>
    </tr>
    <tr>
      <td height="30">楼盘东：  <span><%=buildList.get(id).getBuildingEast()%></span>
        </td>
      <td height="30">楼盘西：  <span><%=buildList.get(id).getBuildingWest()%></span>
      </td>
    </tr>
    <tr>
      <td height="30">楼盘南：  <span><%=buildList.get(id).getBuildingSouth()%></span>
     </td>
      <td height="30">楼盘北：  <span><%=buildList.get(id).getBuildingNorth()%></span>
        </td>
    </tr>
    <tr>
      <td height="30">所处土地等级：  <span><%=buildList.get(id).getLandLevel()%></span>
      </td>
      <td height="30">周边居住小区：  <span><%=buildList.get(id).getNeighborhood()%></span>
     </td>
    </tr>
    <tr>
      <td height="30">楼盘基本情况：  <span><%=buildList.get(id).getBuildingInfor()%></span>
      </td>
      <td height="30">邻近道路类型：  <span><%=buildList.get(id).getNearRoad()%></span>
    </td>
    </tr>
    <tr>
      <td height="30">公共交通：  <span><%=buildList.get(id).getPublicTransport()%></span>
        </td>
      <td height="30">商业设施：  <span><%=buildList.get(id).getCommercialFacility()%></span>
        </td>
    </tr>
    <tr>
      <td height="30">金融机构：  <span><%=buildList.get(id).getFinancingNstitution()%></span>
        </td>
      <td height="30">学校：  <span><%=buildList.get(id).getSchool()%></span>
      </td>
    </tr>
    <tr>
      <td height="30">医疗：  <span><%=buildList.get(id).getHospital()%></span>
        </td>
      <td height="30">其他：  <span><%=buildList.get(id).getOther()%></span>
        </td>
    </tr>
    <tr>
      <td height="30">小区内部设施：  <span><%=buildList.get(id).getInternalFacility()%></span>
      </td>
      <td height="30">水、电设施：  <span><%=buildList.get(id).getElectricityFacility()%></span>
     </td>
    </tr> 
    <tr>
      <td height="30">停车场所配备：  <span><%=buildList.get(id).getParkFacility()%></span>
      </td>
      <td height="30">物业管理：  <span><%=buildList.get(id).getPropertyManagement()%></span>
      </td>
    </tr>
    <tr>
      <td height="30">小区环境：  <span><%=buildList.get(id).getEnvironment()%></span>
      </td>
      <td height="30">信息采集时间：  <span><%=buildList.get(id).getCollectTime()%></span>
      </td>
    </tr>
    <tr>
      <td height="30">信息录入人：
        <span><%=buildList.get(id).getEntryName()%></span></td>
     <td height="30">  录入时间：
     <span> <%=buildList.get(id).getEntryTime()%></span></td>
    </tr>
    <tr>
      <!-- <td height="30">提交人：
      <input name="auditName" type="text" size="20" />提交时间：
      <input name="auditTime" type="text" size="20" /> -->
    <td height="30" colspan="2">   状态标记：<span><%=buildList.get(id).getStatus()%></span>
</td>
    </tr>
    <tr>
      <td height="30" colspan="2">备注：  <span><%=buildList.get(id).getRemarks()%></span>
      </td>
    </tr>
  </table>

</form>
</body>
</html>