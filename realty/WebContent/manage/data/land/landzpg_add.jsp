<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.realty.base.action.*,com.realty.base.model.*,java.util.*,java.text.*"%>
<%
String landId1=request.getParameter("landId");
int landId=Integer.parseInt(landId1);

LandAction landaction=new LandAction();
List<LandUsage> usageList=landaction.landusageList();
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
<title>添加招拍挂</title>
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
 <script type="text/javascript" src="js/usage.js"></script>

</head>
<body>
<form id="form1" name="form1" method="post" action="LandServlet?flag=5&landId=<%=landId%>">
<div id="Layer1">
<table width="100%" height="40" border="0" style="border-right:0px ;border-bottom:0px ;">
  <tr>
      <th colspan="2"><div align="center" class="STYLE1"> 招拍挂信息</div></th>
    </tr>
</table>
  <table width="100%" height="300" cellpadding=0 cellspacing=0  >
    <tr>
      <td colspan="2">土地用途：
            <select name="landusageId" size="1" onchange="chg(this)">
            <%for(int j=0;j<usageList.size();j++){ %>
            <option value="<%=usageList.get(j).getUsageId()%>"><%= usageList.get(j).getUsageName()%></option>
            <% }%>
        </select>
         <input id="select_else" name="select_else" style="display:none">
         </td>
    </tr>
    <tr>
      <td>土地面积：
        <input name="landArea" type="text" size="20" />（m<sup>2</sup>）</td>
      <td>规划建筑面积：
        <input name="planArea" type="text" size="20" />（m<sup>2</sup>）</td>
    </tr>
    <tr>
      <td>土地级别：
        <input name="landLevel" type="text" size="20" /></td>
      <td>出让使用年限：
         <input name="useyear" type="text" size="20" /></td>
    </tr>
    <tr>
      <td>出让楼面地价：
       <!--  <input name="initialPrice" type="text" size="20" />元/m<sup>2</sup> -->
        <input name="initialPrice" value ="0" onBlur="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<0){alert('请保留整数');this.focus();};" placeholder="请保留整数"/>
      	     元/m<sup>2</sup> </td>
      <td>成交楼面地价：
        <!-- <input name="dealPrice" type="text" size="20" /> -->
        <input name="dealPrice" value ="0" onBlur="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<0){alert('请保留整数');this.focus();};" placeholder="请保留整数"/>
        	元/m<sup>2</sup></td>
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
