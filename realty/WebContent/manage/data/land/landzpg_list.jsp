<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.List,java.util.Map"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
<%
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);
LandzpgAction landzpgaction=new LandzpgAction();
List<LandMutiusage> landzpg=landzpgaction.landzpgsearch(landId);
int zpgnums=landzpg.size();
LandAction landaction=new LandAction();
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
	window.open('manage/data/land/landzpg_add.jsp?landId=<%=landId%>','landtwo','top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
</SCRIPT>
<body  style="font-size: 12px">
<form id="form1" name="form1" method="post"  action="BuildingServlet?flag=5&landId=<%=landId%>">
<table style="border-right:0px ;border-bottom:0px;">
<tr>
 <th>
	<input name="button2" type="button" class="right-button07" value="添加用途" onClick="insert()"/>
</th>	
</tr>
</table>
<table width="150%" cellpadding=0 cellspacing=0 >
  <tr>
    <td>土地用途</td>
    <td>土地面积（m<sup>2</sup>）</td>
    <td>规划建筑面积（m<sup>2</sup>）</td>
    <td>土地级别</td>
    <td>出让年限</td>
    <td>出让楼面地价（元/m<sup>2</sup>）</td>
    <td>成交楼面地价（元/m<sup>2</sup>）</td>
    <td>备注</td>
    <td>操作</td>
  </tr>
  <%for(int m=0;m<zpgnums;m++){
String usageName=null;
usageName=landaction.landusageSearch(landzpg.get(m).getLandusageId());%>
  <tr>
    <td><%=usageName%></td>
    <td><%=landzpg.get(m).getLandArea()%></td>
    <td><%=landzpg.get(m).getPlanArea()%></td>
    <td><%=landzpg.get(m).getLandLevel()%></td>
    <td><%=landzpg.get(m).getUseyear()%></td>
    <td><%=landzpg.get(m).getInitialPrice()%></td>
    <td><%=landzpg.get(m).getDealPrice()%></td>
    <td><%=landzpg.get(m).getRamarks()%></td>
   <td><a  href="LandServlet?flag=6&landId=<%=landId %>&mutiusageId=<%=landzpg.get(m).getMutiusageId()%>" onclick="return del_sure()"><span>删除</span></a>  <a href="manage/data/land/landzpg_modify.jsp?landId=<%=landId %>&mutiusageId=<%=landzpg.get(m).getMutiusageId()%>"><span>修改</span></a></td>
 </tr>
	<% } %> 
</table>
</form>
</body>
</html>