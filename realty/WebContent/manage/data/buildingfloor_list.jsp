<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%
String buildingfloorId=request.getParameter("buildingId");
int buildingId=Integer.parseInt(buildingfloorId);
BuildingAction buildaction=new BuildingAction();
List<Floor> floorList=buildaction.floorList(buildingId);
int floornums=floorList.size();
SecondAction secondaction=new SecondAction();
BuildingDecorateAction decorateaction=new BuildingDecorateAction();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link href="css/manstyle.css" type="text/css" rel="stylesheet">
</head>
<SCRIPT language=JavaScript>
function del_sure(){ 
	var gnl=confirm("确定要删除吗?"); 
	if (gnl==true){ 
	return true; 
	} 
	else{ 
	return false; 
	} 
	}
function insert()
{
	window.open('manage/data/buildingfloor_add.jsp?buildingId=<%=buildingId%>','buildingthree','top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function passpageNo(){
	var gopageNo = document.getElementById("gopageNo").value; 
	document.form.action="manage/web/culture/culture_list.jsp?pageNo="+gopageNo;
	document.form.submit();
}
</SCRIPT>
<body  style="font-size: 12px">
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=5&buildingId=<%=buildingId%>">
<table style="border-right:0px ;border-bottom:0px;">
<tr>
 <th>
	<input name="button2" type="button" class="right-button07" value="添加楼栋" onClick="insert()"/>
</th>	
</tr>
</table>
<table width="150%" cellpadding=0 cellspacing=0 >
  <tr>
    <td>楼号</td>
    <td>单元号</td>
    <td>房号</td>
    <td>建筑面积</td>
    <td>赠送面积</td>
    <td>装修情况</td>
    <td>总层数</td>
    <td>所在名义层</td>
    <td>所在实际层</td>
    <td>房屋用途</td>
    <td>户型</td>
    <td>单户朝向</td>
    <td>成交单价</td>
    <td>成交总价</td>
    <td>成交时间</td>
    <td>备注</td>
    <td>操作</td>
  </tr>
  <%for(int m=0;m<floornums;m++){
String decorateName=null;
decorateName=decorateaction.buildingdecorateSearch(floorList.get(m).getDecorateId());
String usageName=null;
usageName=secondaction.secondusageSearch(floorList.get(m).getUsageId());%>
  <tr>
    <td><%=floorList.get(m).getBuildNum()%></td>
    <td><%=floorList.get(m).getUnitNum()%></td>
    <td><%=floorList.get(m).getHouseNum()%></td>
    <td><%=floorList.get(m).getHouseArea()%></td>
    <td><%=floorList.get(m).getPresent()%></td>
    <td><%=decorateName%></td>
    <td><%=floorList.get(m).getFloorTotle()%></td>
    <td><%=floorList.get(m).getFloorSaid()%></td>
    <td><%=floorList.get(m).getFloorActual()%></td>
    <td><%=usageName%></td>
    <td><%=floorList.get(m).getHouseType()%></td>
    <td><%=floorList.get(m).getOrientation()%></td>
    <td><%=floorList.get(m).getExchangePrice()%></td>
    <td><%=floorList.get(m).getExchangeTotle()%></td>
    <td><%=floorList.get(m).getExchangeTime()%></td>
    <td><%=floorList.get(m).getRemarks()%></td>
    <td><a href="BuildingServlet?flag=7&buildingId=<%=buildingId %>&floorId=<%=floorList.get(m).getFloorId()%>" onclick="return del_sure()"><span>删除</span></a>  <a href="manage/data/buildingfloor_modify.jsp?buildingId=<%=buildingId %>&floorId=<%=floorList.get(m).getFloorId()%>"><span>修改</span></a></td>
  </tr>
	<% } %> 
</table>
</form>
</body>
</html>