<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*,java.text.*"%>
<%
String buildingIdf=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingIdf);
BuildingDecorateAction BD=new BuildingDecorateAction();
List<BuildingDecorate> BDList=BD.buildingdecorateList();
SecondAction secondaction=new SecondAction();
List<FloorUsage> usageList=secondaction.secondusageList();
BuildingAction buildaction=new BuildingAction();
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
<form id="form1" name="form1" method="post" action="BuildingServlet?flag=6&buildingId=<%=buildingId%>">
<div id="Layer1">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 楼栋信息</div></th>
    </tr>
</table>
  <table width="100%" height="300" cellpadding=0 cellspacing=0  >
    <tr>
      <td width="325">楼号：
        <input name="buildNum" id="buildNum" type="text" size="20" /></td>
      <td width="325">单元号：
        <input name="unitNum" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>房号：
        <input name="houseNum" type="text" size="20" /></td>
      <td>建筑面积：
        <input name="houseArea" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>赠送面积：
        <input name="present" type="text" size="20" /></td>
      <td>装修情况：
        <select name="decorateId" size="1">
            <%for(i=0;i<BDList.size();i++){ %>
            <option value="<%=BDList.get(i).getDecorateId()%>"><%=BDList.get(i).getDecorateName()%></option>
            <%} %>
        </select></td>
    </tr>
    <tr>
      <td>总层数：
        <input name="floorTotle" type="text" size="20" /></td>
      <td>所在名义层：
        <input name="floorSaid" type="text" size="15" value=""/></td>
    </tr>
    <tr>
      <td>所在实际层：
        <input name="floorActual" type="text" size="15" value=""/></td>
       <td>房屋用途：
        <select name="usageId" size="1">
        <%for(i=0;i<usageList.size();i++){ %>
         <option value="<%=usageList.get(i).getUsageId()%>"><%=usageList.get(i).getUsageName()%></option>
		<%} %>
        </select></td>
    </tr>
    <tr>
     <td height="30">户型：
        <input name="houseType" type="text" size="20" /></td>
      <td>单户朝向：
        <input name="orientation" type="text" size="20" /></td>
    </tr>
     
      <tr>
      <td>成交单价：
        <input name="exchangePrice" type="text" size="20" /></td>
      <td>成交总价：
        <input name="exchangeTotle" type="text" size="20" /></td>
    </tr>
    <tr>
      <td colspan="2">成交时间：
        <input name="exchangeTime" type="text" size="20" /></td>
    </tr>
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
