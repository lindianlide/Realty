<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,com.realty.base.dao.impl.*,com.realty.base.dao.*,java.util.*,java.text.*"%>
<%
String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
String managername=(String)session.getAttribute("managername");
BuildingDecorateAction BD=new BuildingDecorateAction();
List<BuildingDecorate> BDList=BD.buildingdecorateList();

BuildingFormAction BF=new BuildingFormAction();
List<BuildingForm> BFList=BF.buildingformList();

RegionAction region=new RegionAction();
List<Region> regionList=region.regionList();

SecondDao SU=new SecondDaoImpl();
List<FloorUsage> SUList=SU.secondusageList();

BuildingStructureAction BS=new BuildingStructureAction();
List<BuildingStructure> BSList=BS.buildingstructureList();
int i=0; 
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
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 22px;
	font-family: "宋体";
}
#Layer1 {
	margin-left: auto;
	margin-right: auto;
	width:663px;
	height:340px;
	z-index:1;
	left: 4px;
	top: 15px;
}
-->
</style>
</head>
<body>
<form id="form1" name="form1" method="post" action="SecondServlet?flag=1">
<div id="Layer1">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 二手房基本信息</div></th>
    </tr>
</table>
  <table width="100%" height="300" cellpadding=0 cellspacing=0 >
  <tr>
      <td colspan="2"><span class="notnull">*</span>二手房名字：
        <input name="houseName" type="text" size="20"/></td>
    </tr>
    <tr>
      <td width="325">物业所在区域：
        <select name="regionId" size="1">
            <%for(i=0;i<regionList.size();i++){ %>
            <option value="<%=regionList.get(i).getRegionId()%>"><%= regionList.get(i).getRegionName()%></option>
            <% }%>
        </select> </td>
      <td width="325">物业地址：
        <input name="propertyAdress" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>物业名称：      
        <input name="propertyName" type="text" size="20" /></td>
      <td>房屋用途：     
        <select name="usageId" size="1">
            <%for(i=0;i<SUList.size();i++){ %>
            <option value="<%=SUList.get(i).getUsageId()%>"><%=SUList.get(i).getUsageName()%></option>
            <%} %>
        </select></td>
    </tr>
    <tr>
      <td>建筑结构：
        <select name="structureId" size="1">
        <%for(i=0;i<BSList.size();i++){ %>
         <option value="<%=BSList.get(i).getStructureId()%>"><%=BSList.get(i).getStructureName()%></option>
		<%} %>
        </select></td>
      <td>赠送面积：
        <input name="present" type="text" size="15"/></td>
    </tr>
    <tr>
      <td>装修情况：
        <select name="decorateId" size="1">
          <%for(i=0;i<BDList.size();i++){ %>
          <option value="<%=BDList.get(i).getDecorateId()%>"><%=BDList.get(i).getDecorateName() %></option>
          <%} %>
        </select></td>
      <td>建成年代：
        <input name="buildingTime" type="text" size="15"/></td>
    </tr>
    <tr>
      <td>总层数：
        <input name="floorTotle" type="text" size="15"/></td>
       <td>所在名义层 ：
         <input name="floorSaid" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>所在实际层 ：
        <input name="floorActual" type="text" size="20" /></td>
      <td>得房率：
        <input name="roomRate" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>户型：
        <input name="houseType" type="text" size="20" /></td>
      <td>单户朝向：
        <input name="orientation" type="text" size="20" /></td>
    </tr>
     
      <tr>
      <td>信息录入人：
       <input name="entryName" type="text" size="15" value="<%=managername%>" /></td>
      <td> 录入时间：
       <input name="entryTime" type="text" size="15" value="<%=datetime%>" /></td>
    </tr>
   <!-- <tr>
      <td colspan="2">提交人：
        <input name="auditName" type="text" size="20" />
        提交时间：
        <input name="auditTime" type="text" size="20" />
        状态标记：
        <select name="status" size="1">
          <option value="1">录入</option>
          <option value="2">提交</option>
        </select></td>
    </tr>  -->
    <tr>
      <td colspan="2">备注：
        <input name="remarks" type="text" size="50" /></td>
    </tr>
    <tr>
      <td height="40"><div align="center">
          <input type="submit" name="Submit" value="保存" />
      </div></td>
      <td height="30"><div align="center">
          <input type="reset" name="Submit2" value="重置" />
      </div></td>
    </tr>
  </table>
</div>
</form>
</body>
</html>
